void main() {

    System.out.println("——————————————————————————————————————————————————");

    // Brug et interface til at lave den overordnede Billet-type.
    // Lave en billet på basis af et billet-id man får opgivet.
    BilletInterface billet = new BilletClass("abmy446");

    // Spørge efter en billets pris.
    System.out.println(STR."Prisen er: \{billet.getPris()}");

    System.out.println("——————————————————————————————————————————————————");

    // Kalde toString()-metoden på en meningsfuld måde (så den angiver billettype, billettens id og pris).
    System.out.println(billet);

    System.out.println("——————————————————————————————————————————————————");

    // Lav en klasse der hedder SolgteBilletter som kan indeholde et antal forskellige billetobjekter.
    SolgteBilletter sb = new SolgteBilletter();

    // En metode så man kan tilføje solgte billetter.
    sb.tilføjBillet(new BilletClass("wwr54tf", 5, "dfddfgd"));
    sb.tilføjBillet(new BilletClass("fsdf554fc", 45));
    sb.tilføjBillet(new BilletClass("sdfar4", 5, "1345678954cc"));
    sb.tilføjBillet(new BilletClass("445gdfgg45g"));

    // En toString()-metode til at udskrive alle solgte billetter. Billetterne skal udskrives ordnet efter billet-id
    System.out.println(sb);

    System.out.println("——————————————————————————————————————————————————");

    // En metode der viser hvor mange af hver slags billetter der er solgt.
    System.out.println(sb.antalBilletter());

    System.out.println("——————————————————————————————————————————————————");

    // En metode der hedder hentAlleStudiekortId
    // som returnerer en String med studiekortnummeret på alle de solgte billetter med studierabat.
    // I den String der returneres skal studiekortnumrene være sorteret med det mindste først.
    System.out.println(sb.hentAlleStudiekortId());

    System.out.println("——————————————————————————————————————————————————");
}