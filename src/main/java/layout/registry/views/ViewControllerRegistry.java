package layout.registry.views;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

import static layout.registry.page.PageContentRegistryInterface.DEFAULT_CONTENT;

public class ViewControllerRegistry {

    protected String view = DEFAULT_CONTENT;

    public ViewControllerRegistry setViewController(String view) {
        this.view = view;

        return this;
    }

    public String getRequestViews(HttpServletRequest request) {
        return view;
    }
}
