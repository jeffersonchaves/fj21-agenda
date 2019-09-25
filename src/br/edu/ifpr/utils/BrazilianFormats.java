package br.edu.ifpr.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BrazilianFormats {

    public static String date(Date date){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); //"dd/MM/yyyy HH:mm:ss"
        return fmt.format(date);   // isto faz com que a data seja formatada
    }
}
