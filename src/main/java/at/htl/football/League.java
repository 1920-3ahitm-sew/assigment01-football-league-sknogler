package at.htl.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {
    List<Team> teams = new ArrayList<>();

    public void addMatchResult(Match match){
        findOrCreateTeam(match.getGuestTeam()).addMatch(match);
        findOrCreateTeam(match.getHomeTeam()).addMatch(match);
    }

    private Team findOrCreateTeam(String teamN){
        for (Team team : teams) {
            if (team.getName().equals(teamN)) {
                return team;
            }
        }
        Team newTeam = new Team(teamN);

        teams.add(newTeam);
        return newTeam;
    }

    public List<Team> getTable(){
        teams.sort(Collections.reverseOrder());
        return teams;
    }
}
