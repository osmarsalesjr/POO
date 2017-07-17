package capitulo05;

import java.util.Random;

public class QuestionIV {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] par = new int[10];
		int [] impar = new int[10];
		
		int indexpar = 0, indeximpar = 0, numero;
		
		for (int i = 0; i < 10; i++){
			
			numero = random.nextInt(20);
			
			if (numero % 2 == 0){
				
				par[indexpar] = numero;
				indexpar++;
			} else {
				
				impar[indeximpar] = numero;
				indeximpar++;
			}
		}
		
		printArray("Pares:\n", par);
		printArray("\nImpares:\n", impar);

	}
	
	private static void printArray(String msg, int[] array){
		
		System.out.println(msg);
		for (int i = 0; i < array.length; i++){
			
			System.out.println("| " + array[i] + " |");
		}
	}

}
