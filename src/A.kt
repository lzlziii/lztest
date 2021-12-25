import java.util.*

private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readLong() = readLn().toLong()
private fun readDouble() = readLn().toDouble()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }
private fun readLongs() = readStrings().map { it.toLong() }
private fun readDoubles() = readStrings().map { it.toDouble() }

fun main() {

  var mp = arrayOf(TreeMap<Long, Int>(), TreeMap<Long, Int>())
  var (n, x) = readLongs()
  for (i in 0 until n) {

    var now = mp[i.toInt() and 1]
    var pre = mp[i.toInt() and 1 xor 1]

    if (i == 0L) {

      readLongs().drop(1).forEach {
        mp[0].apply {
          this[it] = this.getOrDefault(it, 0) + 1
        }
      }

    } else {

      now.clear()
      readLongs().drop(1).forEach {
        now.apply {
          pre.forEach { (t, u) ->

            if (it.toDouble() * t.toDouble() <= 2e18) {
              this[it * t] = this.getOrDefault(it * t, 0) + u
            }

          }
        }
      }

    }
  }
  println(mp[(n - 1).toInt() and 1][x] ?: 0)
}