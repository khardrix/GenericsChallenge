package GenericsChallenge;


// IMPORTS of needed tools and plug-ins
import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> implements Comparable<League<T>> {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> leagueTable = new ArrayList<>();


    public League(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public boolean addTeam(T team){

        if(leagueTable.contains(team)){
            System.out.println(team.getName() + " is already a part of this league table.");
            return false;
        }else{
            leagueTable.add(team);
            System.out.println(team.getName() + " has been added to the league table named " + this.name);
            return true;
        }
    }


    public int getNumberOnRoster(){
        return this.leagueTable.size();
    }


    public void gameResult(League<T> opponent, int ourScore, int opponentScore){

        String message;
        if(ourScore > opponentScore){
            won++;
            message = " beat ";
        }else if(ourScore == opponentScore){
            tied++;
            message = " tied with ";
        }else{
            lost++;
            message = " lost to ";
        }

        played++;
        if(opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.gameResult(null, opponentScore, ourScore);
        }
    }


    public int ranking(){
        return (((4 * won) + tied) - (2 * lost));
    }


    @Override
    public int compareTo(League<T> opponent) {
        if(this.ranking() > opponent.ranking()){
            return -1;
        }else if(this.ranking() < opponent.ranking()){
            return 1;
        }else{
            return 0;
        }
    }


    public void printOrderedTeams(ArrayList<T> teams){

        Collections.sort(teams);
    }
}
