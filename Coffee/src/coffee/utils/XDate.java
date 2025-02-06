/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nguye
 */
public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    // Chuyen chuoi thanh thoi gian
    public static Date toDate(String date, String pattern){
        try{
            formater.applyPattern(pattern);
            return formater.parse(date);
        }catch(ParseException ex){
            throw new RuntimeException(ex);
        }
    }
    public static String toString(Date date, String pattern){
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    /**
     * Bổ sung số ngày vào thời gian
     * @param date thời gian hiện có
     * @param days số ngày cần bổ sung váo date
     * @return Date kết quả
     */
     public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }
}
