import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IngresoAlumnos {
    public static void main(String[] args) {
        System.out.println("*** BIENVENIDO AL PROGRAMA ***");
        System.out.println();
        var ingreso = true;
        var consola = new Scanner(System.in);
        HashMap<String, List<Float>> alumnos = new HashMap<>();
        while (ingreso) {
            System.out.print("""
                    ¿Que deseas realizar: 
                       1. Agregar alumnos.
                       2. Ver alumnos.
                       3. Eliminar alumnos.
                       4. Ver notas.
                       5. Calcular promedio.
                       6. Modificar notas.
                       7. Modificar alumno.
                       8. Salir del programa.
                    Elija una opcion:\s""");
            try {
                var opcion = Integer.parseInt(consola.nextLine());
                System.out.println();
                if (opcion >= 1 || opcion <= 8) {
                    if (opcion == 1) {
                        var a = true;
                        while (a) {
                            // Ingresar alumno y sus notas
                            System.out.println("INGRESO DE ESTUDIANTES");
                            List<Float> calificaciones = new ArrayList<>();
                            System.out.print("ingrese el nombre del alumno: ");
                            var estudiante = consola.nextLine();
                            if (estudiante.matches("[a-z A-Z]*")) {
                                while (true) {
                                    System.out.print("Ingrese la primera nota: ");
                                    try {
                                        var nota1 = Float.parseFloat(consola.nextLine());
                                        calificaciones.add(nota1);
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Ingrese una nota valida");
                                    }
                                }
                                while (true) {
                                    System.out.print("Ingrese la segunda nota: ");
                                    try {
                                        var nota2 = Float.parseFloat(consola.nextLine());
                                        calificaciones.add(nota2);
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Ingrese una nota valida");
                                    }
                                }
                                while (true) {
                                    System.out.print("Ingrese la tercera nota: ");
                                    try {
                                        var nota3 = Float.parseFloat(consola.nextLine());
                                        calificaciones.add(nota3);
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Ingrese una nota valida");
                                    }
                                }
                                while (true) {
                                    System.out.print("Ingrese la cuarta nota: ");
                                    try {
                                        var nota4 = Float.parseFloat(consola.nextLine());
                                        calificaciones.add(nota4);
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Ingrese una nota valida");
                                    }
                                }
                                alumnos.put(estudiante, calificaciones);
                                System.out.println(alumnos);
                                System.out.println("!!! Estudiante ingresado con exito ¡¡¡");
                                System.out.println();
                                a = false;
                            } else {
                                System.out.println("Ingrese un nombre valido");
                                System.out.println();
                            }
                        }
                    }
                    if (opcion == 2) {
                        // Ver alumnos
                        while (true) {
                            System.out.print("""
                                    Necesitas ver a 1 o a varios alumnos?
                                       Solo 1 (Marque 1).
                                       Varios (Marque 2).
                                    Marque una opcion:\s""");
                            try {
                                var eleccion = Integer.parseInt(consola.nextLine());
                                if (eleccion == 1 || eleccion == 2) {
                                    if (eleccion == 1) {
                                        System.out.print("Ingrese el nombre del alumno: ");
                                        var unAlumno = consola.nextLine();
                                        if (unAlumno.matches("[a-z A-Z]*")) {
                                            if (alumnos.containsKey(unAlumno)) {
                                                System.out.println(unAlumno + " " + alumnos.get(unAlumno));
                                                System.out.println();
                                                break;
                                            } else {
                                                System.out.println("Alumno " + unAlumno + " no existe, favor de ingresar un alumno existente");
                                                System.out.println();
                                            }
                                        } else {
                                            System.out.println("""
                                                    Nombre invalido
                                                    Favor de ingresar un nombre valido""");
                                            System.out.println();
                                        }
                                    }
                                    if (eleccion == 2) {
                                        System.out.println(alumnos);
                                        System.out.println();
                                        break;
                                    }
                                } else {
                                    System.out.println("Ingrese un valor entre 1 y 2");
                                    System.out.println();
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ingrese un valor valido");
                                System.out.println();
                            }
                        }
                    }
                    if (opcion == 3) {
                        // Eliminar alumno
                        while (true) {
                            System.out.println("ELIMINACION DE ALUMNOS");
                            System.out.print("Que alumno desea eliminar?: ");
                            var alumnoBorrar = consola.nextLine();
                            if (alumnoBorrar.matches("[a-z A-Z]*")) {
                                if (alumnos.containsKey(alumnoBorrar)) {
                                    alumnos.remove(alumnoBorrar);
                                    System.out.println(alumnos);
                                    System.out.println("!!! Alumno eliminado con exito ¡¡¡");
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Alumno " + alumnoBorrar + " no existe, favor de ingresar un alumno existente");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("""
                                        Nombre Invalido
                                        Favor de ingresar un nombre valido""");
                                System.out.println();
                            }
                        }
                    }
                    if (opcion == 4) {
                        // Ver notas alumno
                        while (true) {
                            System.out.println("VER NOTAS ALUMNO");
                            System.out.print("Indique nombre de alumno: ");
                            var notasAlumno = consola.nextLine();
                            if (notasAlumno.matches("[a-z A-Z]*")) {
                                if (alumnos.containsKey(notasAlumno)) {
                                    System.out.println("las notas de " + notasAlumno + " son " + alumnos.get(notasAlumno));
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Alumno " + notasAlumno + " no existe, favor de ingresar un alumno existente");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("""
                                        Nombre Invalido
                                        Favor de ingresar un nombre valido""");
                                System.out.println();
                            }
                        }
                    }
                    if (opcion == 5) {
                        // Calcular promedio
                        while (true) {
                            System.out.println("PROMEDIO ALUMNO");
                            System.out.print("Indique el alumno al cual requiere calcular promedio: ");
                            var alumnoPromedio = consola.nextLine();
                            if (alumnoPromedio.matches("[a-z A-Z]*")) {
                                if (alumnos.containsKey(alumnoPromedio)) {
                                    List<Float> notas = new ArrayList<>(alumnos.get(alumnoPromedio));
                                    var suma = 0.0;
                                    for (Float nota : notas) {
                                        suma += nota;
                                    }
                                    var promedio = suma / notas.size();
                                    var patron = new DecimalFormat("#.#").format(promedio);
                                    System.out.println("El promedio de " + alumnoPromedio + " es " + patron);
                                    System.out.println("!!! promedio calculado con exito ¡¡¡");
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Alumno " + alumnoPromedio + " no existe, favor de ingresar un alumno existente");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("""
                                        Nombre Invalido
                                        Favor de ingresar un nombre valido""");
                                System.out.println();
                            }
                        }
                    }
                    if (opcion == 6) {
                        // Modificar notas alumno
                        while (true) {
                            System.out.println("MODIFICACION NOTAS");
                            System.out.print("Indique alumno para modificar sus notas: ");
                            var alumnoNotasMo = consola.nextLine();
                            if (alumnoNotasMo.matches("[a-z A-Z]*")) {
                                if (alumnos.containsKey(alumnoNotasMo)) {
                                    var buscarNota = alumnos.get(alumnoNotasMo);
                                    while (true) {
                                        System.out.print("Ingrese nota a cambiar: ");
                                        try {
                                            var notaModificar = Float.parseFloat(consola.nextLine());
                                            for (int i = 0; i < buscarNota.size(); i++) {
                                                if (Math.abs(buscarNota.get(i) - notaModificar) < 0.00001f) {
                                                    System.out.print("Ingrese nueva nota: ");
                                                    var nuevaNota = Float.parseFloat(consola.nextLine());
                                                    buscarNota.set(i, nuevaNota);
                                                    System.out.println(alumnoNotasMo + ": " + alumnos.get(alumnoNotasMo));
                                                    System.out.println("!!! Nota modificada con exito ¡¡¡");
                                                    System.out.println();
                                                    break;
                                                }
                                            }
                                            break;
                                        } catch (NumberFormatException e) {
                                            System.out.println("Ingrese una nota valida");
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("Alumno " + alumnoNotasMo + " no existe, favor de ingresar un alumno existente");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("""
                                        Nombre Invalido
                                        Favor de ingresar un nombre valido""");
                                System.out.println();
                            }
                        }
                    }
                    if (opcion == 7) {
                        // Modificar alumno
                        while (true) {
                            System.out.println("MODIFICACION ALUMNO");
                            System.out.print("Ingrese nombre de alumno a modificar: ");
                            var alumnoActual = consola.nextLine();
                            if (alumnoActual.matches("[a-z A-Z]*")) {
                                if (alumnos.containsKey(alumnoActual)) {
                                    System.out.print("Ingrese nuevo nombre: ");
                                    var alumnoNuevo = consola.nextLine();
                                    List<Float> notas = new ArrayList<>(alumnos.get(alumnoActual));
                                    alumnos.remove(alumnoActual);
                                    alumnos.put(alumnoNuevo, notas);
                                    System.out.println(alumnos);
                                    System.out.println("!!! Alumno modificado con exito ¡¡¡");
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.println("Alumno " + alumnoActual + " no existe, favor de ingresar un alumno existente");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("""
                                        Nombre Invalido
                                        Favor de ingresar un nombre valido""");
                                System.out.println();
                            }
                        }
                    }
                    if (opcion == 8) {
                        // Salir del programa
                        System.out.println("SALIENDO DEL PROGRAMA......");
                        System.out.println("HASTA PRONTO");
                        ingreso = false;
                    }
                }
                if (opcion < 1 || opcion > 8) {
                    System.out.println("Ingrese un valor entre 1 y 8");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("¡¡¡¡ Ingrese un valor valido !!!!!");
                System.out.println();
            }
        }
    }
}