package domain;

public class Enigma{
	
	private String tema;
	private String palavra;
	
	public Enigma(String tema, String palavra) {
		
		this.tema = tema;
		this.palavra = palavra;
	}
	
	public String getTema() {
		
		return tema;
	}
	
	public String getPalavra() {
		
		return palavra;
	}

	public int compareTo(Enigma enigma) {
		
		return this.tema.compareToIgnoreCase(enigma.getTema());
	}
	
}
