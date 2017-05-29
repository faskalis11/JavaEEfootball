package lt.vu.dao;

import lt.vu.entities.Footballer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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

        manager.persist(footballer);
        manager.flush();
    }

    public void updateAndFlush(Footballer footballer) {
        manager.merge(footballer);
        manager.flush();
    }

    public Footballer findById(Integer id) {
        return manager.find(Footballer.class, id);
    }


}
