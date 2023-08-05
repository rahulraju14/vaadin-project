package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
public class MainView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;
    private Span span = new Span();

    public MainView() {
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        span.getElement().setAttribute("style", "align-self: flex-end; font-size: 3em; margin-left: 2em; color: red; background: lavender;");
        sayHello.addClickListener(e -> {
        	span.removeAll();
        	span.add("Welcome :" + name.getValue().toUpperCase());
            Notification.show("Hello " + name.getValue());
            span.removeAll();
        });
        sayHello.addClickShortcut(Key.ENTER);
        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello, span);

        add(name, sayHello, span);
    }

}
