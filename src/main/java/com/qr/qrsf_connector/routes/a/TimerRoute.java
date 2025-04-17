package com.qr.qrsf_connector.routes.a;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        // TODO Auto-generated method stub
//        from("timer:first-timer")
//                .transform().constant("My Constant Message")
//                .transform().constant("Time now is "+LocalDateTime.now())
//                .to("log:first-timer");
    }

}
