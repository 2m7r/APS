import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sb[] = new int[9]; // 난쟁이 배열
		int real[] = new int[7]; // 찐난쟁이 배열

		int f1 = 0; // 짭난쟁이1
		int f2 = 0; // 짭난쟁이2
		int sum = 0; // 키의 총합

		for (int i = 0; i < 9; i++) { // 난쟁이 키 모음
			sb[i] = sc.nextInt();
			sum += sb[i];
		}
		
//		sc.close();
		
		// 짭난쟁이 찾기
		out:
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == j)
					continue;
				else if (sum - sb[i] - sb[j] == 100) {
					f1 = i;
					f2 = j;
					break out;
				}
			}
		}

        // 찐난쟁이 배열
		for (int i = 0, index = 0; i < 9; i++) {
			if (i == f1)
				continue;
			else if (i == f2)
				continue;
			else {
				real[index] = sb[i];
				index++;
			}
		}

		Arrays.sort(real); // 오름차순 정렬
		
		// 출력
		for (int i : real) {
			System.out.println(i);
		}
	}
}