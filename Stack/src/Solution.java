import java.util.Scanner;
import java.util.Stack;

/**
 * 栈的应用：括号匹配问题
 * @author DUSTY
 */
public class Solution {

    public boolean isValid(String s){

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //查看s中第i个的字符
            char c = s.charAt(i);
            if (c =='(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
              //当前考察字符为右括号，需要查看栈顶的字符是否与该右括号匹配
              //先考虑如果当前栈顶元素为空，即为空栈
              if (stack.isEmpty()) {
                  return false;
              }
              //继续查看当前栈顶元素
                Character topChar = stack.pop();
                if (c ==')' && topChar != '('){
                    return false;
                }
                if (c ==']' && topChar !='['){
                    return false;
                }
                if (c =='}' && topChar !='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args){

        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}
