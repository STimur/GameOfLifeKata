public class App {
    public static void main(String[] args) throws InterruptedException {
        Field field = new Field(".....\n..*..\n..*..\n..*..\n.....");
        int i = 0;
        while (true) {
            System.out.println("Generation " + i + ":");
            System.out.println(field);
            System.out.println();
            Thread.sleep(1000);
            field = field.nextGen();
            i++;
        }
    }
}
