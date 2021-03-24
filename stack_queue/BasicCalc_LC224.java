import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicCalc_LC224 {
    public int calculate(String s) {
        if (s == null)
            return 0;

        List<String> tokens = infixToPostfix(s);
        // System.out.println(tokens);
        if (tokens.size() == 1)
            return Integer.parseInt(tokens.get(0));
        long result = processPostFix(tokens);

        return (int) result;
    }

    private boolean isOperator(String token) {
        List<Character> operands = List.of('+', '-', '*', '/');
        return token.length() == 1 && operands.contains(token.charAt(0));
    }

    private long processPostFix(List<String> tokens) {
        Deque<Long> operandStack = new ArrayDeque<>();
        long result = 0;

        for (int i = 0; i < tokens.size(); i++) {
            // Each of the string tokens can either be a operator or a number
            if (isOperator(tokens.get(i))) {

                String operator = tokens.get(i);
                long operandA = operandStack.removeFirst();
                long operandB = operandStack.removeFirst();

                switch (operator) {
                case "*":
                    result = operandA * operandB;
                    break;
                case "-":
                    result = operandB - operandA;
                    break;
                case "+":
                    result = operandA + operandB;
                    break;
                case "/":
                    result = operandB / operandA;
                    break;
                }
                operandStack.addFirst(result);
            } else {
                operandStack.addFirst(Long.valueOf(tokens.get(i)));
            }
        }
        return operandStack.removeFirst();
    }

    public List<String> infixToPostfix(String exp) {
        Deque<Character> operatorStack = new ArrayDeque<>();

        // Define the priority
        Map<Character, Integer> operatorPriority = Map.of('+', 1, '-', 1, '/', 2, '*', 2, '^', 3);
        Set<Character> operands = operatorPriority.keySet();
        List<String> tokens = new ArrayList<>();

        char[] infix = exp.toCharArray();

        long num = 0;

        for (int i = 0; i < infix.length; i++) {
            if (Character.isDigit(infix[i])) {
                num = num * 10 + (infix[i] - '0');
            }
            // Operands
            else if (operands.contains(infix[i])) {
                if (num > Long.MIN_VALUE) {
                    tokens.add(String.valueOf(num));
                    num = Long.MIN_VALUE;
                }

                while (!operatorStack.isEmpty() && operatorStack.getFirst() != '('
                        && operatorPriority.get(infix[i]) <= operatorPriority.get(operatorStack.getFirst())) {

                    tokens.add(String.valueOf(operatorStack.removeFirst()));

                }
                operatorStack.addFirst(infix[i]);
            } else if (infix[i] == 32)
                continue;
            else if (infix[i] == '(') {
                operatorStack.addFirst(infix[i]);
            } else if (infix[i] == ')') {
                if (num > Long.MIN_VALUE) {
                    tokens.add(String.valueOf(num));
                    num = Long.MIN_VALUE;
                }
                // (1 + (4 + 3 / 2) - 3)
                // tokens - 1 4 3 2 / + 3 - +
                // stack - EMPTY
                while (operatorStack.getFirst() != '(') {
                    tokens.add(String.valueOf(operatorStack.removeFirst()));
                }
                operatorStack.removeFirst(); // This gets the Opening bracket out of the stack.
            }
        }
        if (num > Long.MIN_VALUE) {
            tokens.add(String.valueOf(num));
            num = 0;
        }
        // Append the remaining characters
        while (!operatorStack.isEmpty()) {
            tokens.add(String.valueOf(operatorStack.removeFirst()));
        }
        return tokens;
    }
}
