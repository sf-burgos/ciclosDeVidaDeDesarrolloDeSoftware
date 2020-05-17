package edu.eci.cvds.servlet;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.PrimeFaces;
import java.util.ArrayList;
import java.util.Random;

@ManagedBean(name="guessBean")
@SessionScoped 
public class Adivina {
	private int numero;
	private int intentos;
	private int acumulado;
	private String estado;
	private ArrayList<Integer> lis;
	
	public Adivina() {
		 lis=new ArrayList<Integer>();
		 restart();
	}
	
	public void restart() {
		estado="Bienvenido a adivina el numero.";
		acumulado=100000;
		intentos=0;
		Random r=new Random();
		numero=r.nextInt(30);
		lis.clear();
	} 
	
	public void guess(int num) {
		if(num!=numero) {
			intentos+=1;
			acumulado-=10000;
			estado="Casi, sigue intentando";
			lis.add(num);
		}else{
			estado="Por fin ganaste :v!";
		}
	} 
	
	public ArrayList<Integer> getLista() {
		return lis;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public int getIntentoActual(){
		return numero;
	}

	public int getIntentos() {
		return intentos;
	}

	public int getAcumulado() {
		return acumulado;
	}


	public String getEstado() {
		return estado;
	}
}