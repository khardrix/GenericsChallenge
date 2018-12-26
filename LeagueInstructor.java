package GenericsChallenge;


// IMPORTS of needed tools and plug-ins
import java.util.ArrayList;
import java.util.Collections;

// To help prevent "raw type" declaration in the Main class, we could declare this class as:
    // public class LeagueInstructor<U extends PlayerInstructor, T extends TeamInstructor> {
        // However, this is NOT an ideal solution!!!!!!!
public class LeagueInstructor<T extends TeamInstructor> {

    public String name;
    private ArrayList<T> league = new ArrayList<>();


    public LeagueInstructor(String name) {
        this.name = name;
    }


    public boolean add(T team){

        if(league.contains(team)){
            return false;
        }else{
            league.add(team);
            return true;
        }
    }


    public void showLeagueTable(){
        Collections.sort(league);
        for(T t : league){
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
