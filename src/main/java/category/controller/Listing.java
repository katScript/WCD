package category.controller;

import layout.controller.AbstractController;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="category", urlPatterns = {"/category"})
public class Listing extends AbstractController {
    public Listing() {
        super();

        this.viewControllerRegistry
                .setViewController("/views/homepage/index.jsp");

        this.pageContentRegistry.setTitle("Homepage");
    }
}