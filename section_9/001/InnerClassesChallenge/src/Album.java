import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String name;
    private String artist;
    private SongList songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songList = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.songList.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, List<Song> playList) {
        Song song = this.songList.findSong(trackNumber);
        if (song == null) {
            return false;
        }

        playList.add(song);
        return true;
    }

    public boolean addToPlayList(String title, List<Song> playList) {
        Song song = this.songList.findSong(title);
        if (song == null) {
            System.out.println("The song " + title + " is not in this album.");
            return false;
        }

        playList.add(song);
        return true;
    }

    private class SongList {
        private List<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song) {
            if (this.songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }
        
        public int size() {
            return this.songs.size();
        }
        
        @Nullable
        public Song findSong(String title) {
            for (Song song: this.songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }
        
        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index < 0 || index > this.songs.size()) {
                System.out.println("This album does not have a track " + (trackNumber + 1));
                return null;
            }

            return this.songs.get(index);
        }
    }
}
