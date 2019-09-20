package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MatchTest {
    @Test
    public void tes01_home_team_wins(){
        Match match = new Match("Nurnberg", "Dortmund", 1, 0);

        assertThat(match.getHomePoints(), is(3));
        assertThat(match.getGuestPoints(), is(0));
    }

    @Test
    public void tes02_home_team_wins(){
        Match match = new Match("Nurnberg", "Dortmund", 0, 2);

        assertThat(match.getHomePoints(), is(0));
        assertThat(match.getGuestPoints(), is(3));
    }

    @Test
    public void tes03_home_team_wins(){
        Match match = new Match("Nurnberg", "Dortmund", 2, 2);

        assertThat(match.getHomePoints(), is(1));
        assertThat(match.getGuestPoints(), is(1));
    }

}