package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static int getIntValue(String textValue){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(textValue);
        if(matcher.find()){
            return Integer.parseInt(matcher.group());
        }
        return 0;
    }

    public static String getFileNameFromLink(String link){
        String[] lnWords = link.split("/");
        return lnWords[lnWords.length-1];
    }

}
