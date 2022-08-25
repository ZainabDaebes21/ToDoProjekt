package com.example.todoprojekt.views;

import com.example.todoprojekt.security.PrincipalUtils;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@Route(value = "/", layout = AppView.class)
public class HelloView extends VerticalLayout {

    public HelloView() {
        add(new H2("Task management tool"));
        Paragraph paragraph = new Paragraph("A simple to-do list that meets your needs");

        Button loginButton = new Button("Login", evt -> UI.getCurrent().navigate(LoginView.class));
        loginButton.addThemeVariants(ButtonVariant.LUMO_LARGE);

        if(!PrincipalUtils.isAuthenticated()){
            add(loginButton, paragraph);
        }

        setAlignItems(Alignment.CENTER);
    }

}
