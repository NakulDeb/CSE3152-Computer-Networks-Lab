/* NAKUL DEB NATH
 * 28-04-2018
 */
package assignment_13;

import java.util.Scanner;

public class Expiment_13 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the 7-bit data code : ");
		int d[]=new int[7];
		String inputData = "";
		String inputCodeWord = "";
		String temp = "";
		
		inputData =in.nextLine();
		
		for(int i = 0 ; i < 7 ; i++){
			temp = temp + inputData.charAt(i);
			d[i] = Integer.parseInt(temp);
			temp = "";
		}
		
		int p[]=new int[4];
		p[0]=d[0]^d[1]^d[3]^d[4]^d[6];
		p[1]=d[0]^d[2]^d[3]^d[5]^d[6];
		p[2]=d[1]^d[2]^d[3];
		p[3]=d[4]^d[5]^d[6];

		int c[]=new int[11];
		System.out.print("Code Word : ");

		c[0]=p[0];
		c[1]=p[1];
		c[2]=d[0];
		c[3]=p[2];
		c[4]=d[1];
		c[5]=d[2];
		c[6]=d[3];
		c[7]=p[3];
		c[8]=d[4];
		c[9]=d[5];
		c[10]=d[6];

		for(int i=0; i<11;i++){
			System.out.print(c[i]);
		}

		System.out.print("\nEnter the Received 11-bit Codeword : ");
		
		int r[]=new int[11];
		
		inputCodeWord = in.nextLine();
		for(int i=0;i<11;i++){
			temp = temp + inputCodeWord.charAt(i);
			r[i] = Integer.parseInt(temp);
			temp = "";
		}

		int pr[]=new int[4];
		int rd[]=new int[7];

		pr[0]=r[0];
		pr[1]=r[1];
		rd[0]=r[2];
		pr[2]=r[3];
		rd[1]=r[4];
		rd[2]=r[5];
		rd[3]=r[6];
		pr[3]=r[7];
		rd[4]=r[8];
		rd[5]=r[9];
		rd[6]=r[10];
		
		int s[]=new int[4];
		
		s[0]=pr[0]^rd[0]^rd[1]^rd[3]^rd[4]^rd[6];
		s[1]=pr[1]^rd[0]^rd[2]^rd[3]^rd[5]^rd[6];
		s[2]=pr[2]^rd[1]^rd[2]^rd[3];
		s[3]=pr[3]^rd[4]^rd[5]^rd[6];

		int dec=(s[0]*1)+(s[1]*2)+(s[2]*4)+(s[3]*8);
		
		if(dec==0)
			System.out.println("No error");
		else{
			System.out.println("Error Found in Position " + dec + " (from right)");
			if(r[dec-1]==0)
				r[dec-1]=1;
			else
				r[dec-1]=0;
		}
		System.out.println("The Original data is : " + inputData);
		System.out.print("corrected bit sequence is : ");
		for(int i=0;i<11;i++){
			System.out.print(r[i]);
		}
		System.out.println();
	}

}
