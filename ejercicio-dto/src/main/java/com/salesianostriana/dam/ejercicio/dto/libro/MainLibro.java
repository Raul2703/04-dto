package com.salesianostriana.dam.ejercicio.dto.libro;

public class MainLibro {
    public static void main(String[] args) {
        Autor autora = new Autor(1L, "Isabel", "Allende", null, "chilena");
        Libro conAutora = new Libro(1L, "La casa de los espíritus", "978-84-9759-220-8", 1982, 496, autora);
        Libro sinAutor = new Libro(2L, "Libro sin autor", "978-00-0000-000-0", 2025, 120, null);

        System.out.println(LibroDTO.desde(conAutora));
        System.out.println(LibroDTO.desde(sinAutor));
        System.out.println(LibroDTO.desde(null));
    }
}
