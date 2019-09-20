package at.htl.football;

public class Team implements Comparable<Team> {
    private String name;
    private int p, wins, draws, defeats, goalsShot, goalsRecieved;

    //region Constructor & Getter
    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getP() {
        return p;
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

    public void addMatch(Match match){
        if (match.getHomeTeam().equals(name)) {
            goalsShot += match.getHomeGoals();
            goalsRecieved += match.getGuestGoals();
            p += match.getHomeGoals();

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
            p += match.getGuestPoints();

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

    @Override
    public int compareTo(Team o) {
        if (p > o.getP()) {
            return 1;
        } else if (p < o.getP()) {
            return -1;
        } else {
            return Integer.compare(getGoalDifference(), o.getGoalDifference());
        }
    }
}
