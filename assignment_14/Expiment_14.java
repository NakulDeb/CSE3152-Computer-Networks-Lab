/* NAKUL DEB NATH
 * 28-04-2018
 */
package assignment_14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Expiment_14 {
	private static int distances[][];
	private static  int numberofvertices;
	public static final int MAX_VALUE = 500;
	static int n = 0;
	static int scnode;
	static int dnode;

	public static void initialize(int numberofvertices1){       
		numberofvertices = numberofvertices1;
		distances = new int[numberofvertices1 + 1][numberofvertices1 + 1];      
	}

	public static void Calculation(int adjacencymatrix[][]){
		int index;
		for (index = 1; index <= numberofvertices; index++)
			for (int node = 1; node <= numberofvertices; node++){
				distances[index][node] = MAX_VALUE;
			}

		for(index = 1; index <= numberofvertices; index++){
			distances[index][index] = 0;
			for (int node = 1; node <= numberofvertices - 1; node++){
				for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++){
					for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++){
						if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE){
							if (distances[index][destinationnode] > distances[index][sourcenode] + adjacencymatrix[sourcenode][destinationnode])
								distances[index][destinationnode] = distances[index][sourcenode] + adjacencymatrix[sourcenode][destinationnode];
							System.out.println("Index: " +index);
							System.out.print("\tSource node: " +sourcenode);
							System.out.print("\tDesination node: " +destinationnode);
							System.out.println(" Distance between index and destination node inside if loop " +distances[index][destinationnode]);
						}
					}
				}
			}
		}
	}

	public static void printMatrix(){
		int index;
		System.out.println("The final matrix after DV algorithm is: ");
		for (index = 1; index <= numberofvertices; index++){
			System.out.println();
			for (int vertex = 1; vertex <= numberofvertices; vertex++){
				System.out.print(" "+ distances[index][vertex]+" ");    
			}
		}
	}

	public static void main(String... arg) throws IOException{
		int numberofvertices = 0;
		int source;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of vertices : ");
		numberofvertices = scanner.nextInt();

		int adjacencymatrix[][] = new int[numberofvertices + 1][numberofvertices + 1];

		System.out.println("Enter the adjacency matrix : ");
		for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++){
			for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++){
				adjacencymatrix[sourcenode][destinationnode] = scanner.nextInt();
				if (sourcenode == destinationnode){
					adjacencymatrix[sourcenode][destinationnode] = 0;
					continue;
				}
				if (adjacencymatrix[sourcenode][destinationnode] == 0){
					adjacencymatrix[sourcenode][destinationnode] = MAX_VALUE;
				}
			}
		}

		initialize(numberofvertices);
		Calculation(adjacencymatrix);

		System.out.println("\n\n****** Routing table for requre node *******");
		printMatrix();
		scanner.close(); 
	}
}