package com.tvh.warehouseManager.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * This class takes the values from MailTrap that are needed to send the mail.
 * 
 * @author simon
 */
public class EmailConfig {
    /**
    * The host that will be used for the email configuration
    * This attribute will contain the info from application.properties
    */
    @Value("${spring.mail.host}")
    private String host;
    
    /**
    * The port that will be used for the email configuration
    * This attribute will contain the info from application.properties
    */
    @Value("${spring.mail.port}")
    private int port;
    
    /**
    * The username that will be used for the email configuration
    * This attribute will contain the info from application.properties
    */
    @Value("${spring.mail.username}")
    private String username;
    
    /**
    * The password that will be used for the email configuration
    * This attribute will contain the info from application.properties
    */
    @Value("${spring.mail.password}")
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
