package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


public class Main {
   public static void main(String[] args)throws Exception {

    String request = "https://translate.yandex.net/api/v1.5/tr.json/translate?" +
            "key=trnsl.1.1.20151016T210027Z.f1498ea6c752d7c2.dc3680491a3da4c00477f69fc49a87641516ef24" +
            "&text=cat dog tree mouse" +
            "&lang=en-ru" +
            "&format=plain";

       String result = performRequest(request);

       System.out.println(result);

       Gson gson = new GsonBuilder().create();
       JSON json = (JSON) gson.fromJson(result, JSON.class);

       /*for (Rate rate : json.query.results.rate) {
           System.out.println(rate.id + "=" + rate.Rate);
       }*/
       String newString = new String(Arrays.toString(json.text).getBytes("Cp1251"), "UTF-8");
       System.out.println(newString);
       System.out.println("JSON: \n\t" + gson.toJson(json));
   }

    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
        } finally {
            http.disconnect();
        }

        return sb.toString();
    }
   }

