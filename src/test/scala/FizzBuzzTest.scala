import TestConstants.FIZZ_BUZZ_RESULT
import org.scalatest.funsuite.AnyFunSuite
import ru.ifmo.backend_2021.fizzbuzz._

class FizzBuzzTest extends AnyFunSuite {

  def catchOut(action: => Unit): String = {
    import java.io.{ByteArrayOutputStream, PrintStream}
    val newOut = new ByteArrayOutputStream
    System.setOut(new PrintStream(newOut))
    action
    val value = newOut.toString
    newOut.close()
    value
  }

  test("don't handle input") {
    val fizzBuzz = new FizzBuzz()
    val out = catchOut {
      fizzBuzz.flexibleFizzBuzz(s => {})
    }
    assert(out == "")
  }

  test("println") {
    val fizzBuzz = new FizzBuzz()
    val out = catchOut {
      fizzBuzz.flexibleFizzBuzz(s => System.out.print(s + "\n"))
    }
    assert(out == FIZZ_BUZZ_RESULT)
  }
}
