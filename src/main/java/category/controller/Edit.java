package category.controller;

import layout.controller.AbstractController;

public class Edit  extends AbstractController {

    public Edit() {
        super();

        this.viewControllerRegistry
                .setViewController("/views/homepage/index.jsp");

        this.pageContentRegistry.setTitle("Homepage");
    }
}
