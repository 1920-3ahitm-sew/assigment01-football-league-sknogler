package at.htl.football;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;

class LeagueTest {
    @Test
    public void test01_add_new_teams(){
        League league = new League();
        league.addMatchResult(new Match("Nurnberg", "Dortmund", 3, 2));

        assertThat(league.getTable().get(0).getP(), is(3));
        assertThat(league.getTable().get(1).getP(), is(0));
    }

    @Test
    public void test02_teams_Exist(){
        League league = new League();
        league.addMatchResult(new Match("Nurnberg", "Dortmund", 3, 1));
        league.addMatchResult(new Match("Nurnberg", "Dortmund", 2, 2));

        assertThat(league.getTable().get(0).getP(), is(4));
        assertThat(league.getTable().get(1).getP(), is(1));
    }
}