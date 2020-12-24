package org.acme.resteasyjackson.jfr;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.StartupEvent;
import jdk.jfr.FlightRecorder;

@ApplicationScoped
public class Metrics {

    public void registerEvent(@Observes StartupEvent se) {
        FlightRecorder.register(JaxRsInvocationEvent.class);
        System.out.println("#### Registered!");
    }
}
