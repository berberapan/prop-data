import java.util.ArrayList;

public interface MatchDivideStrategy {
    void sorting(ArrayList<MatchData> matchList,
                 ArrayList<MatchData> subListaA,
                 ArrayList<MatchData> subListaB);

    void showData(ArrayList<MatchData> subListA, ArrayList<MatchData> subListB);
}
