import java.util.*;

public class Main {

    /*
    * create a program that implements a playlist for songs
    * create a song class having title and duration for a song.
    * The program will have an Album class containing a list of songs.
    * The albums will be stored in the ArrayList
    * Songs from different albums can be added to the playlist and will appear in the list in the order
    * they are added.
    * Once the songs have been added to the playlist, create a menu of options to: -
    * Quit, Skip forward to the next song, skip backwards to a previous song. Replay the current song.
    * List the songs in the playlist
    * A song must exists in an album before it can be added to the playlist (so you can only play songs that you own).
    * Hint: to replay a song, consider what happened when we went back and forth from a city before we
    * started tracking the direction we were going.
    * As an option extra, provide an option to remove the current song from the playlist
    * hint: listIterator.remove()
    *  */

    private static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album stormbringer = new Album("Stormbringer", "Deep Purble");
        stormbringer.addSong("Stormbringer", 4.6);
        stormbringer.addSong("Love don't mean anything", 4.2);
        stormbringer.addSong("Holy man", 4.3);
        stormbringer.addSong("Hold on", 5.6);
        stormbringer.addSong("Lady double dealer", 3.21);
        stormbringer.addSong("You can't do it right", 6.23);
        stormbringer.addSong("High ball shooter", 4.27);
        stormbringer.addSong("The gypsy", 4.2);
        stormbringer.addSong("Soldier of fortune", 3.13);

        albums.add(stormbringer);

        Album forThoseAboutToRock = new Album("For those about to rock", "AC/DC");
        forThoseAboutToRock.addSong("For those about to rock", 5.44);
        forThoseAboutToRock.addSong("I put the finger on you", 3.25);
        forThoseAboutToRock.addSong("Let's go", 3.45);
        forThoseAboutToRock.addSong("Inject the venom", 3.33);
        forThoseAboutToRock.addSong("Snowballed", 4.51);
        forThoseAboutToRock.addSong("Evil walks", 3.45);
        forThoseAboutToRock.addSong("C.O.D.", 5.25);
        forThoseAboutToRock.addSong("Breaking the rules", 5.32);
        forThoseAboutToRock.addSong("Night of the long knives", 5.12);

        albums.add(forThoseAboutToRock);

        List<Song> playList = new ArrayList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList); // does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList); // There is no track 24

        play(playList);
    }

    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist.");
            return;
        }

        System.out.println("Now playing: " + listIterator.next());
        printMenu();

        while (!exit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    exit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else {
                        System.out.println("We have reached the end of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list.");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list.");
                        }
                    }

                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                default:
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist.\n"
        );
    }

    private static void printList(List<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===============");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===============");
    }

    /*
    * Modify the Playlist challenge so that the Album class uses an inner class.
    * Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
    * The inner SonList class will use an ArrayList and will provide a method to add a song.
    * It will also provide findSong() methods which will be used by the containing Album class
    * to add songs to the playlist
    * Neither the Song class or the Main class should be changed
    *
    *
    * */
}

