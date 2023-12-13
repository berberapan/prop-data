public class PropsData {

    public static void main(String[] args) throws InterruptedException {

        var search = new UserInput();
        var facade = new ApiFacade();

        var ListOfMatches = facade.getMatchHistory(search.getSearchedTeamID(), search.getSearchedFromDate());
        var matches = facade.getIndividualMatches(ListOfMatches);

        MatchDivideStrategy strategy = switch (search.getSelection()) {
            case 1 -> new BasicStrategy();
            case 2 -> new WinLossStrategy();
            case 3 -> new DireRadiantStrategy();
            default -> throw new IllegalArgumentException("Incorrect values");
        };
        var dataHandler = new DataHandler(matches, strategy, search.getSearchedTeamID());
    }
}
