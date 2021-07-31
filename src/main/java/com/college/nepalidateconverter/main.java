package com.college.nepalidateconverter;

import java.sql.Date;

public class main {
	
   public static void main(String []args) {
	   long millis=System.currentTimeMillis();  
		Date date=new Date(millis);
	   Converter converter =new Converter();
//	   System.out.println(converter.getNepaliDate(2021, 8, 16));
//	   System.out.println(converter.getEnglishDate(2078, 4, 32));
//
//	   System.out.println(converter.getBar(2078, 4, 32));
	   EnglishDate engDate=converter.getEnglishDate(2078,4,16);
       NepaliDate nepaliDate= converter.getNepaliDate(engDate.getYear(), engDate.getMonth(), engDate.getDate());
       System.out.println(converter.isDateToday( 2078, 4,16));
       
       String dateInString=date.toString();
		String dateInArray[]=dateInString.split("-");
		NepaliDate nepaliDates=converter.getNepaliDate(Integer.parseInt(dateInArray[0]),Integer.parseInt(dateInArray[1]),Integer.parseInt(dateInArray[2]));
	   System.out.println(nepaliDates);
   }
}	
