package ru.kpfu.itis.bagaviev.servlet.tourism;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.kpfu.itis.bagaviev.dao.TouristPlaceDao;
import ru.kpfu.itis.bagaviev.model.TouristPlace;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "touristPlacesServlet", urlPatterns = "/places")
public class TouristPlacesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ftl/tourist_places.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        String city = req.getParameter("city");
        TouristPlaceDao touristPlaceDao = new TouristPlaceDao();
        List<TouristPlace> touristPlaces = touristPlaceDao.get(city);
        JSONArray hotelsJsonArray = new JSONArray();

        for (TouristPlace touristPlace : touristPlaces) {
            hotelsJsonArray.add(new JSONObject(
                    Map.of("name", touristPlace.getName(),
                            "city", touristPlace.getCity(),
                            "location", touristPlace.getLocation(),
                            "image", touristPlace.getImageUrl(),
                            "description", touristPlace.getDescription()
                    )
            ));
        }
        resp.getWriter().print(hotelsJsonArray.toJSONString());
    }

}
