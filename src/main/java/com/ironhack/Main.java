package com.ironhack;

import com.ironhack.classes.Input;
import com.ironhack.commands.CommandService;
import com.ironhack.styles.Start;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private CommandService commandService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//      Print the new version features
        Start.printNewVersion();
        Input.getEnterToContinue();

        while (true) {
//      Print the system header:
            Start.printStart();
//      Print initial menu (designers gave us different options):
            Start.printMenuV2();
//      Call the getValidCommand method that validates menu input and calls the methods accordingly.
            String[] command = Input.getValidCommand();
            commandService.commandCaller(command);
        }
    }
}
