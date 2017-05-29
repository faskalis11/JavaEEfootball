package lt.vu.utility;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
public class LogToDB {

    @Inject
    LogDAO logDAO;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveLog(Log log){
        System.out.println("LOGTODB" + log.getMethod_name() + logDAO);

        logDAO.createLog(log);
    }
}
