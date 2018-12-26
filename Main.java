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

        System.out.println("\n\nMy Test Cases: \n");

        // MY TEST CASES:
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

        League<BeerPongTeam> beerPongLeague = new League<>("Beer Pong Tournament");
        League<BilliardsTeam> billiardsLeague = new League<>("Pool Tournament");
        League<DartsTeam> dartsLeague = new League<>("Dart Tournament");

        // beerPongLeague.addTeam(poolTeamRyan); <- Correctly gives a compile time error

        System.out.println("Beer Pong Tournament Teams: ");
        beerPongLeague.addTeam(beerPongRyan);
        beerPongLeague.addTeam(beerPongCarmen);
        beerPongLeague.addTeam(beerPongBella);
        beerPongLeague.addTeam(beerPongBob);

        System.out.println("\nBilliards (Pool) Tournament Teams: ");
        billiardsLeague.addTeam(poolTeamRyan);
        billiardsLeague.addTeam(poolTeamCarmen);
        billiardsLeague.addTeam(poolTeamBella);
        billiardsLeague.addTeam(poolTeamBob);

        System.out.println("\nDarts Tournament Teams: ");
        dartsLeague.addTeam(dartTeamRyan);
        dartsLeague.addTeam(dartTeamCarmen);
        dartsLeague.addTeam(dartTeamBella);
        dartsLeague.addTeam(dartTeamBob);

        System.out.println("\nNumber of Beer Pong Teams = " + beerPongLeague.getNumberOnRoster());
        beerPongLeague.printOrderedTeams();

        System.out.println("\nNumber of Billiards (Pool) Tournament Teams = " + billiardsLeague.getNumberOnRoster());
        billiardsLeague.printOrderedTeams();

        System.out.println("\nNumber of Darts Tournament Teams = " + dartsLeague.getNumberOnRoster());
        dartsLeague.printOrderedTeams();


        System.out.println("\n\nInstructor Test Cases: \n");

        // INSTRUCTOR TEST CASES:
        LeagueInstructor<TeamInstructor<FootballPlayerInstructor>> footballLeague =
                new LeagueInstructor<>("AFL");
        TeamInstructor<FootballPlayerInstructor> adelaideCrows = new TeamInstructor<>("Adelaide Crows");
        TeamInstructor<FootballPlayerInstructor> melbourne = new TeamInstructor<>("Melbourne");
        TeamInstructor<FootballPlayerInstructor> hawthorn = new TeamInstructor<>("Hawthorn");
        TeamInstructor<FootballPlayerInstructor> freemantle = new TeamInstructor<>("Freemantle");

        hawthorn.matchResult(freemantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(freemantle, 2, 1);

        footballLeague.add(adelaideCrows);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(freemantle);

        TeamInstructor<BaseballPlayerInstructor> baseballTeam = new TeamInstructor<>("Chicago Cubs");
        // footballLeague.add(baseballTeam); <- Correctly gives a compile time error

        footballLeague.showLeagueTable();



        // RAW TYPE EXAMPLES BY INSTRUCTOR:
        BaseballPlayerInstructor pat = new BaseballPlayerInstructor("Pat");
        SoccerPlayerInstructor beckham = new SoccerPlayerInstructor("Beckham");

        TeamInstructor rawTeam = new TeamInstructor("Raw Team");
        rawTeam.addPlayer(beckham);    // unchecked warning
        rawTeam.addPlayer(pat);        // unchecked warning

        footballLeague.add(rawTeam);   // unchecked warning

        // If we changed the declaration of the LeagueInstructor class to:
            // public class LeagueInstructor<U extends PlayerInstructor, T extends TeamInstructor> {
                // We would have to declare and initialize the below object, "rawLeague," like this:
                // LeagueInstructor<FootballPlayerInstructor, TeamInstructor<FootballPlayerInstructor>> rawLeague =
                // new LeagueInstructor<>("Raw");
                    // This is still not an ideal solution!!!!!!!
        LeagueInstructor<TeamInstructor> rawLeague = new LeagueInstructor<>("Raw");
        rawLeague.add(adelaideCrows);   // no warning
        rawLeague.add(baseballTeam);    // no warning
        rawLeague.add(rawTeam);         // no warning

        LeagueInstructor reallyRaw = new LeagueInstructor("Really Raw");
        reallyRaw.add(adelaideCrows);   // unchecked warning
        reallyRaw.add(baseballTeam);    // unchecked warning
        reallyRaw.add(rawTeam);         // unchecked warning
    }
}
