package com.salesianostriana.dam.ejercicio.dto.reserva;

public class MainReserva {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1L, "Ana", "García López", "ana@example.com", "600000000");
        Habitacion doble = new Habitacion(10L, "204", "Doble", 90.0, 2);
        Reserva completa = new Reserva(100L, "R-2026-001", 3, cliente, doble);
        Reserva sinCliente = new Reserva(101L, "R-2026-002", 2, null, doble);
        Reserva sinHabitacion = new Reserva(102L, "R-2026-003", 1, cliente, null);
        Reserva sinNoches = new Reserva(103L, "R-2026-004", null, cliente, doble);
        Habitacion sinPrecio = new Habitacion(11L, "105", "Individual", null, 1);
        Reserva sinPrecioNoche = new Reserva(104L, "R-2026-005", 2, cliente, sinPrecio);

        System.out.println(ReservaDTO.desde(completa));
        System.out.println(ReservaDTO.desde(sinCliente));
        System.out.println(ReservaDTO.desde(sinHabitacion));
        System.out.println(ReservaDTO.desde(sinNoches));
        System.out.println(ReservaDTO.desde(sinPrecioNoche));
        System.out.println(ReservaDTO.desde(null));
    }
}
