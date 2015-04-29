import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   @Test
   public void testArtistComparator()
   {
      Comparator<Song> comp = new ArtistComparator();

      assertTrue(comp.compare(songs[0], songs[1]) < 0);
      assertTrue(comp.compare(songs[0], songs[0]) == 0);
      assertTrue(comp.compare(songs[1], songs[0]) > 0);
   }

   @Test
   public void testLambdaTitleComparator()
   {
      Comparator<Song> comp = (Song s1, Song s2) -> {
         String artist1 = s1.getArtist();
         String artist2 = s2.getArtist();

         return artist1.compareTo(artist2);
      };

      assertTrue(comp.compare(songs[0], songs[1]) < 0);
      assertTrue(comp.compare(songs[0], songs[0]) == 0);
      assertTrue(comp.compare(songs[1], songs[0]) > 0);
   }

   @Test
   public void testComposedComparator()
   {
      Comparator<Song> compArtist = (Song s1, Song s2) -> {
         String artist1 = s1.getArtist();
         String artist2 = s2.getArtist();

         return artist1.compareTo(artist2);
      };

      Comparator<Song> compTitle = (Song s1, Song s2) -> {
         String title1 = s1.getTitle();
         String title2 = s2.getTitle();

         return title1.compareTo(title2);
      };

      Comparator<Song> comp = new ComposedComparator(compTitle, compArtist);

      assertTrue(comp.compare(songs[0], songs[1]) > 0);
      assertTrue(comp.compare(songs[0], songs[0]) == 0);
      assertTrue(comp.compare(songs[3], songs[5]) > 0);
   }

   @Test
   public void testThenComparing()
   {
      Comparator<Song> compTitle = (Song s1, Song s2) -> {
         String title1 = s1.getTitle();
         String title2 = s2.getTitle();

         return title1.compareTo(title2);
      };

      Comparator<Song> compArtist = (Song s1, Song s2) -> {
         String artist1 = s1.getArtist();
         String artist2 = s2.getArtist();

         return artist1.compareTo(artist2);
      };

      compTitle = compTitle.thenComparing(compArtist);

      assertTrue(compTitle.compare(songs[0], songs[1]) > 0);
      assertTrue(compTitle.compare(songs[0], songs[0]) == 0);
      assertTrue(compTitle.compare(songs[3], songs[5]) > 0);
   }

   @Test
   public void runSort()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      Comparator<Song> comp = (Song s1, Song s2) -> {
         String artist1 = s1.getArtist();
         String artist2 = s2.getArtist();

         return artist1.compareTo(artist2);
      };

      comp = comp.thenComparing((Song s1, Song s2) -> {
            String title1 = s1.getTitle();
            String title2 = s2.getTitle();

            return title1.compareTo(title2);
         }
      );

      comp = comp.thenComparing((Song s1, Song s2) -> {
                 Integer year1 = s1.getYear();
                 Integer year2 = s2.getYear();

                 return year1 - year2;
              }
      );

      songList.sort(
         comp
      );
      printList(songList);
   }

   private static void printList(List<Song> songList)
   {
      int i = 0;
      for (Song song : songList)
      {
         System.out.println(i + ": " + song);
         i++;
      }
   }
}
