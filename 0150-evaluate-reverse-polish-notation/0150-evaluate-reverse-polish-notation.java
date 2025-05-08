class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for (String t : tokens) {
            //연산자처리
            if (t.length() == 1 && !Character.isDigit(t.charAt(0))) {
                //System.out.println("operator put :" + t);
                if (stack.isEmpty()) continue;
                int num1 = Integer.valueOf(stack.pop());
                if (stack.isEmpty()) continue;
                int num2 = Integer.valueOf(stack.pop());
            

                char c = t.charAt(0);

                int res = 0;
                switch (c) {
                    case '+':
                        res = num1 + num2;
                        break;
                    case '-':
                        res = num2 - num1;
                        break;
                    case '*':
                        res = num1 * num2;
                        break;
                    case '/':
                        if (num1 != 0) res = num2 / num1;
                        break;
                }
                
                stack.push(Integer.toString(res));
            }   

            else {//숫자처리
                //System.out.println("operand");
                stack.push(t);
            }
        }


        return stack.isEmpty() ? -1 :Integer.valueOf(stack.pop());
    
    }


}

/**
String s
s.charAt
 */