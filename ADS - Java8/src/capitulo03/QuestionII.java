package capitulo03;

import javax.swing.JOptionPane;

public class QuestionII {

	public static void main(String[] args) {
		
		int R1, R2, R3, R4, Max, Min;
		
		try{
			
			R1 = getInt("R1:");
			R2 = getInt("R2:");
			R3 = getInt("R3:");
			R4 = getInt("R4:");
			
			if (R1 >= R2 && R1 >= R3 && R1 >= R4){
				
				Max = R1;
			} else if (R2 >= R1 && R2 >= R3 && R2 >= R4){
				
				Max = R2;
				
			} else if (R3 >= R1 && R3 >= R2 && R3 >= R4){
				
				Max = R3;
			} else {
				
				Max = R4;
			}
			
			if (R1 <= R2 && R1 <= R3 && R1 <= R4){
				
				Min = R1;
				
			} else if (R2 <= R1 && R2 <= R3 && R2 <= R4){
				
				Min = R2;
				
			} else if (R3 <= R1 && R3 <= R2 && R3 <= R4){
				
				Min = R3;
			} else {
				
				Min = R4;
			}
			
			showMsg("Resistencias Fornecidas: " + R1 + ", " + R2 + ", " + R3 + ", " + R4 + "\nMaior Resistencia e: " + Max + "\nMenor Resistencia: " + Min + ".");
			
			
		} catch (NumberFormatException erro){
			
			System.out.println("Erro na Entrada de Dados! Digite Apenas Caracteres Numericos.\n" + erro.toString());
			
		}

	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}
	
	private static Integer getInt(String msg){
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
		
	}

}
