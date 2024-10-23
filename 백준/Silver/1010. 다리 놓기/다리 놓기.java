import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][]d = new int[30][30];
		for(int i=0; i<30; i++) {
			d[i][0]=1;
			d[i][i]=1;
			d[i][1]=i;
		}
		
		for(int i=1; i<30; i++) {
			for(int j=2; j<=i; j++) {
				d[i][j] = d[i-1][j]+d[i-1][j-1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
//			(0<N<=M<30)
			System.out.println(d[M][N]);
		}
	}
}