package com.qr.qrsf_connector;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.component.salesforce.api.dto.Limits;

@Component
public class SalesforceRouteConfig extends RouteBuilder {

    @Autowired
    private SalesforceComponent salesforceComponent;

    @Override
    public void configure() throws Exception {
        getContext().addComponent("salesforce", salesforceComponent);
        from("salesforce:subscribe:data/AccountChangeEvent?replayId=-1")
                .log("being notified of change events for Account records")
                .log("Salesforce API Limits - Daily Requests Remaining: ${body}");

        from("timer:checkLimits?period=10000")
                .to("salesforce:limits")
                .log("Salesforce API Limits - Daily Requests Remaining: ${body}")
                ;

//        from("direct:querySalesforce")
//                .to("salesforce:limits")
//                .choice()
//                .when(simple("${body.dailyApiRequests.remaining} < ${body.dailyApiRequests.max} * 0.1"))
//                .setBody(constant("API limit threshold reached, query blocked"))
//                .log("Query blocked due to API limit threshold")
//                .otherwise()
//                .to("salesforce:query?sObjectQuery=SELECT Id, Name FROM Account")
//                .log("Query executed successfully")
//                .end();
    }
}