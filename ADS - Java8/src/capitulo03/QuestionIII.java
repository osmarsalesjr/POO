package capitulo03;

import javax.swing.JOptionPane;

public class QuestionIII {

	public static void main(String[] args) {
		
		String Login, Senha;
		
		for (int i = 2; i >= 0; i--){
			Login = getString("Forneca um Login:");
			Senha = getString("Forneca uma Senha:");
			
			if (Login.equals("java8") && Senha.equals("java8")){
				
				showMsg("Login e Senha Aceitos!");
				break;
				
			} else {
				
				showMsg("Falha, Verifique Login e Senha!\nVoce tem mais " + i + " Tentativa(s)!");
				
			}
			
		}
		
	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}
	
	private static String getString(String msg){
		return JOptionPane.showInputDialog(msg);
		
	}

}
