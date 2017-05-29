package lt.vu.utility;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class LogDAO {

    @Inject
    private EntityManager manager;

    public void createLog(Log log){
        System.out.println("LOG DAO" + log.getMethod_name());
        manager.persist(log);
    }
}
