package nl.arbro.tictactoe;

import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.model.ScoreList;
import nl.arbro.tictactoe.model.ScoresFetcher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created By: arbro
 * Date: 23-9-17 - 16:51
 * Project: tictactoe
 **/

public class ScoreListTest {

    private List<Score> exampleScores;
    private ScoreList target = null;
    private ScoresFetcher mockFetcher;

    @Before
    public void setup() {
        target = ScoreList.getInstance();

        exampleScores = new ArrayList<>();
        exampleScores.add(new Score(1L, "TestPlayer", 12));
        exampleScores.add(new Score(2L, "TestPlayer", 15));
        exampleScores.add(new Score(3L, "TestPlayer", 10));
        exampleScores.add(new Score(2L, "TestPlayer", 9));

        mockFetcher = mock(ScoresFetcher.class);
        when(mockFetcher.fetchScores()).thenReturn(exampleScores);
    }

    @Test
    public void test_getScores_Success() throws Exception {
        //given
        List<Score> resultList = target.getScores(mockFetcher);

        //then
        verify(mockFetcher).fetchScores();
        assertEquals(exampleScores, resultList);
    }

    @Test
    public void test_getScores_DoesNotStackData() {
        target.getScores(mockFetcher);
        List<Score> resultList = target.getScores(mockFetcher);

        assertEquals(exampleScores, resultList);
    }

    @Test
    public void test_getInstance_IsNotNull() {
        assertNotNull(target);
    }

    @Test
    public void test_fetchScores_IsNotNull () {
        assertNotNull(mockFetcher.fetchScores());
    }

}
