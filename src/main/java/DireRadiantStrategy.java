import java.util.ArrayList;

public class DireRadiantStrategy implements MatchDivideStrategy {

    @Override
    public void sorting(ArrayList<MatchData> matches,
                        ArrayList<MatchData> dire,
                        ArrayList<MatchData> radiant,
                        String teamID) {

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
        System.out.println("PLACEHOLDER");
    }
}
