package praticas_capitulo3;

public class QuestionIV {

	public static void main(String[] args) {
		
		double Fatorial;
		
		for (int i = 1; i <= 10; i++){
			Fatorial = 1;
			
			for (int j = i; j > 0; j--){
				Fatorial = Fatorial * j;
			}
			
			System.out.println("Fatorial de " + i + " e: " + Fatorial + ".");
		}

	}

}
