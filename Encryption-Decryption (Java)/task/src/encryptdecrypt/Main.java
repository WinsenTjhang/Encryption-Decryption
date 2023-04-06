package encryptdecrypt;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        List<String> argsList = Arrays.asList(args);

        String message = "";
        if (argsList.contains("-data") && argsList.contains("-in") || argsList.contains("-data")) {
            message = args[argsList.indexOf("-data") + 1];
        } else if (argsList.contains("-in") ) {
            String fileName = args[argsList.indexOf("-in") + 1];
            message = readFile(fileName);
        }

        String operation = argsList.contains("-mode") ? args[argsList.indexOf("-mode") + 1] : "enc";
        String algorithm = argsList.contains("-alg") ? args[argsList.indexOf("-alg") + 1] : "shift";
        int key = argsList.contains("-key") ? Integer.parseInt(args[argsList.indexOf("-key") + 1]) : 0;

        String result = "";
        switch (algorithm) {
            case "shift" -> result = shift(message, key, operation);
            case "unicode" -> result = unicode(message, key, operation);
        }

        String fileName = args[argsList.indexOf("-out") + 1];
        writeToFile(argsList.contains("-out"), fileName, result);
    }



    private static void writeToFile(boolean isToFile, String fileName, String result) {
        if (isToFile) {
            File file = new File(fileName);
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.println(result);
            } catch (IOException e) {
                e.getMessage();
            }
        } else {
            System.out.println(result);
        }
    }

    private static String readFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    private static String shift(String message, int key, String operation) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c >= 65 && c <= 90) {
                if (Objects.equals(operation, "enc")) {
                    result.append(c + key > 90 ? (char) (c + key - 26) : (char) (c + key));
                } else {
                    result.append(c - key < 65 ? (char) (c - key + 26) : (char) (c - key));
                }

            } else if (c >= 97 && c <= 122) {
                if (Objects.equals(operation, "enc")) {
                    result.append(c + key > 122 ? (char) (c + key - 26) : (char) (c + key));
                } else {
                    result.append(c - key < 97 ? (char) (c - key + 26) : (char) (c - key));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static String unicode(String message, int key, String operation) {
        key *= Objects.equals(operation, "enc") ? 1 : -1;
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            result.append((char) (c + key));
        }
        return result.toString();
    }

}
