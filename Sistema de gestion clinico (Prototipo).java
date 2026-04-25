/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkgfinal.ayd;

import java.util.ArrayList;
import java.util.Scanner;

// Clase para registrar los datos de pacientes
class Paciente {
    String id, nombre, tipoSangre, alergias, contactoEmergencia;

    public Paciente(String id, String nombre, String tipoSangre, String alergias, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.contactoEmergencia = contacto;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Sangre: " + tipoSangre + " | Alergias: " + alergias;
    }
}

// Clase para citas y pagos
class Cita {
    String fechaHora;
    String idPaciente;
    double monto;

    public Cita(String fechaHora, String idPaciente, double monto) {
        this.fechaHora = fechaHora;
        this.idPaciente = idPaciente;
        this.monto = monto;
    }
}

/**
 * @author Federico Rodea
 */
public class ProyectoFinalAyD {

   
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static ArrayList<Cita> citas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        int opcion = 0;
        do {
            System.out.println(" SISTEMA DE GESTIÓN CLÍNICA (PROTOTIPO)");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Agendar Cita (Validación de duplicados)");
            System.out.println("3. Ver Historial Médico");
            System.out.println("4. Reporte de Pagos (Para Contabilidad)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1: registrarPaciente(); break;
                    case 2: agendarCita();       break;
                    case 3: verHistorial();      break;
                    case 4: reportePagos();      break;
                    case 5: System.out.println("Saliendo del sistema..."); break;
                    default: System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        } while (opcion != 5);
    }

    
    private static void registrarPaciente() {
        System.out.print("Ingrese ID del Paciente: ");
        String id = sc.nextLine();
        System.out.print("Nombre Completo: ");
        String nombre = sc.nextLine();
        System.out.print("Tipo de Sangre: ");
        String sangre = sc.nextLine();
        System.out.print("Alergias: ");
        String alergias = sc.nextLine();
        System.out.print("Contacto de Emergencia: ");
        String contacto = sc.nextLine();

       
        pacientes.add(new Paciente(id, nombre, sangre, alergias, contacto));
        System.out.println("Paciente registrado con éxito.");
    }

    private static void agendarCita() {
        System.out.print("Ingrese Fecha y Hora (DD/MM/AAAA-HH:MM): ");
        String fecha = sc.nextLine();

        for (Cita c : citas) {
            if (c.fechaHora.equals(fecha)) {
                System.out.println("ERROR: Este horario ya está ocupado. Elija otro.");
                return;
            }
        }

        System.out.print("Ingrese ID del Paciente: ");
        String id = sc.nextLine();
        System.out.print("Monto a Pagar: ");
        double pago = Double.parseDouble(sc.nextLine());

        citas.add(new Cita(fecha, id, pago));
        System.out.println("Cita agendada exitosamente.");
    }

    private static void verHistorial() {
        System.out.print("Ingrese ID del Paciente para ver su historial: ");
        String id = sc.nextLine();
        System.out.println(" Historial de Citas ");
        for (Cita c : citas) {
            if (c.idPaciente.equals(id)) {
                System.out.println("Fecha: " + c.fechaHora + " | Estado: Atendido");
            }
        }
    }

    private static void reportePagos() {
        double total = 0;
        System.out.println("--- Reporte Financiero para Contador ---");
        for (Cita c : citas) {
            System.out.println("Paciente ID: " + c.idPaciente + " | Pago: $" + c.monto);
            total += c.monto;
        }
        System.out.println("Ingreso Total del Día: $" + total);
    }
}

    

