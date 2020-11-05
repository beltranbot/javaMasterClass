package com.beltranbot;

import com.beltranbot.model.Artist;
import com.beltranbot.model.DataSource;
import com.beltranbot.model.SongArtist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artistList = dataSource.queryArtists(DataSource.ORDER_BY_NONE);
        if (artistList == null) {
            System.out.println("No artists!");
            return;
        }

        for (Artist artist : artistList) {
            System.out.println("ID = " + artist.getId() + ", Name = " +
                    artist.getName());
        }

        String artist = "Pink Floyd";
        List<String> albums = dataSource.queryAlbumsForArtist(artist, dataSource.ORDER_BY_ASC);

        System.out.println("******** ALBUMS BY: " + artist + " **************");
        for (String album : albums) {
            System.out.println("album: " + album);
        }

        List<SongArtist> songArtists = dataSource.queryArtistsForSong("Go Your Own Way", DataSource.ORDER_BY_ASC);
        if (songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for (SongArtist songArtist : songArtists) {
            System.out.println("Artist name = " + songArtist.getArtistName() +
                    " Album: " + songArtist.getAlbumName() +
                    " Track: " + songArtist.getTrack());
        }

        dataSource.querySongsMetadata();

        int count = dataSource.getCount(dataSource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        dataSource.createViewForSongArtists();

        songArtists = dataSource.querySongInfoView("She's On Fire");
        if (songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for (SongArtist songArtist : songArtists) {
            System.out.println("Artist name = " + songArtist.getArtistName() +
                    " Album: " + songArtist.getAlbumName() +
                    " Track: " + songArtist.getTrack());
        }

        dataSource.close();
    }

}
