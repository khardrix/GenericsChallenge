package GenericsChallenge;


// IMPORTS of needed tools and plug-ins
import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    private String name;
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


    public void printOrderedTeams(){

        Collections.sort(this.leagueTable);

        System.out.println(this.leagueTable);
    }
}
