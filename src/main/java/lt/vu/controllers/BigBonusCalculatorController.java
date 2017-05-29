package lt.vu.controllers;

import lt.vu.api.SalaryCalculator;
import lt.vu.entities.Footballer;
import lt.vu.entities.Team;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Named
@RequestScoped
@Alternative
public class BigBonusCalculatorController implements SalaryCalculator {

    public Footballer calculateSalaryClub(Footballer player){
        Team team = player.getTeam();
        player.setBonus((player.getGoals() * 100 + player.getAssists() * 50) * team.getSalaryMultipler());

        return player;
    }
}
