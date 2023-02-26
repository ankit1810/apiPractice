package apiConfigs;

import utils.PropertyReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HeadersConfigs {
    public Map<String, String> defaultHeaders(){
        Map<String, String> defaultHeaders=new HashMap<>();
        defaultHeaders.put("Content-Type","application/json");
        defaultHeaders.put("Accept","application/json");
        return defaultHeaders;
    }
    public Map<String, String> headers(){
        Map<String, String> defaultHeaders=new HashMap<>();
        defaultHeaders.put("Content-Type","application/json");
        defaultHeaders.put("Accept","application/json");
        return defaultHeaders;
    }
    public Map<String,File> headersForFile(){
        Map<String,File> defaultHeaders=new HashMap<>();
        File file = new File(PropertyReader.path);
        defaultHeaders.put("multipart/form-data",file);
        return defaultHeaders;
    }
}
