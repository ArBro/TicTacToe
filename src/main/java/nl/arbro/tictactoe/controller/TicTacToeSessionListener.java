package nl.arbro.tictactoe.controller; /**
 * Created By: arbro
 * Date: 28-9-17 - 12:39
 * Project: tictactoe
 **/

import nl.arbro.tictactoe.model.UserRepository;
import org.springframework.stereotype.Controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Controller
@WebListener
public class TicTacToeSessionListener implements HttpSessionListener {

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
            new UserRepository().getUserByName(username).setLoggedIn(false);
            return;
        }

    }
}