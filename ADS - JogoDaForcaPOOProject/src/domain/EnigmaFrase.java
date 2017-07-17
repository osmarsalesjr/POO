package domain;

public class EnigmaFrase{
	
	private String dica;
	private String frase;
	
	public EnigmaFrase(String dica, String frase) {
		
		this.dica = dica;
		this.frase = frase;
	}
	
	public String getDica() {
		
		return dica;
	}
	
	public String getFrase() {
		
		return frase;
	}
}
