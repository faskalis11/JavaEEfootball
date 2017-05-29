package lt.vu.dao;

import lt.vu.entities.Taxes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class TaxesDAO {

    @Inject
    private EntityManager manager;

    public void create(Taxes taxes) {

        manager.persist(taxes);
        manager.flush();
    }
}
