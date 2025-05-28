import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Yugyeong {

	/**
	 * 괄호 문자열이 주어졌을 때, 유효한 괄호인지 판별하세요.
	 * 예: "({[]})" → true, "({[})" → false
	 *
	 * 괄호 종류 : ( , { , [
	 *
	 * Ex) (){}[]
	 * Ex) ({[]})
	 * Ex) ()({})
	 */
	private static final List<String> SUCCESS_LIST = Arrays.asList(
		"",
		"()",
		"[]",
		"{}",
		"({})",
		"{[()]}",
		"([]{})",
		"[({})]",
		"((({[]})))",
		"{([])}",
		"[{({[]})}]"
	);

	private static final List<String> FAIL_LIST = Arrays.asList(
		"(",
		"({[})",
		"([)]",
		"{{{}",
		"[{)]}",
		"(()",
		"{([)]}",
		"}{",
		"[{({})]",
		"[("
	);

	public static void main(String[] args) {
		for (String s : SUCCESS_LIST) {
			System.out.println("성공 : " + isBracket(s));
		}

		for (String s : FAIL_LIST) {
			System.out.println("실패 : " + isBracket(s));
		}
	}

	private static boolean isBracket(String brackets) {
		Stack<Character> stack = new Stack<>();

		for (char bracket : brackets.toCharArray()) {
			switch (bracket) {
				case '(', '{', '[' -> stack.push(bracket);
				case ')' -> {
					if (stack.isEmpty() || stack.pop() != '(')
						return false;
				}
				case '}' -> {
					if (stack.isEmpty() || stack.pop() != '{')
						return false;
				}
				case ']' -> {
					if (stack.isEmpty() || stack.pop() != '[')
						return false;
				}
				default -> {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

}
