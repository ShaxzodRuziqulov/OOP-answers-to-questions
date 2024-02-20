package musicPlayer.gpt;
import java.util.ArrayList;
import java.util.List;

// Artist sinfi
class Artist {
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Album sinfi
class Album {
    private String title;
    private Artist artist;
    private List<Song> songs;

    public Album(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }
}

// Song sinfi
class Song {
    private String title;
    private Artist artist;

    public Song(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }
}

// MusicLibrary sinfi
class MusicLibrary {
    private List<Artist> artists;
    private List<Album> albums;

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

public class Main {
    public static void main(String[] args) {
        // Musiqa kutubxonasi yaratish
        MusicLibrary musicLibrary = new MusicLibrary();

        // Artistlar yaratish
        Artist artist1 = new Artist("Artist 1");
        Artist artist2 = new Artist("Artist 2");

        // Albomlar yaratish
        Album album1 = new Album("Album 1", artist1);
        Album album2 = new Album("Album 2", artist2);

        // Qo'shiqlar yaratish
        Song song1 = new Song("Song 1", artist1);
        Song song2 = new Song("Song 2", artist2);

        // Albom va qo'shiqlarni qo'shish
        album1.addSong(song1);
        album2.addSong(song2);

        musicLibrary.addArtist(artist1);
        musicLibrary.addArtist(artist2);
        musicLibrary.addAlbum(album1);
        musicLibrary.addAlbum(album2);

        // Musiqa kutubxonasini chiqarish
        System.out.println("Artists:");
        for (Artist artist : musicLibrary.getArtists()) {
            System.out.println(artist.getName());
        }

        System.out.println("\nAlbums:");
        for (Album album : musicLibrary.getAlbums()) {
            System.out.println(album.getTitle() + " - " + album.getArtist().getName());
            System.out.println("  Songs:");
            for (Song song : album.getSongs()) {
                System.out.println("  - " + song.getTitle() + " by " + song.getArtist().getName());
            }
        }
    }
}

