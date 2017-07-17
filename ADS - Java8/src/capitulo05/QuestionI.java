package capitulo05;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class QuestionI {

	public static void main(String[] args) {
		
		double[] notas = new double[5];
		double media = 0.0;
		String resultados = "Notas:\n";
		
		for (int i = 0; i < notas.length; i++){
			
			notas[i] = getDouble("Digite a " + (i + 1) + "º nota: ");
			media += notas[i];
		}
		
		Arrays.sort(notas);
		media = media /(double)(notas.length);
		
		for (int i = notas.length - 1; i >= 0; i--){
			
			resultados += "| " + notas[i] + " |";
		}
		
		resultados += "\n\nMedia = " + media;
		
		showMsg(resultados);

	}
	
	private static Double getDouble(String msg){
		return Double.valueOf(JOptionPane.showInputDialog(msg));
		
	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}

}
