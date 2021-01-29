package com.ironhack;

import com.ironhack.classes.Input;
import com.ironhack.commands.Command;
import com.ironhack.styles.Start;

public class Main {
    public static void main(String[] args) {
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
