package category.controller;

import layout.controller.AbstractController;

public class Delete  extends AbstractController {

    public Delete() {
        super();

        this.viewControllerRegistry
                .setViewController("/views/homepage/index.jsp");

        this.pageContentRegistry.setTitle("Homepage");
    }
}
