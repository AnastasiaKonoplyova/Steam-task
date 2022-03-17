package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;

public class JSONReader {
    private static final String TEST_DATA_PATH = "src/test/resources/testData.json";
    private static JsonNode testNode;

    public static void loadProperty(){
        try(FileInputStream testInput = new FileInputStream(TEST_DATA_PATH))
        {
            ObjectMapper mapper = new ObjectMapper();
            testNode = mapper.readTree(testInput);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTestDataJSON(String property){
        return testNode.get(property).textValue();
    }

}
