package org.example.date_20250516_game369;

import java.util.Arrays;
import java.util.List;

public class Game369Choi {
	public static void main(String[] args) {
		game369(100000);
	}

	private static final List<Character> THREE_SIX_NINE = Arrays.asList('3', '6', '9');

	public static void game369(int num) {
		if (doNotContinueGame(num)) {
			System.out.println("369게임은 1번보다 적게, 10만보다 크게 할 수 없습니다.");
		}

		for (int i = 1; i <= num; i++) {
			char[] numberToCharArray = Integer.toString(i).toCharArray();

			StringBuilder clapWordBuilder = new StringBuilder();
			for (char numberChar : numberToCharArray) {
				if (THREE_SIX_NINE.contains(numberChar)) {
					clapWordBuilder.append("짝");
				}
			}

			if (clapWordBuilder.isEmpty()) {
				System.out.println(i);
			} else {
				System.out.println(clapWordBuilder + "(" + i + ")");
			}
		}
	}

	private static boolean doNotContinueGame(int num) {
		return num < 1 || num > 100000;
	}
}
