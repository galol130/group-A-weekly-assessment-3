package com.ironhack;

import com.ironhack.classes.Input;
import com.ironhack.commands.Command;
import com.ironhack.styles.Start;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main{
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        while (true) {
//      Print the system header:
            Start.printStart();
//      Print initial menu (designers gave us different options):
            Start.printMenuV2();
//      Call the getValidCommand method that validates menu input and calls the methods accordingly.
            String[] command = Input.getValidCommand();
            Command.commandCaller(command);
        }
    }
}
