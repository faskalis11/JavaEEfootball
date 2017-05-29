package lt.vu.controllers;

import lombok.Getter;
import lt.vu.dao.FootballerDAO;
import lt.vu.dao.TeamDAO;
import lt.vu.entities.Footballer;
import org.omnifaces.util.Messages;

import javax.ejb.AsyncResult;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Named
@RequestScoped
public class FootballerController implements Serializable{

    @Inject
    @Getter
    private FootballerDAO footballerDAO;

    @Inject
    @Getter
    private TeamDAO teamDAO;

    @Inject
    CalculateAllSalary calculateAllSalary;

    @Getter
    private Footballer footballer = new Footballer();

    @Getter
    private Future<Integer> integerFuture = null;

    public List<Footballer> getAllFootballers()
    {
        return footballerDAO.getAllFootballers();
    }

    @Transactional
    public String createFootballer(){
        footballerDAO.create(footballer);
        return null;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void calculateAll(){
        integerFuture = calculateAllSalary.calculateAll(getAllFootballers());
        try{
            while (!integerFuture.isDone()){
                Thread.sleep(10);
            }
            Messages.addGlobalInfo("Calculated: " + integerFuture.get() );
        } catch (ExecutionException e){
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    /*public String createFootballer(String name, int number){
        footballer.setName(name);
        footballer.setNumber(number);
        footballerDAO.create(footballer);
        return null;
    }*/
}
