///  Check IP address class.
package assignment_12;
import java.util.Scanner;

public class Part_02 {

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

		int_A = Integer.parseInt(A);
		int_B = Integer.parseInt(B);
		int_C = Integer.parseInt(C);
		int_D = Integer.parseInt(D);
		
		
		if(InValidIP(int_A,int_B,int_C,int_D)) {
			return;
		}
		else if(clasA(int_A,int_B,int_C,int_D)){
			
		}
		
		


	}

	private static boolean clasA(int A, int B, int C, int D) {
		if((A > 0 && A < 127) && (B > -1 && B < 256) && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			System.out.print("Class A ");
			if(PrivateIP(A, B, C, D)){
				System.out.println("Private Address.");
			}
			else
				System.out.println("Public Address.");
			return true;
		}
		
		
		else if((A > 127 && A < 192) && (B > -1 && B < 256) && (C > -1 && C < 256) && (D > 0 && D < 256)) {
			System.out.print("Class B ");
			if(PrivateIP(A, B, C, D)){
				System.out.println("Private Address.");
			}
			else
				System.out.println("Public Address.");
			return true;
		}
		
		
		else if((A > 191 && A < 224) && (B > -1 && B < 256) && (C > -1 && C < 255) && (D > -1 && D < 256)) {
			System.out.print("Class C ");
			if(PrivateIP(A, B, C, D)){
				System.out.println("Private Address.");
			}
			else
				System.out.println("Public Address.");
			return true;
		}
		
		
		else if((A > 223 && A < 240) && (B > -1 && B < 256) && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			System.out.print("Class D ");
			if(PrivateIP(A, B, C, D)){
				System.out.println("Private Address.");
			}
			else
				System.out.println("Public Address.");
			return true;
		}
		return false;
	}


	private static boolean PrivateIP(int A, int B, int C, int D) {
		if(A == 10 && (B > -1 && B < 256) && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			return true;
		}
		else if(A == 172 && (B > 15 && B < 32) && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			return true;
		}
		else if(A == 192 && B == 168 && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			return true;
		}
		return false;
	}
	
	private static boolean InValidIP(int A, int B, int C, int D) {
		if(A>255||B>255||C>255||D>255) {
			System.out.println("Invalid IP Address.");
			return true;
		}
		return false;
	}

}
