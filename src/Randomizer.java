import java.util.Random;

public class Randomizer {
    static private String[] names = {"Cameron Estrada","Daniel Gillis",
            "Edward Conley","Ian Balaguera","Liam O'Connor","S Graber-Adamsons",
            "Ian Richardson","Kameron Miller", "Christopher Zhu"};//,"Evan Kisselev"};
    static private int[] order = new int[names.length];
    static private String[] randomized = new String[names.length];
    static private Random rand = new Random();
    static private int current;

    public Randomizer() {
        int completed = 0;
        while(completed < names.length) {
            boolean set = false;
            int val = rand.nextInt(names.length);
            for(int v=0; v<names.length; v++) {
                if(order[v] == val && v < completed) {
                    set = true;
                }
            }
            if(!set) {
                order[completed] = val;
                completed++;
            }
        }
        for(int i=0; i<names.length; i++) {
            randomized[i] = names[order[i]];
            //System.out.println(order[i]);
        }

        current = 0;
    }

    public String[] nextPair() {
        String target;
        String assassin;
        if(current == names.length - 1) {
            assassin = randomized[current];
            current = 0;
            target = randomized[current];
        } else {
            assassin = randomized[current];
            target = randomized[current + 1];
            current++;
        }
        String[] pair = {assassin, target};
        return pair;
    }

    public int numPlayers() {
        return names.length;
    }
}
