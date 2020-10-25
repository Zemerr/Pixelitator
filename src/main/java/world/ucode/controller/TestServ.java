package world.ucode.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import world.ucode.model.Picures;




@WebServlet("/upload")
@MultipartConfig
public class TestServ extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("file");
        InputStream fileContent = null;
        PrintWriter out = null;
        String imageStr = null;

        if (filePart!=null) {
            fileContent = filePart.getInputStream();
            out = response.getWriter();


            byte[] imageBytes = new byte[(int)filePart.getSize()];
            if (fileContent != null) {
                fileContent.read(imageBytes, 0, imageBytes.length);
                fileContent.close();
                imageStr = Base64.encodeBase64String(imageBytes);
                System.out.println(imageStr);
            }
            Picures pic = new Picures();
            pic.setBase64Image(imageStr);
            String jsonstring = gson.toJson(pic);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(jsonstring);
            out.close();
        }
    }
}
