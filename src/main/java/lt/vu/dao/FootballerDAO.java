package lt.vu.dao;

import lt.vu.entities.Footballer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FootballerDAO {
    @Inject
    private EntityManager manager;


    public List<Footballer> getAllFootballers()
    {
        return manager.createNamedQuery("Footballer.findAll", Footballer.class).getResultList();
    }

    public void create(Footballer footballer) {
        System.out.println(footballer.getTeam().getName());

        manager.persist(footballer);
        manager.flush();
    }

}
