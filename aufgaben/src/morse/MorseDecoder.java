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

    }

    public String decode(String code) {

        MorseNode current = root;

        for (int i = 0; i < code.length(); i++) {

            char c = code.charAt(i);

            if (c == '.') {

                current = current.punkt;

            } else if (c == '-') {

                current = current.strich;

            }
        }
        return current.text;
    }
}
