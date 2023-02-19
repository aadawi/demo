package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

    /**
     * This is the main method that used to start the application
     *
     * @param args String Arguments array
     * @Auther Aadawi
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        User leadUser = new User();
        leadUser.setName("lead");
        leadUser.setMobile(1234);
        leadUser.setEmail("lead@com");
        leadUser.setChildren(new ArrayList<>());
        for (int i = 0; i < 20000; i++) {
            User user = new User();
            user.setName("Ahmad" + i);
            user.setEmail(String.format("ama %s @.com", i + ""));
            user.setMobile(05555 + i);
            user.setParent(leadUser);
            leadUser.getChildren().add(user);
            if (i % 100 == 0) {
                userRepository.save(leadUser);
                leadUser = new User();
                leadUser.setName("lead" + i);
                leadUser.setMobile(1234);
                leadUser.setEmail("lead@com");
                leadUser.setChildren(new ArrayList<>());
            }
        }

    }
}
