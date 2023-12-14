import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;

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

    @JsonProperty("game_mode")
    private int gameMode;

    int convertBinaryTower(int total) {
        String binString = Integer.toBinaryString(total);
        String towerPositions = String.format("%11s", binString).replace(" ", "0");
        return towerPositions.length() - towerPositions.replace("0", "").length();
    }
    int convertBinaryBarracks(int total) {
        String binString = Integer.toBinaryString(total);
        String barracksPositions = String.format("%6s", binString).replace(" ", "0");
        return barracksPositions.length() - barracksPositions.replace("0", "").length();
    }
    public String getRadiantTeam() {
        return radiantTeam;
    }
    public boolean isRadiantWin() {
        return radiantWin;
    }
    public int getGameMode() {
        return gameMode;
    }
    public int getTotalTowers() {
        return convertBinaryTower(this.radiantTowers) + convertBinaryTower(direTowers);
    }
    public int getTotalBarracks() {
        return convertBinaryBarracks(this.radiantBarracks) + convertBinaryBarracks(this.direBarracks);
    }
    public int totalKills() {
        return this.radiantKillScore + this.direKillScore;
    }
    public boolean firstTowerRadiant() {
        Iterator<JsonNode> objectiveList = objectives.iterator();
        while (objectiveList.hasNext()) {
            JsonNode objectiveNode = objectiveList.next();
            String type = objectiveNode.path("type").asText();
            String key = objectiveNode.path("key").asText();
            if ("building_kill".equals(type) && key.contains("badguys")) {
                return true;
            }
        } return false;
    }

    public int getTotalRoshan() {
        int total = 0;
        Iterator<JsonNode> objectiveList = objectives.iterator();
        while (objectiveList.hasNext()) {
            JsonNode objectiveNode = objectiveList.next();
            String type = objectiveNode.path("type").asText();
            if ("CHAT_MESSAGE_ROSHAN_KILL".equals(type)) {
                total++;
            }
        }
        return total;
    }
}
