package ru.kpfu.itis.bagaviev.servlet.hotels;

import ru.kpfu.itis.bagaviev.dao.HotelReviewsDao;
import ru.kpfu.itis.bagaviev.model.HotelReview;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "addHotelReviewServlet", urlPatterns = "/reviews/hotel/add")
public class AddHotelReviewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        Integer hotelId = Integer.parseInt(req.getParameter("hotel_id"));
        String text = req.getParameter("text");
        HotelReviewsDao hotelReviewsDao = new HotelReviewsDao();
        hotelReviewsDao.save(new HotelReview(
                hotelId,
                userId,
                text,
                new Timestamp(System.currentTimeMillis())
        ));
    }

}
