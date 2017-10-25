
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GetApiKeys {

    private String apiKey;
    private String apiSecret;
    private JSONObject jsonObject;

    GetApiKeys() {
        createJsonObject(getApiFile());
        setApiKey(jsonObject);
        setApiSecret(jsonObject);
    }

    public String getApiKey() {
       return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    private void setApiKey(JSONObject jsonObject) {
        this.apiKey = (String) jsonObject.get("apiKey");
    }

    private void setApiSecret(JSONObject jsonObject) {
        this.apiSecret = (String) jsonObject.get("apiSecret");
    }

    private String getApiFile() {
        String currentPath = new File("").getAbsolutePath();
        String apiFilePath = currentPath.concat("/apiKeys.json");
        return apiFilePath;
    }

    private void createJsonObject(String apiFilePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(apiFilePath));
            this.jsonObject = (JSONObject) obj;
        }
        catch(FileNotFoundException fe) {
            fe.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
