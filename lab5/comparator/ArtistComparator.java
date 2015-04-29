import java.util.Comparator;

public class ArtistComparator implements Comparator<Song> {

    @Override
    public int compare(Song s1, Song s2) {
        String artist1 = s1.getArtist();
        String artist2 = s2.getArtist();

        return artist1.compareTo(artist2);
    }
}
