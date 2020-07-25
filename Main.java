import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int a[] = new int[10];
		Scanner boardScanner = new Scanner(System.in);
		for(int i = 0 ; i < 10;i++) {
			a[i] = boardScanner.nextInt();
		}
		System.out.print("Done");
		System.out.print("Truy cap vao mot vi tri bat ky dua vao id ");
		// vi du 7
		System.out.print(a[7]);
	}
    
}