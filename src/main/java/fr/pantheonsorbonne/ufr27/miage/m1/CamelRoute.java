package fr.pantheonsorbonne.ufr27.miage.m1;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import org.apache.camel.builder.RouteBuilder;

public class CamelRoute extends RouteBuilder {



    @Override
    public void configure() throws Exception {
        rest("/ping")
                .post("/").to("direct:restHandler");

        from("direct:restHandler")
                .to("sjms2:queue:M1.ping");

        from("sjms2:queue:M1.ping")
                .transform().constant("Round trip with broker worked, everything works");


    }
}
