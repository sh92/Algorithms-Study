package org.cscnu.temperature;

/**
* 섭씨와 화씨를 변환하는 함수를 정의해둠
*@author 이상희
*@version 1.0
*@since 2015-3-14
*/
public class MyTemperature implements Temperature{
 private double celsius; //섭씨값을 저장

 	public MyTemperature(double value, char scale){
 	if(scale == 'C') setCelsius(value);
	else setFahrenheit(value);
	}

 	public double getCelsius(){
 	return celsius;
	}

	 public double getFahrenheit(){
 	return 9*celsius/5+32.0;
	}

	public void setCelsius(double celsius){
		this.celsius = celsius;
	}

	public void setFahrenheit(double fahrenheit){
		this.celsius = 5*(fahrenheit - 32)/9;
	}
	/** @return 화씨와 섭씨의 변환을 출력함*/
	public String toString(){

		return round(getCelsius())+" C = "+ round(getFahrenheit())+" F";
	}
	/** @return double x를 10진수의 첫째자리로 반올림함*/
	private double round(double x){
	//return x, 10진수로 반올림
	 	return Math.round(10*x)/10.0;
   }
 } 
