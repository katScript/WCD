package layout.controller.product;

import jstl.product.Product;
import layout.controller.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "layout", value = "/layout")
public class ProductController extends AbstractController {
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.setTitle("Product");
        this.setMainContent("/product/listing.jsp");
        this.setData("products", new Product("IO1234", "test", 12.3, "sdfs"));

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
