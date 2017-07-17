package capitulo05;

import javax.swing.JOptionPane;

public class QuestionV {

	public static void main(String[] args) {
		
		String[] vagas = new String[10];
		int opcao = -1;	
		String menu = ">> Menu <<";
		menu += "\n1 - Entrada\n2 - Saida\n3 - Status\n0 - Encerra Programa";
		
		while (opcao != 0){
			
			opcao = getInt(menu);
			
			switch(opcao){
				
				case 0:
					
					showMsg("Programa Encerrado!");
					break;
				
				case 1:
					
					Entrada(vagas);
					break;
				case 2:
					
					Saida(vagas);
					break;
				case 3:
					
					statusVagas(vagas);
					break;
					
				default:
					
					showMsg("Opcao Invalida!");
			
			}
			
		}

	}

	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}
	
	private static Integer getInt(String msg){
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
		
	}
	
	private static String getString(String msg){
		return JOptionPane.showInputDialog(msg);
		
	}
	
	private static void statusVagas(String[] vagas){
		
		String status = "";
		
		for (int i = 0; i < vagas.length; i++){
			
			if (vagas[i] == null){
				
				status += "\nVaga " + i + " Livre.";
			} else {
				
				status += "\nVaga " + i + " | Nº da Placa: " + vagas[i];
			}
		}
		
		showMsg(status);
	}
	
	
	private static void Entrada(String[] vagas){
		int opcao;
		
		statusVagas(vagas);
		opcao = getInt("Digite o numero da Vaga:");
		
		if ((opcao < 0) || (opcao >= vagas.length) || (vagas[opcao] != null)){
			
			showMsg("Vaga Nao Existe ou Ocupada!");
		} else {
			
			vagas[opcao] = getString("Numero da Placa:");
			showMsg("Cadastrado com Sucesso!");
		}
		
	}
	
	private static void Saida(String[] vagas) {
		
		int opcao;
		
		statusVagas(vagas);
		opcao = getInt("Digite o numero da Vaga:");
		
		if ((opcao < 0) || (opcao >= vagas.length) || (vagas[opcao] == null)){
			
			showMsg("Vaga Nao Existe ou Ja Esta Livre!");
		} else {
			
			vagas[opcao] = null;
			showMsg("Vaga Liberada com Sucesso!");
		}
		
	}

}
