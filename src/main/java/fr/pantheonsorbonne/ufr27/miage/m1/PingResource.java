package fr.pantheonsorbonne.ufr27.miage.m1;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/home")
public class PingResource {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance ping();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance hello() {
        return Templates.ping();
    }
}
