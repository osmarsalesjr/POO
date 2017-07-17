package Domain;

public class Estacionamento {
	
	private static Estacionamento instacia;
	private static int qtdVeiculos = 0;
	
	public String nome = "ParkingLot";
	public Veiculo[] vagas = new Veiculo[10];
	
	@Override
	public String toString() {
		
		return this.nome;
	}
	
	public static Estacionamento getInstance(){
		
		if (Estacionamento.instacia == null){
			
			Estacionamento.instacia = new Estacionamento();
		}
		
		return instacia;
	}
	
	public boolean entradaVeiculo(String placa, String modelo){
		
		int index = -1;
		
		if (qtdVeiculos >= 1){
			
			for (int i = 0; i < vagas.length; i++){
				
				if (vagas[i] == null && contemVeiculo(placa) == false){
					
					index = i;
					break;
				}
			}
		} else {
			
			index = 0;
		}
		
		if (index != -1){
			
			qtdVeiculos++;
			vagas[index] = new Veiculo(placa, modelo);
			return true;
		}
		
		return false;
	}
	
	public boolean saidaVeiculo(String placa){
		
		for (int i = 0; i < qtdVeiculos; i++){
			
			if (vagas[i].getPlaca().equals(placa) && contemVeiculo(placa) == true){
				
				vagas[i] = null;
				qtdVeiculos--;
				return true;
			}
		}
		
		return false;
	}
	
	public String listarVagas(){
		
		String status = "";
		for(int i = 0; i < vagas.length; i++){
			
			if (vagas[i] == null){
				
				status += "\nVaga [" + i + "] Livre";
			} else {
				
				status += "\nVaga [" + i + "] Ocupada";
			}
		}
		
		return status;
	}
	
	private boolean contemVeiculo(String placa){
		
		for (int i = 0; i < qtdVeiculos; i++){
			
			if (vagas[i] != null && vagas[i].getPlaca().equals(placa)){
				
				return true;
			}
		}

		return false;
	}
	
	

}
