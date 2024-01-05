package utils;


import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static String getObjectAsString(Object data){
        try {
            return objectMapper.writeValueAsString(data);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
