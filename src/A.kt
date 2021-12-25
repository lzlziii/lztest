import java.io.Serializable

class Apple(a: String, b: String, c: Int) : Serializable {
  private val name = a
  private val type = b
  private val num = c

  override fun toString(): String {
    return "Apple(name='$name', type='$type', num=$num)"
  }

}

fun main() {
}

