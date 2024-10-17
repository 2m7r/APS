import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		tree = new int[4 * N];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 세그먼트 트리 초기화
		init(1,1,N);
		
		//쿼리 처리
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(query(1,1,N,a,b));
		}

	}// main

	static int init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			int left = init(2 * node, start, mid);
			int right = init(2 * node + 1, mid + 1, end);
			return tree[node] = Integer.min(left, right);
		}
	}

	// 최솟값 쿼리
	static int query(int node, int start, int end, int left, int right) {
		if (right < start || left > end)
			return Integer.MAX_VALUE; //최솟값 구하는거라 이거 0으로 하면 안됨!!!

		if (left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		int leftMin = query(2*node,start,mid, left, right);
		int rightMin = query(2*node+1,mid+1,end,left,right);
		return Integer.min(leftMin,rightMin);
	}

}// class