import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SuperMapTest {

    private val testSuperMap = SuperMap<String, String>()

    @Test
    fun testGetValueShouldReturnString() {

        testSuperMap.set("h", "Hello")
        testSuperMap.set("w", "World")

        assertEquals("Hello", testSuperMap.get("h"))
        assertEquals("World", testSuperMap.get("w"))
    }

    @Test
    fun testGetNotFoundValueShouldReturnNull() {

        assertEquals(null, testSuperMap.get("bt"));
    }


}