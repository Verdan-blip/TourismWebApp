package ru.kpfu.itis.bagaviev.servlet.news;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.kpfu.itis.bagaviev.dao.NewsDao;
import ru.kpfu.itis.bagaviev.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "newsServlet", urlPatterns = "/news")
public class NewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsDao newsDao = new NewsDao();
        List<News> newsList = newsDao.getAll();
        req.setAttribute("news", newsList);
        req.getRequestDispatcher("ftl/news.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        Integer id = Integer.parseInt(req.getParameter("news_id"));
        NewsDao newsDao = new NewsDao();
        News news = newsDao.get(id);
        JSONObject jsonObject = new JSONObject(
                Map.of(
                        "id", news.getId().toString(),
                        "title", news.getTitle(),
                        "text", news.getText(),
                        "image", news.getImageUrl(),
                        "author", news.getAuthor(),
                        "posting_time", news.getPostingTime().toString()
                )
        );
        resp.getWriter().print(jsonObject.toJSONString());
    }
}
