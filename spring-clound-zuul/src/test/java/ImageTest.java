import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

public class ImageTest {

  private static Person person = new Person("1");

  public static void main(String[] args) {
    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          try {
            Thread.sleep(1000);
            System.out.println(person.getName());
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    Thread thread2 = new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        Thread.sleep(2000);
        person.setName("2");
      }
    });

    thread1.start();
    thread2.start();
  }
}


@Data
@AllArgsConstructor
class Person {

  private String name;
}
