package praticas_capitulo3;

public class QuestionVI {

	public static void main(String[] args) {
		
		long Atual, PreAnterior = 0, Anterior = 1;
		
		for (int i = 1; i <= 101; i++){
			
			Atual = PreAnterior + Anterior;
			System.out.println("| " + i + " ||| " + Atual + " |");
			
			PreAnterior = Anterior;
			Anterior = Atual;
		}

	}

}
