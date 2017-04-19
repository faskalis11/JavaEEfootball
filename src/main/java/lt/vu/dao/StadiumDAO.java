package lt.vu.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StadiumDAO {
    @Inject
    private EntityManager manager;
}
