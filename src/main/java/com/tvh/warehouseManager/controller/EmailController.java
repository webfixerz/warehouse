package com.tvh.warehouseManager.controller;

import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * This is a controller that sends the mail when it's 8 o'clock, every business day.
 * This controller should be replaced by the EmailService.
 * 
 * @author simon
 */
@Component
public class EmailController {
    
    /**
    * The warehouseRepository that will be used for database operations
    * This attribute will receive a reference to the object by Spring
    */
    @Autowired
    private WarehouseRepository warehouseRepository;
    
    /*@Autowired
    private EmailConfig emailConfig;*/
    
    
    @Scheduled(cron = "0 0 8 * * Mon-Fri")
    public void sendMail() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mailtrap.io");
        mailSender.setPort(587);
        mailSender.setUsername("4cfc82f3e7c65c");
        mailSender.setPassword("dabba4a21b1036");
        
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("info@warehouses.be");
        mailMessage.setTo("simon.anckaert@sgsintpaulus.eu");
        mailMessage.setSubject("Update warehouses");
        
        StringBuilder sb = new StringBuilder();
        Iterable<Warehouse> it = this.warehouseRepository.findAll();
        it.forEach(w -> sb.append(String.format("Warehouse %s still has %d free place(s)%n%n", w.getName(), w.calculateCapacityLeft())));
        
        mailMessage.setText(sb.toString());
        
        mailSender.send(mailMessage);
    }
}
