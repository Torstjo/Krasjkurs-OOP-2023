package EksamensforelesningLF.Misc;

public class finalTest {
    public class Main {
        final int x = 10;
      
        public static void main(String[] args) {
          Main myObj = new Main();
          myObj.x = 25;
          System.out.println(myObj.x);
        }
      }
}
