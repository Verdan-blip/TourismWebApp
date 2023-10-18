package ru.kpfu.itis.bagaviev.servlet;

import ru.kpfu.itis.bagaviev.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "hotelsServlet", urlPatterns = "/hotels")
public class HotelsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        req.setAttribute("user", user);

        req.getRequestDispatcher("ftl/hotels.ftl").forward(req, resp);
    }

}
