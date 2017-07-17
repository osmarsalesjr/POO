package Domain;

public class Retangulo {
	
	public double width;
	public double height;
	public Ponto ponto_origem;
	
	public double area(){
		return this.width * this.height;
	}
	
	public double perimetro(){
		return 2 * this.width + 2 * this.height;
	}
	
	public boolean Contem(Retangulo rect){
		if ((rect.ponto_origem.x >= this.ponto_origem.x && rect.ponto_origem.x <= (this.ponto_origem.x + this.width)) && (rect.ponto_origem.y >= this.ponto_origem.y && rect.ponto_origem.y <= (this.ponto_origem.y + this.height))){
			return true;
		} else {
			return false;
		}
	}

}
