import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		
		a=a.replace("c=","c");
		a=a.replace("c-","c");
		a=a.replace("dz=","c");
		a=a.replace("d-","c");
		a=a.replace("lj","c");
		a=a.replace("nj","c");
		a=a.replace("s=","c");
		a=a.replace("z=","c");
		
		System.out.println(a.length());
	}

}
