package lt.vu.utility;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.sql.Timestamp;

@Logged
@Interceptor
public class LoggedInterceptor implements Serializable {

    @Inject
    LogToDB logToDB;

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
        Object context;
        System.out.println("HYOUH");
        try{
            context = invocationContext.proceed();
        } finally {
            Log log = new Log();
            log.setTime(new Timestamp(System.currentTimeMillis()));
            log.setClass_name(invocationContext.getMethod().getDeclaringClass().getSimpleName());
            log.setMethod_name(invocationContext.getMethod().getName());

            logToDB.saveLog(log);
        }
        return context;
    }
}