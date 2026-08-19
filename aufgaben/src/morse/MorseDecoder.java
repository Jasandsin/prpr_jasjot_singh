package morse;

public class MorseDecoder {

    private final MorseNode root;

    public MorseDecoder() {
        root = new MorseNode("");
        root.punkt = new MorseNode("E");
        root.strich = new MorseNode("T");
    }

    public String decode(String code) {
        // TODO
        return "TODO";
    }
}
