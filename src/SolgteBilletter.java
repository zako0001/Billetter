import java.util.*;
import java.util.stream.Collectors;

public class SolgteBilletter {

    // Attribute
    private final SortedSet<BilletInterface> BILLETTER;     // SortedSet er en sorteret samling uden gentagelser.

    // Constructor
    public SolgteBilletter() {
        BILLETTER = new TreeSet<>();                        // SortedSet implementeres her som TreeSet.
    }

    // Methods
    public void tilføjBillet(BilletInterface billet) {
        BILLETTER.add(billet);                              // En ny billet får sin plads efter naturlig sortering.
    }

    public Map<String, Long> antalBilletter() {

        return BILLETTER.stream()                           // Tager billetterne
                .collect(                                   // og samler dem sammen
                        Collectors.groupingBy(              // til et map,
                                BilletInterface::getType,   // hvor key er billettypen
                                Collectors.counting()       // og entry er, hvor mange af den type, der er.
                        )
                );
    }

    public String hentAlleStudiekortId() {

        return BILLETTER.stream()                           // Tager billetterne
                .map(BilletInterface::getIdStudie)          // og reducerer dem til deres studie-ID
                .filter(id -> !id.isEmpty())                // (fjerner billetter, der ikke er studiebilletter)
                .sorted()                                   // i sorteret rækkefølge (String-klassens naturlige orden)
                .collect(Collectors.joining(" & "));        // sat sammen med et og-tegn i mellem.
    }

    // Object method
    @Override
    public String toString() {

        return BILLETTER.stream()                           // Tager billetterne i samlingen (som er sorteret af natur)
                .map(BilletInterface::toString)             // som Strings
                .collect(Collectors.joining("\n\n"));       // sat sammen med to linjeskift i mellem.
    }
}