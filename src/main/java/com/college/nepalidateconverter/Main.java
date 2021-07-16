package com.college.nepalidateconverter;

import java.util.List;

/**
 * Created by nabin_khadka on 11/18/16.
 */
public class Main {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        Converter converter = new Converter();

//        List<NepaliDate> nepaliDateList = converter.getFullNepaliMonthOf(2021, 0, 0);
//        
//        for (NepaliDate nepaliDate: nepaliDateList){
//            System.out.println(nepaliDate.toString());
//        }
//
//
//        long endTime   = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
        
        System.out.println(converter.getNepaliMonthFromYear(2078,0)+" "+converter.getNepaliMonthFromYear(2078,1)+" "+converter.getNepaliMonthFromYear(2078,2)+" "+converter.getNepaliMonthFromYear(2078,3)+" "+converter.getNepaliMonthFromYear(2078,4)+" "+converter.getNepaliMonthFromYear(2078,11));
//        System.out.println("Time taken: " + totalTime + " ms");
//           for(int i:converter.getNepaliMonthFromYear(2078,2)) {
//        	   System.out.println(i);
//           }
        
    }
}
