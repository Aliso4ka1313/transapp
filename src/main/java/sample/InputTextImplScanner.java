package sample;

import java.util.Scanner;

/**
 * Created by dm on 20.02.16.
 */
public class InputTextImplScanner implements InputText {

    @Override
    public String inputText() {

        String input = IOTools.scanner.nextLine();

        return input;
    }
}


