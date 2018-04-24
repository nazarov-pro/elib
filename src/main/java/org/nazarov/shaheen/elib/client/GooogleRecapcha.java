package org.nazarov.shaheen.elib.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class GooogleRecapcha {

    private static final String RECAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify";
    private static final String SITEKEY = "6Ld45xkTAAAAAGdlU2yfj2x8G8kbwv_Xm2cgaCeo";

    public String getIpAddress(String recaptcha){
        try {
            String urlParameters = String.format("secret=%s&response=%s", SITEKEY, recaptcha);
            URL obj = new URL(RECAPTCHA_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("Accept", MediaType.APPLICATION_JSON_VALUE);
            con.setRequestProperty("Content-Length", urlParameters.getBytes().length + "");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            ObjectMapper objectMapper = new ObjectMapper();
            TypeFactory factory = TypeFactory.defaultInstance();
            MapType mapType = factory.constructMapType(HashMap.class, String.class, Object.class);
            Map<String, Object> result = objectMapper.readValue(con.getInputStream(), mapType);
            if((boolean) result.get("success")){
                return (String) result.get("hostname");
            }
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
