package org.example.date_20250523_q1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Choi {

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
		"[{({[]})}]",
		"()({})"
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
		"[({})]}}"
	);

	public static void main(String[] args) {
		for (String target : SUCCESS_LIST) {
			System.out.println("성공해야하는 결과 : " + parentheses(target));
		}

		System.out.println("실패해야하는 결과 >>>>>>>>>>>>> ");

		for (String target : FAIL_LIST) {
			System.out.println("결과 : " + parentheses(target));
		}
	}

	private static final List<Character> OPEN_PARENTHESES = Arrays.asList('(', '{', '[');

	public static boolean parentheses(String target) {
		Stack<Character> parenthesesStack = new Stack<>();
		char[] targetWords = target.toCharArray();

		for (char word : targetWords) {

			if (OPEN_PARENTHESES.contains(word)) {
				parenthesesStack.push(word);
				continue;
			}

			if (parenthesesStack.isEmpty()) {
				return false;
			}
			char parentheses = parenthesesStack.peek();


			if (matchParentheses(word, parentheses)) {
				parenthesesStack.pop();
			} else {
				return false;
			}
		}

		return parenthesesStack.isEmpty();
	}

	private static boolean matchParentheses(char word, char parentheses) {
		return word == ')' && parentheses == '(' ||
		word == '}' && parentheses == '{' ||
		word == ']' && parentheses == '[';
	}
}
