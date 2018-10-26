public class Driver {

    public static void main(String[] args) throws Exception {
        Randomizer order = new Randomizer();

        for(int i=0; i<order.numPlayers(); i++) {
            String[] nextPair = order.nextPair();
            Send.Email(nextPair[0],nextPair[1]);
        }
    }
}
