package ru.kpfu.itis.bagaviev.servlet;

import com.cloudinary.Cloudinary;
import ru.kpfu.itis.bagaviev.dao.UserDao;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.utils.CloudinaryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Map;

@WebServlet(name = "fileUploadingServlet", urlPatterns = "/upload")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class FileUploadingServlet extends HttpServlet {

    private final Cloudinary cloudinary = CloudinaryUtil.getCloudinary();
    public static final String FILE_PATH_PREFIX = "/tmp";
    public static final int DIRECTORIES_COUNT = 100;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");

        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        File file = new File(FILE_PATH_PREFIX + File.separator
                + filename.hashCode() % DIRECTORIES_COUNT + File.separator + filename);

        file.getParentFile().mkdirs();
        file.createNewFile();

        try (InputStream inputStream = part.getInputStream()) {
            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                outputStream.write(buffer);
            }
        }

        Map map = cloudinary.uploader().upload(file, null);

        HttpSession session = req.getSession();
        UserDao userDao = new UserDao();
        User user = (User) session.getAttribute("user");

        String url = (String) map.get("url");
        user.setAvatar(url);

        userDao.update(user);

        resp.sendRedirect("/profile");
    }

}
