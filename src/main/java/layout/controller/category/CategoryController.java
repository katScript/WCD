package layout.controller.category;

import database.category.Category;
import database.category.CategoryDao;
import database.category.CategoryRepository;
import jstl.product.Product;
import layout.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "category", urlPatterns = {"/category"})
public class CategoryController extends AbstractController {
    private CategoryDao categoryDao;

    public CategoryController() {
        this.setDirection("/category", "/category/listing.jsp");
        this.categoryDao = new CategoryDao();
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.setTitle("Category")
                .setData("products", new Product("IO1234", "test", 12.3, "sdfs"));

        super.processRequest(request, response);
    }

    @Override
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        processRequest(request, response);
    }
}
