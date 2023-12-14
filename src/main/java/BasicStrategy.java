import java.util.ArrayList;

public class BasicStrategy implements MatchDivideStrategy{

    @Override
    public void sorting (ArrayList<MatchData> matches,
                        ArrayList<MatchData> matchesToLookAt,
                        ArrayList<MatchData> matchesToIgnore,
                        String teamID) {

        for (MatchData match : matches) {
            if (match.getGameMode() == 2) {
                matchesToLookAt.add(match);
            } else {
                matchesToIgnore.add(match);
            }
        }
    }
    @Override
    public void showData(ArrayList<MatchData> matchesToCheck, ArrayList<MatchData> ignore) {
        double numberOfMatches = matchesToCheck.size();
        int totalTowers = 0;
        int totalBarracks = 0;

        for (MatchData match : matchesToCheck) {
            totalTowers += match.getTotalTowers();
            totalBarracks += match.getTotalBarracks();
        }

        System.out.printf("\nNumber of games: %.0f", numberOfMatches);
        System.out.printf("\nTowers Avg: %.2f", totalTowers/numberOfMatches);
        System.out.printf("\nBarracks Avg: %.2f", totalBarracks/numberOfMatches);
    }
}
