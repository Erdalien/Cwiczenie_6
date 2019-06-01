package resources;

import domain.parts.RAMMemory;
import domain.service.RAMMemoryService;

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

//@Path("/parts/RAMMemory")
@Stateless
public class RAMMemoryResources {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(RAMMemory ramMemory){
        em.persist(ramMemory);
        return Response.ok(ramMemory.getId()).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RAMMemory> getAll(){
        return em.createNamedQuery("RAMMemory.all", RAMMemory.class).getResultList();
    }

    @PersistenceContext
    EntityManager em;
}
