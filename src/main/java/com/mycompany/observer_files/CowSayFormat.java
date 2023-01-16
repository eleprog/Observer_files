package com.mycompany.observer_files;

public class CowSayFormat {

    static String print(String str) {
        String formatStr = "_";
        formatStr += "_".repeat(str.length() + 3);

        formatStr += "\n\\ " + str + " /\n \\";

        formatStr += "_".repeat(str.length());
        formatStr += "/\n";

        formatStr +=
                """
                      \\  ^__^
                       \\ (oo)\\______
                         (__)\\      )\\|\\
                           ||----w |
                           ||     ||
                """;


        return formatStr;
    }
}
