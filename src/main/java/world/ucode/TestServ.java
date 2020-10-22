package world.ucode;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;



@WebServlet("/upload")
@MultipartConfig
public class TestServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.getWriter().write("mazafaka");
        //resp.get
        System.out.println("\n\nloliata\n\n");

        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        System.out.println("after desc");

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        System.out.println("after part " + filePart);
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        System.out.println("after filename");
        InputStream fileContent = filePart.getInputStream();

        OutputStream out = resp.getOutputStream();

        // Copy the contents of the file to the output stream
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = fileContent.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        fileContent.close();

        System.out.println("description = " + description);
        System.out.println("filename = " + fileName);
        System.out.println(fileContent);




//        for (Part part : request.getParts()) {
//            String fileName = getFileName(part);
//            System.out.println(fileName);
//            //part.write(uploadPath + File.separator + fileName);
//        }
//    }
//
//    private String getFileName(Part part) {
//        for (String content : part.getHeader("content-disposition").split(";")) {
//            if (content.trim().startsWith("filename"))
//                return content.substring(content.indexOf("=") + 2, content.length() - 1);
//        }
//        return null;
    }
}
