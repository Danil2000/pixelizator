package world.ucode;

import world.ucode.module.Pixelate;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;


@MultipartConfig
public class Pixel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        Pixelate pixels = new Pixelate();
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = pixels.toPixel(filePart.getInputStream());
        if (fileContent != null) {
            OutputStream out = resp.getOutputStream();
            byte[] buffer = new byte[2400];
            int count = 0;
            while ((count = fileContent.read(buffer)) >= 0) {
                resp.getOutputStream().write(buffer);
            }
        }
        else {
            resp.getWriter().println("Bad image");
        }
        System.out.println("Hey");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
