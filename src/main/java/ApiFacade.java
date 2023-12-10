import okhttp3.Request;
import okhttp3.Response;
import okhttp3.OkHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;

public class ApiFacade {
    OkHttpClient httpClient = new OkHttpClient();

    // https://docs.opendota.com/ API documentation.
    // {team_id}/matches needs adding for full call.
    private final String teamAPI  =  "https://api.opendota.com/api/teams/";
    // {match_id} needs adding for full call.
    private final String matchAPI = "https://api.opendota.com/api/matches/";

    public ArrayList<MatchID> getMatchHistory(String teamID, long startTime) {
        ArrayList<MatchID> listOfMatches = new ArrayList<>();
        String call = teamAPI + teamID + "/matches";
        ObjectMapper jsonParser = new ObjectMapper();

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
}
