package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Getter
@Log4j2
public class Configuracion {

    private static Configuracion configuracion;

    public static Configuracion getInstance() {
        if (configuracion == null) {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();

            try {
                configuracion = mapper.readValue(
                        Configuracion.class.getClassLoader().getResourceAsStream("config.yaml"), Configuracion.class);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return configuracion;
    }
    private String pathJson;
}