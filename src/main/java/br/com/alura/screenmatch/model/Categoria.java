package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action","Ação"),
    ROMANCE("Romance","Romance"),
    COMEDIA("Comedy","Comédia"),
    DRAMA("Drama","Drama"),
    CRIME("Crime","Crime"),
    OUTROS("outros","outros");

    private String categoriaOmdb;
    private String fromPortugues;

    Categoria(String categoriaOmdb,String fromPortugues) {

        this.categoriaOmdb = categoriaOmdb;
        this.fromPortugues = fromPortugues;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        return Categoria.OUTROS;
    }

    public static Categoria fromPortugues(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.fromPortugues.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        return Categoria.OUTROS;
    };
}
