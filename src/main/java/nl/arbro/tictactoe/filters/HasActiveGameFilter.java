package nl.arbro.tictactoe.filters;

import nl.arbro.tictactoe.controller.TicTacToeGameController;
import nl.arbro.tictactoe.model.GameStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created By: arbro
 * Date: 26-7-17 - 14:52
 * Project: tictactoe
 **/

@WebFilter(filterName = "HasActiveGameFilter", urlPatterns = {"/game"})
public class HasActiveGameFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        HttpSession session = httpReq.getSession(true);

        if (session.getAttribute("game") != null){
            TicTacToeGameController gameCtrl = (TicTacToeGameController) session.getAttribute("game");
            GameStatus gameStatus = gameCtrl.getGame().getGameStatus();
            if (gameStatus != GameStatus.PLAYING) {
                if (gameStatus != GameStatus.PLAYING){
                    httpResp.sendRedirect("winner");
                } else {
                    chain.doFilter(req, resp);
                }
            } else {
                chain.doFilter(req, resp);
            }

        } else {
            httpResp.sendRedirect("tictactoe");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
