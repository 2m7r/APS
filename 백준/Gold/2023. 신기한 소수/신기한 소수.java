import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		if(N<1||N>8)return;
		sc.close();
		
		for(int i=2; i<8*Math.pow(10, N-1);i++) {
			boolean s=true;
			
			for(int k=1;k<=N;k++) {
				if(check(N,i,k)==false) {
					s=false;
					break;
				}
			}
			
			if(s==true) {
				System.out.println(i);
			}
		}

		
		
	}//main
	
	private static boolean check(int N,int i,int k) {
		int x = (int) (i/Math.pow(10, N-k));
		
		if(isPrime(x))return true;
		else return false;
	}
	
	// 주어진 숫자가 소수인지 확인하는 메서드
    public static boolean isPrime(int num) {
        if (num <= 1) return false; // 소수 X
        if (num == 2) return true;  // 2는 소수
        if (num % 2 == 0) return false; // 짝수 소수 X

        // 제곱근 이상의 약수를 가지면 제곱근 이하의 약수도 함께 가지기 때문
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            // num이 i로 나누어 떨어지면 소수 X
            if (num % i == 0) return false;
        }

        // 어떤 약수로도 나누어 떨어지지 않으면 소수입니다.
        return true;
    }

}