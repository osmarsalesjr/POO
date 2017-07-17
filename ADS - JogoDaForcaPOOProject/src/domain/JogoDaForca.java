package domain;

import java.util.*;

public class JogoDaForca {
	
	private static JogoDaForca instancia;
	
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	private List<Enigma> enigmas = new ArrayList<Enigma>();
	private List<EnigmaFrase> enigmasFrases = new ArrayList<EnigmaFrase>();	
	private List<String[]> palpites;
	private List<Integer> indexDaVez;
	
	Random random = new Random();
	private BonecoForca boneco;
	private String letrasErradas;
	private String letrasCertas;
	private int qtdErros, totalDePontos;
	
	private JogoDaForca() {
		
		this.letrasCertas = "";
		this.letrasErradas = "";
		this.qtdErros = 0;
		this.totalDePontos = 0;
		this.boneco = new BonecoForca();
		this.indexDaVez = new ArrayList<Integer>();
		this.palpites = new ArrayList<String[]>();
	}
	
	public static JogoDaForca getInstancia(){
		
		if (instancia == null){
			
			JogoDaForca.instancia = new JogoDaForca();
		}
		
		return instancia;
	}
	
	public int getQtdErros() {
		
		return qtdErros;
	}
	
	public List<String[]> getPalpites() {
		
		return Collections.unmodifiableList(palpites);
	}
	
	public List<Integer> getIndexDaVez() {
		
		return Collections.unmodifiableList(indexDaVez);
	}
	
	public List<Enigma> getEnigmas() {
		
		return Collections.unmodifiableList(enigmas);
	}
	
	public List<EnigmaFrase> getEnigmasFrases() {
		
		return Collections.unmodifiableList(enigmasFrases);
	}
	
	public List<Jogador> getJogadores() {
		
		return Collections.unmodifiableList(jogadores);
	}
	
	public void resetValores(){
		
		this.letrasCertas = "";
		this.letrasErradas = "";
		this.qtdErros = 0;
		this.totalDePontos = 0;
		this.boneco = new BonecoForca();
		this.indexDaVez = new ArrayList<Integer>();
		this.palpites = new ArrayList<String[]>();
	}
	
	public void adicionarIndexDaVez(int index){
		
		indexDaVez.add(index);
	}
	
	public void adicionarPalpite(int tamanho){
		
		palpites.add(new String[tamanho]);
	}
	
	public void pontuaLetraCerta(){
		
		totalDePontos += 5;
	}
	
	public void pontuaFinalDeJogo(){
		
		int espacos = 0;
		
		for (String[] auxiliar : palpites){
			
			for (String item : auxiliar){
				
				if (item.contains("_")){
					
					espacos++;
				}
			}
		}
		
		totalDePontos += 100 + (15 * espacos);
	}
	
	public void adicionarNovoJogador(String nome){
		
		jogadores.add(new Jogador(nome, totalDePontos));
		Collections.sort(jogadores);
	}
	
	public String getStatusJogares(){
		
		String statusJogadores = "";
		
		for (int i = jogadores.size() - 1; i >= 0; i--) {
			
			statusJogadores += jogadores.get(i).toString() + "\n";
		}
		
		return statusJogadores;
	}
	
	public void adicionarNovoEnigma(String tema, String palavra){
		
		enigmas.add(new Enigma(tema, palavra));
	}
	
	public void adicionarNovaFrase(String dica, String frase){
		
		enigmasFrases.add(new EnigmaFrase(dica, frase));
	}
	
	public int selecionarIndex(int limite){
		
		int index = random.nextInt(limite);
		
		for (int numero : indexDaVez){
			
			if (index == numero){
				
				return selecionarIndex(limite);
			}
		}
		
		return index;
	}
	
	public void inicializarPalpite(String[] palpite, String palavraEnigma){
		
		String[] auxiliar = palavraEnigma.split("");
		for (int i = 0; i < palavraEnigma.length(); i++){
			
			if (auxiliar[i].equals(" ")){
				
				palpite[i] = " ";
			} else if (auxiliar[i].equals("-")){
				
				palpite[i] = "-";
			} else {
				
				palpite[i] = "_";
			}
		}
	}
	
	public void finalizarPalpite(String[] palpite, String palavraEnigma){
		
		String[] auxiliar = palavraEnigma.split("");
		
		for (int i = 0; i < palavraEnigma.length(); i++){
			
			palpite[i] = auxiliar[i];
		}
	}
	
	public String getStatusPalpite(String[] palpite){
		
		String statusPalpite = "";
		
		for (String letra : palpite){
			
			statusPalpite += letra;
		}
		return statusPalpite ;
	}
	
	public String getStatusJogoFrase(){
		
		String statusJogo = ">> Jogo da Forca<<";
		statusJogo += "\n\nErros: " + letrasErradas + "\nPontos: " + totalDePontos;
		statusJogo += "\n\nBoneco:\n" + boneco.getStatusBoneco(qtdErros);
		statusJogo += "\n\nDICA| " + enigmasFrases.get(indexDaVez.get(0)).getDica() + ": ";
		statusJogo += getStatusPalpite(palpites.get(0));
		return statusJogo;
	}
	
	public String getStatusJogoUm(){
		
		String statusJogo = ">> Jogo da Forca<<";
		statusJogo += "\n\nErros: " + letrasErradas + "\nPontos: " + totalDePontos;
		statusJogo += "\n\nBoneco:\n" + boneco.getStatusBoneco(qtdErros);
		statusJogo += "\n\nDICA 1| " + enigmas.get(indexDaVez.get(0)).getTema() + ": ";
		statusJogo += getStatusPalpite(palpites.get(0));
		return statusJogo;
	}
	
	public String getStatusJogoDois(){
		
		String statusJogo = "\nDICA 2| " + enigmas.get(indexDaVez.get(1)).getTema() + ": ";
		statusJogo += getStatusPalpite(palpites.get(1));
		return getStatusJogoUm() + statusJogo;
	}
	
	public String getStatusJogoTres(){
		
		String statusJogo = "\nDICA 3| " + enigmas.get(indexDaVez.get(2)).getTema() + ": ";
		statusJogo += getStatusPalpite(palpites.get(2));
		return getStatusJogoDois() + statusJogo;
	}
	
	public boolean verificarLetraRepetida(String letra){
		
		if (letrasCertas.toLowerCase().contains(letra.toLowerCase()) || letrasErradas.toLowerCase().contains(letra.toLowerCase())){
			
			return true;
		}
		return false;
	}
	
	public boolean contemLetra(String[] palpite, String palavraEnigma, String letra){
		
		boolean encontrou = false;
		String[] word = palavraEnigma.split("");
		
		for (int i = 0; i < word.length; i++){
			
			if (word[i].toLowerCase().equals(letra.toLowerCase())){
				
				encontrou = true;
				palpite[i] = letra.toUpperCase();
			}
		}

		return encontrou;
	}
	
	public void registrarLetraCerta(String letra){
		
		letrasCertas += letra.toUpperCase();
		pontuaLetraCerta();
	}
	
	public void registrarLetraErrada(String letra){
		
		letrasErradas += "| " + letra.toUpperCase() + " |";
		qtdErros++;
	}
	
	public boolean verificarTudoOuNada(String palpite, String palavraEnigma){
		
		if (palpite.toLowerCase().equals(palavraEnigma.toLowerCase())){
			
			return true;
		}
		return false;
	}
	
}
