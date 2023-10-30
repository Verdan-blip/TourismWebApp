package ru.kpfu.itis.bagaviev.filters;

import ru.kpfu.itis.bagaviev.dto.UserDto;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authorizationFilter", urlPatterns = {"/profile", "/reviews", "/hotels"})
public class AuthorizationFilter implements Filter {

    private final String COOKIE_NAME_FOR_AUTHORIZATION = "userId";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            Cookie[] cookies = req.getCookies();
            UserDto userDto = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(COOKIE_NAME_FOR_AUTHORIZATION)) {
                    UserService userService = new UserService();
                    userDto = userService.get(Integer.parseInt(cookie.getValue()));
                    break;
                }
            }
            if (userDto == null) {
                resp.sendRedirect("/login");
            } else {
                session.setAttribute("userId", userDto.getId());
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
