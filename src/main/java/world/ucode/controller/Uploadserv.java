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
import java.util.Enumeration;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import world.ucode.model.Picures;
import world.ucode.model.Pixelizator;


@WebServlet("/upload")
@MultipartConfig
public class Uploadserv extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("file");
        PrintWriter out;

        Enumeration<String> headerNames = request.getHeaderNames();
        //request.getHeaders();
        //Enumeration<String> header= request.getHeaders();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.println("Header: " + headerName + " "+ request.getHeader(headerName));
            }
        }

        if (filePart!=null) {
            out = response.getWriter();
            Pixelizator pixelizator = new Pixelizator(filePart);
            String jsonstring = gson.toJson(pixelizator.getPic());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(jsonstring);
            out.close();

        }
    }
}
