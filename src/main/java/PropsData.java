import java.util.ArrayList;

public class PropsData {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<MatchData> subListA = new ArrayList<>();
        ArrayList<MatchData> subListB = new ArrayList<>();

        var search = new UserInput();
        var facade = new ApiFacade();

        String teamID = search.getSearchedTeamID();
        long unixDate = search.getSearchedFromDate();

        var ListOfMatches = facade.getMatchHistory(teamID, unixDate);
        var matches = facade.getIndividualMatches(ListOfMatches);

        MatchDivideStrategy strategy = switch (search.getSelection()) {
            case 1 -> new BasicStrategy(teamID);
            case 2 -> new WinLossStrategy(teamID);
            case 3 -> new DireRadiantStrategy(teamID);
            default -> throw new IllegalArgumentException("Incorrect values");
        };

        strategy.sorting(matches, subListA,subListB);
        strategy.showData(subListA, subListB);
    }
}
