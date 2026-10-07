package com.salesianostriana.dam.ejercicio.dto.serie;

public record SerieDTO(String titulo, Integer temporadas, String creador,
                       String categoria, String imagenPrincipal) {

    public static SerieDTO desde(Serie serie) {
        if (serie == null) {
            return new SerieDTO(null, null, null, null, null);
        }

        String nombreCreador = null;
        Creador creador = serie.getCreador();
        if (creador != null) {
            String nombre = creador.getNombre();
            String apellidos = creador.getApellidos();
            if (nombre == null || nombre.isBlank()) nombre = null;
            if (apellidos == null || apellidos.isBlank()) apellidos = null;

            if (nombre != null && apellidos != null) nombreCreador = nombre.trim() + " " + apellidos.trim();
            else if (nombre != null) nombreCreador = nombre.trim();
            else if (apellidos != null) nombreCreador = apellidos.trim();
        }

        String nombreCategoria = null;
        if (serie.getCategoria() != null) {
            nombreCategoria = serie.getCategoria().getNombre();
        }

        String imagenPrincipal = null;
        if (serie.getImagenes() != null && !serie.getImagenes().isEmpty()) {
            imagenPrincipal = serie.getImagenes().get(0);
        }

        return new SerieDTO(serie.getTitulo(), serie.getNumeroTemporadas(),
                nombreCreador, nombreCategoria, imagenPrincipal);
    }
}
