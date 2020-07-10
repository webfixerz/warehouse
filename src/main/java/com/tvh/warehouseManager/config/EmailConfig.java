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

    /**
    * <p>This method will return the host</p>
    * @return the host
    * @since 1.0
    */
    public String getHost() {
        return host;
    }

    /**
    * <p>This method will return the port</p>
    * @return the port
    * @since 1.0
    */
    public int getPort() {
        return port;
    }

    /**
    * <p>This method will return the username</p>
    * @return the username
    * @since 1.0
    */
    public String getUsername() {
        return username;
    }

    /**
    * <p>This method will return the password</p>
    * @return the password
    * @since 1.0
    */
    public String getPassword() {
        return password;
    }    
}
