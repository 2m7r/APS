import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
		static int N;
		static int M;
		static int[][] map;
		
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			char[]chr = str.toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j]=(int)chr[j]-'0';
			}
		}

		
		
		int[]row = {-1,1,0,0};
		int[]col = {0,0,-1,1};
		
		int res = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		int[][]distance = new int[N][M];
		boolean[][]visited = new boolean[N][M];
		
		//출발점
		queue.add(new int[] {0,0});
		visited[0][0] = true;
		distance[0][0] = 1;
		
		while(!queue.isEmpty()) {
			int[]cur = queue.poll();
			int cX = cur[0];
			int cY = cur[1];
			
			if(cX==N-1 && cY==M-1) {
				res = distance[cX][cY];
			}
			
			for(int i=0; i<4; i++) {
				int nX  = cX + row[i];
				int nY = cY + col[i];
				
				if(move(nX,nY,visited)) {
					queue.add(new int[] {nX,nY});
					visited[nX][nY]=true;
					distance[nX][nY] = distance[cX][cY]+1;
				}
			}
			
		}
		
		System.out.println(res);
		
	}//main
	
	
	private static boolean move(int x, int y, boolean[][]visited) {
		return(x>=0&&x<N&&y>=0&&y<M&&map[x][y]!=0&&!visited[x][y]);
	}//move
	
}//class