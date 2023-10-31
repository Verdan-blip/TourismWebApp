package ru.kpfu.itis.bagaviev.servlet.hotels;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ru.kpfu.itis.bagaviev.dto.HotelReviewsDto;
import ru.kpfu.itis.bagaviev.service.HotelReviewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "hotelReviewsServlet", urlPatterns = "/reviews/hotel")
public class HotelReviewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        Integer hotelId = Integer.parseInt(req.getParameter("hotel_id"));

        HotelReviewService hotelReviewService = new HotelReviewService();
        List<HotelReviewsDto> hotelReviewsDtoList = hotelReviewService.getAllReviews(hotelId);
        JSONArray jsonArray = new JSONArray();
        for (HotelReviewsDto hotelReviewsDto : hotelReviewsDtoList) {
            jsonArray.add(new JSONObject(
                    Map.of(
                            "name", hotelReviewsDto.getUserName(),
                            "avatar", hotelReviewsDto.getUserAvatar(),
                            "date", hotelReviewsDto.getDate().toString(),
                            "text", hotelReviewsDto.getText()
                    ))
            );
        }
        resp.getWriter().print(jsonArray.toJSONString());
    }

}
