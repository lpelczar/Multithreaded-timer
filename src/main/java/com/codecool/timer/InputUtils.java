package com.codecool.timer;

class InputUtils {

    static String getCommandValue(String command) {
        if (!containsWhiteSpace(command)) {
            return null;
        } else {
            String[] args = command.split(" ");
            if (args.length < 2) {
                return null;
            }
            return args[1].trim();
        }
    }

    private static boolean containsWhiteSpace(final String testCode){
        if (testCode != null) {
            for (int i = 0; i < testCode.length(); i++) {
                if (Character.isWhitespace(testCode.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
