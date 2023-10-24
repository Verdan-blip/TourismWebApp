package ru.kpfu.itis.bagaviev.servlet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.kpfu.itis.bagaviev.dao.HotelDao;
import ru.kpfu.itis.bagaviev.model.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "searchHotelsServlet", urlPatterns = "/search")
public class SearchHotelsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        String city = req.getParameter("city");
        HotelDao hotelDao = new HotelDao();
        List<Hotel> hotels = hotelDao.get(city);
        JSONArray hotelsJsonArray = new JSONArray();

        for (Hotel hotel : hotels) {
            hotelsJsonArray.add(new JSONObject(
                    Map.of("name", hotel.getName(),
                            "city", hotel.getCity(),
                            "location", hotel.getLocation(),
                            "image", hotel.getImageUrl(),
                            "star_rating", hotel.getStarRating(),
                            "price_per_night", hotel.getPricePerNight())
            ));
        }
        resp.getWriter().print(hotelsJsonArray.toJSONString());
    }

}
