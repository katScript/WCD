package category.controller;

import layout.controller.AbstractController;

public class New extends AbstractController {

    public New() {
        super();

        this.viewControllerRegistry
                .setViewController("/views/homepage/index.jsp");

        this.pageContentRegistry.setTitle("Homepage");
    }
}
