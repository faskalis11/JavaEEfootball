package lt.vu.rest;

import lt.vu.entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_XML)
public class TeamRestService {
    @Inject
    private EntityManager em;

    @GET
    @Path("/{teamId}")
    public Team find(@PathParam("teamId") Integer teamId) {
        return em.find(Team.class, teamId);
    }

    @Path("/create")
    @PUT
    @Transactional
    public Team create(@QueryParam("name") String name,
                       @QueryParam("multiply") Integer multiply) {

        Team team = new Team();
        team.setName(name);
        team.setSalaryMultipler(multiply);
        em.persist(team);
        return team;
    }

    @Path("/update/{id}")
    @POST
    @Transactional
    public Response update(@PathParam("id") long id,
                           @QueryParam("name") String name,
                           @QueryParam("multiply") Integer multiply) {
        Team team = em.find(Team.class, id);
        if (team == null) {
            throw new IllegalArgumentException("team id "
                    + id + " not found");
        }
        team.setName(name);
        team.setSalaryMultipler(multiply);
        em.merge(team);
        return Response.ok(team).build();

    }
}


