package resources;

import domain.parts.HardDisk;
import domain.service.HardDiskService;

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

//@Path("/parts/HardDisk")
@Stateless
public class HardDiskResources {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(HardDisk hardDisk){
        em.persist(hardDisk);
        return Response.ok(hardDisk.getId()).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HardDisk> getAll(){
        return em.createNamedQuery("HardDisk.all", HardDisk.class).getResultList();
    }

    @PersistenceContext
    EntityManager em;
}
