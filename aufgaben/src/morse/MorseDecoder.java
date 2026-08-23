package morse;

public class MorseDecoder {

    private final MorseNode root;

    public MorseDecoder() {
        root = new MorseNode("");

        // Linke Seite Baum

        root.punkt = new MorseNode("E");

        root.punkt.punkt = new MorseNode("I");
        root.punkt.strich = new MorseNode("A");

        root.punkt.punkt.punkt = new MorseNode("S");
        root.punkt.punkt.strich = new MorseNode("U");
        root.punkt.strich.punkt = new MorseNode("R");
        root.punkt.strich.strich = new MorseNode("W");

        root.punkt.punkt.punkt.punkt = new MorseNode("H");
        root.punkt.punkt.punkt.strich = new MorseNode("V");
        root.punkt.punkt.strich.punkt = new MorseNode("F");
        root.punkt.punkt.strich.strich = new MorseNode("Ü");
        root.punkt.strich.punkt.punkt = new MorseNode("L");
        root.punkt.strich.punkt.strich = new MorseNode("Ä");
        root.punkt.strich.strich.punkt = new MorseNode("P");
        root.punkt.strich.strich.strich = new MorseNode("J");

        root.punkt.punkt.punkt.punkt.punkt = new MorseNode("5");
        root.punkt.punkt.punkt.punkt.strich = new MorseNode("4");
        root.punkt.punkt.punkt.strich.strich = new MorseNode("3");
        root.punkt.punkt.punkt.strich.punkt = new MorseNode("Verstanden");
        root.punkt.punkt.strich.punkt.punkt = new MorseNode("é");
        root.punkt.punkt.strich.strich.punkt = new MorseNode("");
        root.punkt.punkt.strich.strich.strich = new MorseNode("2");
        root.punkt.strich.punkt.strich.punkt = new MorseNode("Ende");
        root.punkt.strich.strich.strich.strich = new MorseNode("1");

        // Rechte seite Baum
        root.strich = new MorseNode("T");

        root.strich.punkt = new MorseNode("N");
        root.strich.strich = new MorseNode("M");

        root.strich.punkt.punkt = new MorseNode("D");
        root.strich.punkt.strich = new MorseNode("K");
        root.strich.strich.punkt = new MorseNode("G");
        root.strich.strich.strich = new MorseNode("O");

        root.strich.punkt.punkt.punkt = new MorseNode("B");
        root.strich.punkt.punkt.strich = new MorseNode("X");
        root.strich.punkt.strich.punkt = new MorseNode("C");
        root.strich.punkt.strich.strich = new MorseNode("Y");
        root.strich.strich.punkt.punkt = new MorseNode("Z");
        root.strich.strich.punkt.strich = new MorseNode("Q");
        root.strich.strich.strich.punkt = new MorseNode("Ö");
        root.strich.strich.strich.strich = new MorseNode("CH");

        root.strich.punkt.punkt.punkt.punkt = new MorseNode("6");
        root.strich.punkt.punkt.punkt.strich = new MorseNode("Abschnitt");
        root.strich.punkt.punkt.strich.punkt = new MorseNode("/");
        root.strich.punkt.strich.strich.punkt = new MorseNode("");
        root.strich.strich.punkt.punkt.punkt = new MorseNode("7");
        root.strich.strich.punkt.punkt.strich = new MorseNode("");
        root.strich.strich.strich.punkt.punkt = new MorseNode("8");
        root.strich.strich.strich.strich.punkt = new MorseNode("9");
        root.strich.strich.strich.strich.strich = new MorseNode("0");

    }

    public String decode(String code) {

        MorseNode current = root;
        String word = "";

        for (int i = 0; i < code.length(); i++) {

            char c = code.charAt(i);

            if (c == '.') {

                current = current.punkt;

            } else if (c == '-') {

                current = current.strich;

            } else if (c == ' ') {

                if (i > 0 && code.charAt(i - 1) == ' ') {
                    word = word + " "; // Abstand zwishen wörtern, wenn zwei leerzeichen
                } else {
                    word = word + current.text; // Wort erstellung fertig und zu word (ergebnis) hinzufügen
                    current = root; // neues Wort starten von root aus
                }
            }
        }


        return word + current.text;
    }
}
