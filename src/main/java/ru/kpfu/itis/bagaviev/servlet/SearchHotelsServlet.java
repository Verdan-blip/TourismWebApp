package ru.kpfu.itis.bagaviev.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@WebServlet(name = "searchHotelsServlet", urlPatterns = "/search/patterns")
public class SearchHotelsServlet extends HttpServlet {

    private final String queryFormat = "http://engine.hotellook.com/api/v2/lookup.json?query=%s&lang=ru&lookFor=hotels";
    private final String SCHEME = "http";
    private final String HOST = "engine.hotellook.com";
    private final int PORT = 1234;
    private final String PATH = "/api/v2/lookup.json";
    private final String QUERY_FORMAT = "query=%s";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        String query = String.format(QUERY_FORMAT, city);
        try {
            URL url = new URI(SCHEME, null, HOST, PORT, PATH, query, null).toURL();
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);
            } catch (Exception exception) {
                throw new ServletException(exception);
            }
        } catch (Exception exception) {
            throw new ServletException(exception);
        }

    }

}
