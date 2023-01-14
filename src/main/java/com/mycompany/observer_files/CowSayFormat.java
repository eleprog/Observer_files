package com.mycompany.observer_files;

public class CowSayFormat {

    static String print(String str) {
        String formatStr = "";

        for(int i = 0; i < str.length() + 4; i++)
            formatStr += "_";

        formatStr += "\n\\ " + str + " /\n \\";

        for(int i = 0; i < str.length(); i++)
            formatStr += "_";
        formatStr += "/\n";

        formatStr +=
                "      \\  ^__^              \n"+
                "       \\ (oo)\\______      \n"+
                "         (__)\\      )\\|\\ \n"+
                "           ||----w |        \n"+
                "           ||     ||          ";


        return formatStr;
    }
}
