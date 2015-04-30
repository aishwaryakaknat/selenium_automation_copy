package com.keyword;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class KeywordExecution {

	
	public boolean runReflectionMethod(KeyWords key,String strClassName, String strMethodName,
			Object... inputArgs) {
		boolean blnRetValue = false;
		Class<?> params[] = new Class[inputArgs.length];

		for (int i = 0; i < inputArgs.length; i++) {
			if (inputArgs[i] instanceof String) {
				params[i] = String.class;
			}
		}
		try {
			Class<?> cls = Class.forName(strClassName);		
			Method myMethod = cls.getDeclaredMethod(strMethodName, params);
			Object obj=myMethod.invoke(key,inputArgs);
			if(obj.toString().contentEquals("true")){blnRetValue=true;}
			
		} catch (ClassNotFoundException e) {
			System.err.format(strClassName + ":- Class not found%n");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.err
					.format("Method invoked with wrong number of arguments%n");
		} catch (NoSuchMethodException e) {
			System.err.format("In Class " + strClassName + "::" + strMethodName
					+ ":- method does not exists%n");
		} catch (InvocationTargetException e) {
			System.err.format("Exception thrown by an invoked method%n");
		} catch (IllegalAccessException e) {
			System.err
					.format("Can not access a member of class with modifiers private%n");
			e.printStackTrace();
		} 
		
		/*catch (InstantiationException e) {
			System.err
				.format("Object cannot be instantiated for the specified class using the newInstance method%n");
		}*/
		return blnRetValue;

}
}