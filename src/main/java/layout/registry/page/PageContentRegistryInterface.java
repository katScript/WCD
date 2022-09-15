package layout.registry.page;

import java.util.HashMap;

public interface PageContentRegistryInterface {
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
    String getMainContent();
    HashMap<String,String> getMapContent();
    PageContentRegistryInterface setTitle(String title);
    PageContentRegistryInterface setStyle(String style);
    PageContentRegistryInterface setHeader(String header);
    PageContentRegistryInterface setMainTop(String mainTop);
    PageContentRegistryInterface setMainBot(String mainBot);
    PageContentRegistryInterface setMainLeft(String mainLeft);
    PageContentRegistryInterface setMainRight(String mainRight);
    PageContentRegistryInterface setMainContent(String mainContent);
    PageContentRegistryInterface setFooter(String footer);
    PageContentRegistryInterface setStatic(String staticContent);
    HashMap<String, Object> getPageData();
    PageContentRegistryInterface setData(String key, Object value);
    Object getData(String key);
}
