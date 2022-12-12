package data;

import modelo.*;
import ui.common.Constantes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BD {

    static LinkedHashMap<String, Persona> personas = new LinkedHashMap<>();
    static ArrayList<Persona> personasCotizables = new ArrayList<>();

    static {

        //personas
        personas.put("100", new Administrador("100", "Alvaro", 1500, Constantes.LIMPIAR_LOS_BAÑOS));
        personas.put("101", new Administrador("101", "Pancracio", 1200, "estafar a Hacienda"));
        personas.put("102", new Administrador("102", "Bernarda", 1600, "hacer los horarios de clase"));
        personas.put("103", new Administrador("103", "Francisco", 1800, Constantes.LIMPIAR_LOS_BAÑOS));

        personas.put("200", new Profesor("200", "Oscar", 2500, 15, List.of(new Asignatura(Constantes.PROGRAMACIÓN, 50, 1), new Asignatura("PSP", 20, 5), new Asignatura("Móviles"))));
        personas.put("201", new Profesor("201", "Mercedes", 2000, 20, List.of(new Asignatura(Constantes.BASE_DE_DATOS, 40, 25))));
        personas.put("202", new Profesor("202", "Lucía", 1700, 10, List.of(new Asignatura(Constantes.LENGUAJE_DE_MARCAS, 25, 10), new Asignatura("Otra asignatura"))));
        personas.put("203", new Profesor("203", "Dani", 1600, 12, List.of(new Asignatura(Constantes.SISTEMAS_INFORMÁTICOS, 35, 15), new Asignatura("Matemáticas"))));

        ArrayList<Asignatura> asignaturasTemporales = new ArrayList<>();
        asignaturasTemporales.add(new Asignatura(Constantes.PROGRAMACIÓN));
        asignaturasTemporales.add(new Asignatura(Constantes.LENGUAJE_DE_MARCAS));
        personas.put("300", new Alumno("300", "Juan Carlos", asignaturasTemporales, 250));

        asignaturasTemporales.clear();
        asignaturasTemporales.add(new Asignatura(Constantes.PROGRAMACIÓN));
        asignaturasTemporales.add(new Asignatura(Constantes.LENGUAJE_DE_MARCAS));
        asignaturasTemporales.add(new Asignatura(Constantes.BASE_DE_DATOS));
        asignaturasTemporales.add(new Asignatura(Constantes.SISTEMAS_INFORMÁTICOS));
        personas.put("301", new Alumno("301", "Jimena", asignaturasTemporales, 400));
        personas.put("302", new Alumno("302", "Sergio", asignaturasTemporales, 300));

        asignaturasTemporales.clear();
        asignaturasTemporales.add(new Asignatura(Constantes.PROGRAMACIÓN));
        personas.put("303", new Alumno("303", "Alan", asignaturasTemporales, 500));

        asignaturasTemporales.clear();
        asignaturasTemporales.add(new Asignatura(Constantes.BASE_DE_DATOS));
        personas.put("304", new Alumno("304", "Joaquín", asignaturasTemporales, 100000));

        personasCotizables.add(new Administrador("100", "Alvaro", 1500, Constantes.LIMPIAR_LOS_BAÑOS));
        personasCotizables.add(new Administrador("101", "Pancracio", 1200, "estafar a Hacienda"));
        personasCotizables.add(new Administrador("102", "Bernarda", 1600, "hacer los horarios de clase"));
        personasCotizables.add(new Administrador("103", "Francisco", 1800, Constantes.LIMPIAR_LOS_BAÑOS));

        personas.put("200", new Profesor("200", "Oscar", 2500, 15, List.of(new Asignatura(Constantes.PROGRAMACIÓN, 50, 1), new Asignatura("PSP", 20, 5), new Asignatura("Móviles"))));
        personasCotizables.add(new Profesor("201", "Mercedes", 2000, 20, List.of(new Asignatura(Constantes.BASE_DE_DATOS, 40, 25))));
        personasCotizables.add(new Profesor("202", "Lucía", 1700, 10, List.of(new Asignatura(Constantes.LENGUAJE_DE_MARCAS, 25, 10), new Asignatura("Otra asignatura"))));
        personasCotizables.add(new Profesor("203", "Dani", 1600, 12, List.of(new Asignatura(Constantes.SISTEMAS_INFORMÁTICOS, 35, 15), new Asignatura("Matemáticas"))));

    }

    private BD() {
    }
}
