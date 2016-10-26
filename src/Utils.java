import java.util.Random;
import java.util.Scanner;


public class Utils {
	public static int random(int set, int start) {
		return (int)(Math.random() * set) + start;
	}
	
	public static boolean random() {
		return new Random().nextBoolean();
	}
	
	public static int errorCheck(String prompt, int min, int max) {
		System.out.println(prompt);
		
		int user;
		Scanner in = new Scanner(System.in);
		
		do {
			user = in.nextInt();
			if(user > max || user < min) {
				System.out.println("Please try again.");
			}
		} while(user > max || user < min);
		
		return user;
	}
	
	public static void displayArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			if((i + 1) % 20 == 0)
				System.out.println();
		}
		System.out.println("\n");
	}
	
	public static void initializeArray(int[] arr, int value) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = value;
		}
	}
	
	public static void initializeArray(int[][] mat, int value) {
		for(int i = 0; i < mat.length; i++) {
			initializeArray(mat[i], value);
		}
	}
}
