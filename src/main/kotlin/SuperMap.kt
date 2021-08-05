class SuperMap<K, V> {
    private val map: MutableMap<K, V> = mutableMapOf()
    fun get(key: K) = map.get(key)
    fun set(key: K, value: V) = map.set(key, value)
    fun remove(key: K) = map.remove(key)
}