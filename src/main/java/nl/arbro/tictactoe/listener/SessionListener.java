package nl.arbro.tictactoe.listener; /**
 * Created By: arbro
 * Date: 28-9-17 - 12:39
 * Project: tictactoe
 **/

import nl.arbro.tictactoe.repository.UserRepositoryImpl;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        String username = (String) session.getAttribute("loggedInUsername");

        if(username == null){
            return;
        } else {
            new UserRepositoryImpl().getUserByName(username).setLoggedIn(false);
            return;
        }

    }
}