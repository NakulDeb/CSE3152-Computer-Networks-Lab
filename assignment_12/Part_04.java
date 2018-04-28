//   Generate network address, subnet mask and IP address ranges for sub netting.

package assignment_12;

import java.util.Scanner;
import java.lang.NumberFormatException;

public class Part_04 {

	public static void main(String[] args)throws NumberFormatException {
		Scanner in = new Scanner(System.in);

		String s = "";
		String A = "",B="",C="",D="";
		String subnet = "";
		
		int int_A,int_B,int_C,int_D;
		int subnetbit ;

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
			if(s.charAt(i)==' ') break;
			D = D + s.charAt(i);
		}
		for(i++ ;i<s.length();i++) {
			
			if(s.charAt(i) >= '0' && s.charAt(i) <='9'){
				subnet = subnet + s.charAt(i);
			}
		}

		int_A = Integer.parseInt(A);
		int_B = Integer.parseInt(B);
		int_C = Integer.parseInt(C);
		int_D = Integer.parseInt(D);
		subnetbit = Integer.parseInt(subnet);
		
		
		
		
		if(InValidIP(int_A,int_B,int_C,int_D)) {
			return;
		}

		else if(addressGenerator(int_A,int_B,int_C,int_D)) {
			return;
		}
		System.out.println("Only this Program is Uncopmleted.");

	}
	
	
	
	
	private static boolean addressGenerator(int A, int B, int C, int D) {
		// TODO Auto-generated method stub
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
