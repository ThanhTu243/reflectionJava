package com.thanhtu.function;

import java.util.List;

public class Function {
	public void sumAB(Double a, Double b)
	{
		System.out.println(" - Tổng 2 số "+a+" và "+b+" là: "+(a+b));
	}
	public void sumArray(List<Double> list)
	{
		Double sum = list.stream()
				  .reduce(0.0, Double::sum);
		System.out.println(" - Tổng của mảng là: "+sum);
	}
	public void sayHello()
	{
		System.out.println(" - Reflection is ez");
	}
}
