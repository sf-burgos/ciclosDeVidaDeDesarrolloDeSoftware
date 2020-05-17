package edu.eci.cvds.tdd.registry;

public class Registry {
    public RegisterResult registerVoter(Person p) {
		
		if(p.isAlive()==false){
			return RegisterResult.DEAD;
		}else if(p.getAge()<18 && 0<=p.getAge()){
			return RegisterResult.UNDERAGE;
		}else if(p.getAge()<0){
			return RegisterResult.INVALID_AGE;
		}else if(p.getGender()==Gender.UNIDENTIFIED){
			return RegisterResult.UNEPESIFIED_GENDER;
		}
		else{
			return RegisterResult.VALID;
		}
    }
	
}