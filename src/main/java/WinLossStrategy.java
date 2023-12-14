import java.util.ArrayList;

public class WinLossStrategy implements MatchDivideStrategy {
    private String teamID;

    public WinLossStrategy(String teamID) {
        this.teamID = teamID;
    }

    @Override
    public void sorting(ArrayList<MatchData> matches,
                        ArrayList<MatchData> wins,
                        ArrayList<MatchData> losses) {

        for (MatchData match : matches) {
            if (match.getGameMode() == 2) {
                if (match.getRadiantTeam().equals(teamID) && match.isRadiantWin()) {
                    wins.add(match);
                } else if (!match.getRadiantTeam().equals(teamID) && !match.isRadiantWin()) {
                    wins.add(match);
                } else {
                    losses.add(match);
                }
            }
        }
    }
    public void showData(ArrayList<MatchData> wins, ArrayList<MatchData> losses) {
        double numberOfWins = wins.size();
        double numberOfLosses = losses.size();
        double numberOfMatches = numberOfWins + numberOfLosses;
        int totalTowersWin = 0;
        int totalTowersLoss = 0;
        int firstTowerWins = 0;
        int firstTowerLoss = 0;
        int totalBarracksWin = 0;
        int totalBarracksLoss = 0;
        int totalRoshanWins = 0;
        int totalRoshanLoss = 0;
        int totalKillsWins = 0;
        int totalKillsLoss = 0;

        for (MatchData match : wins) {
            totalTowersWin += match.getTotalTowers();
            totalBarracksWin += match.getTotalBarracks();
            totalRoshanWins += match.getTotalRoshan();
            totalKillsWins += match.totalKills();
            if (match.getRadiantTeam().equals(teamID) && match.firstTowerRadiant()) {
                firstTowerWins++;
            } else if  (!match.getRadiantTeam().equals(teamID) && !match.firstTowerRadiant()) {
                firstTowerWins++;
            }
        }
        for (MatchData match : losses) {
            totalTowersLoss += match.getTotalTowers();
            totalBarracksLoss += match.getTotalBarracks();
            totalRoshanLoss += match.getTotalRoshan();
            totalKillsLoss += match.totalKills();
            if (match.getRadiantTeam().equals(teamID) && match.firstTowerRadiant()) {
                firstTowerLoss++;
            } else if  (!match.getRadiantTeam().equals(teamID) && !match.firstTowerRadiant()) {
                firstTowerLoss++;
            }
        }
        System.out.print("\n\nTOTAL");
        System.out.printf("\nNumber of games: %.0f", numberOfMatches);
        System.out.printf("\nTotal Kills Avg: %.2f", (totalKillsWins+totalKillsLoss)/numberOfMatches);
        System.out.printf("\nTowers Avg: %.2f", (totalTowersWin+totalTowersLoss)/numberOfMatches);
        System.out.printf("\nFirst Tower Percent: %.2f%%", (firstTowerWins+firstTowerLoss)/numberOfMatches * 100);
        System.out.printf("\nBarracks Avg: %.2f", (totalBarracksWin+totalBarracksLoss)/numberOfMatches);
        System.out.printf("\nRoshan Avg: %.2f\n", (totalRoshanWins+totalRoshanLoss)/numberOfMatches);

        System.out.print("\nWINS");
        System.out.printf("\nNumber of games: %.0f", numberOfWins);
        System.out.printf("\nTotal Kills Avg: %.2f", totalKillsWins/numberOfWins);
        System.out.printf("\nTowers Avg: %.2f", totalTowersWin/numberOfWins);
        System.out.printf("\nFirst Tower Percent: %.2f%%", firstTowerWins/numberOfWins * 100);
        System.out.printf("\nBarracks Avg: %.2f", totalBarracksWin/numberOfWins);
        System.out.printf("\nRoshan Avg: %.2f\n", totalRoshanWins/numberOfWins);

        System.out.print("\nLOSS");
        System.out.printf("\nNumber of games: %.0f", numberOfLosses);
        System.out.printf("\nTotal Kills Avg: %.2f", totalKillsLoss/numberOfLosses);
        System.out.printf("\nTowers Avg: %.2f", totalTowersLoss/numberOfLosses);
        System.out.printf("\nFirst Tower Percent: %.2f%%", firstTowerLoss/numberOfLosses * 100);
        System.out.printf("\nBarracks Avg: %.2f", totalBarracksLoss/numberOfLosses);
        System.out.printf("\nRoshan Avg: %.2f\n", totalRoshanLoss/numberOfLosses);
    }
}
