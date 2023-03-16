package com.thanhtu.main;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.thanhtu.function.Function;
import com.thanhtu.function.FunctionDetail;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("REFLECTION JAVA");
		// create a instance of Function
		Function objFuntion = new Function();

		// declare function SUM A and B
		FunctionDetail functionSumAB = new FunctionDetail();
		functionSumAB.setFunctionName("sumAB");
		List<String> listTypeArgumentSumAB = Arrays.asList("java.lang.Double", "java.lang.Double");
		functionSumAB.setListTypeArgument(listTypeArgumentSumAB);

		System.out.println("a. Call method  arguments");

		// call method sumAB
		List<Class<?>> listTypeSumAB = functionSumAB.getListTypeArgument().stream().map(ele -> {
			try {
				return Class.forName(ele);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		// convert to List To Array SumAB
		Class<?>[] typeArrays = listTypeSumAB.stream().toArray(Class<?>[]::new);
		Method methodSumAB = Function.class.getDeclaredMethod(functionSumAB.getFunctionName(), typeArrays);
		methodSumAB.invoke(objFuntion, 5.0, 6.0);

		// declare function SUM of Array
		FunctionDetail functionSumArray = new FunctionDetail();
		functionSumArray.setFunctionName("sumArray");
		List<String> listArgumentSumArray = Arrays.asList("java.util.List");
		functionSumArray.setListTypeArgument(listArgumentSumArray);

		// call method sumAB
		List<Class<?>> listTypeSumArrays = functionSumArray.getListTypeArgument().stream().map(ele -> {
			try {
				return Class.forName(ele);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
		// convert to List To Array SumAB
		typeArrays= listTypeSumArrays.stream().toArray(Class<?>[]::new);
		Method methodSumArrays = Function.class.getDeclaredMethod(functionSumArray.getFunctionName(), typeArrays);
		List<Double> listArrays=Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0);
		methodSumArrays.invoke(objFuntion, listArrays);

		// call method without arguments
		System.out.println("b. Call method without arguments");
		// declare a Function Detail to call function sayHello
		FunctionDetail functionSayHello = new FunctionDetail();
		functionSayHello.setFunctionName("sayHello");
		Method method = Function.class.getDeclaredMethod(functionSayHello.getFunctionName());
		method.invoke(objFuntion);
	}
}
