package at.htl.football;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

class LeagueTest {
    @Test
    public void test01_add_new_teams(){
        League league = new League();
        league.addMatchResult(new Match("Nurnberg", "Dortmund", 3, 2));

        assertThat(league.getTable().get(0).getPoints(), is(3));
        assertThat(league.getTable().get(1).getPoints(), is(0));
    }

    @Test
    public void test02_teams_Exist(){
        League league = new League();
        league.addMatchResult(new Match("Nurnberg", "Dortmund", 3, 1));
        league.addMatchResult(new Match("Nurnberg", "Dortmund", 2, 2));

        assertThat(league.getTable().get(0).getPoints(), is(4));
        assertThat(league.getTable().get(1).getPoints(), is(1));
    }
}