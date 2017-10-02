package nl.arbro.tictactoe;

import nl.arbro.tictactoe.model.LoginHandler;
import nl.arbro.tictactoe.model.User;
import nl.arbro.tictactoe.model.UserRepository;
import nl.arbro.tictactoe.model.UserRoles;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created By: arbro
 * Date: 25-9-17 - 14:14
 * Project: tictactoe
 **/

public class LoginHandlerTest {

    private LoginHandler target = null;
    private Properties prop = null;

    @Before
    public void setup(){
        prop = new Properties();
        ClassLoader loader =  Thread.currentThread().getContextClassLoader();

        try (InputStream input = loader.getResourceAsStream("testuser.properties")) {
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_login_sucess(){
        User userFixture = new User(
                prop.getProperty("username"),
                prop.getProperty("passwordHash"),
                UserRoles.valueOf(prop.getProperty("userRole")),
                Boolean.valueOf(prop.getProperty("isLoggedIn"))
        );

        UserRepository mockFetcher = mock(UserRepository.class);
        when(mockFetcher.getUserByName(anyString())).thenReturn(userFixture);

        target = new LoginHandler(mockFetcher);

        Boolean result = target.processLogin(prop.getProperty("username"), prop.getProperty("password"));
        assertEquals(true, result);

    }

    @Test
    public void test_login_fail(){
        User userFixture = new User(
                prop.getProperty("username"),
                prop.getProperty("passwordHash"),
                UserRoles.valueOf(prop.getProperty("userRole")),
                Boolean.valueOf(prop.getProperty("isLoggedIn"))
        );

        UserRepository mockFetcher = mock(UserRepository.class);
        when(mockFetcher.getUserByName(anyString())).thenReturn(userFixture);

        target = new LoginHandler(mockFetcher);

        Boolean result = target.processLogin(prop.getProperty("username"), "wrongpass");
        assertEquals(false, result);

    }

}
