package wordwrap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordWrapperTest {

    @Test
    void emptyText() {
        WordWrapper wrapper = new WordWrapper(20);

        assertEquals("", wrapper.wrap(""));
    }

    @Test
    void wrapLongText(){
        WordWrapper wrapper = new WordWrapper(20);
        assertEquals("Dies ist ein Text,\n" +
            "der umgebrochen\n" +
            "werden soll.", wrapper.wrap("Dies ist ein Text, der umgebrochen werden soll."));

    }

    @Test
    void wrapTextWithSpacesAndLineBreaks(){
        WordWrapper wrapper = new WordWrapper(20);
        assertEquals("Ein kurzer Text mit\n" +
            "nur einem Umbruch", wrapper.wrap("Ein     kurzer\n" +
            " Text mit nur    einem\n" +
            "Umbruch"));

    }


    @Test
    void textWithoutChanges(){
        WordWrapper wrapper = new WordWrapper(20);

        assertEquals("Wie gehts dir?", wrapper.wrap("Wie gehts dir?"));
    }

    @Test
    void textWithChanges(){
        WordWrapper wrapper = new WordWrapper(10);

        assertEquals("Wie gehts\n" + "dir?", wrapper.wrap("Wie gehts dir?"));
    }

    @Test
    void textExactMaxLineLength(){
        WordWrapper wrapper = new WordWrapper(7);
        assertEquals("Exactly", wrapper.wrap("Exactly"));

    }

    @Test
    void removeSpaces(){
        WordWrapper wrapper = new WordWrapper(30);
        assertEquals("Was meinst du damit?", wrapper.wrap("Was    meinst     du      damit?      "));

    }

    @Test
    void removeBreaks() {
        WordWrapper wrapper = new WordWrapper(20);

        assertEquals("Was machst du hier?", wrapper.wrap("Was machst du \nhier?"));
    }
}
