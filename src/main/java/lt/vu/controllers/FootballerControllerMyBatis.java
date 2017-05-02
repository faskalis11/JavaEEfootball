package lt.vu.controllers;

import lombok.Getter;
import lt.vu.mybatis.dao.FootballerMapper;
import lt.vu.mybatis.dao.StadiumMapper;
import lt.vu.mybatis.dao.TeamMapper;
import lt.vu.mybatis.dao.TeamStadiumMapper;
import lt.vu.mybatis.model.Footballer;
import lt.vu.mybatis.model.Team;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class FootballerControllerMyBatis {

    @Getter
    private Footballer footballer = new Footballer(); //myBatis

    @Getter
    List<Footballer> allFootballers;

    @Inject
    private FootballerMapper footballerMapper;
    @Inject
    private StadiumMapper stadiumMapper;
    @Inject
    private TeamMapper teamMapper;
    @Inject
    private TeamStadiumMapper teamStadiumMapper;



    @PostConstruct
    public void init() {
        loadAllFootballers();
    }

    @Transactional
    public String createFootballer(){

        footballerMapper.insert(footballer);

        return null;
    }

    @Transactional
    public List<Team> getAllTems(){
        return teamMapper.selectAll();
    }

    /*private Team getTeamById(int id){
        return teamMapper.selectByPrimaryKey(id);
    }*/

    private void loadAllFootballers(){
        allFootballers = footballerMapper.selectAll();
        for (Footballer f : allFootballers){
            System.out.println(f.getTeamO().getName() + " / " + f.getTeamO().getId() + " " + f.getTeam());
        }
    }
}
