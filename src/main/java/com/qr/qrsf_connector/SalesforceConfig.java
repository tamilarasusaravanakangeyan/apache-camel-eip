package com.qr.qrsf_connector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.camel.CamelContext;
import org.apache.camel.component.salesforce.SalesforceComponent;

@Configuration
public class SalesforceConfig {

    @Autowired
    private CamelContext camelContext;

    @Value("${salesforce.login-url}")
    private String loginUrl;

    @Value("${salesforce.client-id}")
    private String clientId;

    @Value("${salesforce.client-secret}")
    private String clientSecret;

    @Value("${salesforce.username}")
    private String username;

    @Value("${salesforce.password}")
    private String password;

    @Bean
    public SalesforceComponent salesforceComponent() {
        SalesforceComponent component = new SalesforceComponent();
        component.setLoginUrl(loginUrl);
        component.setClientId(clientId);
        component.setClientSecret(clientSecret);
        component.setUserName(username);
        component.setPassword(password);
        
        return component;
    }
}