package com.example.todoprojekt;

import com.example.todoprojekt.entities.AppUser;
import com.example.todoprojekt.entities.Todo;
import com.example.todoprojekt.repositories.AppUserRepository;
import com.example.todoprojekt.repositories.TodoRepository;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class ToDoProjektApplication implements CommandLineRunner {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ToDoProjektApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        AppUser Zainab = new AppUser("Zainab", passwordEncoder.encode("wood"));
        AppUser Martin = new AppUser("Martin", passwordEncoder.encode("wood"));
        AppUser Viktor = new AppUser("Viktor", passwordEncoder.encode("wood"));
        appUserRepository.saveAll(List.of(Zainab, Martin, Viktor));

        Todo toDo = new Todo("Finish project", true, Zainab);
        Todo toDo1 = new Todo("Cook Dinner", false, Zainab);
        Todo toDo2 = new Todo("Groceries", true, Martin);
        Todo todo3 = new Todo("Workout", false, Martin);
        Todo todo4 = new Todo("Start assignment", false, Zainab);

        todoRepository.saveAll(List.of(toDo,toDo1, toDo2, todo3, todo4));

    }
}
