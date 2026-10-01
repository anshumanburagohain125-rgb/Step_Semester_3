import java.util.Arrays;

public final class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        songs = new String[capacity];
    }

    public boolean addSong(String title) {
        if (title == null || title.isBlank() || songCount == songs.length) {
            return false;
        }
        songs[songCount++] = title;
        return true;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");

        String[] copiedSongs = playlist.getSongs();
        copiedSongs[0] = "Hacked";
        System.out.println("Modified copy: " + copiedSongs[0]);
        System.out.println("First stored song: " + playlist.getSongs()[0]);
        System.out.println("Song count: " + playlist.getSongCount());
    }
}