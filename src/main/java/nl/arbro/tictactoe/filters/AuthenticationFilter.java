package nl.arbro.tictactoe.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created By: arbro
 * Date: 26-9-17 - 15:39
 * Project: tictactoe
 **/

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/highscores.html", "/loginsuccess.html"})
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;
        HttpSession session = httpReq.getSession();
        String loginURI = httpReq.getContextPath() + "/login.html";

        boolean loggedIn = session != null && session.getAttribute("loggedInUsername") != null;
        boolean loginRequest = httpReq.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest){
            chain.doFilter(request, response);
        } else {
            httpResp.sendRedirect(loginURI);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
