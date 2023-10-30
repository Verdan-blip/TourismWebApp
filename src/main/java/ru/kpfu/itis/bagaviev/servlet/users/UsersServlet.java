package ru.kpfu.itis.bagaviev.servlet.users;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.kpfu.itis.bagaviev.dto.UserDto;
import ru.kpfu.itis.bagaviev.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "usersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();
        List<UserDto> users = service.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("ftl/users.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        String userName = req.getParameter("name");
        UserService service = new UserService();
        List<UserDto> userDtoList = service.getByName(userName);
        JSONArray jsonArray = new JSONArray();
        for (UserDto userDto : userDtoList) {
            jsonArray.add(new JSONObject(
                    Map.of(
                            "name", userDto.getName(),
                            "lastname", userDto.getLastname(),
                            "avatar", userDto.getAvatar()
                    )
            ));
        }
        resp.getWriter().print(jsonArray.toJSONString());
    }

}
