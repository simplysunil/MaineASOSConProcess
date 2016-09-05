package org.cgi.com;
/**
 * 
 */


import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sunil.kumar2
 *
 */
@XmlRootElement
public class MaineASOSConProcess {
	
	private String paramOne;
	private String paramTwo;
	private String paramThree;
	
	public String getParamOne() {
		return paramOne;
	}
	public void setParamOne(String paramOne) {
		this.paramOne = paramOne;
	}
	public String getParamTwo() {
		return paramTwo;
	}
	public void setParamTwo(String paramTwo) {
		this.paramTwo = paramTwo;
	}
	public String getParamThree() {
		return paramThree;
	}
	public void setParamThree(String paramThree) {
		this.paramThree = paramThree;
	}
	
	
	

}
