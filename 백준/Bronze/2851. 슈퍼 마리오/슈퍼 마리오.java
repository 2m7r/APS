import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] mr = new int[10]; // mushroom

		int sum = 0;
		int in = 0;
		int over = 0;
		
		for (int i = 0; i < 10; i++) {
			mr[i] = sc.nextInt();
			sum += mr[i];
			if(sum>100) {
				over = sum;
				in = sum-mr[i];
				break;
			}
			
			if (i==9 && sum<100)over=sum;
		}
		
		if(over-100>100-in) sum=in;
		else sum=over;

		System.out.println(sum);
	}
}