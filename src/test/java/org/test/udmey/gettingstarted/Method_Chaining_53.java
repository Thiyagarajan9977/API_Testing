package org.test.udmey.gettingstarted;

public class Method_Chaining_53 {
	
	public static void main(String[] args) {
		a1().a2().a3();		
		
	}
	
	public static Method_Chaining_53 a1() { 
		System.out.println("This is a1 method");
	return new Method_Chaining_53();	}

	public Method_Chaining_53 a2() { 
		System.out.println("This is a2 method");
	return new Method_Chaining_53();	}
	
	public Method_Chaining_53 a3() { 
		System.out.println("This is a3 method");
	return new Method_Chaining_53();	}
}
