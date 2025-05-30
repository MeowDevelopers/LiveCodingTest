package org.example.date_20250516_q1;

public class Game369Ko {

	public static void main(String[] args) {
		int N = -1;
		print(N);
	}

	private static final List<String> THREE_SIX_NINE_WORDS = Arrays.asList("3", "6", "9");

	public static void print(int N) {
		if (N <= 0 || N > 100000) throw new RuntimeException("N은 1 이상 10,000 이하 숫자만 가능합니다.");

		String clap = "짝";

		for(int i = 1; i <= N; i++) {
			String numToString = String.valueOf(i);
			String[] splitNumbers = numToString.split("");

			long count = Arrays.stream(splitNumbers).filter(THREE_SIX_NINE_WORDS::contains).count();

			if (count == 0) {
				System.out.println(i);
			} else {
				for (int clapCount = 0; clapCount < count; clapCount++) {
					System.out.print(clap);
				}
				System.out.println("(" + i + ")");
			}
		}
	}

}
