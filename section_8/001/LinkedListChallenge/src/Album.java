import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            return false;
        }

        this.songs.add(new Song(title, duration));
        return true;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if (index < 0 || index > this.songs.size() - 1) {
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }

        playList.add(this.songs.get(index));
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song == null) {
            System.out.println("The song " + title + " is not in this album.");
            return false;
        }

        playList.add(song);
        return true;
    }

    @Nullable
    private Song findSong(String title) {
        for (Song song : this.songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }
}
