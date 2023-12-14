import java.util.ArrayList;

public class DireRadiantStrategy implements MatchDivideStrategy {
    private String teamID;
    public DireRadiantStrategy (String teamID) {
        this.teamID = teamID;
    }

    @Override
    public void sorting(ArrayList<MatchData> matches,
                        ArrayList<MatchData> dire,
                        ArrayList<MatchData> radiant) {

        for (MatchData match : matches) {
            if (match.getGameMode() == 2) {
                if (match.getRadiantTeam().equals(teamID)) {
                    radiant.add(match);
                } else {
                    dire.add(match);
                }
            }
        }
    }
   public void showData(ArrayList<MatchData> dire, ArrayList<MatchData> radiant) {
        double numberOfDire = dire.size();
        double numberOfRadiant = radiant.size();
        double numberOfMatches = numberOfDire + numberOfRadiant;
        int totalTowersDire = 0;
        int totalTowersRadiant = 0;
        int firstTowerDire = 0;
        int firstTowerRadiant = 0;
        int totalBarracksDire = 0;
        int totalBarracksRadiant = 0;
        int totalRoshanDire = 0;
        int totalRoshanRadiant = 0;
        int totalKillsDire = 0;
        int totalKillsRadiant = 0;

        for (MatchData match : dire) {
            totalTowersDire += match.getTotalTowers();
            totalBarracksDire += match.getTotalBarracks();
            totalRoshanDire += match.getTotalRoshan();
            totalKillsDire += match.totalKills();
            if (match.getRadiantTeam().equals(teamID) && match.firstTowerRadiant()) {
                firstTowerDire++;
            } else if  (!match.getRadiantTeam().equals(teamID) && !match.firstTowerRadiant()) {
                firstTowerDire++;
            }
        }
        for (MatchData match : radiant) {
            totalTowersRadiant += match.getTotalTowers();
            totalBarracksRadiant += match.getTotalBarracks();
            totalRoshanRadiant += match.getTotalRoshan();
             totalKillsRadiant += match.totalKills();
            if (match.getRadiantTeam().equals(teamID) && match.firstTowerRadiant()) {
                firstTowerRadiant++;
            } else if  (!match.getRadiantTeam().equals(teamID) && !match.firstTowerRadiant()) {
                firstTowerRadiant++;
            }
        }
        System.out.print("\n\nTOTAL");
        System.out.printf("\nNumber of games: %.0f", numberOfMatches);
        System.out.printf("\nTotal Kills Avg: %.2f", (totalKillsDire+ totalKillsRadiant)/numberOfMatches);
        System.out.printf("\nTowers Avg: %.2f", (totalTowersDire+totalTowersRadiant)/numberOfMatches);
        System.out.printf("\nFirst Tower Percent: %.2f%%", (firstTowerDire+firstTowerRadiant)/numberOfMatches * 100);
        System.out.printf("\nBarracks Avg: %.2f", (totalBarracksDire+totalBarracksRadiant)/numberOfMatches);
        System.out.printf("\nRoshan Avg: %.2f\n", (totalRoshanDire+totalRoshanRadiant)/numberOfMatches);

        System.out.print("\nDIRE");
        System.out.printf("\nNumber of games: %.0f", numberOfDire);
        System.out.printf("\nTotal Kills Avg: %.2f", totalKillsDire/numberOfDire);
        System.out.printf("\nTowers Avg: %.2f", totalTowersDire/numberOfDire);
        System.out.printf("\nFirst Tower Percent: %.2f%%", firstTowerDire/numberOfDire * 100);
        System.out.printf("\nBarracks Avg: %.2f", totalBarracksDire/numberOfDire);
        System.out.printf("\nRoshan Avg: %.2f\n", totalRoshanDire/numberOfDire);

        System.out.print("\nRADIANT");
        System.out.printf("\nNumber of games: %.0f", numberOfRadiant);
        System.out.printf("\nTotal Kills Avg: %.2f",  totalKillsRadiant/numberOfRadiant);
        System.out.printf("\nTowers Avg: %.2f", totalTowersRadiant/numberOfRadiant);
        System.out.printf("\nFirst Tower Percent: %.2f%%", firstTowerRadiant/numberOfRadiant * 100);
        System.out.printf("\nBarracks Avg: %.2f", totalBarracksRadiant/numberOfRadiant);
        System.out.printf("\nRoshan Avg: %.2f\n", totalRoshanRadiant/numberOfRadiant);
    }
}
