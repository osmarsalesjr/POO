package domain;

public class BonecoForca {
	
	private String[] boneco;
	
	public BonecoForca() {
		
		this.boneco = new String[]{"    [°_°]", "\n[=]", " [||] ", "[=]", "\n [=]'   ", "'[=]"};
	}
	
	public String getStatusBoneco(int qtdPartes){
		
		String statusBoneco = "";
		
		for (int i = 0; i < qtdPartes; i++){
			
			statusBoneco += boneco[i];
		}
		
		return statusBoneco;
	}
}
