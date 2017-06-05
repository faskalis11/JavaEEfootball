package lt.vu.controllers;

import lt.vu.entities.Footballer;
import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.Future;


@Dependent
public class CalculateAllSalary {

    @Futureable
    // @Transactional(Transactional.TxType.REQUIRES_NEW)
    Future<Integer> calculateAll(List<Footballer> listPlayer){
        try{
            Integer sum = 0;
            for (Footballer f : listPlayer){
                sum += f.getSalary();
            }
            Thread.sleep(3000);
            return new AsyncResult<>(sum);
        }
        catch (InterruptedException e){
            e.printStackTrace();
            return new AsyncResult<>(null);
        }
    }
}
