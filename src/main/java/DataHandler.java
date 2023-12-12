import java.util.ArrayList;

public class DataHandler {
    private ArrayList<String> matches = new ArrayList<>();
    private int strategy;

    public DataHandler(ArrayList<String> matches, int strategy) {
        this.matches = matches;
        this.strategy = strategy;

        switch (strategy) {
            case 1:
                //basic stats
                break;
            case 2:
                //win-loss
                break;
            case 3:
                //radiant-dire
                break;
        }

        showData();
    }

    public void showData() {
        System.out.println();
    }
}
