package GenericsChallenge;


// IMPORTS of needed tools and plug-ins
import java.util.ArrayList;

public class TeamInstructor<T extends PlayerInstructor> implements Comparable<TeamInstructor<T>> {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();


    public TeamInstructor(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public boolean addPlayer(T player){

        if(members.contains(player)){
            System.out.println(player.getName() + " is already on this team");
            return false;
        }else{
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }


    public int numPlayers(){
        return this.members.size();
    }


    public void matchResult(TeamInstructor<T> opponent, int ourScore, int theirScore){

        String message;
        if(ourScore > theirScore){
            won++;
            message = " beat ";
        }else if(ourScore == theirScore){
            tied++;
            message = " drew with ";
        }else{
            lost++;
            message = " lost to ";
        }

        played++;
        if(opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }


    public int ranking(){
        return ((won * 2) + tied);
    }


    @Override
    public int compareTo(TeamInstructor<T> team) {

        if(this.ranking() > team.ranking()){
            return -1;
        } else if(this.ranking() < team.ranking()){
            return 1;
        } else{
            return 0;
        }
    }
}
