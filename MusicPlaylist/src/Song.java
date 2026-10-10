public class Song {
    public long id;
    public String titulo;
    public String artista;
    public int duracion;

    public Song(long id, String titulo, String artista, int duracion){
        if (id <= 0) {
            throw new IllegalArgumentException("El id es invalido"); }
        if (titulo == null || titulo.isEmpty()){
            throw new IllegalArgumentException("El titulo es invalido"); }
        if (artista == null || artista.isEmpty()){
            throw new IllegalArgumentException("El artista es invalido"); }
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duracion es invalida"); }
            this.id = id;
            this.titulo = titulo;
            this.artista = artista;
            this.duracion = duracion;
    }
    public long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getArtista() {
        return artista;
    }
    public int getDuracion() {
        return duracion;
    }
    @Override public String toString() {
        return "#" + id + "|" + titulo + "-" + artista + "(" + duracion + "s)";
    }
}