package Application;

import javax.swing.JOptionPane;
import Domain.Retangulo;
import Domain.Ponto;

public class ProgramaRetangulo {

	public static void main(String[] args) {
		
		Retangulo rect1 = new Retangulo();
		rect1.ponto_origem = new Ponto();
	
		Retangulo rect2 = new Retangulo();
		rect2.ponto_origem = new Ponto();
		
		String menu = "### Menu Retangulo ###\n\n";
		menu += "1 - Configurar Retangulo 1\n";
		menu += "2 - Configurar Retangulo 2\n";
		menu += "3 - Area do Retangulo 1\n";
		menu += "4 - Area do Retangulo 2\n";
		menu += "5 - Perimetro do Retangulo 1\n";
		menu += "6 - Perimetro do Retangulo 2\n";
		menu += "7 - Verificar Ponto do Retangulo 2 no Retangulo 1\n";
		menu += "0 - Sair\n";
		
		int opcao = -1;
		
		while(opcao != 0){
			opcao = getInt(menu);
			
			switch (opcao){
				case 1:
					rect1.height = getDouble("Digite a Altura do Retangulo 1:");
					rect1.width = getDouble("Digite a Largura do Retangulo 1:");
					rect1.ponto_origem.x = getDouble("Ponto X do Retangulo 1:");
					rect1.ponto_origem.y = getDouble("Ponto Y do Retangulo 1:");
					break;
			
				case 2:
					rect2.height = getDouble("Digite a Altura do Retangulo 2:");
					rect2.width = getDouble("Digite a Largura do Retangulo 2:");
					rect2.ponto_origem.x = getDouble("Ponto X do Retangulo 2:");
					rect2.ponto_origem.y = getDouble("Ponto Y do Retangulo 2:");
					break;
				
				case 3:
					showMsg("Area do Retangulo 1 e: " + rect1.area());
					break;
				
				case 4:
					showMsg("Area do Retangulo 2 e: " + rect2.area());
					break;
				
				case 5:
					showMsg("Perimetro do Retangulo 1 e: " + rect1.perimetro());
					break;
				
				case 6:
					showMsg("Perimetro do Retangulo 2 e: " + rect2.perimetro());
					break;
					
				case 7:
					if (rect1.Contem(rect2) == true){
						showMsg("Ponto do Retangulo 2 Esta Contido no Retangulo 1!");
					} else {
						showMsg("Ponto do Retangulo 2 Nao Esta Contido no Retangulo 1!");
					}
					break;
			
				case 0:
					showMsg("Programa Encerrado!");
					break;
			
				default:
					showMsg("Opcao Invalida!");
				
			}
		}		

	}
	
	private static void showMsg(String msg){
		JOptionPane.showConfirmDialog(null, msg);
	}
	
	//private static String getString(String msg){
		//return JOptionPane.showInputDialog(msg);
		
	//}
	
	private static Integer getInt(String msg){
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
		
	}
	
	private static Double getDouble(String msg){
		return Double.valueOf(JOptionPane.showInputDialog(msg));
		
	}

}
