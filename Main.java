package GenericsChallenge;


public class Main {


    public static void main(String[] args) {

        // ArrayList<League> teams;
        // Collections.sort(teams);

        //////////       Challenge!!!!!!!       //////////
        // Create a generic class to implement a league table for a sport.
        // The class should allow teams to be added to the list, and store
        // a list of teams that belong to the league.
        //
        // Your class should have a method to print out the teams in order,
        // with the team at the top of the league printed first.
        //
        // Only teams of the same type should be added to any particular
        // instance of the league class - the program should fail to compile
        // if an attempt is made to add an incompatible team.

        // MY SOLUTION:
        BeerPongTeam beerPongRyan = new BeerPongTeam("Ryan Beer Pong", 10, 6, 3, 1);
        BeerPongTeam beerPongCarmen = new BeerPongTeam("Carmen Beer Pong", 10, 4, 3, 3);
        BeerPongTeam beerPongBella = new BeerPongTeam("Bella Beer Pong", 10, 8, 1, 1);
        BeerPongTeam beerPongBob = new BeerPongTeam("Bob Beer Pong", 10, 2, 7, 1);

        BilliardsTeam poolTeamRyan = new BilliardsTeam("Ryan Pool", 20, 12, 5, 3);
        BilliardsTeam poolTeamCarmen = new BilliardsTeam("Carmen Pool", 20, 14, 5, 1);
        BilliardsTeam poolTeamBella = new BilliardsTeam("Bella Pool", 20, 19, 0, 1);
        BilliardsTeam poolTeamBob = new BilliardsTeam("Bob Pool", 20, 4, 15, 1);

        DartsTeam dartTeamRyan = new DartsTeam("Ryan Darts", 5, 3, 1, 1);
        DartsTeam dartTeamCarmen = new DartsTeam("Carmen Darts", 4, 3, 0, 1);
        DartsTeam dartTeamBella = new DartsTeam("Bella Darts", 5, 5, 0, 0);
        DartsTeam dartTeamBob = new DartsTeam("Bob Darts", 5, 1, 4, 0);

        League<Team> beerPongLeague = new League<>("Beer Pong Tournament");
        League<Team> billiardsLeague = new League<>("Pool Tournament");
        League<Team> dartsLeague = new League<>("Dart Tournament");

        beerPongLeague.addTeam(beerPongRyan);
        beerPongLeague.addTeam(beerPongCarmen);
        beerPongLeague.addTeam(beerPongBella);
        beerPongLeague.addTeam(beerPongBob);

        billiardsLeague.addTeam(poolTeamRyan);
        billiardsLeague.addTeam(poolTeamCarmen);
        billiardsLeague.addTeam(poolTeamBella);
        billiardsLeague.addTeam(poolTeamBob);

        dartsLeague.addTeam(dartTeamRyan);
        dartsLeague.addTeam(dartTeamCarmen);
        dartsLeague.addTeam(dartTeamBella);
        dartsLeague.addTeam(dartTeamBob);

        System.out.println(beerPongLeague.getNumberOnRoster());
        beerPongLeague.printOrderedTeams();

        System.out.println(billiardsLeague.getNumberOnRoster());
        billiardsLeague.printOrderedTeams();

        System.out.println(dartsLeague.getNumberOnRoster());
        dartsLeague.printOrderedTeams();
    }
}
