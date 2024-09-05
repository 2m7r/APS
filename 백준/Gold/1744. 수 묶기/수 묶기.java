import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();

		int[] perm = new int[N];

		for (int i = 0; i < N; i++) {
			perm[i] = sc.nextInt();
			sc.nextLine();
		}

		Arrays.sort(perm);

		int sum = 0;

		int i = 0;
		int minus = 0;
		int zero = 0;

		if (N > 1) {
			// 음수일 때
			while (i < N && perm[i] < 0) {
				if (i + 1 < N && perm[i + 1] < 0) { // 절대 값이 큰 음수 두 개씩 묶기
					sum += perm[i] * perm[i + 1];
					i += 2;
				} else {// 짝이 없는 음수
					minus = perm[i];
					i++;
				}
			}

			// 0일 때 -> 음수가 단독으로 남은게 아니라면 스킵
			while (i < N && perm[i] == 0) {
				zero++;
				i++;
			}

			// 짝이 없는 음수가 있지만, 0이 없다면 음수를 더해줌
			if (minus != 0 && zero == 0)
				sum += minus;

			int j = N - 1;
			// 양수일 때
			while (j >= 0 && perm[j] > 0) {
				if (j - 1 >= 0 && perm[j - 1] > 0) {
					if(perm[j]*perm[j-1]>perm[j]+perm[j-1]) {
						sum += perm[j] * perm[j - 1];
						j -= 2;
					}else {
						sum+=perm[j]+perm[j-1];
						j -= 2;
					}
					
				} else {
					sum += perm[j];
					j--;
				}
			}
		} else sum = perm[0]; //N==1이면 수열 그대로 출력
		
		System.out.println(sum);

	}

}