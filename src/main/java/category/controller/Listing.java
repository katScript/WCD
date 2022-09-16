package category.controller;

import layout.controller.AbstractController;

public class Listing extends AbstractController {
    public Listing() {
        super();

        this.viewControllerRegistry
                .setViewController("/views/homepage/index.jsp");

        this.pageContentRegistry.setTitle("Homepage");
    }
}