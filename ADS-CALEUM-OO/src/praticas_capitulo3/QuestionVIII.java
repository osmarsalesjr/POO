package praticas_capitulo3;

import java.util.*;

public class QuestionVIII {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int numero;
		
		System.out.print("Digite um número: ");
		numero = input.nextInt();
		
		for (int i = 1; i <= numero; i++){
			
			for (int j = 1; j <= i; j++){
				
				System.out.print(i * j + " ");
				
			}
			System.out.println();
			
		}

	}

}
