package resources;

import domain.parts.GraphicCard;
import domain.parts.Motherboard;
import domain.service.MotherboardService;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//@Path("/parts/Motherboard")
@Stateless
public class MotherboardResources {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(Motherboard motherboard){
        em.persist(motherboard);
        return Response.ok(motherboard.getId()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Motherboard> getAll(){
        return em.createNamedQuery("Motheboard.all", Motherboard.class).getResultList();
    }

    @PersistenceContext
    EntityManager em;
}
