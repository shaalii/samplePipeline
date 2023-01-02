package com.sapient.app;

import com.sapient.model.Message;


public class App 
{
    public static void main( String[] args )
    {
    	Message m=new Message("Hello kirti");
        System.out.println(m.getGreeting());
    }
}


