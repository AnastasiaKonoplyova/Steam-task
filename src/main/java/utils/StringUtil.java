package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private StringUtil(){}
    public static String getNumberValue(String textValue){
        Pattern pattern = Pattern.compile("(\\.\\d+|[0-9]+\\.[0-9]*)|(\\d+)");
        Matcher matcher = pattern.matcher(textValue);
        if(matcher.find()){
            return matcher.group();
        }
        return "";
    }

    public static String getFileNameFromLink(String link){
        String[] lnWords = link.split("/");
        return lnWords[lnWords.length-1];
    }

}
