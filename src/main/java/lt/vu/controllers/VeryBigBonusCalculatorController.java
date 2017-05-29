package lt.vu.controllers;

import lt.vu.entities.Footballer;
import lt.vu.entities.Team;

import javax.enterprise.inject.Specializes;

@Specializes
public class VeryBigBonusCalculatorController extends BigBonusCalculatorController {

    public Footballer calculateSalaryClub(Footballer player){
        Team team = player.getTeam();
        player.setBonus(1 + (player.getGoals() * 100 + player.getAssists() * 50) * team.getSalaryMultipler());

        return player;
    }
}
