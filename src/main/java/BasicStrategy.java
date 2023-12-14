import java.util.ArrayList;
public class BasicStrategy implements MatchDivideStrategy{
    private String teamID;
    public BasicStrategy(String teamID) {
        this.teamID =teamID;
    }

    @Override
    public void sorting (ArrayList<MatchData> matches,
                        ArrayList<MatchData> matchesToLookAt,
                        ArrayList<MatchData> matchesToIgnore) {

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
        int firstTower = 0;
        int totalRoshan = 0;
        int totalKills = 0;

        for (MatchData match : matchesToCheck) {
            totalTowers += match.getTotalTowers();
            totalBarracks += match.getTotalBarracks();
            totalRoshan += match.getTotalRoshan();
            totalKills += match.totalKills();
            if (match.getRadiantTeam().equals(teamID) && match.firstTowerRadiant()) {
                firstTower++;
            } else if  (!match.getRadiantTeam().equals(teamID) && !match.firstTowerRadiant()) {
                firstTower++;
            }
        }

        System.out.print("\n\nTOTAL");
        System.out.printf("\nNumber of games: %.0f", numberOfMatches);
        System.out.printf("\nTotal Kills Avg: %.2f", totalKills/numberOfMatches);
        System.out.printf("\nTowers Avg: %.2f", totalTowers/numberOfMatches);
        System.out.printf("\nFirst Tower Percent: %.2f%%", firstTower/numberOfMatches * 100);
        System.out.printf("\nBarracks Avg: %.2f", totalBarracks/numberOfMatches);
        System.out.printf("\nRoshan Avg: %.2f\n", totalRoshan/numberOfMatches);
    }
}
