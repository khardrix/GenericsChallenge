package GenericsChallenge;


public class BeerPongTeam extends Team {


    public BeerPongTeam(String name) {
        super(name);
    }


    public BeerPongTeam(String name, int played, int won, int lost, int tied) {
        super(name, played, won, lost, tied);
    }


    @Override
    public int ranking() {
        return (((2 * won) + tied) - lost);
    }
}
