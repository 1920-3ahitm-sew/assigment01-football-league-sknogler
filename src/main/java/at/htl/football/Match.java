package at.htl.football;

public class Match {
    private String homeTeam, guestTeam;
    private int homeGoals, guestGoals;

    //region Constructor & Getter
    public Match(String homeTeam, String guestTeam, int homeGoals, int guestGoals) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.homeGoals = homeGoals;
        this.guestGoals = guestGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public int getHomePoints() {
        if (guestGoals < homeGoals) {
            return 3;
        } else if (guestGoals == homeGoals) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getGuestPoints() {
        if (guestGoals > homeGoals) {
            return 3;
        } else if (guestGoals == homeGoals) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getGuestGoals() {
        return guestGoals;
    }

    //endregion
}

