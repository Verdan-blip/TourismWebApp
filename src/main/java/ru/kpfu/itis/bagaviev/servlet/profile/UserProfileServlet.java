package ru.kpfu.itis.bagaviev.servlet.profile;

import ru.kpfu.itis.bagaviev.dto.UserDto;
import ru.kpfu.itis.bagaviev.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userProfileServlet", urlPatterns = "/profile/user")
public class UserProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        if (userId == null) {
            resp.sendRedirect("/login");
        }
        Integer friendId = Integer.parseInt(req.getParameter("id"));
        if (userId.equals(friendId)) {
            resp.sendRedirect("/profile");
        } else {
            UserService service = new UserService();
            UserDto userDto = service.get(friendId);
            req.setAttribute("current_user", userDto);
            req.getRequestDispatcher("ftl/user_profile.ftl").forward(req, resp);
        }
    }

}
