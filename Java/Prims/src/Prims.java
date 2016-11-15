import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by withGod on 2016. 11. 14..
 */
public class Prims {
    public static void main(String[] args) throws IOException {
        String[] input = {"AB4","AH8","BH11","BC8","CI2","CD7","CF4","DE9","DF14","EF10","GF2","IG6","HI7","HG1"};
        String[] vertex = {"A","B","C","D","E","F","G","H","I"};
        Graph g = new Graph(vertex,input);
        g.prims("A");
    }
}
