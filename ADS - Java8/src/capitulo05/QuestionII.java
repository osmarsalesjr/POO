package capitulo05;

import java.util.Random;

import javax.swing.JOptionPane;

public class QuestionII {

	public static void main(String[] args) {
		
		String[] meses = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		Random random = new Random();
		int mes = random.nextInt(11);
		
		showMsg("Mes sorteado: " + meses[mes]);
		

	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}

}
