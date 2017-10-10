package com.vaadin.flow.tutorial.routing;

import com.vaadin.flow.tutorial.annotations.CodeFor;
import com.vaadin.router.ErrorParameter;
import com.vaadin.router.HasErrorParameter;
import com.vaadin.router.NotFoundException;
import com.vaadin.router.event.BeforeNavigationEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tag;

@CodeFor("routing/tutorial-routing-exception-handling.asciidoc")
public class ExceptionHandling {

    @Tag(Tag.DIV)
    public class RouteNotFoundError extends Component
            implements HasErrorParameter<NotFoundException> {

        @Override
        public int setErrorParameter(BeforeNavigationEvent event,
                ErrorParameter<NotFoundException> parameter) {
            getElement().setText(
                    "Could not navigate to '" + event.getLocation().getPath() + "'");
            return 404;
        }
    }

    public class CustomNotFoundTarget extends RouteNotFoundError
            implements HasErrorParameter<NotFoundException> {

        @Override
        public int setErrorParameter(BeforeNavigationEvent event,
                ErrorParameter<NotFoundException> parameter) {
            getElement().setText("My custom not found class!");
            return 404;
        }
    }
}
