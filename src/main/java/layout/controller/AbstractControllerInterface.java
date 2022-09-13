package layout.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public interface AbstractControllerInterface {
    String INDEX_PAGE = "/index.jsp";
    String DEFAULT_CONTENT = "default.jsp";
    String STYLE = "page_style";
    String HEADER = "page_header";
    String M_TOP = "main_top";
    String M_BOT = "main_bot";
    String M_LEFT = "main_left";
    String M_RIGHT = "main_right";
    String M_CONTENT = "main_content";
    String FOOTER = "page_footer";
    String STATIC_CONTENT = "page_static";
    String TITLE = "page_title";
    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    String getMainContent();
    HashMap<String,String> getMapContent();
    AbstractControllerInterface setTitle(String title);
    AbstractControllerInterface setStyle(String style);
    AbstractControllerInterface setHeader(String header);
    AbstractControllerInterface setMainTop(String mainTop);
    AbstractControllerInterface setMainBot(String mainBot);
    AbstractControllerInterface setMainLeft(String mainLeft);
    AbstractControllerInterface setMainRight(String mainRight);
    AbstractControllerInterface setMainContent(String mainContent);
    AbstractControllerInterface setFooter(String footer);
    AbstractControllerInterface setStatic(String staticContent);
    HashMap<String, Object> getPageData();
    AbstractControllerInterface setData(String key, Object value);
    Object getData(String key);
}
