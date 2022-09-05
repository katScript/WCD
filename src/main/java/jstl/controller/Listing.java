package jstl.controller;

import jstl.product.Product;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "product", value = "/product")
public class Listing extends HttpServlet {

    private void processRequest(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product("axd", "p1", 33.4, "ok"));
        productList.add(new Product("agc", "p2", 77.4, "ko"));

        if (request.getMethod().equals("POST")) {
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String des = request.getParameter("des");

            productList.add(new Product(code, name, price, des));
        }

        request.setAttribute("products", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jstl/listing.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        processRequest(request, response);
    }
}
