package com.salesianostriana.dam.ejercicio.dto.libro;

public record LibroDTO(String titulo, String isbn, String autor, Integer anioPublicacion) {

    public static LibroDTO desde(Libro libro) {
        if (libro == null) {
            return new LibroDTO(null, null, null, null);
        }

        String nombreAutor = null;
        Autor autor = libro.getAutor();
        if (autor != null) {
            nombreAutor = autor.getNombre();
            if (nombreAutor == null) nombreAutor = "";

            if (autor.getApellido1() != null && !autor.getApellido1().isBlank()) {
                nombreAutor += " " + autor.getApellido1().trim();
            }
            if (autor.getApellido2() != null && !autor.getApellido2().isBlank()) {
                nombreAutor += " " + autor.getApellido2().trim();
            }

            nombreAutor = nombreAutor.trim();
            if (nombreAutor.isEmpty()) nombreAutor = null;
        }

        return new LibroDTO(libro.getTitulo(), libro.getIsbn(), nombreAutor, libro.getAnioPublicacion());
    }
}
