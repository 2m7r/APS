import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// a층의 b호에 살려면 자신의 아래 (a-1)층의 1호부터 b호까지
		// 사람들의 수의 합만큼 사람들을 데려와 살아야 한다
		
		// 1<=k,n<=14
		int[][]d = new int[15][15];
		// 아파트는 0층부터, 각층에는 1호부터, 0층의 i호에는 i명
		for(int i=0; i<=14; i++) {
			d[0][i] = i;
			d[i][1] = 1;
		}
		
		for(int i=1; i<=14; i++) {
			for(int j=2; j<=14; j++) {
				// d[a][b] = d[a-1][0] + ... + d[a-1][b-1] + d[a-1][b]
				// d[a][b] = d[a][b-1]+d[a-1][b]
				// 본인의 이전 집과 아랫집의 합과 같다
				d[i][j] = d[i-1][j]+d[i][j-1];
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			// k층 n호에는 몇 명이 살고 있는가?
			System.out.println(d[k][n]);
		}//tc
		
	}

}