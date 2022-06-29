package ge.gtu.smartfridgewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@SpringBootApplication
public class SmartFridgeWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartFridgeWebAppApplication.class, args);
    }
}
