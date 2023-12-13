public class PropsData {

    public static void main(String[] args) throws InterruptedException {

        var search = new UserInput();
        var facade = new ApiFacade();

        var ListOfMatches = facade.getMatchHistory(search.getSearchedTeamID(), search.getSearchedFromDate());
        var matches = facade.getIndividualMatches(ListOfMatches);

        switch (search.getSelection()) {
            case 1:
                var basicStrategy = new BasicStrategy();
                var DataHandler = new DataHandler(matches, basicStrategy);
                break;
            case 2:
                var winLossStrategy = new WinLossStrategy();
                var DataHandler2 = new DataHandler(matches, winLossStrategy);
                break;
            case 3:
                var direRadiantStrategy = new DireRadiantStrategy();
                var DataHandler3 = new DataHandler(matches, direRadiantStrategy);
                break;
        }
    }
}
