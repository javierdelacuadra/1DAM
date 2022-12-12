package data;

import modelo.Alumno;
import modelo.Asignatura;
import modelo.Persona;
import modelo.Profesor;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class DaoInstituto {

    public boolean matricularAlumno(String dni, String asignatura) {
        boolean alumnoMatriculado = false;
        Asignatura a = new Asignatura(asignatura);
        int precio = 0;

        for (int i = 0; i < BD.personasCotizables.size(); i++) {
            if (BD.personasCotizables.get(i) instanceof Profesor) {
                for (int j = 0; j < ((Profesor) BD.personasCotizables.get(i)).getAsignaturas().size(); j++) {
                    if (Objects.equals(a.getNombre(), ((Profesor) BD.personasCotizables.get(i)).getAsignaturas().get(j).getNombre())) {
                        precio = ((Profesor) BD.personasCotizables.get(i)).getAsignaturas().get(j).getPrecio();
                        a = ((Profesor) BD.personasCotizables.get(i)).getAsignaturas().get(j);
                        break;
                    }
                }
            }
        }

        if (BD.personas.get(dni) instanceof Alumno && a.getMaxAlumnos() > 0) {
            if (((Alumno) BD.personas.get(dni)).getDinero() > precio) {
                ((Alumno) BD.personas.get(dni)).setDinero(((Alumno) BD.personas.get(dni)).getDinero() - precio);
                a.setMaxAlumnos(a.getMaxAlumnos() - 1);
                ((Alumno) BD.personas.get(dni)).getAsignaturas().add(new Asignatura(a.getNombre()));
                alumnoMatriculado = true;
            }
        }
        return alumnoMatriculado;
    }

    public List<Persona> listaProfesoresOrdenada() {
        return BD.personas.values().stream().filter(Profesor.class::isInstance)
                .sorted(Comparator.comparingInt(persona -> ((Profesor) persona).getAsignaturas().size()))
                .collect(Collectors.toUnmodifiableList());
    }

    public double notaMedia(String dni) {
        AtomicReference<Double> notaMedia = new AtomicReference<>((double) 0);
        AtomicReference<Double> contador = new AtomicReference<>((double) 0);

        BD.personas.values().stream().filter(persona -> persona.getDni().equalsIgnoreCase(dni))
                .filter(Alumno.class::isInstance)
                .forEach(persona -> ((Alumno) persona).getAsignaturas().forEach(asignatura -> {
                    if (asignatura.getNota() >= 0) {
                        notaMedia.updateAndGet(aDouble -> aDouble+asignatura.getNota());
                        contador.getAndSet(contador.get() + 1);
                    }
                }));

        double notaMediaFinal = notaMedia.get();
        notaMediaFinal = notaMediaFinal / contador.get();

        return notaMediaFinal;
    }

    public boolean addNota(String dni, Asignatura a) {
        AtomicBoolean notaAdded = new AtomicBoolean(false);
        if (BD.personas.get(dni) instanceof Alumno) {
            BD.personas.values().stream().filter(persona -> persona.getDni().equalsIgnoreCase(dni))
                    .forEach(persona -> ((Alumno) persona).getAsignaturas().forEach(asignatura -> {
                        if (asignatura.getNombre().equalsIgnoreCase(a.getNombre()))  {
                            asignatura.setNota(a.getNota());
                            notaAdded.set(true);
                        }
                    }));
        }
        return notaAdded.get();
    }
}
