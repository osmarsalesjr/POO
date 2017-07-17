package capitulo02;

import javax.swing.JOptionPane;

public class InputWithJOptionPane {

	public static void main(String[] args) {
		Double PercentualImposto, ValorTransacao, ValorVenal, ValorImposto;
		
		try{
			
			ValorTransacao = getDouble("Digite o Valor da Transicao:");
			ValorVenal = getDouble("Digite o Valor Venal:");
			PercentualImposto = getDouble("Digite o Percentual de Imposto:");
			
			if (ValorTransacao >= ValorVenal){
				
				ValorImposto = ValorTransacao * (PercentualImposto / 100.0);
				
			} else{
				
				ValorImposto = ValorVenal * (PercentualImposto / 100.0);
				
			}
			
			showMsg("O Valor de Imposto e R$ " + ValorImposto + " Reais.");
			
		} catch (NumberFormatException erro){
			
			System.out.println("Erro na Entrada de Dados! Digite Apenas Caracteres Numericos." + erro.toString());
			
		}
		
		
	}
	
	private static Double getDouble(String msg){
		return Double.valueOf(JOptionPane.showInputDialog(msg));
		
	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}

}
