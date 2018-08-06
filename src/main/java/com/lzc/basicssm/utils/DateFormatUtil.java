package com.lzc.basicssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    public static String formatDate(Date times){
        return new SimpleDateFormat("yyyy-MM").format(times);
    }
}
