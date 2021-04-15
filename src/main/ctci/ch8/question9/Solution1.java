package main.ctci.ch8.question9;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    static List<String> getParenPerms(int parens) {
        return parens(
                new ArrayList<>(),
                "",
                0,
                parens,
                parens
        );
    }

    static List<String> parens(
            List<String> allStrings,
            String string,
            int currentlyOpen,
            int openNotUsed,
            int closeNotUsed
    ) {

        // We used all parenthesis
        if (openNotUsed == 0 && closeNotUsed == 0) {
            allStrings.add(string);
            return allStrings;
        }

        if (currentlyOpen == 0) {
            parens(
                    allStrings,
                    string + "(",
                    currentlyOpen + 1,
                    openNotUsed - 1,
                    closeNotUsed
            );
            return allStrings;
        } else {
            if (openNotUsed > 0 && closeNotUsed > 0) {
                parens(
                        allStrings,
                        string + "(",
                        currentlyOpen + 1,
                        openNotUsed - 1,
                        closeNotUsed
                );
                parens(
                        allStrings,
                        string + ")",
                        currentlyOpen - 1,
                        openNotUsed,
                        closeNotUsed - 1
                );
                return allStrings;
            } else {
                parens(
                        allStrings,
                        string + ")",
                        currentlyOpen - 1,
                        openNotUsed,
                        closeNotUsed - 1
                );
                return allStrings;
            }
        }
    }
}
