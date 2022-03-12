package utils;

public class StringUtil {
    public static Integer getIntValue(String textValue){
        return Integer.getInteger(textValue.substring(0,textValue.length()-1));
    }
}
