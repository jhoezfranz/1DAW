
public class Fecha {
	int dia;
	int mes;
	int ano;
	
	
	Fecha(){
		
		this.dia=1;
		this.mes=1;
		this.ano=1;
	}
	
	Fecha(String f){
		String [] separar=f.split("/");
		this.dia=Integer.parseInt(separar[0]);
		this.mes=Integer.parseInt(separar[1]);
		this.ano=Integer.parseInt(separar[2]);
		
		
	}
}
