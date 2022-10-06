package category.controller;

import layout.controller.AbstractController;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="category", urlPatterns = {"/category/edit/*"})
@MultipartConfig
public class Edit  extends AbstractController {

    public Edit() {
        super();

        this.viewControllerRegistry
                .setViewController("/views/homepage/index.jsp");

        this.pageContentRegistry.setTitle("Homepage");
    }
}
