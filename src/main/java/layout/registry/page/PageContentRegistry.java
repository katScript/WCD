package layout.registry.page;

import java.util.HashMap;

public class PageContentRegistry implements PageContentRegistryInterface {
    protected String layout;

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


    public String getLayout() {
        if (this.layout == null || this.layout.equals(""))
            this.layout = INDEX_PAGE;

        return this.layout;
    }
    public PageContentRegistry setLayout(String layout) {
        this.layout = layout;
        return this;
    }

    public HashMap<String, String> getMapContent() {
        return this.mapContent;
    }

    public PageContentRegistry setTitle(String title) {
        this.getMapContent().replace(TITLE, title);
        return this;
    }

    public PageContentRegistry setStyle(String style) {
        this.getMapContent().replace(STYLE, style);
        return this;
    }

    public PageContentRegistry setHeader(String header) {
        this.getMapContent().replace(HEADER, header);
        return this;
    }

    public PageContentRegistry setMainTop(String mainTop) {
        this.getMapContent().replace(M_TOP, mainTop);
        return this;
    }

    public PageContentRegistry setMainBot(String mainBot) {
        this.getMapContent().replace(M_BOT, mainBot);
        return this;
    }

    public PageContentRegistry setMainLeft(String mainLeft) {
        this.getMapContent().replace(M_LEFT, mainLeft);
        return this;
    }

    public PageContentRegistry setMainRight(String mainRight) {
        this.getMapContent().replace(M_RIGHT, mainRight);
        return this;
    }

    public PageContentRegistry setMainContent(String mainContent) {
        this.getMapContent().replace(M_CONTENT, mainContent);
        return this;
    }

    public String getMainContent() {
        return this.getMapContent().get(M_CONTENT);
    }

    public PageContentRegistry setFooter(String footer) {
        this.getMapContent().replace(FOOTER, footer);
        return this;
    }

    public PageContentRegistry setStatic(String staticContent) {
        this.getMapContent().replace(STATIC_CONTENT, staticContent);
        return this;
    }

    public HashMap<String, Object> getPageData() {
        return this.data;
    }

    public PageContentRegistry setData(String key, Object value) {
        this.getPageData().put(key, value);

        return this;
    }

    public Object getData(String key) {
        return this.getPageData().get(key);
    }
}
