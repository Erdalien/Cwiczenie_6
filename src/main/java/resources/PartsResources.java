package resources;

import domain.parts.GraphicCard;
import domain.service.GraphicCardService;

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

//@Path("/parts/GraphicCard")
@Stateless
public class PartsResources {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(GraphicCard graphicCard){
        em.persist(graphicCard);
        return Response.ok(graphicCard.getId()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GraphicCard> getAll(){
        return em.createNamedQuery("GraphicCard.all", GraphicCard.class).getResultList();
    }

    @PersistenceContext
    EntityManager em;
}
