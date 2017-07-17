package domain;

public class Jogador implements Comparable<Jogador>{
	
	private String nome;
	private int totalDePontos;
	
	public Jogador(String nome, int totalDePontos) {
		
		this.nome = nome;
		this.totalDePontos = totalDePontos;		
	}
	
	public String toString() {
		
		return "| Nome: " + getNome() + " | Pontos: " + getTotalDePontos() + " |";
	}
	
	public String getNome() {
		
		return nome;
	}
	
	public int getTotalDePontos() {
		
		return totalDePontos;
	}

	public int compareTo(Jogador jogador) {
		
		return Integer.compare(this.totalDePontos, jogador.getTotalDePontos());
	}
}
