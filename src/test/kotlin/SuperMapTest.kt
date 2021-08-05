import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlinx.coroutines.*

internal class SuperMapTest {


    @Test
    fun testGetShouldReturnValue() {

        val testSuperMap = SuperMap<String, String>()

        testSuperMap.set("h", "Hello")
        testSuperMap.set("w", "World")

        assertEquals("Hello", testSuperMap.get("h"))
        assertEquals("World", testSuperMap.get("w"))
    }

    @Test
    fun testGetNotFoundValueShouldReturnNull() {

        val testSuperMap = SuperMap<String, String>()

        assertEquals(null, testSuperMap.get("bt"));
    }

    @Test
    fun testRemoveShouldRemoveItem() {

        val testSuperMap = SuperMap<String, String>()

        testSuperMap.set("h", "Hello")
        testSuperMap.set("w", "World")

        assertEquals("Hello", testSuperMap.get("h"))
        assertEquals("World", testSuperMap.get("w"))

        val removedItem = testSuperMap.remove("h");

        assertEquals("Hello", removedItem)

        assertEquals(null, testSuperMap.get("h"))

    }


    @Volatile var m: Int = 1;
    @Test
    fun testSuperMapShouldBeThreadSafe() = runBlocking  {

            val testSuperMap = SuperMap<String, String>()

            val scope = CoroutineScope(newFixedThreadPoolContext(4, ""))
            scope.launch {

                val coroutines = 1.rangeTo(10).map {

                    launch {

                        for (i in 1..4) {
                            testSuperMap.set("h${m}", "Hello${m}")
                            m++
                        }

                    }
                }

                coroutines.forEach {
                        corotuine->
                    corotuine.join()
                }
            }.join()

        assertEquals("Hello4", testSuperMap.get("h4"));

        assertEquals("Hello10", testSuperMap.get("h10"));

        assertEquals("Hello12", testSuperMap.get("h12"));

        assertEquals("Hello40", testSuperMap.get("h40"));

        assertNotNull(testSuperMap.get("h40"));

    }


}