public class BilletClass implements BilletInterface {

    // Attribute
    private final String id;
    private final String type;
    private final int pris;
    private final String idStudie;

    // Constructors
    public BilletClass(String id) {
        this.id = id;
        idStudie = "";
        type = "dørsalg";
        pris = 15000;
    }

    public BilletClass(String id, int dageTilEvent) {
        this.id = id;
        idStudie = "";
        type = "forsalg";
        pris = dageTilEvent > 10 ? 10200 : 12000;
    }

    public BilletClass(String id, int dageTilEvent, String idStudie) {
        this.id = id;
        this.idStudie = idStudie;
        type = "studierabat";
        pris = dageTilEvent > 10 ? 7650 : 9000;
    }

    // BilletInterface methods
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getIdStudie() {
        return idStudie;
    }

    @Override
    public String getPris() {

        String s = pris + "";
        String kroner = s.substring(0, s.length() - 2);
        String øre = s.substring(s.length() - 2);

        return STR."DKK \{kroner},\{øre}";
    }

    @Override
    public String getType() {
        return type;
    }

    // Comparable method
    @Override
    public int compareTo(BilletInterface that) {
        return
                this.getId()
                        .compareTo
                                (that.getId());
    }

    // Object method
    @Override
    public String toString() {
        return STR."""
                ---Billet \{type}---
                Billet-ID: \{id}
                Pris: \{getPris()}""" + (idStudie.isEmpty() ? "" : "\n" + STR."""
                Studie-ID: \{idStudie}
                Husk studiekort.""");
    }
}