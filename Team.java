package GenericsChallenge;


public abstract class Team implements Comparable<Team> {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;


    public Team(String name) {
        this.name = name;
    }


    public Team(String name, int played, int won, int lost, int tied) {
        this.name = name;
        this.played = played;
        this.won = won;
        this.lost = lost;
        this.tied = tied;
    }


    public String getName() {
        return name;
    }


    public void gameResult(Team opponent, int ourScore, int opponentScore){

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


    public int compareTo(Team opponent) {

        if(this.ranking() > opponent.ranking()){
            return -1;
        }else if(this.ranking() < opponent.ranking()){
            return 1;
        }else{
            return 0;
        }
    }


    public String toString(){

        return "\nTeam: " + this.name +
                "\nRanking: " + this.ranking() +
                "\n\nGames Played: " + this.played +
                "\nRecord: " + this.won + " - " + this.lost + " - " + this.tied + "\n\n";
    }


    public abstract int ranking();
}
