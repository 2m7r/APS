import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static long[] arr; // 원래 배열
	static long[] tree; // 세그먼트 트리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수의 개수
		M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
		K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수

		arr = new long[N + 1]; // 1부터 인덱싱
		tree = new long[4 * N]; // 세그먼트 트리 크기
		// 4N은 이진 트리에서 가장 많은 노드가 필요한 경우의 크기

		// 배열 입력
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		// 세그먼트 트리 초기화 (루트노드 인덱스, 구간시작 인덱스, 구간 끝 인덱스)
		init(1, 1, N);

		// 쿼리 처리
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) { // 수 변경
				update(1, 1, N, b, c);
			} else if (a == 2) { // 구간 합
				System.out.println(query(1, 1, N, b, (int) c));
			}
		}
	}

	// 세그먼트 트리 초기화 (구간 합 구하기)
	// 재귀적으로 세그먼트 트리 구성
	public static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			long left = init(2 * node, start, mid); // 왼쪽 자식 구간
			long right = init(2 * node + 1, mid + 1, end); // 오른쪽 자식 구간
			return tree[node] = left + right; // 부모 노드 구간 합
		}
	}

	// 구간 합 쿼리 (start부터 end까지의 합) //b번째 수부터 c번째 수 까지의 합. left = b , right = c
	public static long query(int node, int start, int end, int left, int right) {
		// 1. 구간이 겹치지 않는 경우
		if (right < start || end < left) {
			return 0; // 구간이 겹치지 않으면 0 반환
		}
		
		// 2. 구간이 완전히 포함되는 경우
		if (left <= start && end <= right) {
			return tree[node]; // 구간이 완전히 포함되면 현재 노드 반환
		}
		
		// 3. 구간이 일부만 겹치는 경우
		// 구간이 일부만 겹치는 경우, 왼쪽 자식과 오른쪽 자식에서 합을 구한다.
		int mid = (start + end) / 2;
		long leftSum = query(2 * node, start, mid, left, right);
		long rightSum = query(2 * node + 1, mid + 1, end, left, right);
		return leftSum + rightSum;
	}

	// 업데이트 ((b)index 번째 수를 (c)value로 변경)
	public static void update(int node, int start, int end, int index, long value) {
		//리프노드인 경우
		if (start == end) {
			arr[index] = value; // 배열의 값을 업데이트
			tree[node] = value; // 세그먼트 트리의 값을 업데이트
		} else {
			int mid = (start + end) / 2;
			if (index <= mid) {
				update(2 * node, start, mid, index, value); // 왼쪽 자식 업데이트
			} else {
				update(2 * node + 1, mid + 1, end, index, value); // 오른쪽 자식 업데이트
			}
			tree[node] = tree[2 * node] + tree[2 * node + 1]; // 부모 노드 업데이트
		}
	}

}