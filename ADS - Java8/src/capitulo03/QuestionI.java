package capitulo03;

import javax.swing.JOptionPane;
//import java.io.*;

public class QuestionI {

	public static void main(String[] args) throws Exception {
		
		Double ValorProduto, ValorFinal;
		String NomeProduto;
		
		try{
			
			NomeProduto = getString("Digite o Nome do Produto:");
			ValorProduto = getDouble("Digite o Valor do Produto:");
			
			if (ValorProduto <= 0){
				
				throw new Exception ("Erro! Valor Incorreto!");
				
			} else if (ValorProduto >= 50.0 && ValorProduto < 200.0){
				
				ValorFinal = ValorProduto - (ValorProduto * 0.05);
				
			} else if (ValorProduto >= 200.0 && ValorProduto < 500.0){
				
				ValorFinal = ValorProduto - (ValorProduto * 0.06);
				
			} else if (ValorProduto >= 500.0 && ValorProduto < 1000.0){
				
				ValorFinal = ValorProduto - (ValorProduto * 0.07);
				
			} else {
				
				ValorFinal = ValorProduto - (ValorProduto * 0.08);
				
			}
			
			showMsg("Produto: " + NomeProduto + "\nDe: R$ " + ValorProduto + " Reais\nPor: R$ " + ValorFinal + " Reais!");
			
		} catch (NumberFormatException erro){
			
			System.out.println("Erro na Entrada de Dados! Digite Apenas Caracteres Numericos.\n" + erro.toString());
		}

	}
	
	private static Double getDouble(String msg){
		return Double.valueOf(JOptionPane.showInputDialog(msg));
		
	}
	
	private static String getString(String msg){
		return JOptionPane.showInputDialog(msg);
		
	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}

}
