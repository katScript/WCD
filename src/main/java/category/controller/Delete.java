package category.controller;

import layout.controller.AbstractController;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="category", urlPatterns = {"/category/delete/*"})
public class Delete  extends AbstractController {

    public Delete() {
        super();

        this.viewControllerRegistry
                .setViewController("/views/homepage/index.jsp");

        this.pageContentRegistry.setTitle("Homepage");
    }
}
