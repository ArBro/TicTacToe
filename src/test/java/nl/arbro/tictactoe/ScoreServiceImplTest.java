package nl.arbro.tictactoe;

import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.repository.ScoreRepository;
import nl.arbro.tictactoe.service.ScoreServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
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

public class ScoreServiceImplTest {

    private List<Score> exampleScores;

    @InjectMocks
    private ScoreServiceImpl target;

    @Mock
    private ScoreRepository scoreRepository;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        exampleScores = new ArrayList<>();
        exampleScores.add(new Score("TestPlayer", 12, LocalDate.now()));
        exampleScores.add(new Score("TestPlayer", 15, LocalDate.now()));
        exampleScores.add(new Score("TestPlayer", 10, LocalDate.now()));
        exampleScores.add(new Score("TestPlayer", 9, LocalDate.now()));

        when(scoreRepository.findAll()).thenReturn(exampleScores);
    }

    @Test
    public void test_getScores_Success() throws Exception {
        //given
        List<Score> resultList = target.getScores();

        //then
        verify(scoreRepository).findAll();
        assertEquals(exampleScores, resultList);
    }

    @Test
    public void test_getScores_DoesNotStackData() {
        target.getScores();
        List<Score> resultList = target.getScores();

        assertEquals(exampleScores, resultList);
    }

    @Test
    public void test_getInstance_IsNotNull() {
        assertNotNull(target);
    }

    @Test
    public void test_fetchScores_IsNotNull () {
        assertNotNull(scoreRepository.findAll());
    }

}
