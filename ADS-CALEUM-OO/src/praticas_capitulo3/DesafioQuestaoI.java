package praticas_capitulo3;

import java.util.*;

public class DesafioQuestaoI {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		long FibN, FibI = 0, FibII = 1;
		
		System.out.print("Digite o Termo da Sequencia Fibonacci: ");
		FibN = input.nextLong();
		
		for (int i = 0; i < FibN; i++){
			
			FibII += FibI;
			FibI = FibII - FibI;
			
			System.out.println("| " + FibII + " |");
		}
		
		System.out.println("\nO " + FibN + " Termo da Sequencia Fibonacci e: " + FibII + ".");

	}

}
