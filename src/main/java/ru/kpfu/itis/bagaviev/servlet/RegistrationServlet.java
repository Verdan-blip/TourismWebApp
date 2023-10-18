package ru.kpfu.itis.bagaviev.servlet;

import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private static final String DEFAULT_USER_AVATAR_URL = "https://www.mfp-law.com/wp-content/uploads/2021/06/Platzhalter-j.bunz_.jpg";

    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_LASTNAME = "lastname";
    private static final String PARAM_NAME_PHONE = "phone";
    private static final String PARAM_NAME_GENDER = "gender";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("html/registration.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService service = new UserService();
        User user = new User(
                req.getParameter(PARAM_NAME_NAME),
                req.getParameter(PARAM_NAME_LASTNAME),
                req.getParameter(PARAM_NAME_PHONE),
                req.getParameter(PARAM_NAME_GENDER),
                req.getParameter(PARAM_NAME_EMAIL),
                DEFAULT_USER_AVATAR_URL,
                req.getParameter(PARAM_NAME_PASSWORD));

        service.save(user);

        HttpSession session = req.getSession();
        session.setAttribute("user", user);

    }

}
