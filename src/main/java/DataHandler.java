import java.util.ArrayList;

public class DataHandler {
    private ArrayList<MatchData> matches = new ArrayList<>();
    private ArrayList<MatchData> subListA = new ArrayList<>();
    private ArrayList<MatchData> subListB = new ArrayList<>();

    public DataHandler(ArrayList<MatchData> matches, MatchDivideStrategy strategy) {
        this.matches = matches;


        showData();
    }

    public void showData() {
        System.out.println();
    }

}
