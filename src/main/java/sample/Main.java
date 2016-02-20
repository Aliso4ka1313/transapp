package sample;

public class Main {
    private static String stringToTranslate;
    private static String translatedString;

    public static void main(String[] args)throws Exception {

        System.out.println("input text to translate");
        InputTextImplScanner scanner = new InputTextImplScanner() ;

        stringToTranslate =FileUtil.readFromFile();
        //stringToTranslate = scanner.inputText();
        //stringToTranslate = "cat dog tree mouse";

        translatedString = TranslateUtil.translate(stringToTranslate);
        FileUtil.writeToFile(translatedString);
   }

}

