//   Find the Network address and Host addresses range for class full IP addressing.

package assignment_12;

import java.util.Scanner;

public class Part_03 {

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
		else if(hostClass(int_A,int_B,int_C,int_D)) {
			return;
		}
	}
	
	
	
	private static boolean hostClass(int A, int B, int C, int D) {
		if(A == 10 && (B > -1 && B < 256) && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			System.out.println("Net ID : 10.0.0.0 Host ID Range from 10.0.0.1 to 10.255.255.254");
			return true;
		}
		else if(A == 172 && (B > 15 && B < 32) && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			System.out.println("Net ID : 172.16.0.0 Host ID Range from 172.16.0.1 to 172.31.255.254");
			return true;
		}
		else if(A == 192 && B == 168 && (C > -1 && C < 256) && (D > -1 && D < 256)) {
			System.out.println("Net ID : 192.168.0.0 Host ID Range from 192.168.0.1 to 192.168.255.254");
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
