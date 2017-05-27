package lt.vu.controllers;

import lombok.Getter;
import lt.vu.dao.FootballerDAO;
import lt.vu.dao.TeamDAO;
import lt.vu.entities.Footballer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class FootballerController implements Serializable{

    @Inject
    @Getter
    private FootballerDAO footballerDAO;

    @Inject
    @Getter
    private TeamDAO teamDAO;

    @Getter
    private Footballer footballer = new Footballer();

    public List<Footballer> getAllFootballers()
    {
        return footballerDAO.getAllFootballers();
    }

    @Transactional
    public String createFootballer(){
        footballerDAO.create(footballer);
        return null;
    }

    /*public String createFootballer(String name, int number){
        footballer.setName(name);
        footballer.setNumber(number);
        footballerDAO.create(footballer);
        return null;
    }*/
}
