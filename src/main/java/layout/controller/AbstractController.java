package layout.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AbstractController extends HttpServlet implements AbstractControllerInterface {
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initContent(request);
        initPageData(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX_PAGE);
        dispatcher.forward(request, response);
    }

    protected void initContent(HttpServletRequest request) {
        for (Map.Entry<String, String> entry: this.getMapContent().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (!value.equals(""))
                request.setAttribute(key, value);
        }
    }
    protected void initPageData(HttpServletRequest request) {
        for (Map.Entry<String, Object> entry: this.getPageData().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            request.setAttribute(key, value);
        }
    }
    @Override
    public HashMap<String, String> getMapContent() {
        return this.mapContent;
    }

    @Override
    public AbstractControllerInterface setTitle(String title) {
        this.getMapContent().replace(TITLE, title);
        return this;
    }

    @Override
    public AbstractControllerInterface setStyle(String style) {
        this.getMapContent().replace(STYLE, style);
        return this;
    }

    @Override
    public AbstractControllerInterface setHeader(String header) {
        this.getMapContent().replace(HEADER, header);
        return this;
    }

    @Override
    public AbstractControllerInterface setMainTop(String mainTop) {
        this.getMapContent().replace(M_TOP, mainTop);
        return this;
    }

    @Override
    public AbstractControllerInterface setMainBot(String mainBot) {
        this.getMapContent().replace(M_BOT, mainBot);
        return this;
    }

    @Override
    public AbstractControllerInterface setMainLeft(String mainLeft) {
        this.getMapContent().replace(M_LEFT, mainLeft);
        return this;
    }

    @Override
    public AbstractControllerInterface setMainRight(String mainRight) {
        this.getMapContent().replace(M_RIGHT, mainRight);
        return this;
    }

    @Override
    public AbstractControllerInterface setMainContent(String mainContent) {
        this.getMapContent().replace(M_CONTENT, mainContent);
        return this;
    }

    @Override
    public String getMainContent() {
        return this.getMapContent().get(M_CONTENT);
    }

    @Override
    public AbstractControllerInterface setFooter(String footer) {
        this.getMapContent().replace(FOOTER, footer);
        return this;
    }

    @Override
    public AbstractControllerInterface setStatic(String staticContent) {
        this.getMapContent().replace(STATIC_CONTENT, staticContent);
        return this;
    }

    @Override
    public HashMap<String, Object> getPageData() {
        return this.data;
    }

    @Override
    public AbstractControllerInterface setData(String key, Object value) {
        this.getPageData().put(key, value);

        return this;
    }

    @Override
    public Object getData(String key) {
        return this.getPageData().get(key);
    }
}
