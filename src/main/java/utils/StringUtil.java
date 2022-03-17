package utils;

import org.apache.commons.lang.StringUtils;

public class StringUtil {

    public static int getIntValue(String textValue){
        return Integer.parseInt(textValue.substring(1,textValue.length()-1));
    }

    public static String getFileNameFromLink(String link){
        String[] lnWords = link.split("/");
        return lnWords[lnWords.length-1];
    }

    public static String changeMonthCase(String month){
        return StringUtils.capitalize(month.toLowerCase());
    }
}
