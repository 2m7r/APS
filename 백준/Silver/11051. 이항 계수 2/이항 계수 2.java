import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		final int mod = 10007;
		
		int[][]d = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			d[i][1] = i;
			d[i][0] = 1;
			d[i][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<i; j++) {
				d[i][j] = d[i-1][j] + d[i-1][j-1];
				d[i][j] = d[i][j]%mod;
			}
		}
		
		System.out.println(d[N][K]);
	}

}
