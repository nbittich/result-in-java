public class ErrorHandling {
  sealed interface Result<O,E> permits Ok, Error {}

  final record Ok<O, E>(O result) implements Result<O,E> {}
  final record Error<O,E>(E error) implements Result<O,E> {}

  public static Result<Integer, String> doSomethingIfNotOdd(int number) {
    if(number %2 == 0) {
      return new Ok(number*2);
    }else {
      return new Error("Odd numbers are evil, don't do this");
    }
  }

  public static void main(String...args) {
    var result = doSomethingIfNotOdd(21);

    if(result instanceof Ok<Integer,String>(Integer doubled)) {
      System.out.println("doubled " + doubled);
    } else if(result instanceof Error<Integer,String>(String error)) {
      System.err.println("an error occurred: "+ error);
    }

    switch (doSomethingIfNotOdd(20)) {
        case Ok<Integer,String>(Integer number) -> System.out.printf("new number: %d\n", number);
        case Error<Integer, String>(String message) -> System.err.printf("Err: %s", message);
        default -> System.err.println("wrong");
    }
  }
}
