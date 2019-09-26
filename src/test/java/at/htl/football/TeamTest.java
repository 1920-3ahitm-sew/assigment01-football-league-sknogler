package at.htl.football;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.CoreMatchers.is;

class TeamTest {
    @Test
    public void team_is_home_and_won() {
        Team team = new Team("Nurnberg");
        Match match = new Match("Nurnberg", "Hoffenheim", 2, 1);

        team.addMatch(match);
        assertThat(team.getWins(), is(1));
        assertThat(team.getDraws(), is(0));
        assertThat(team.getDefeats(), is(0));

        assertThat(team.getGoalsShot(), is(match.getHomeGoals()));
        assertThat(team.getGoalsRecieved(), is(match.getGuestGoals()));
        assertThat(team.getPoints(), is(match.getHomePoints()));
    }

     @Test
    public void team_is_guest_and_lost() {
        Team team = new Team("Nurnberg");
        Match match = new Match("Hoffenheim", "Nurnberg", 2, 1);

        team.addMatch(match);
         assertThat(team.getWins(), is(0));
         assertThat(team.getDraws(), is(0));
         assertThat(team.getDefeats(), is(1));

         assertThat(team.getGoalsShot(), is(match.getGuestGoals()));
         assertThat(team.getGoalsRecieved(), is(match.getHomeGoals()));
         assertThat(team.getPoints(), is(match.getGuestPoints()));
    }

    @Test
    public void team_is_guest_and_it_was_a_draw() {
        Team team = new Team("Nurnberg");
        Match match = new Match("Hoffenheim", "Nurnberg", 1, 1);

        team.addMatch(match);
        assertThat(team.getWins(), is(0));
        assertThat(team.getDraws(), is(1));
        assertThat(team.getDefeats(), is(0));

        assertThat(team.getGoalsShot(), is(match.getGuestGoals()));
        assertThat(team.getGoalsRecieved(), is(match.getHomeGoals()));
        assertThat(team.getPoints(), is(match.getGuestPoints()));
    }

    @Test
    public void team1_has_more_points() {
        Team team1 = new Team("Nurnberg");
        Team team2 = new Team("Hoffenheim");
        Match match = new Match("Nurnberg", "Hoffenheim", 4, 2);

        team1.addMatch(match);
        team2.addMatch(match);
        assertThat(team1.compareTo(team2), greaterThan(0));
    }

    @Test
    public void team2_has_more_points() {
        Team team1 = new Team("Nurnberg");
        Team team2 = new Team("Hoffenheim");
        Match match = new Match("Nurnberg", "Hoffenheim", 2, 4);

        team1.addMatch(match);
        team2.addMatch(match);
        assertThat(team1.compareTo(team2), lessThan(0));
    }

}