package ru.kpfu.itis.bagaviev.servlet.reviews;

import ru.kpfu.itis.bagaviev.dto.SiteReviewDto;
import ru.kpfu.itis.bagaviev.model.SiteReview;
import ru.kpfu.itis.bagaviev.service.SiteReviewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "siteReviewsServlet", urlPatterns = "/reviews")
public class SiteReviewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("review-text");
        Short starRate = Short.parseShort(req.getParameter("star-rate"));
        Date date = new Date(System.currentTimeMillis());

        HttpSession session = req.getSession();
        Integer userId = (Integer) (session.getAttribute("userId"));

        SiteReview siteReview = new SiteReview(userId, date, text, starRate);
        SiteReviewService service = new SiteReviewService();
        service.save(siteReview);

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SiteReviewService service = new SiteReviewService();
        List<SiteReviewDto> siteReviewDtoList = service.getAll();
        req.setAttribute("reviews", siteReviewDtoList);
        req.getRequestDispatcher("ftl/site_reviews.ftl").forward(req, resp);
    }

}
