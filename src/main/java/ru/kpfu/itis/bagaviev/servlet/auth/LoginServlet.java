package ru.kpfu.itis.bagaviev.servlet.auth;

import org.json.simple.JSONObject;
import ru.kpfu.itis.bagaviev.dto.UserDto;
import ru.kpfu.itis.bagaviev.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_REMEMBER_ME = "remember_me";
    private static final int SESSION_MAX_INACTIVE_INTERVAL = 60 * 60;
    private static final int COOKIES_MAX_AGE = 24 * 60 * 60;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                if (cookie.getValue() != null) {
                    userId = Integer.parseInt(cookie.getValue());
                }
            }
        }
        if (userId != null) {
            resp.sendRedirect("/profile");
        } else {
            req.getRequestDispatcher("html/login.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        String email = req.getParameter(PARAM_NAME_EMAIL);
        String password = req.getParameter(PARAM_NAME_PASSWORD);
        String rememberMe = req.getParameter(PARAM_NAME_REMEMBER_ME);

        UserService service = new UserService();
        UserDto userDto = service.get(email, password);

        JSONObject jsonObject = new JSONObject();

        if (userDto == null) {
            jsonObject.put("status", "failure");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("userId", userDto.getId());
            session.setMaxInactiveInterval(SESSION_MAX_INACTIVE_INTERVAL);
            if (rememberMe != null) {
                Cookie cookie = new Cookie("userId", userDto.getId().toString());
                cookie.setMaxAge(COOKIES_MAX_AGE);
                resp.addCookie(cookie);
            }
            jsonObject.put("status", "success");
        }

        resp.getWriter().print(jsonObject.toJSONString());
    }

}
