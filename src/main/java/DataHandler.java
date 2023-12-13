import java.util.ArrayList;

public class DataHandler {
    private ArrayList<MatchData> subListA = new ArrayList<>();
    private ArrayList<MatchData> subListB = new ArrayList<>();

    public DataHandler(ArrayList<MatchData> matches, MatchDivideStrategy strategy, String teamID) {
        strategy.sorting(matches, subListA, subListB, teamID);

        if (strategy instanceof BasicStrategy) {
            System.out.println("true");
        } else if (strategy instanceof WinLossStrategy) {
            System.out.println("false");
        } else {
            System.out.println("whatever");
        }
    }

    public void showData() {
        System.out.println();
    }
}
