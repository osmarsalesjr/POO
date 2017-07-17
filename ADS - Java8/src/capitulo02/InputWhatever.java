package capitulo02;

import javax.swing.JOptionPane;

public class InputWhatever {

	public static void main(String[] args) {
		
		int Idade, AnosContribuicao, AnosRestantes;
		String Sexo;
		
		try{
			
			Idade = getInt("Digite a Idade:");
			AnosContribuicao = getInt("Quantidade de Anos de Contribuicao:");
			Sexo = getString("Sexo: ('F' ou 'M')");
			
			if (Sexo == "F" && Idade < 60 && AnosContribuicao >= 30){
				
				AnosRestantes = 60 - Idade;
				showMsg("Anos de Contribuicao Restantes:" + AnosRestantes);
				
			} else if (Sexo == "M" && Idade < 65 && AnosContribuicao >= 35){
				
				AnosRestantes = 65 - Idade;
				showMsg("Anos de Contribuicao Restantes:" + AnosRestantes);
				
			} else if (Sexo == "F" && Idade >= 60 && AnosContribuicao < 30){
				
				AnosRestantes = 30 - AnosContribuicao;
				showMsg("Anos de Contribuicao Restantes:" + AnosRestantes);
				
			} else if (Sexo == "M" && Idade >= 65 && AnosContribuicao < 35){
				
				AnosRestantes = 35 - AnosContribuicao;
				showMsg("Anos de Contribuicao Restantes:" + AnosRestantes);
				
			} else {
				showMsg("Voce Ja tem Direito a Aposentadoria.");
			}
			
		} catch (NumberFormatException erro){
			
			System.out.println("Erro na Entrada de Dados! Digite Apenas Caracteres Numericos." + erro.toString());
		}

	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}
	
	private static String getString(String msg){
		return JOptionPane.showInputDialog(msg);
		
	}
	
	private static Integer getInt(String msg){
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
		
	}

}
