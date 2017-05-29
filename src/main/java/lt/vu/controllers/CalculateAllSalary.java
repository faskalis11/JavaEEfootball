package lt.vu.controllers;

import lt.vu.entities.Footballer;

import javax.ejb.AsyncResult;
import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.concurrent.Future;


@Dependent
public class CalculateAllSalary {

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
