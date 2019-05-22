package com.mex.SpringBootProject.initializers;

import com.mex.SpringBootProject.repositories.IItineraryRepository;
import com.mex.SpringBootProject.repositories.ILineRepository;
import com.mex.SpringBootProject.entities.Itinerary;
import com.mex.SpringBootProject.entities.ItineraryId;
import com.mex.SpringBootProject.entities.Line;
import io.micrometer.core.instrument.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class DummyCLR implements CommandLineRunner {

    @Autowired
    private ILineRepository repoLine;

    @Autowired
    private IItineraryRepository repoItinerary;

    @Override
    public void run(String... args) throws Exception {

        System.setProperty("http.agent", "Chrome");
        //lines
        URL urlLines = new URL("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o");
        HttpURLConnection httpconLine = (HttpURLConnection) urlLines.openConnection();
        httpconLine.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        InputStream inputLine = httpconLine.getInputStream();
        JSONArray jsonArray = new JSONArray(IOUtils.toString(inputLine, Charset.forName("UTF-8")));
        inputLine.close();
        jsonArray.forEach((Object x) -> {
            JSONObject obj = (JSONObject) x;
            repoLine.save(new Line(obj.getString("id"), obj.getString("codigo"), obj.getString("nome")));
            try {
                //Itinerario
                URL url = new URL("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + obj.getString("id"));
                HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
                httpcon.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
                InputStream input = httpcon.getInputStream();
                JSONObject obj1 = new JSONObject(IOUtils.toString(input, Charset.forName("UTF-8")));
                String idlinha = (String) obj1.remove("idlinha");
                obj1.remove("codigo");
                obj1.remove("nome");
                obj1.keySet().forEach((posIndex) -> {
                    JSONObject posJson = obj1.getJSONObject(posIndex);
                    repoItinerary.save(new Itinerary(new ItineraryId(idlinha, posIndex), Double.parseDouble(posJson.getString("lat")), Double.parseDouble(posJson.getString("lng"))));
                });
                input.close();
            } catch (MalformedURLException ex) {
                Logger.getLogger(DummyCLR.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DummyCLR.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
