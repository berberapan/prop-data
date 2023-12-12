import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchData {
    @JsonProperty("radiant_team_id")
    private String radiantTeam;

    @JsonProperty("radiant_win")
    private boolean radiantWin;

    @JsonProperty("radiant_score")
    private int radiantKillScore;

    @JsonProperty("dire_score")
    private int direKillScore;

    @JsonProperty("objectives")
    private JsonNode objectives;

    @JsonProperty("tower_status_radiant")
    private int radiantTowers;

    @JsonProperty("tower_status_dire")
    private int direTowers;

    @JsonProperty("barracks_status_radiant")
    private int radiantBarracks;

    @JsonProperty("barracks_status_dire")
    private int direBarracks;

    public String getRadiantTeam() {
        return radiantTeam;
    }

    public boolean isRadiantWin() {
        return radiantWin;
    }

    public int getRadiantKillScore() {
        return radiantKillScore;
    }

    public int getDireKillScore() {
        return direKillScore;
    }

    public JsonNode getObjectives() {
        return objectives;
    }

    public int getRadiantTowers() {
        return radiantTowers;
    }

    public int getDireTowers() {
        return direTowers;
    }

    public int getRadiantBarracks() {
        return radiantBarracks;
    }

    public int getDireBarracks() {
        return direBarracks;
    }
}
