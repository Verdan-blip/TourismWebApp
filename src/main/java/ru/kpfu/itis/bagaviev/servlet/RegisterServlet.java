package ru.kpfu.itis.bagaviev.servlet;

import org.json.simple.JSONObject;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "registrationServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

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
        resp.setContentType("text/plain");

        UserService service = new UserService();

        String email = req.getParameter(PARAM_NAME_EMAIL);
        String phone = req.getParameter(PARAM_NAME_PHONE);

        boolean phoneExists = service.existsPhone(phone);
        boolean emailExists = service.existsEmail(email);

        JSONObject jsonObject = new JSONObject(Map.of(
                "phone_exists", phoneExists,
                "email_exists", emailExists
        ));

        if (!phoneExists && !emailExists) {
            User user = new User(
                    req.getParameter(PARAM_NAME_NAME),
                    req.getParameter(PARAM_NAME_LASTNAME),
                    phone,
                    req.getParameter(PARAM_NAME_GENDER),
                    email,
                    DEFAULT_USER_AVATAR_URL,
                    req.getParameter(PARAM_NAME_PASSWORD));
            service.save(user);
            jsonObject.put("status", "success");
        } else {
            jsonObject.put("status", "failure");
        }
        resp.getWriter().print(jsonObject.toJSONString());
    }

}
