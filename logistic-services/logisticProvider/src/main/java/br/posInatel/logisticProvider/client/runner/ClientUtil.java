package br.posInatel.logisticProvider.client.runner;
import br.posInatel.logisticProvider.client.OrderClient;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ClientUtil {
    public static String getOrderUrl(){
        return getPropertyValue("delivery.rest.url");
    }
    public static String getPropertyValue(String property) {

        try (InputStream input = OrderClientCreateRunner.class.getClassLoader().getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("Não foi possível ler o arquivo application.properties.");
            }
            Properties prop = new Properties();

            // load a properties file from class path, inside static method
            prop.load(input);
            String restURL = prop.getProperty(property);

            return restURL;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
