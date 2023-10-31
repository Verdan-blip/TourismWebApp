package ru.kpfu.itis.bagaviev.servlet.friends;

import ru.kpfu.itis.bagaviev.dto.FriendDto;
import ru.kpfu.itis.bagaviev.service.FriendService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "friendsServlet", urlPatterns = "/friends")
public class FriendsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FriendService friendService = new FriendService();
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        List<FriendDto> friendDtoList = friendService.getAllFriends(userId);
        req.setAttribute("friends", friendDtoList);
        req.getRequestDispatcher("ftl/friends.ftl").forward(req, resp);
    }

}
