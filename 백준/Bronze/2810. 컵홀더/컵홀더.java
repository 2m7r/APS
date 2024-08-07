import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //tc
		if(N<1||N>50)return; //좌석 수 N의 범위
		//좌석의 정보 받기
		String str = br.readLine();
		char[]info = new char[N];
		info=str.toCharArray();
		Stack<Character>stack = new Stack<>();
		
		for(int n=0; n<N; n++) {
			stack.push(info[n]);
		}
		
		Collections.reverse(stack);
		
		String result = "*";
		while(!stack.isEmpty()) {
			if(stack.peek()=='S') {
				result+=stack.pop();
				result+="*";
			} else if(stack.peek()=='L') {
				result+=stack.pop();
				result+=stack.pop();
				result+="*";
			}
		}
		int num = 0;
		int person = 0;
		char[]res = new char[result.length()];
		res = result.toCharArray();
		for(int i=0; i<result.length(); i++) {
			if (res[i]=='*') {
				num++;
			} else {
				person++;
			}
		}
		
		if(person<num) num=person;
		
		
		System.out.println(num);
		
	}//main
}//class