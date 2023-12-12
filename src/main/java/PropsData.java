public class PropsData {

    public static void main(String[] args) throws InterruptedException {

        var search = new UserInput();
        var facade = new ApiFacade();

        var ListOfMatches = facade.getMatchHistory(search.getSearchedTeamID(), search.getSearchedFromDate());
        var matches = facade.getIndividualMatches(ListOfMatches);

        System.out.println(matches.getFirst().getObjectives());



    }
}
