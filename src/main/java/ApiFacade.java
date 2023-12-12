import okhttp3.Request;
import okhttp3.Response;
import okhttp3.OkHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import static java.lang.Thread.sleep;

public class ApiFacade {
    private final OkHttpClient httpClient = new OkHttpClient();
    ObjectMapper jsonParser = new ObjectMapper();

    // https://docs.opendota.com/ API documentation.
    // {team_id}/matches needs adding for full call.
    private final String teamAPI  =  "https://api.opendota.com/api/teams/";
    // {match_id} needs adding for full call.
    private final String matchAPI = "https://api.opendota.com/api/matches/";

    public ArrayList<MatchID> getMatchHistory(String teamID, long startTime) {
        ArrayList<MatchID> listOfMatches = new ArrayList<>();
        String call = teamAPI + teamID + "/matches";

        Request request = new Request.Builder().url(call).build();
        try (Response response = httpClient.newCall(request).execute();) {
            assert response.body() != null;
            String matches = response.body().string();
            MatchID[] ids = jsonParser.readValue(matches, MatchID[].class);

            for (MatchID match : ids) {
                if (match.getStartTime() > startTime) {
                    listOfMatches.add(match);
                } else {
                    // Matches are in chronological order
                    // if the match is smaller than the search param it's not within the search period.
                    break;
                }
            }
        } catch (IOException err) {
            err.printStackTrace();
        }
        return listOfMatches;
    }

    public ArrayList<MatchData> getIndividualMatches(ArrayList<MatchID> matchLista) throws InterruptedException {
        ArrayList<MatchData> advancedStatsMatchList = new ArrayList<>();
        int callCounter = 1;
        for (MatchID match : matchLista) {
            // The API got a rate limit for the free version.
            if (callCounter % 30 == 0) {
                Thread.sleep(60000);
            }
            String call = matchAPI + match.getMatch();
            Request request = new Request.Builder().url(call).build();
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                String matchDataResponse = response.body().string();
                MatchData matchData = jsonParser.readValue(matchDataResponse, MatchData.class);
                advancedStatsMatchList.add(matchData);
                callCounter++;
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
        return advancedStatsMatchList;
    }
}
