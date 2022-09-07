package layout.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public interface AbstractControllerInterface {
    final String INDEX_PAGE = "index.jsp";
    final String STYLE = "page_style";
    final String HEADER = "page_header";
    final String M_TOP = "main_top";
    final String M_BOT = "main_bot";
    final String M_LEFT = "main_left";
    final String M_RIGHT = "main_right";
    final String M_CONTENT = "main_content";
    final String FOOTER = "page_footer";
    final String STATIC_CONTENT = "page_static";
    final String TITLE = "page_title";

    HashMap<String, String> mapContent = new HashMap<String, String>() {{
        put(TITLE, "");
        put(STYLE, "");
        put(HEADER, "");
        put(M_TOP, "");
        put(M_BOT, "");
        put(M_LEFT, "");
        put(M_RIGHT, "");
        put(M_CONTENT, "");
        put(FOOTER, "");
        put(STATIC_CONTENT, "");
    }};

    HashMap<String, Object> data = new HashMap<>();

    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public String getMainContent();
    public HashMap<String,String> getMapContent();
    public AbstractControllerInterface setTitle(String title);
    public AbstractControllerInterface setStyle(String style);
    public AbstractControllerInterface setHeader(String header);
    public AbstractControllerInterface setMainTop(String mainTop);
    public AbstractControllerInterface setMainBot(String mainBot);
    public AbstractControllerInterface setMainLeft(String mainLeft);
    public AbstractControllerInterface setMainRight(String mainRight);
    public AbstractControllerInterface setMainContent(String mainContent);
    public AbstractControllerInterface setFooter(String footer);
    public AbstractControllerInterface setStatic(String staticContent);

    public HashMap<String, Object> getPageData();
    public AbstractControllerInterface setData(String key, Object value);
    public Object getData(String key);
}
