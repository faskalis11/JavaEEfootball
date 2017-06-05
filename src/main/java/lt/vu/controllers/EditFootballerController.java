package lt.vu.controllers;

import lombok.Getter;
import lt.vu.api.SalaryCalculator;
import lt.vu.api.TaxesCalculator;
import lt.vu.dao.FootballerDAO;
import lt.vu.dao.TeamDAO;
import lt.vu.entities.Footballer;
import lt.vu.entities.Taxes;
import lt.vu.entities.Team;
import lt.vu.utility.Logged;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EditFootballerController implements Serializable {
    /*
     * Būsena, kurią saugome ViewScoped kontekste:
     */
    @Getter private Footballer selectedPlayer;
    @Getter private Footballer conflictingPlayer;
    @Getter private List<Footballer> allPlayers;
    @Getter private List<Team> allTeams;

    /*
     * DAO:
     */
    @Inject private FootballerDAO footballerDAO;
    @Inject private TeamDAO teamDAO;

    @Inject
    SalaryCalculator salaryCalculator;


    @PostConstruct
    public void init() {
        reloadAll();
    }

    public void prepareForEditing(Footballer footballer) {
        selectedPlayer = footballer;
        conflictingPlayer = null;
    }

    @Transactional
    @Logged
    public void updateSelectedPlayer() {
        try {
            salaryCalculator.calculateSalaryClub(selectedPlayer);
            footballerDAO.updateAndFlush(selectedPlayer);
            reloadAll();
        } catch (OptimisticLockException ole) {
            conflictingPlayer = footballerDAO.findById(selectedPlayer.getIdf());
            // Pavyzdys, kaip inicializuoti LAZY ryšį, jei jo reikia HTML puslapyje:
            //Hibernate.initialize(conflictingPlayer.getCourseList());
            // Pranešam PrimeFaces dialogui, kad užsidaryti dar negalima:
            RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
        }
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Logged
    public void overwritePlayer() {
        selectedPlayer.setOptLockVersion(conflictingPlayer.getOptLockVersion());
        updateSelectedPlayer();
    }

    public void reloadAll() {
        allPlayers = footballerDAO.getAllFootballers();
        for (Footballer player : allPlayers){
            salaryCalculator.calculateSalaryClub(player);
            //taxesCalculator.takeTaxes(player.getSalary() + player.getBonus());
        }
        allTeams = teamDAO.getAllTeams();
    }
}
