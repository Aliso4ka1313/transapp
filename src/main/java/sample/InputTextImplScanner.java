package sample;

public class InputTextImplScanner implements InputText {

    @Override
    public String inputText() {
        String input = IOTools.scanner.nextLine();
        return input;
    }
}


