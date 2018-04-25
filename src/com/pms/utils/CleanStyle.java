package com.pms.utils;

public class CleanStyle {
	public String cleanStyle(String str){
		
		// " < "  ->  &lt;
		String s1 = str.replace("&", "&amp");
		
		// " > "  ->  &gt;
		String s2 = s1.replace(">", "&gt;");
				
		// " & "  ->  &amp;
		String s3 = s2.replace("<", "&lt;");
		
		// " " "  ->  &quot;
		String s4 = s3.replace("\"", "&quot;");
				
		// " ' "  ->  &apos;
		String s5 = s4.replace("\'", "&apos;");
				
		return s5;
	}
}
