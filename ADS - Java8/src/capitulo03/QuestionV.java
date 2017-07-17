package capitulo03;

import javax.swing.JOptionPane;

public class QuestionV {

	public static void main(String[] args) {
		
		int Opcao;
		String Menu = "Digite uma Opcao:\n1 - Exercicio 1\n2 - Exercicio 2\n3- Exercicio 3\n4 - Exercicio 4";
		
		try {
			
			Opcao = getInt(Menu);
			
			switch (Opcao){
				
				case 1:
					
					QuestionI.main(args);
					break;
				
				case 2:
					
					QuestionII.main(args);
					break;
				
				case 3:
					
					QuestionIII.main(args);
					break;
					
				case 4:
					
					QuestionIV.main(args);
					break;
				
				default:
					
					showMsg("Opcao Invalida.");
					break;
			
			}
			
		} catch (Exception e) {
	
			e.printStackTrace();
			
		}

	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}
	
	private static Integer getInt(String msg){
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
		
	}

}
