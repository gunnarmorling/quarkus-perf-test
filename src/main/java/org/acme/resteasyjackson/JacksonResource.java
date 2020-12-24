package org.acme.resteasyjackson;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.runtime.StartupEvent;

@Path("/resteasy-jackson/quarks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class JacksonResource {

//    private final Set<Quark> quarks = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
//
//    public JacksonResource() {
//        quarks.add(new Quark("Up", "The up quark or u quark (symbol: u) is the lightest of all quarks, a type of elementary particle, and a major constituent of matter."));
//        quarks.add(new Quark("Strange", "The strange quark or s quark (from its symbol, s) is the third lightest of all quarks, a type of elementary particle."));
//        quarks.add(new Quark("Charm", "The charm quark, charmed quark or c quark (from its symbol, c) is the third most massive of all quarks, a type of elementary particle."));
//        quarks.add(new Quark("???", null));
//    }

    @Transactional
    public void insertData(@Observes StartupEvent se) {
        new Quark("Up", "The up quark or u quark (symbol: u) is the lightest of all quarks, a type of elementary particle, and a major constituent of matter.").persist();
        new Quark("Strange", "The strange quark or s quark (from its symbol, s) is the third lightest of all quarks, a type of elementary particle.").persist();
        new Quark("Charm", "The charm quark, charmed quark or c quark (from its symbol, c) is the third most massive of all quarks, a type of elementary particle.").persist();
        new Quark("???", null).persist();
    }

    @GET
    @Transactional
    public List<Quark> list() {
        return Quark.findAll().list();
    }

//    @POST
//    public Set<Quark> add(Quark quark) {
//        quarks.add(quark);
//        return quarks;
//    }
//
//    @DELETE
//    public Set<Quark> delete(Quark quark) {
//        quarks.removeIf(existingQuark -> existingQuark.name.contentEquals(quark.name));
//        return quarks;
//    }
}
