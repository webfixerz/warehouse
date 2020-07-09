/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author simon
 */
//@Service
public class EmailService {
    private JavaMailSender javaMailSender;
    
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
        sendMail("");
    }
    
    
    public void sendMail(String message) {
        System.out.println("Hallo");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        
        mailMessage.setTo("simon.anckaert@sgsintpaulus.eu");
        mailMessage.setSubject("Update stock warehouses");
        
        
        mailMessage.setFrom("info@warehouses.be");
        javaMailSender.send(mailMessage);
    }
}
