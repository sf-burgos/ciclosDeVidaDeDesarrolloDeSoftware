package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    //Test
    public void validateRegistryResult() {

        Person person = new Person();

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
	
	@Test
    public void deberiaValidarElRegistroDeUnaPersona(){

        Person person = new Person("SebastianNieto",1,22,Gender.MALE,true);

		RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);	
    }
	
	@Test
    public void deberiaSerMayorDeEdadFronteraDiecisiete(){

        Person person = new Person("PedroPerez",1,17,Gender.MALE,true);

		RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);	
    }
	
	@Test
    public void deberiaSerMayorDeEdadFronteraDieciOcho(){

        Person person = new Person("PacoPerez",1,18,Gender.MALE,true);

		RegisterResult result = registry.registerVoter(person);

        Assert.assertNotEquals(RegisterResult.UNDERAGE, result);	
    }
	
	@Test
    public void deberiaSerMayorDeEdadFronteraDieciNueve(){

        Person person = new Person("PepitoPerez",1,19,Gender.MALE,true);

		RegisterResult result = registry.registerVoter(person);

        Assert.assertNotEquals(RegisterResult.UNDERAGE, result);	
    }
	
	
	@Test
    public void deberiaEstarConVida(){

        Person person = new Person("BrayanBurgos",1,50,Gender.MALE,true);

		RegisterResult result = registry.registerVoter(person);

        Assert.assertNotEquals(RegisterResult.DEAD, result);	
    }
	
	@Test
    public void noDeberiaEstarConVida(){

        Person person = new Person("PacoAlcarez",1,50,Gender.MALE,false);

		RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);	
    }
	
	//Test
    public void noDeberianEstarDuplicado(){

        Person person = new Person("BrayanBurgosD",1,80,Gender.MALE,true);

		RegisterResult result = registry.registerVoter(person);
		
		Person personDos = new Person("BrayanBurgosD",1,80,Gender.MALE,true);

		RegisterResult resultTwo = registry.registerVoter(personDos);


        Assert.assertEquals(RegisterResult.DUPLICATED, resultTwo);	
    }
	
	@Test
    public void noDeberiaTenerUnaEdadNegativaFronteraMenosUno(){

        Person person = new Person("CarlosDuarte",1,-1,Gender.MALE,true);

		RegisterResult result = registry.registerVoter(person);
	

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);	
     
    }
	@Test
	 public void deberiaTenerUnaEdadCeroFronteraCero(){

        Person person = new Person("VictoriaRueda",1,0,Gender.FEMALE,true);

		RegisterResult result = registry.registerVoter(person);
	

        Assert.assertEquals(RegisterResult.UNDERAGE, result);	
    }
	@Test
	 public void noDeberiaTenerUnaEdadNegativaFronteraUno(){

        Person person = new Person("BrayanBurgosD",1,1,Gender.MALE,true);

		RegisterResult result = registry.registerVoter(person);
	

        Assert.assertEquals(RegisterResult.UNDERAGE, result);	
    }
	
	@Test
	 public void deberiaTernerUnGenero(){

        Person person = new Person("BrayanBurgosD",1,1,Gender.UNIDENTIFIED,true);

		RegisterResult result = registry.registerVoter(person);
	

        Assert.assertNotEquals(RegisterResult.UNEPESIFIED_GENDER, result);	
    }

    // TODO Complete with more test cases
}