package EksamensforelesningLF.Misc;

public class staticTest {
    
    private static int num; //Static modifikator gjør at alle instanser av denne klassen får samme verdi for num

    public int getNum() {
        return num;
    }

    public void changeNum(int newNum) {
        num = newNum;
    }

    public static void main(String[] args) {
        staticTest object1 = new staticTest();
        staticTest object2 = new staticTest();

        System.out.println("num er i følge object1: "+object1.getNum());
        System.out.println("num er i følge object2: "+object2.getNum());

        object1.changeNum(10);

        System.out.println("Nå er num i følge object 1: "+object1.getNum());
        System.out.println("Nå er num i følge object 2: "+object2.getNum());
    }
}
