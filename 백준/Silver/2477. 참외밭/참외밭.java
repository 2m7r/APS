import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] dir = new int[6];
		int[] len = new int[6];

		for (int i = 0; i < 6; i++) {
			dir[i] = sc.nextInt();
			len[i] = sc.nextInt();
		}

		int small = 0;

		int wid = 0;
		int hei = 0;

		// 작은 직사각형
		for (int i = 0; i < 6; i++) {
			int next = (i + 1) % 6;
			if (dir[i] == 3 && dir[next] == 2) {
				small = len[i] * len[next];
			} else if (dir[i] == 4 && dir[next] == 1) {
				small = len[i] * len[next];
			} else if (dir[i] == 1 && dir[next] == 3) {
				small = len[i] * len[next];
			} else if (dir[i] == 2 && dir[next] == 4) {
				small = len[i] * len[next];
			}

		}

		// 큰 직사각형
		for (int i = 0; i < 6; i++) {
			if (dir[i] == 1 || dir[i] == 2) {
				if (len[i] > wid)
					wid = len[i];
			} else if (dir[i] == 3 || dir[i] == 4) {
				if (len[i] > hei)
					hei = len[i];
			}
		}

		int result = wid * hei - small;

		System.out.println(result * n);

	}// main
}// class
