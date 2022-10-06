package layout.controller;

import layout.registry.page.PageContentRegistry;
import layout.registry.views.ViewControllerRegistry;
import session.user.UserValidate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


public abstract class AbstractController extends HttpServlet {
    protected ViewControllerRegistry viewControllerRegistry;

    protected PageContentRegistry pageContentRegistry;

    protected UserValidate userValidate;

    public AbstractController() {
        this.viewControllerRegistry = new ViewControllerRegistry();
        this.pageContentRegistry = new PageContentRegistry();
        this.userValidate = new UserValidate();
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!this.userValidate.validate(request)) {
            response.sendRedirect("/user/login");
            return;
        }

        this.initViews(request).
                initContent(request).
                initPageData(request).
                dispatchRequest(request, response);
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

    public AbstractController initViews(HttpServletRequest request) {
        this.pageContentRegistry
                .setMainContent(
                    this.viewControllerRegistry.getRequestViews(request)
                );

        return this;
    }
    protected AbstractController initContent(HttpServletRequest request) {
        HashMap<String, String> mapContent = this.pageContentRegistry.getMapContent();

        for (String key: mapContent.keySet()) {

            request.setAttribute(key, mapContent.get(key));
        }

        return this;
    }
    protected AbstractController initPageData(HttpServletRequest request) {
        HashMap<String, Object> pageData = this.pageContentRegistry.getPageData();
        for (String key: pageData.keySet()) {

            request.setAttribute(key, pageData.get(key));
        }

        return this;
    }
    public void dispatchRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(this.pageContentRegistry.getLayout());
        dispatcher.forward(request, response);
    }
}
