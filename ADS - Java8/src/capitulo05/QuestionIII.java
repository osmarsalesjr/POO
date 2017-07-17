package capitulo05;

import java.util.*;

public class QuestionIII {

	public static void main(String[] args) {
		
		int[][] imagem = new int[40][40];
		Random random = new Random();
		
		for (int linha = 0; linha < imagem.length; linha ++){
			
			for (int coluna = 0; coluna < imagem[linha].length; coluna++){
				
				imagem[linha][coluna] = random.nextInt(255);
			}
			
		}
		
		for (int linha = 0; linha < imagem.length; linha ++){
			
			for (int coluna = 0; coluna < imagem[linha].length; coluna++){
				
				System.out.print("| " + imagem[linha][coluna] + " |");
			}
			
			System.out.println();
		}

	}

}
