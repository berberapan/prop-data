import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchID {
    @JsonProperty("match_id")
    private String matchID;

    @JsonProperty("start_time")
    private long startTime;

    public String getMatch() {
        return this.matchID;
    }

    public long getStartTime() {
        return startTime;
    }
}
