package main.problems.java;

public class Nr125 {
    public static void main(String[] args) {
        Nr125 nr125 = new Nr125();
        System.out.println(
                nr125.isPalindrome("A man, a plan, a canal: Panama")
        );
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int pointerFront = 0;
        int pointerBack = s.length() - 1;
        while (pointerFront < pointerBack) {
            char pointerFrontChar = s.charAt(pointerFront);
            if (
                    (pointerFrontChar - 'a' < 0 || pointerFrontChar - 'a' >= 26)
                            && (pointerFrontChar - '0' < 0 || pointerFrontChar - '0' >= 10)
            ) {
                pointerFront++;
                continue;
            }

            char pointerBackChar = s.charAt(pointerBack);
            if (
                    (pointerBackChar - 'a' < 0 || pointerBackChar - 'a' >= 26)
                            && (pointerBackChar - '0' < 0 || pointerBackChar - '0' >= 10)
            ) {
                pointerBack--;
                continue;
            }
            if (pointerBackChar == pointerFrontChar) {
                pointerFront++;
                pointerBack--;
            } else {
                return false;
            }
        }
        return true;
    }
}
