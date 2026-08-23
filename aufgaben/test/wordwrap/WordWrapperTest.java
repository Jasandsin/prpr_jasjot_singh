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
}
