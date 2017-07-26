package nl.arbro.tictactoe.filters;

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

@WebFilter(filterName = "HasStartedGameFilter")
public class HasStartedGameFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        HttpSession session = httpReq.getSession(true);

        if (session.getAttribute("gameStarted") != null && session.getAttribute("gameStarted").equals("true")){
            chain.doFilter(req, resp);
        } else {
            httpResp.sendRedirect("home");

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}