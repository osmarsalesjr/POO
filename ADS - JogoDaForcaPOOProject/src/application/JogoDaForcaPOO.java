package application;

import static utils.IOTools.*;
import domain.JogoDaForca;


public class JogoDaForcaPOO {
	
	static JogoDaForca jdf = JogoDaForca.getInstancia();
	
	public static void main(String[] args) {
				
		int opcao;
		String menu = ">>>> JOGO DA FORCA <<<<\n1 - Adicionar Palavra";
		menu += "\n2 - Adicionar Frase\n3 - Novo Jogo";
		menu += "\n4 - Top Records\n0 - Sair";
		
		while(true){		
			
			opcao = getInt(menu);
			
			switch (opcao) {
				
				case 0:
					
					showMsg("APLICACAO FINALIZADA!");
					return;
				case 1:
					
					adicionarPalavra();
					break;
				case 2:
					
					adicionarFrase();
					break;
				case 3:
					
					if (jdf.getEnigmas().size() >= 3 && jdf.getEnigmasFrases().size() > 0){
						
						iniciarNovoJogo();
					} else {
						
						showMsg("ADICIONE UM UM MINIMO DE TRES PALAVRAS E UMA FRASE PARA INICIAR UMA PARTIDA!");
					}
					break;
				case 4:
					
					if (jdf.getJogadores().size() <= 0){
						
						showMsg("Ainda Nao Ha Records Registrados!");
					} else {
						
						showMsg(">>>> TOP RECORDS <<<<\n\n" + jdf.getStatusJogares());;
					}
					break;
				default:
					
					showMsg("OPCAO INVALIDA!");
					break;
			}
		}
	}
	
	public static String getLetra(String msg){
		
		String letra = getPalavra(msg);
		
		if (letra.length() != 1){
			
			showMsg("Quantidade de Letras Excedida! Digite Apenas um Caracter");
			return getLetra(msg);
		} else if(jdf.verificarLetraRepetida(letra)){
			
			showMsg("Esta Letra Ja Foi Testada!");
			return getLetra(msg);
		} else {
			
			return letra;
		}
	}

	private static void adicionarPalavra() {
		
		String tema, palavra;
		
		tema = getFrase("Digite o Tema:");
		palavra = getPalavra("Tema: " + tema.toUpperCase() + "\nDigite a Palavra:");
		jdf.adicionarNovoEnigma(tema.toUpperCase(), palavra.toUpperCase());
		showMsg("Tema e Palavra Adicionados com Sucesso!");
		
	}
	
	private static void adicionarFrase() {
		
		String dica, frase;
		
		dica = getFrase("Digite o Dica da Frase:");
		frase = getFrase("Dica: " + dica.toUpperCase() + "\nDigite a Frase:");
		jdf.adicionarNovaFrase(dica.toUpperCase(), frase.toUpperCase());
		showMsg("Dica e Frase Adicionados com Sucesso!");
	}
	
	private static void adicionarJogador(){
		
		String nome;
		nome = getString("Digite o Nome do Jogador:");
		jdf.adicionarNovoJogador(nome.toUpperCase());
		showMsg("Jogador Registrado nos Records!");
	}
	
	private static void finalizarPalpiteUm(){
		
		jdf.finalizarPalpite(jdf.getPalpites().get(0), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
	}
	
	private static void finalizarPalpiteDois(){
		
		finalizarPalpiteUm();
		jdf.finalizarPalpite(jdf.getPalpites().get(1), jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra());
	}
	
	private static void finalizarPalpiteTres(){
		
		finalizarPalpiteDois();
		jdf.finalizarPalpite(jdf.getPalpites().get(2), jdf.getEnigmas().get(jdf.getIndexDaVez().get(2)).getPalavra());
	}

	private static void iniciarNovoJogo(){
		
		int opcao;
		String menu = ">>>> MENU DE NOVO JOGO <<<<\n1 - Jogar com UMA Palavra";
		menu += "\n2 - Jogar com DUAS Palavras\n3 - Jogar com TRES Palavras";
		menu += "\n4 - Jogar com UMA Frase\n0 - Voltar ao Menu Principal";
		
		while(true){
			
			opcao = getInt(menu);
			
			switch (opcao) {
			
				case 0:
					
					return;
				case 1:
					
					iniciarNovoJogoUm();
					adicionarJogador();
					jdf.resetValores();
					break;
				case 2:
					
					iniciarNovoJogoDois();
					adicionarJogador();
					jdf.resetValores();
					break;
				case 3:
					
					iniciarNovoJogoTres();
					adicionarJogador();
					jdf.resetValores();
					break;
				case 4:
					
					iniciarNovoJogoFrase();
					adicionarJogador();
					jdf.resetValores();
					break;
				default:
					
					showMsg("OPCAO INVALIDA!");
					break;
			}
		}
	}

	private static void iniciarNovoJogoUm() {
		
		int opcao, index;
		boolean possui, ganhou;
		String palpite, letra, menu = "\n\n>> Opcoes de Jogo<<";
		menu += "\n1 - Digitar Letra\n2 - Ja Sei a Resposta\n0 - Desistir Jogo";
		
		index = jdf.selecionarIndex(jdf.getEnigmas().size());
		jdf.adicionarIndexDaVez(index);
		jdf.adicionarPalpite(jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra().length());
		jdf.inicializarPalpite(jdf.getPalpites().get(0), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
		
		while(true){
			
			opcao = getInt(jdf.getStatusJogoUm() + menu);
			
			switch (opcao) {
			
				case 0:
					
					finalizarPalpiteUm();
					showMsg("=[ Voce Desistiu!\n\n" + jdf.getStatusJogoUm());
					return;
				case 1:
					
					letra = getLetra(jdf.getStatusJogoUm() + "\nDigite a Letra: ");
					
					possui = jdf.contemLetra(jdf.getPalpites().get(0), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra(), letra);
					
					if (possui){
						
						jdf.registrarLetraCerta(letra);
					} else {
						
						jdf.registrarLetraErrada(letra);
					}
					
					if (jdf.getQtdErros() >= 6){
						
						finalizarPalpiteUm();
						showMsg("=[ Boneco Enforcado! Voce Perdeu!\n\n" + jdf.getStatusJogoUm());
						return;
					}
					
					ganhou = jdf.verificarTudoOuNada(jdf.getStatusPalpite(jdf.getPalpites().get(0)), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
					
					if (ganhou){
						
						jdf.pontuaFinalDeJogo();
						finalizarPalpiteUm();
						showMsg("Parabens! Voce Ganhou!! =D\n\n" + jdf.getStatusJogoUm());
						return;
					}
					
					break;
				case 2:
					
					palpite = getPalavra(jdf.getStatusJogoUm() + "\nDigite Seu Palpite");
					ganhou = jdf.verificarTudoOuNada(palpite, jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
					
					if (ganhou){
						
						jdf.pontuaFinalDeJogo();
						finalizarPalpiteUm();
						showMsg("Parabens, Voce Ganhou!! =D\n\n" + jdf.getStatusJogoUm());
					} else {
						
						finalizarPalpiteUm();
						showMsg("=[ Voce Errou e Perdeu!\n\n" + jdf.getStatusJogoUm());
					}
					
					return;
				default:
					
					showMsg("OPCAO INVALIDA!");
					break;
			}
		}
		
	}

	private static void iniciarNovoJogoDois() {
		
		int opcao, index, indexDois;
		boolean possui, possuiDois, ganhou, ganhouDois;
		String palpite, palpiteDois, letra, menu = "\n\n>> Opcoes de Jogo<<";
		menu += "\n1 - Digitar Letra\n2 - Ja Sei a Resposta\n0 - Desistir Jogo";
		
		index = jdf.selecionarIndex(jdf.getEnigmas().size());
		jdf.adicionarIndexDaVez(index);
		jdf.adicionarPalpite(jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra().length());
		jdf.inicializarPalpite(jdf.getPalpites().get(0), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
		
		indexDois = jdf.selecionarIndex(jdf.getEnigmas().size());
		jdf.adicionarIndexDaVez(indexDois);
		jdf.adicionarPalpite(jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra().length());
		jdf.inicializarPalpite(jdf.getPalpites().get(1), jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra());
		
		while(true){
			
			opcao = getInt(jdf.getStatusJogoDois() + menu);
			
			switch (opcao) {
			
				case 0:
					
					finalizarPalpiteDois();
					showMsg("=[ Voce Desistiu!\n\n" + jdf.getStatusJogoDois());
					return;
				case 1:
					
					letra = getLetra(jdf.getStatusJogoDois() + "\nDigite a Letra: ");
					
					possui = jdf.contemLetra(jdf.getPalpites().get(0), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra(), letra);
					possuiDois = jdf.contemLetra(jdf.getPalpites().get(1), jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra(), letra);
					
					if (possui || possuiDois){
						
						jdf.registrarLetraCerta(letra);
					} else {
						
						jdf.registrarLetraErrada(letra);
					}
					
					if (jdf.getQtdErros() >= 6){
						
						finalizarPalpiteDois();
						showMsg("=[ Boneco Enforcado! Voce Perdeu!\n\n" + jdf.getStatusJogoDois());
						return;
					}
					
					ganhou = jdf.verificarTudoOuNada(jdf.getStatusPalpite(jdf.getPalpites().get(0)), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
					ganhouDois = jdf.verificarTudoOuNada(jdf.getStatusPalpite(jdf.getPalpites().get(1)), jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra());
					
					if (ganhou && ganhouDois){
						
						jdf.pontuaFinalDeJogo();
						finalizarPalpiteDois();
						showMsg("Parabens! Voce Ganhou!! =D\n\n" + jdf.getStatusJogoDois());
						return;
					}
					
					break;
				case 2:
					
					palpite = getPalavra(jdf.getStatusJogoDois() + "\nDigite Seu Palpite 1:");
					palpiteDois = getPalavra(jdf.getStatusJogoDois() + "\nDigite Seu Palpite 2:");
					
					ganhou = jdf.verificarTudoOuNada(palpite, jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
					ganhouDois = jdf.verificarTudoOuNada(palpiteDois, jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra());
					
					if (ganhou && ganhouDois){
						
						jdf.pontuaFinalDeJogo();
						finalizarPalpiteDois();
						showMsg("Parabens, Voce Ganhou!! =D\n\n" + jdf.getStatusJogoDois());
					} else {
						
						finalizarPalpiteDois();
						showMsg("=[ Voce Errou e Perdeu!\n\n" + jdf.getStatusJogoDois());
					}
					
					return;
				default:
					
					showMsg("OPCAO INVALIDA!");
					break;
			}
		}
	}

	private static void iniciarNovoJogoTres() {
		
		int opcao, index, indexDois, indexTres;
		boolean possui, possuiDois, possuiTres, ganhou, ganhouDois, ganhouTres;
		String palpite, palpiteDois, palpiteTres, letra, menu = "\n\n>> Opcoes de Jogo<<";
		menu += "\n1 - Digitar Letra\n2 - Ja Sei a Resposta\n0 - Desistir Jogo";
		
		index = jdf.selecionarIndex(jdf.getEnigmas().size());
		jdf.adicionarIndexDaVez(index);
		jdf.adicionarPalpite(jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra().length());
		jdf.inicializarPalpite(jdf.getPalpites().get(0), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
		
		indexDois = jdf.selecionarIndex(jdf.getEnigmas().size());
		jdf.adicionarIndexDaVez(indexDois);
		jdf.adicionarPalpite(jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra().length());
		jdf.inicializarPalpite(jdf.getPalpites().get(1), jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra());
		
		indexTres = jdf.selecionarIndex(jdf.getEnigmas().size());
		jdf.adicionarIndexDaVez(indexTres);
		jdf.adicionarPalpite(jdf.getEnigmas().get(jdf.getIndexDaVez().get(2)).getPalavra().length());
		jdf.inicializarPalpite(jdf.getPalpites().get(2), jdf.getEnigmas().get(jdf.getIndexDaVez().get(2)).getPalavra());
		
		while(true){
			
			opcao = getInt(jdf.getStatusJogoTres() + menu);
			
			switch (opcao) {
			
				case 0:
					
					finalizarPalpiteTres();
					showMsg("=[ Voce Desistiu!\n\n" + jdf.getStatusJogoTres());
					return;
				case 1:
					
					letra = getLetra(jdf.getStatusJogoTres() + "\nDigite a Letra: ");
					
					possui = jdf.contemLetra(jdf.getPalpites().get(0), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra(), letra);
					possuiDois = jdf.contemLetra(jdf.getPalpites().get(1), jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra(), letra);
					possuiTres = jdf.contemLetra(jdf.getPalpites().get(2), jdf.getEnigmas().get(jdf.getIndexDaVez().get(2)).getPalavra(), letra);
					
					if (possui || possuiDois || possuiTres){
						
						jdf.registrarLetraCerta(letra);
					} else {
						
						jdf.registrarLetraErrada(letra);
					}
					
					if (jdf.getQtdErros() >= 6){
						
						finalizarPalpiteTres();
						showMsg("=[ Boneco Enforcado! Voce Perdeu!\n\n" + jdf.getStatusJogoTres());
						return;
					}
					
					ganhou = jdf.verificarTudoOuNada(jdf.getStatusPalpite(jdf.getPalpites().get(0)), jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
					ganhouDois = jdf.verificarTudoOuNada(jdf.getStatusPalpite(jdf.getPalpites().get(1)), jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra());
					ganhouTres = jdf.verificarTudoOuNada(jdf.getStatusPalpite(jdf.getPalpites().get(2)), jdf.getEnigmas().get(jdf.getIndexDaVez().get(2)).getPalavra());
					
					if (ganhou && ganhouDois && ganhouTres){
						
						jdf.pontuaFinalDeJogo();
						finalizarPalpiteTres();
						showMsg("Parabens! Voce Ganhou!! =D\n\n" + jdf.getStatusJogoTres());
						return;
					}
					
					break;
				case 2:
					
					palpite = getPalavra(jdf.getStatusJogoTres() + "\nDigite Seu Palpite 1:");
					palpiteDois = getPalavra(jdf.getStatusJogoTres() + "\nDigite Seu Palpite 2:");
					palpiteTres = getPalavra(jdf.getStatusJogoTres() + "\nDigite Seu Palpite 3:");
					
					ganhou = jdf.verificarTudoOuNada(palpite, jdf.getEnigmas().get(jdf.getIndexDaVez().get(0)).getPalavra());
					ganhouDois = jdf.verificarTudoOuNada(palpiteDois, jdf.getEnigmas().get(jdf.getIndexDaVez().get(1)).getPalavra());
					ganhouTres = jdf.verificarTudoOuNada(palpiteTres, jdf.getEnigmas().get(jdf.getIndexDaVez().get(2)).getPalavra());
					
					if (ganhou && ganhouDois && ganhouTres){
						
						jdf.pontuaFinalDeJogo();
						finalizarPalpiteTres();
						showMsg("Parabens, Voce Ganhou!! =D\n\n" + jdf.getStatusJogoTres());
					} else {
						
						finalizarPalpiteTres();
						showMsg("=[ Voce Errou e Perdeu!\n\n" + jdf.getStatusJogoTres());
					}
					
					return;
				default:
					
					showMsg("OPCAO INVALIDA!");
					break;
			}
		}
	}

	private static void iniciarNovoJogoFrase() {
		
		int opcao, index;
		boolean possui, ganhou;
		String palpite, letra, menu = "\n\n>> Opcoes de Jogo<<";
		menu += "\n1 - Digitar Letra\n2 - Ja Sei a Resposta\n0 - Desistir Jogo";
		
		index = jdf.selecionarIndex(jdf.getEnigmasFrases().size());
		jdf.adicionarIndexDaVez(index);
		jdf.adicionarPalpite(jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase().length());
		jdf.inicializarPalpite(jdf.getPalpites().get(0), jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase());
		
		while(true){
			
			opcao = getInt(jdf.getStatusJogoFrase() + menu);
			
			switch (opcao) {
			
				case 0:
					
					jdf.finalizarPalpite(jdf.getPalpites().get(0), jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase());
					showMsg("=[ Voce Desistiu!\n\n" + jdf.getStatusJogoFrase());
					return;
				case 1:
					
					letra = getLetra(jdf.getStatusJogoFrase() + "\nDigite a Letra: ");
					
					possui = jdf.contemLetra(jdf.getPalpites().get(0), jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase(), letra);
					
					if (possui){
						
						jdf.registrarLetraCerta(letra);
					} else {
						
						jdf.registrarLetraErrada(letra);
					}
					
					if (jdf.getQtdErros() >= 6){
						
						jdf.finalizarPalpite(jdf.getPalpites().get(0), jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase());
						showMsg("=[ Boneco Enforcado! Voce Perdeu!\n\n" + jdf.getStatusJogoFrase());
						return;
					}
					
					ganhou = jdf.verificarTudoOuNada(jdf.getStatusPalpite(jdf.getPalpites().get(0)), jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase());
					if (ganhou){
						
						jdf.pontuaFinalDeJogo();
						jdf.finalizarPalpite(jdf.getPalpites().get(0), jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase());
						showMsg("Parabens! Voce Ganhou!! =D\n\n" + jdf.getStatusJogoFrase());
						return;
					}
					
					break;
				case 2:
					
					palpite = getFrase(jdf.getStatusJogoFrase() + "\nDigite Seu Palpite:");
					ganhou = jdf.verificarTudoOuNada(palpite, jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase());
					
					if (ganhou){
						
						jdf.pontuaFinalDeJogo();
						jdf.finalizarPalpite(jdf.getPalpites().get(0), jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase());
						showMsg("Parabens, Voce Ganhou!! =D\n\n" + jdf.getStatusJogoFrase());
					} else {
						
						jdf.finalizarPalpite(jdf.getPalpites().get(0), jdf.getEnigmasFrases().get(jdf.getIndexDaVez().get(0)).getFrase());
						showMsg("=[ Voce Errou e Perdeu!\n\n" + jdf.getStatusJogoFrase());
					}
					
					return;
				default:
					
					showMsg("OPCAO INVALIDA!");
					break;
			}
		}
	}
}
