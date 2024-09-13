package com.farsiman.sistema_de_viajes;

import com.farsiman.sistema_de_viajes.view.AdministrarSucursalesView;
import com.farsiman.sistema_de_viajes.view.LoginView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.farsiman.sistema_de_viajes.repository","com.farsiman.sistema_de_viajes.model","com.farsiman.sistema_de_viajes.view", "com.farsiman.sistema_de_viajes.controller", "com.farsiman.sistema_de_viajes.service"})
public class SistemaDeViajesApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SistemaDeViajesApplication.class, args);

        LoginView loginView = context.getBean(LoginView.class);
        loginView.setVisible(true);
    }

}
