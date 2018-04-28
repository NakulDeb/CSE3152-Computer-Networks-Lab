//  Check valid IP address from a custom subnetting.

package assignment_12;
import java.util.Scanner;

public class Part_05 {


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
		else if(checkValidIPforSubnet(int_A,int_B,int_C,int_D,subnetbit)) {
			return;
		}

	}
	
	
	
	
	private static boolean checkValidIPforSubnet(int A, int B, int C, int D, int subnetbit) {
		int m = 1;
		for(int i = 24; i<33;i++){
			if(subnetbit == i && D < m){
				System.out.println("Valid Address for that subnetting");
				return true;
			}
			m = m<<1;
		}
		System.out.println("Invalid Address for that subnetting");
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
