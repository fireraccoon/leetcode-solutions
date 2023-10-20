/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {

    private int pointer = 0, inputLength;

    private String input;

    public String decodeString(String s) {
        input = s;
        inputLength = s.length();
        return LL1Parse().toString();
    }

    private StringBuilder LL1Parse() {
        if (pointer == inputLength) {
            return new StringBuilder();
        }

        Token token = getToken();
        return switch (token.type) {
            case Token.NUMBER -> {
                StringBuilder insideString = LL1Parse();
                StringBuilder sb = new StringBuilder();
                for (int i = Integer.valueOf(token.value); i > 0; i--) {
                    sb.append(insideString);
                }
                yield sb.append(LL1Parse());
            }
            case Token.LETTER -> new StringBuilder(token.value).append(LL1Parse());
            case Token.END -> new StringBuilder();
            default -> LL1Parse();
        };
    }

    private Token getToken() {
        char c = input.charAt(pointer);
        if (c == '[') {
            pointer++;
            return new Token("", Token.BEGIN);
        } else if (c == ']') {
            pointer++;
            return new Token("", Token.END);
        }
        Token token;
        int start = pointer;
        if (Character.isDigit(c)) {
            while (++pointer < inputLength && Character.isDigit(input.charAt(pointer)));
            token = new Token(input.substring(start, pointer), Token.NUMBER);
        } else {
            while (++pointer < inputLength && Character.isLetter(input.charAt(pointer)));
            token = new Token(input.substring(start, pointer), Token.LETTER);
        }
        return token;
    }

    private class Token {

        public String value;

        public int type;

        public final static int NUMBER = 0, LETTER = 1, BEGIN = 2, END = 3;

        public Token(String value, int type) {
            this.value = value;
            this.type = type;
        }
    }
}
// @lc code=end

