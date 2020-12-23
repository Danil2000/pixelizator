package world.ucode;

import world.ucode.module.Pixelate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;


@MultipartConfig
public class Pixel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        Pixelate pixels = new Pixelate();
        int pixSize = inputStreamToInt(req.getPart("size").getInputStream());
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = pixels.toPixel(filePart.getInputStream(), pixSize);
                
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
    }
    private static int inputStreamToInt(InputStream is) {
        return Integer.parseInt(inputStreamToString(is));
    }
    private static String inputStreamToString(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
