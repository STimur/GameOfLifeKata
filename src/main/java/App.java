import java.io.IOException;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        World world = new World("*.**.\n...**\n**.*.\n..*.*\n**.*.");
        System.out.println(world.toString());
        System.out.println();
        while (true) {
            Thread.sleep(1000);
            System.out.println(world.nextGeneration().toString());
            System.out.println();
        }
    }
}
