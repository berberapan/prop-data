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
}
