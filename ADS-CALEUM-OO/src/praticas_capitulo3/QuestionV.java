package praticas_capitulo3;

public class QuestionV {

	public static void main(String[] args) {
		
		long Fatorial;
		
		for (int i = 1; i <= 30; i++){
			Fatorial = 1;
			
			for (int j = i; j > 0; j--){
				Fatorial = Fatorial * j;
			}
			
			System.out.println("Fatorial de " + i + " e: " + Fatorial + ".");
		}

	}

}
