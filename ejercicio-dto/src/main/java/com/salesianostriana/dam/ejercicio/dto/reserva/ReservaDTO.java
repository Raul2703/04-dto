package com.salesianostriana.dam.ejercicio.dto.reserva;

public record ReservaDTO(String codigo, String cliente, String habitacion,
                         Integer numeroNoches, Double precioTotal) {

    public static ReservaDTO desde(Reserva reserva) {
        if (reserva == null) {
            return new ReservaDTO(null, null, null, null, null);
        }

        String nombreCliente = null;
        Cliente cliente = reserva.getCliente();
        if (cliente != null) {
            String nombre = cliente.getNombre();
            String apellidos = cliente.getApellidos();
            if (nombre == null || nombre.isBlank()) nombre = null;
            if (apellidos == null || apellidos.isBlank()) apellidos = null;

            if (nombre != null && apellidos != null) nombreCliente = nombre.trim() + " " + apellidos.trim();
            else if (nombre != null) nombreCliente = nombre.trim();
            else if (apellidos != null) nombreCliente = apellidos.trim();
        }

        String descripcionHabitacion = null;
        Habitacion habitacion = reserva.getHabitacion();
        if (habitacion != null) {
            String numero = habitacion.getNumero();
            String tipo = habitacion.getTipo();
            if (numero != null && !numero.isBlank() && tipo != null && !tipo.isBlank()) {
                descripcionHabitacion = numero.trim() + " - " + tipo.trim();
            } else if (numero != null && !numero.isBlank()) {
                descripcionHabitacion = numero.trim();
            } else if (tipo != null && !tipo.isBlank()) {
                descripcionHabitacion = tipo.trim();
            }
        }

        Integer noches = reserva.getNumeroNoches();
        Double precioTotal = null;
        if (noches != null && habitacion != null && habitacion.getPrecioNoche() != null) {
            precioTotal = noches * habitacion.getPrecioNoche();
        }

        return new ReservaDTO(reserva.getCodigo(), nombreCliente, descripcionHabitacion, noches, precioTotal);
    }
}
