package at.htl.football;

public class Team implements Comparable<Team> {
    private String name;
    private int points, wins, draws, defeats, goalsShot, goalsRecieved;

    public void addMatch(Match match){
   if (match.getHomeTeam().equals(name)) {
        goalsShot += match.getHomeGoals();
        goalsRecieved += match.getGuestGoals();
        points += match.getHomePoints();

        switch (match.getHomePoints()) {
            case 3:
                wins++;
                break;
            case 1:
                draws++;
                break;
            case 0:
                defeats++;
        }
    } else if (match.getGuestTeam().equals(name)) {
        goalsShot += match.getGuestGoals();
        goalsRecieved += match.getHomeGoals();
        points += match.getGuestPoints();

        switch (match.getGuestPoints()) {
            case 3:
                wins++;
                break;
            case 1:
                draws++;
                break;
            case 0:
                defeats++;
        }
    }
}
    //region Constructor & Getter

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsRecieved() {
        return goalsRecieved;
    }
    public int getGoalDifference(){
        return goalsShot - goalsRecieved;
    }

    //endregion

    @Override
    public int compareTo(Team o) {
        if (points > o.getPoints()) {
            return 1;
        } else if (points < o.getPoints()) {
            return -1;
        } else {
            return Integer.compare(getGoalDifference(), o.getGoalDifference());
        }
    }
}
