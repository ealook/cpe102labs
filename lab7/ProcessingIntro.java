import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import processing.core.*;
import java.util.Random;

public class ProcessingIntro extends PApplet
{
    private List<PImage> imgs;
   private int current_image;
   private long next_time;

    private PImage grass;
    private PImage rock;
    private PImage flower;

    private static final int GRASS = 0;
    private static final int ROCK = 1;
    private static final int FLOWER = 2;
    private static final int VISITED = 4;
    private static final int ON_PATH = 5;

    private int dfsing = 0;
    private ArrayList<Point> path;

    private final int BGND_COLOR = color(62, 113, 13);
   private static final int ANIMATION_TIME = 100;

    private Point wyvern_loc = new Point(0, 0);
    private int[][] world = new int[20][15];
    private Random random = new Random();
    private Point goal;

    private boolean gameover;
    private int e_rad;

    private int p1_score = 0;
    private boolean follow_path = false;

    public void setup() {
       size(640, 480);
      background(BGND_COLOR);

      imgs = new ArrayList<PImage>();
      imgs.add(loadImage("wyvern1.png"));
      imgs.add(loadImage("wyvern2.png"));
      imgs.add(loadImage("wyvern3.png"));

       grass = loadImage("grass.png");
       rock = loadImage("rock.png");
       flower = loadImage("flower.png");

      current_image = 0;
      next_time = System.currentTimeMillis() + ANIMATION_TIME;

       reset_scene();
  }

    public void keyPressed()
    {
        if (!gameover) {
            switch (key)
            {
                case 'a':
                    wyvern_loc = check_move(-1, 0, wyvern_loc, world);
                    break;
                case 'd':
                    wyvern_loc = check_move(1, 0, wyvern_loc, world);
                    break;
                case 'w':
                    wyvern_loc = check_move(0, -1, wyvern_loc, world);
                    break;
                case 's':
                    wyvern_loc = check_move(0, 1, wyvern_loc, world);
                    break;
                case ' ':
                    System.out.println("Spacebar pressed " + dfsing);
                    if (dfsing == 0) {
                        dfsing++;
                        path = new ArrayList<>();
                        dfs(wyvern_loc, world, path);
                    } else if (dfsing == 1) {
                        dfsing++;
                        for (Point pt : path) {
                            world[pt.getX()][pt.getY()] = ON_PATH;
                        }
                    } else {
                        follow_path = true;
                    }
                    break;
            }
        }
    }

    public static Point check_move(int dx, int dy, Point wyvern_loc, int[][] world) {
        Point new_pt = new Point(wyvern_loc.getX() + dx, wyvern_loc.getY() + dy);
        if (within_bounds(new_pt) && open(world, new_pt)) {
            wyvern_loc.setX(wyvern_loc.getX() + dx);
            wyvern_loc.setY(wyvern_loc.getY() + dy);
        }
        return wyvern_loc;
    }

    public static boolean within_bounds(Point pt) {
        return pt.getX() >= 0 && pt.getX() < 20 && pt.getY() >= 0 && pt.getY() < 15;
    }

    public static boolean open(int[][] world, Point pt) {
        return world[pt.getX()][pt.getY()] != 1;
    }

   private void next_image()
   {
      current_image = (current_image + 1) % imgs.size();
   }

   public void draw()
   {
      // A simplified action scheduling handler
      long time = System.currentTimeMillis();
      if (time >= next_time)
      {
         next_image();
         next_time = time + ANIMATION_TIME;

          if (follow_path) {
              System.out.println("going!");
              Point next = path.get(0);
              Point diff = new Point(next.getX() - wyvern_loc.getX(), next.getY() - wyvern_loc.getY());
              wyvern_loc = check_move(diff.getX(), diff.getY(), wyvern_loc, world);
              path.remove(0);

              if (path.size() == 0) {
                  dfsing = 0;
                  follow_path = false;
              }
          }
      }

       background(BGND_COLOR);

       for (int x = 0; x < 20; x++) {
           for (int y = 0; y < 15; y++) {
               if (world[x][y] == GRASS) {
                   image(grass, x*32, y*32);
               } else if (world[x][y] == ROCK) {
                   image(rock, x*32, y*32);
               } else if (world[x][y] == FLOWER) {
                   image(flower, x*32, y*32);
               } else if (world[x][y] == VISITED) {
                   image(grass, x*32, y*32);
                   fill(0);
                   rect(x*32 + 8, y*32 + 8, 16, 16);
               } else if (world[x][y] == ON_PATH && goal.getX() == x && goal.getY() == y) {
                   image(flower, x*32, y*32);
               } else if (world[x][y] == ON_PATH) {
                   image(grass, x*32, y*32);
                   fill(0);
                   rect(x * 32 + 8, y * 32 + 8, 16, 16);
                   fill(255, 0, 0);
                   rect(x*32 + 12, y*32 + 12, 8, 8);
               }
           }
       }

       fill(0, 0, 255);
       rect(wyvern_loc.getX()*32 + 8, wyvern_loc.getY()*32 + 8, 16, 16);
       image(imgs.get(current_image), wyvern_loc.getX()*32, wyvern_loc.getY()*32);

       if (checkGoal(wyvern_loc, goal)) {
           if (gameover == false) {
               p1_score++;
           }
           gameover = true;
           fill(255, 255, 255);
           ellipse(goal.getX() * 32 + 16, goal.getY() * 32 + 16, e_rad, e_rad);
           if (e_rad < 1500) {
               e_rad = (int) (e_rad *1.05 + 1);
           } else {
               reset_scene();
           }
       }

       draw_scores();
   }

    public static boolean checkGoal(Point wyvern_loc, Point goal) {
        return wyvern_loc.getX() == goal.getX() && wyvern_loc.getY() == goal.getY();
    }

    public void reset_scene() {
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {
                world[x][y] = GRASS;
            }
        }

        for (int i = 0; i < 60; i++) {
            int x = random.nextInt(20);
            int y = random.nextInt(15);
            world[x][y] = ROCK;
        }

        goal = new Point(random.nextInt(20), random.nextInt(15));
        world[goal.getX()][goal.getY()] = FLOWER;

        world[wyvern_loc.getX()][wyvern_loc.getY()] = 0;

        gameover = false;
        e_rad = 0;
    }

    public void draw_scores() {
        textSize(32);
        fill(0, 0, 0);
        text(p1_score, 10, 32);
    }

    public static boolean dfs(Point pt, int[][] grid, List<Point> path) {
        int GOAL = 2;
        int OBSTACLE = 1;
        int VISITED = 4;

        if (!(pt.getX() >= 0 && pt.getX() < grid.length && pt.getY() >= 0 && pt.getY() < grid[pt.getX()].length)) {
            return false;
        }
        if (grid[pt.getX()][pt.getY()] == GOAL) {
            path.add(0, pt);
            return true;
        }
        if (grid[pt.getX()][pt.getY()] == OBSTACLE) {
            return false;
        }
        if (grid[pt.getX()][pt.getY()] == VISITED) {
            return false;
        }

        grid[pt.getX()][pt.getY()] = VISITED;

        boolean found = dfs(new Point(pt.getX() + 1, pt.getY()), grid, path) ||
                dfs(new Point(pt.getX() - 1, pt.getY()), grid, path) ||
                dfs(new Point(pt.getX(), pt.getY() - 1), grid, path) ||
                dfs(new Point(pt.getX(), pt.getY() + 1), grid, path);

        if (found) {
            path.add(0, pt);
        }

        return found;
    }

   public static void main(String[] args)
   {
      PApplet.main("ProcessingIntro");
   }
}
