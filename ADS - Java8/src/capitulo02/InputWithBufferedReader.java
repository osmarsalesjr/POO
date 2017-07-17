package capitulo02;

import java.io.*;

public class InputWithBufferedReader {

	public static void main(String[] args) {
		
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			double Desconto, ValorDesconto, PrecoProduto, PrecoFinalProduto;
			
			System.out.println("Digite o Valor do Produto:");
			PrecoProduto = Double.valueOf(input.readLine());
			
			System.out.println("Digite o Porcentagem de Desconto: ");
			Desconto = Double.valueOf(input.readLine());
			
			ValorDesconto = PrecoProduto * (Desconto / 100.0);
			PrecoFinalProduto = PrecoProduto - ValorDesconto;
			
			System.out.println("Valor do Desconto: R$ " + ValorDesconto + " Reais.");
			System.out.println("Valor Final do Produto: R$ " + PrecoFinalProduto + " Reais.");
		
		} catch (IOException erro){
			
			System.out.println("Erro na Entrada de Dados!" + erro.toString());
			
		} catch (NumberFormatException erro){
			
			System.out.println("Erro na Entrada de Dados! Digite Apenas Caracteres Numericos e Ponto. Ex.: 0.00" + erro.toString());
		}

	}

}
