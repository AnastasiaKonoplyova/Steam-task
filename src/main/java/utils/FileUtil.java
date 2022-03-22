package utils;

import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.protocol.BasicHttpContext;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static void saveFile(String downloadPath, String path) {
        File file = new File(path);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(downloadPath);
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(httpGet, new BasicHttpContext());
            FileUtils.copyInputStreamToFile(response.getEntity().getContent(), file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean isFileDownloaded(String filePath){
        return new File(filePath).exists();
    }

    public static boolean deleteFile(String filePath){
        return new File(filePath).delete();
    }
}
