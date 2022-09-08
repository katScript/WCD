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
    protected String layout;
    protected HashMap<String, String> directional = new HashMap<>();
    protected HashMap<String, Object> data = new HashMap<>();
    protected HashMap<String, String> mapContent = new HashMap<String, String>() {{
        put(TITLE, DEFAULT_CONTENT);
        put(STYLE, DEFAULT_CONTENT);
        put(HEADER, DEFAULT_CONTENT);
        put(M_TOP, DEFAULT_CONTENT);
        put(M_BOT, DEFAULT_CONTENT);
        put(M_LEFT, DEFAULT_CONTENT);
        put(M_RIGHT, DEFAULT_CONTENT);
        put(M_CONTENT, DEFAULT_CONTENT);
        put(FOOTER, DEFAULT_CONTENT);
        put(STATIC_CONTENT, DEFAULT_CONTENT);
    }};

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        director(request);
        initContent(request);
        initPageData(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(this.getLayout());
        dispatcher.forward(request, response);
    }

    public void director(HttpServletRequest request) {
        String uri = request.getRequestURI();
        this.setMainContent(this.directional.get(uri));
    }
    public AbstractController setDirection(String uri, String target) {
        this.directional.put(uri, target);

        return this;
    }

    protected void initContent(HttpServletRequest request) {
        for (Map.Entry<String, String> entry: this.getMapContent().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

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

    public String getLayout() {
        if (this.layout == null || this.layout.equals(""))
            this.layout = INDEX_PAGE;

        return this.layout;
    }
    public AbstractController setLayout(String layout) {
        this.layout = layout;
        return this;
    }

    @Override
    public HashMap<String, String> getMapContent() {
        return this.mapContent;
    }

    @Override
    public AbstractController setTitle(String title) {
        this.getMapContent().replace(TITLE, title);
        return this;
    }

    @Override
    public AbstractController setStyle(String style) {
        this.getMapContent().replace(STYLE, style);
        return this;
    }

    @Override
    public AbstractController setHeader(String header) {
        this.getMapContent().replace(HEADER, header);
        return this;
    }

    @Override
    public AbstractController setMainTop(String mainTop) {
        this.getMapContent().replace(M_TOP, mainTop);
        return this;
    }

    @Override
    public AbstractController setMainBot(String mainBot) {
        this.getMapContent().replace(M_BOT, mainBot);
        return this;
    }

    @Override
    public AbstractController setMainLeft(String mainLeft) {
        this.getMapContent().replace(M_LEFT, mainLeft);
        return this;
    }

    @Override
    public AbstractController setMainRight(String mainRight) {
        this.getMapContent().replace(M_RIGHT, mainRight);
        return this;
    }

    @Override
    public AbstractController setMainContent(String mainContent) {
        this.getMapContent().replace(M_CONTENT, mainContent);
        return this;
    }

    @Override
    public String getMainContent() {
        return this.getMapContent().get(M_CONTENT);
    }

    @Override
    public AbstractController setFooter(String footer) {
        this.getMapContent().replace(FOOTER, footer);
        return this;
    }

    @Override
    public AbstractController setStatic(String staticContent) {
        this.getMapContent().replace(STATIC_CONTENT, staticContent);
        return this;
    }

    @Override
    public HashMap<String, Object> getPageData() {
        return this.data;
    }

    @Override
    public AbstractController setData(String key, Object value) {
        this.getPageData().put(key, value);

        return this;
    }

    @Override
    public Object getData(String key) {
        return this.getPageData().get(key);
    }
}
