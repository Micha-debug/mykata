class Calculator1 {

    public Calculator1() {
    }

    int calculate(int num1, char op, int num2) {
        int ans;
        switch (op) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/':
                ans = num1 / num2;
                break;
            default:
                throw new RuntimeException("Error: unexpected operation: " + op);
        }
        return ans;
    }
}
