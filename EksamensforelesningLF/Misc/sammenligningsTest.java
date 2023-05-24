package EksamensforelesningLF.Misc;

public class sammenligningsTest {
    public static void main(String[] args) {

        String streng1 = new String("Hei");
        String streng2 = new String("Hei");

        System.out.println(streng1 == streng2);
        System.out.println(streng1.equals(streng2));
    }
}
