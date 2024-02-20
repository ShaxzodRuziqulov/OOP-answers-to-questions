package musicPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

record Artist(String name) {
}

record Song(String title, Artist artist) {
}

class MusicLibrary {
    private final List<Artist> artists;
    private final List<Album> albums;

    public MusicLibrary() {
        this.artists = new ArrayList<>();
        this.albums = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}

class Album {
    private final String title;
    private final Artist artist;
    private final List<Song> songs;

    public Album(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public List<Song> getSongs() {
        return songs;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicLibrary musicLibrary = new MusicLibrary();

        System.out.println("artistni kiriting ");
        String artistSC = scanner.next();
        Artist artist = new Artist(artistSC);

        System.out.println("artistni kiriting ");
        String artistSC1 = scanner.next();
        Artist artist1 = new Artist(artistSC1);

        System.out.println("albomni kiriting ");
        String albumSC = scanner.next();
        Album album = new Album(albumSC, artist);

        System.out.println("albomni kiriting ");
        String albumSC1 = scanner.next();
        Album album2 = new Album(albumSC1, artist1);

        System.out.println("songni kiriting ");
        String songSC = scanner.next();
        Song song = new Song(songSC, artist);

        System.out.println("songni kiriting ");
        String songSC1 = scanner.next();
        Song song1 = new Song(songSC1, artist1);

        album.addSong(song);
        album2.addSong(song1);

        musicLibrary.addAlbum(album);
        musicLibrary.addAlbum(album2);
        musicLibrary.addArtist(artist);
        musicLibrary.addArtist(artist1);

        System.out.println("Artists");
        for (Artist a :
                musicLibrary.getArtists()) {
            System.out.println(a.name());
        }
        System.out.println("\nAlbum");
        for (Album a :
                musicLibrary.getAlbums()) {
            System.out.println(a.getTitle() + " - " + a.getArtist().name());
            System.out.println(" Songs:");
            for (Song s :
                    album.getSongs()) {
                System.out.println(" - " + s.title() + " by " + s.artist().name());
            }
        }
    }
}
