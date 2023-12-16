import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class UserInput {
    private final String searchedTeamID;
    private long searchedFromDate;
    private final int selection;

    public UserInput() {
        var scanner = new Scanner(System.in);

        System.out.print("""
                
                Put in the Team ID for the team you want to see stats for. E.g. 2163 for Team Liquid.
                Just put in the numbers and press Enter:
                """);
        this.searchedTeamID = scanner.nextLine();

        System.out.print("""
                
                Note that the further back you go the more time the search will take as API calls are restricted.
                Put in what date you want to search FROM. Please add in following format DD/MM/YYYY:
                """);
        convertDateToUnix(scanner.nextLine());

        System.out.print("""
                
                Enter 1 if you want just the stats without breakdown.
                Enter 2 if you want stats and stats for in wins and losses.
                Enter 3 if you want stats and stats for radiant vs dire.
                """);
        this.selection = scanner.nextInt();
        if (selection > 3 || selection < 1) {
            System.out.println("Not a valid option selected. Try again");
            System.exit(0);
        }
    }

    private void convertDateToUnix(String input) {
        var date = input.split("/");
        try {
            var calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(date[2]), Integer.parseInt(date[1])-1, Integer.parseInt(date[0]),
                    0,0,0);
            Date inputDate = calendar.getTime();
            this.searchedFromDate = inputDate.toInstant().getEpochSecond();
        } catch (Exception e) {
            System.out.println("Date given in wrong format. Try again.");
        }
    }

    public String getSearchedTeamID() {
        return searchedTeamID;
    }

    public long getSearchedFromDate() {
        return searchedFromDate;
    }

    public int getSelection() {
        return selection;
    }
}
