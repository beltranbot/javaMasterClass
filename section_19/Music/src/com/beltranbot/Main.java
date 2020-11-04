package com.beltranbot;

import com.beltranbot.model.Artist;
import com.beltranbot.model.DataSource;

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

        dataSource.close();
    }

}
