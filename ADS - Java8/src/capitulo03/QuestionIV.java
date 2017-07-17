package capitulo03;

import javax.swing.JOptionPane;

public class QuestionIV {

	public static void main(String[] args) {
		
		String Tabuada = "";
		int Numero, p;
		
		Numero = getInt("Forneca um Numero:");
		
		for (int i = 1; i <= 10 ; i++){
			
			p = Numero * i;
			Tabuada += Numero + " x " + i + " = " + p + "\n";
		}
		
		showMsg(Tabuada);
	}
	
	private static Integer getInt(String msg){
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
		
	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}

}
