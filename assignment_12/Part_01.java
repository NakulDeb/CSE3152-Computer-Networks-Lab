//  Check IP address validation.
package assignment_12;
import java.util.Scanner;

public class Part_01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = "";
		String A = "",B="",C="",D="";
		int int_A,int_B,int_C,int_D;
		
		s = in.nextLine();
		
		int i = 0;
		for(i=0;i<s.length();i++) {
			if(s.charAt(i)=='.') break;
			A = A + s.charAt(i);
		}
		for(i++ ;i<s.length();i++) {
			if(s.charAt(i)=='.') break;
			B = B + s.charAt(i);
		}
		for(i++ ;i<s.length();i++) {
			if(s.charAt(i)=='.') break;
			C = C + s.charAt(i);
		}
		for(i++ ;i<s.length();i++) {
			if(s.charAt(i)=='.') break;
			D = D + s.charAt(i);
		}
		
		//int i = Integer.parseInt(myString)
		int_A = Integer.parseInt(A);
		int_B = Integer.parseInt(B);
		int_C = Integer.parseInt(C);
		int_D = Integer.parseInt(D);
		
		if(ValidIP(int_A,int_B,int_C,int_D)) {
			return;
		}
		else if(PrivateIP(int_A,int_B,int_C,int_D)) {
			
		}
		else
			System.out.println("Valid public Address");

	}

	private static boolean PrivateIP(int A, int B, int C, int D) {
		if(A == 10 && (B > -1 && B < 256) && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			System.out.println("Vlid Private Address");
			return true;
		}
		else if(A == 172 && (B > 15 && B < 32) && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			System.out.println("Vlid Private Address");
			return true;
		}
		else if(A == 192 && B == 168 && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			System.out.println("Vlid Private Address");
			return true;
		}
		return false;
	}

	private static boolean ValidIP(int A, int B, int C, int D) {
		if(A>255) {
			System.out.println("Invalid Address. Error in 1st octet.");
			return true;
		}
		else if(B>255) {
			System.out.println("Invalid Address. Error in 2st octet.");
			return true;
		}
		else if(C>255) {
			System.out.println("Invalid Address. Error in 3st octet.");
			return true;
		}
		else if(D>255) {
			System.out.println("Invalid Address. Error in 4st octet.");
			return true;
		}

		return false;
	}

}




