import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompressionDataTest {

    private CompressionData testData;

    @BeforeEach
    void setUp(){
        testData = new CompressionData();
    }

    @AfterEach
    void tearDown() {
        testData = null;
    }

    @Test
    @DisplayName("Testing splitting data to ArrayList")
    void splitData() {
        List<Character> expectedList = Arrays.asList('A', 'A', 'A', 'A', 'A', 'D', 'D', 'D', 'D', 'D', 'E', 'E', 'E', 'F');
        List<Character> actualList = testData.splitData("AAAAADDDDDEEEF");
        assertEquals(expectedList, actualList);
    }

    @Test
    @DisplayName("Testing data compression for basic input")
    void compressDataBasic() {
        assertEquals("A±9B±5C", testData.compressData("AAAAAAAAABBBBBC"));
        assertEquals("H±42F±7E", testData.compressData("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHFFFFFFFE"));
        assertEquals("LE±10N±12A", testData.compressData("LEEEEEEEEEENNNNNNNNNNNNA"));
    }

    @Test
    @DisplayName("Testing data compression for one character")
    void compressDataOneChar() {
        assertEquals("B", testData.compressData("B"));
        assertEquals("&", testData.compressData("&"));
        assertEquals("#", testData.compressData("#"));
    }

    @Test
    @DisplayName("Testing throwing an exception if illegal argument '±' given")
    void testIllegalArgumentExceptionOnWrongParameter() {
        assertThrows(IllegalArgumentException.class, () -> testData.compressData("AAAAA±BBBBBC"));
        assertThrows(IllegalArgumentException.class, () -> testData.compressData("±±AAAAAAADDDX"));
        assertDoesNotThrow(() -> {
            testData.compressData("FFFFFDDDDDX");
        });
    }

    @Test
    @DisplayName("Testing data decompression for basic input")
    void decompressData() {
        assertEquals("DDDDDDDDDDDDDDDDDDDDDDDDSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSX",
                testData.decompressData("D±24S±34X"));
        assertEquals("FOOOOOOOOOOOOOOOOOOLLLLL", testData.decompressData("FO±18L±5"));
        assertEquals("JEEEEEEEEEEEEEEETTTTTTTTTTTTTTTBRRRRRRRRRRRRRRAAAAAAAIIIIINNS",
                testData.decompressData("JE±15T±15BR±14A±7I±5N±2S"));
    }

    @Test
    @DisplayName("Testing throwing an exception if consecutive '±' argument given")
    void testIllegalArgumentExceptionOnConsecutiveParameter() {
        assertThrows(IllegalArgumentException.class, () -> testData.decompressData("D±±24S±34X"));
        assertThrows(IllegalArgumentException.class, () -> testData.decompressData("FO±±18L±5"));
        assertDoesNotThrow(() -> {
            testData.decompressData("FO±18L±5");
        });
    }
}