public class PropsData {

    public static void main(String[] args) {

        var search = new UserInput();
        var facade = new ApiFacade();

        System.out.println(facade.getMatchHistory(search.getSearchedTeamID(), search.getSearchedFromDate()).size());
    }
}
