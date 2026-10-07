package com.salesianostriana.dam.ejercicio.dto.serie;

public class MainSerie {
    public static void main(String[] args) {
        Creador creador = new Creador(1L, "Álex", "Pina", "España");
        Categoria drama = new Categoria(1L, "Drama", "Series dramáticas");
        Serie completa = new Serie(1L, "La casa de papel", "Un atraco", 5, creador, drama,
                java.util.List.of("https://ejemplo.test/portada.jpg", "https://ejemplo.test/segunda.jpg"));
        Serie sinCategoria = new Serie(2L, "Sin categoría", null, 1, creador, null,
                java.util.List.of("https://ejemplo.test/serie.jpg"));
        Serie sinImagenes = new Serie(3L, "Sin imágenes", null, 2, creador, drama, null);
        Serie listaVacia = new Serie(4L, "Lista vacía", null, 2, creador, drama, java.util.List.of());

        System.out.println(SerieDTO.desde(completa));
        System.out.println(SerieDTO.desde(sinCategoria));
        System.out.println(SerieDTO.desde(sinImagenes));
        System.out.println(SerieDTO.desde(listaVacia));
        System.out.println(SerieDTO.desde(null));
    }
}
