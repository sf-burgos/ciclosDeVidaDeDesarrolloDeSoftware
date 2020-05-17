package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert.*;
import org.junit.Test;
import junit.framework.Assert;

public class TarifasTest {
	
	
	@Test 
	public void descuentosMayoresDeEdadDiasAntelacionVeintiuno(){
		double valor=CalculadorDescuentos.calculoTarifa(300,21,66);
		Assert.assertEquals(231.0, valor);	
	}
	
	@Test 
	public void descuentosMenoresDeEdadDiasAntelacionVentiunoBaseSeis() throws Exception{
		double valor=CalculadorDescuentos.calculoTarifa(600,21,18);
		Assert.assertEquals(510.0, valor);	
	}
	
	@Test 
	public void descuentosMenoresDeEdadDiasAntelacionVeintiunoBaseUno() throws Exception{
		double valor=CalculadorDescuentos.calculoTarifa(100,21,17);
		Assert.assertEquals(80.0, valor);	
	}
	
	@Test
	public void descuentosMenoresDeEdadDiasAntelacionDiezynueveBaseUno() throws Exception{
		double valor=CalculadorDescuentos.calculoTarifa(100,20,18);
		Assert.assertEquals(100.0, valor);	
	}
	
	@Test
	public void sinDescuento() throws Exception{
		double valor=CalculadorDescuentos.calculoTarifa(100,20,19);
		Assert.assertEquals(100.0, valor);	
		double valor2=CalculadorDescuentos.calculoTarifa(100,20,65);
		Assert.assertEquals(100.0, valor2);
	}
	
	//@Test
	public void descuentosMenoresDeEdadDiezciete() throws Exception{
		double valor=CalculadorDescuentos.calculoTarifa(100,20,17);
		Assert.assertEquals(5.0, valor);	
	}
	
	@Test
	public void descuentosMenoresDiasAntelacionVeintiuno() throws Exception{
		double valor=CalculadorDescuentos.calculoTarifa(100,21,19);
		Assert.assertEquals(85.0, valor);	
	}
	
	
	
	
	
	
	

	
	
}