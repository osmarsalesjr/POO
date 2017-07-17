package capitulo02;

import javax.swing.JOptionPane;

public class InputWithJOptionPaneTwo {

	public static void main(String[] args) {
		Double Nota1, Nota2, Nota3, Media;
		
		try{
			
			Nota1 = getDouble("Digite a Nota da Prova 1:");
			Nota2 = getDouble("Digite a Nota da Prova 2:");
			Nota3 = getDouble("Digite a Nota do Trabalho:");
			
			Media = (Nota1 + Nota2 + Nota3) / 3.0;
			
			if (Media >= 6.0){
				
				showMsg("Media: " + Media + ". APROVADO =D");
				
			} else {
				
				showMsg("Media: " + Media + ". REPROVADO ='C");
			
			}
			
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
