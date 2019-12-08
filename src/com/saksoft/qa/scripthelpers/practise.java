package com.saksoft.qa.scripthelpers;

public class practise {
	
	
	public static void main(String[] args) {
		String s="//div[div[label[contains(text(),'Email')]]]//div[@class='customLabelValue form-label']";
		
		String[] st=s.split("'");
		
		for(int i=0; i<st.length; i++) {
			System.out.println(st[i]);
		}

	}

}