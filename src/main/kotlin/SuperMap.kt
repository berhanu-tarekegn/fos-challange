
class SuperMap<K, V> {

    @Volatile
    private var map: MutableMap<K, V> = mutableMapOf()

    fun get(key: K) = map.get(key)

    @Synchronized fun set(key: K, value: V) = map.set(key, value)

    fun remove(key: K) = map.remove(key)
}