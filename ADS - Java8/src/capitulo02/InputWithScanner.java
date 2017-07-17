package capitulo02;

//import java.io.IOException;
import java.util.Scanner;

public class InputWithScanner {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int PontosLider, PontosLanterna, VitoriasNecessarias;
		
		try{
			
			System.out.println("Digite a Quantidade de Pontos do Time Lider:");
			PontosLider = input.nextInt();
			
			System.out.println("Digite a Quantidade de Pontos do Time Lanterna:");
			PontosLanterna = input.nextInt();
			
			VitoriasNecessarias = (PontosLider - PontosLanterna) / 3;
			
			System.out.print("A Quantidade de Vitorias Necessarias para o Time Lanterna e: " + VitoriasNecessarias);
			
		} catch (NumberFormatException erro){
			
			System.out.println("Erro na Entrada de Dados! Digite Apenas Caracteres Numericos." + erro.toString());
		}

	}

}
