package utils;

import javax.swing.JOptionPane;

public class IOTools {
	
	public static void showMsg(String msg){
		
		JOptionPane.showConfirmDialog(null, msg);
	}
	
	public static String getString(String msg){
		
		String string = JOptionPane.showInputDialog(msg);
		
		if (string.isEmpty()){
			
			showMsg("Entrada Vazia!");
			return getString(msg);
		} else{
			
			return string;
		}
	}
	
	public static String getFrase(String msg){
		
		String frase = getString(msg);
		
		if (frase.matches("^[0-9]*$")){
			
			showMsg("Digite Apenas Letras!");
			return getFrase(msg);
		} else{
			
			return frase;
		}
	}
	
	public static String getPalavra(String msg){
		
		String palavra = getFrase(msg);
		
		if (palavra.contains(" ")){
			
			showMsg("Por Favor, Digite Apenas uma Palavra!");
			return getPalavra(msg);
		} else {
			
			return palavra;
		}
	}
	
	public static int getInt(String msg){
		
		int integer;
		
		try {
			
			integer = Integer.valueOf(getString(msg));
			return integer;
		} catch (NumberFormatException e) {
			
			showMsg("Entrada Invalida!");
			return getInt(msg);
		}
	}
}
