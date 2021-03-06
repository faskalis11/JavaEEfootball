package lt.vu.dao;

import lt.vu.entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TeamDAO {
    @Inject
    private EntityManager em;

    public List<Team> getAllTeams(){
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }
}
