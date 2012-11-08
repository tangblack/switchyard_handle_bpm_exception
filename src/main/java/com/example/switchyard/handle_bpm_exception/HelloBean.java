package com.example.switchyard.handle_bpm_exception;

import org.switchyard.component.bean.Service;

@Service(HelloBeanInterface.class)
public class HelloBean implements HelloBeanInterface
{

	@Override
	public String sayHi(String str)
	{
		/* Simulate what happens when webservice returns exception. */
		return sayHiButThrowException();
		
//		return sayHiImp(str);
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
