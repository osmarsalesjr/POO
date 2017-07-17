package Application;

import javax.swing.JOptionPane;

import Domain.Estacionamento;

public class ProgramaEstacionamento {

	public static void main(String[] args) {
		
		int opcao = -1;
		Estacionamento estacionamento = Estacionamento.getInstance();
		
		String menu = ">> ParkingLot <<\n";
		menu += "1 - Entrada\n";
		menu += "2 - Saida\n";
		menu += "3 - Listar\n";
		menu += "0 - Encerrar Aplicacao";
		
		while (opcao != 0){
			
			opcao = getInt(menu);
			
			switch(opcao){
				
				case 0:
					
					showMsg("APLICACAO ENCERRADA!");
					break;
			
				case 1:
					
					entrada(estacionamento);
					break;
				case 2:
					
					saida(estacionamento);
					break;
				case 3:
					
					listar(estacionamento);
					break;
				default:
					
					showMsg("OPCAO INVALIDA!");
			}
		}
		

	}
	
	
	private static void listar(Estacionamento estacionamento) {
		
		showMsg(estacionamento.listarVagas());
	}


	private static void saida(Estacionamento estacionamento) {
		
		String placa = getString("Digite a Placa do Veiculo:");
		
		if (estacionamento.saidaVeiculo(placa)){
			
			showMsg("Vaga Liberada com Sucesso!");
		} else {
			
			showMsg("Veiculo Nao Encontrado ou Ja Foi Liberado!");
		}
	}


	private static void entrada(Estacionamento estacionamento) {
		
		String placa = getString("Digite a Placa:");
		String modelo = getString("Digite o Modelo:");
		
		if (estacionamento.entradaVeiculo(placa, modelo)){
			
			showMsg("Entrada do Veiculo Autorizada!");
		} else {
			
			showMsg("Nao Ha Vagas Disponiveis ou Veiculo Ja Esta Estacionado!");
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
