package upload.demo;

import layout.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(name="demoupload", urlPatterns = {"/upload"})
@MultipartConfig
public class Upload  extends AbstractController {
    public Upload() {
        super();

        this.viewControllerRegistry
                .setViewController("/views/upload/index.jsp");

        this.pageContentRegistry.setTitle("Demo upload");
    }

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        super.doPost(request, response);

        try {
            Part part = request.getPart("tFile");
            String realPath = request.getServletContext().getRealPath("/images");
            String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectories(Path.of(realPath));
            }

            part.write(realPath + "/" + fileName);
            this.pageContentRegistry.setData("fileName", fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}