package com.example.switchyard.handle_bpm_exception;

import org.switchyard.component.bean.Service;

@Service(HelloBeanInterface.class)
public class HelloBean implements HelloBeanInterface
{
	/* Class variable */
	private static int sSayHiNumber = 0;
	
	
	@Override
	public String sayHi(String str)
	{
		System.out.println("[HelloBean] sSayHiNumber = " + sSayHiNumber);
		
		if (sSayHiNumber < 3)
		{
			/* Simulate what happens when webservice returns exception. */
			sSayHiNumber++;
			return sayHiButThrowException();
		}
		else
		{
			sSayHiNumber++;
			return sayHiImp(str);
		}
	}
	
	private String sayHiButThrowException()
	{
		System.out.println("[HelloBean] Boom! Here is a exception!");
		throw new RuntimeException("Boom!");
	}
	
	private String sayHiImp(String str)
	{
		if (str == null)
		{
			System.out.println("[HelloBean] Hi!");
			return "Hi!";
		}
		else
		{
			System.out.println("[HelloBean] Hi! " + str);
			return "Hi! " + str;
		}
	}

}
