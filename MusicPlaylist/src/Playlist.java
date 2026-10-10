import java.util.function.Consumer;

public class Playlist {
    private SongNode cabeza;
    private SongNode cola;
    private SongNode current;
    private int size;
    private long nextId = 1;


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public Song currentSong() { return current == null ? null : current.song; }
    public Song nextSong() {
        if (current == null) {
        return null;
        }
        current = current.next;
        return current.song;
        
    }

    public Song prevSong() {
        if (current == null) {
        return null;
        }
        current = current.prev;
        return current.song;
    }
    public Song addcabeza(String titulo, String artista, int duracion){
        SongNode node = new SongNode(new Song(nextId++, titulo, artista, duracion));
        if (isEmpty()) {
            cabeza = cola = current = node;
            node.next = node.prev = node;
    } else {
        node.next = cabeza;
        node.prev = cola;
        cabeza.prev = node;
        cola.next = node;
        cabeza = node;
    }
        size++;
        return node.song;
    }

    public Song addcola(String titulo, String artista, int duracion){
        SongNode node = new SongNode(new Song(nextId++, titulo, artista, duracion));
        if (isEmpty()) {
            cabeza = cola = current = node;
            node.next = node.prev = node;
    } else {
        node.next = cabeza;
        node.prev = cola;
        cabeza.prev = node;
        cola.next = node;
        cola = node;
    }
        size++;
        return node.song;
    }
    private SongNode buscarNode(long id) {
        SongNode node = cabeza;
        for (int i = 0; i < size; i++, node = node.next) {
            if (node.song.getId() == id) {
                return node;
            }
        }
        return null;
    }

    public Song find(long id) {
        SongNode node = buscarNode(id);
        return node == null ? null : node.song;
    }

    public boolean remove(long id) {
    SongNode node = buscarNode(id);
    if (node == null) return false;

    unlink(node);
    return true;
}

    public boolean removeCurrent(){
        if (current == null) return false;
        unlink(current); return true;
    }

    private void unlink(SongNode n){
        if (size == 1) {
            cabeza = cola = current = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            if (n == cabeza) cabeza = n.next;
            if (n == cola) cola = n.prev;
            if (n == current) current = n.next;
        }
        size--;
        n.next = n.prev = null;
    }
    public void forEachForward(Consumer<Song> action) {
        SongNode n = cabeza;
        for (int i = 0; i < size; i++, n = n.next) action.accept(n.song);
    }
    public void forEachBackward(Consumer<Song> action) {
        SongNode n = cola;
        for (int i = 0; i < size; i++, n = n.prev) action.accept(n.song);
    }

    public void play(int k, Consumer<Song> action) {
        if (k <= 0) throw new IllegalArgumentException("valor de k invalido");
        if (isEmpty()) throw new IllegalStateException("la playlist esta vacia");
        for (int i = 0; i < k; i++) { action.accept(current.song); current = current.next; }
    }
}