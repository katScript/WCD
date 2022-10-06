package layout.controller.index;

import layout.controller.AbstractController;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="homepage", urlPatterns = "")
public class IndexController extends AbstractController {

    public IndexController() {
        super();

        this.userValidate.setLoginRequire(false);
        this.viewControllerRegistry
                .setViewController("/views/homepage/index.jsp");

        this.pageContentRegistry.setTitle("Homepage");
    }
}
