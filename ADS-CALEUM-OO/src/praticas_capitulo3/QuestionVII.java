package praticas_capitulo3;

import java.util.Scanner;

public class QuestionVII {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int x, y;
		
		System.out.print("Digite um número: ");
		x = input.nextInt();
		
		for (int i = 1; x > 1 ; i++){
			
			if (x % 2 == 0){
				
				y = x / 2;
				
			} else {
				
				y = (3 * x) + 1;
				
			}
			
			System.out.println("Volta Nº " + i + " => X = " + x + " | Y = " + y + " |");
			x = y;
		}

	}

}
