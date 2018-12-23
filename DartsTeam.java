package GenericsChallenge;


public class DartsTeam extends Team {


    public DartsTeam(String name) {
        super(name);
    }


    public DartsTeam(String name, int played, int won, int lost, int tied) {
        super(name, played, won, lost, tied);
    }


    @Override
    public int ranking() {
        return (((2 * won) + tied) - (2 * lost));
    }
}
