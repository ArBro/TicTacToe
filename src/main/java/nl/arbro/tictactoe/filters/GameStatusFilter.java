package nl.arbro.tictactoe.filters;

import nl.arbro.tictactoe.controller.BoardGameService;
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

@WebFilter(filterName = "GameStatusFilter", urlPatterns = {"/game.html", "/initgame.html"})
public class GameStatusFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        HttpSession session = httpReq.getSession();

        BoardGameService gameCtrl = (BoardGameService) session.getAttribute("game");

        if (gameCtrl != null){
            GameStatus gameStatus = gameCtrl.getGame().getGameStatus();
            if (gameStatus == GameStatus.WINNER || gameStatus == GameStatus.DRAW) {
                httpReq.getServletContext().getRequestDispatcher("/WEB-INF/jsp/winner.jsp").forward(httpReq, httpResp);
            } else {
                chain.doFilter(req, resp);
            }
        } else {
            httpReq.getServletContext().getRequestDispatcher("/WEB-INF/jsp/tictactoe.jsp").forward(httpReq, httpResp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
