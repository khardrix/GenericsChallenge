package GenericsChallenge;


public class BilliardsTeam extends Team {


    public BilliardsTeam(String name) {
        super(name);
    }


    public BilliardsTeam(String name, int played, int won, int lost, int tied) {
        super(name, played, won, lost, tied);
    }


    @Override
    public int ranking() {
        return ((4 * won) + (2 * tied) - lost);
    }
}
