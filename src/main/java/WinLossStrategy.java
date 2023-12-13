import java.util.ArrayList;

public class WinLossStrategy implements MatchDivideStrategy {

    @Override
    public void sorting(ArrayList<MatchData> matches,
                        ArrayList<MatchData> wins,
                        ArrayList<MatchData> losses,
                        String teamID) {

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
}
