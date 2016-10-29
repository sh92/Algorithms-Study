package org.cscnu.temperature;
/**
* 온도에서  화씨와 섭씨를  변환하는 프로그램의 interface
* @author 이상희
* @see MyTemperature
* @version 1.0
* @since 2015-03-14
*/

public interface Temperature{
	/** @return 섭씨의값을 반환*/
	public double getCelsius();

	/** @return 화씨의 값을 반환*/
	public double getFahrenheit();

	/** @param celsius 섭씨값을 저장*/
	public void setCelsius(double celsius);

	/** @param fahrenheit 화씨값을 저장*/
	public void setFahrenheit(double fahrenheit);
}
