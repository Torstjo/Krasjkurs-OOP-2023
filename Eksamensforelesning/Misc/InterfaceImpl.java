package Eksamensforelesning.Misc;

public class InterfaceImpl implements InterfaceTest {

    @Override
    public void testFunction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'testFunction'");
    }
    
    public static void main(String[] args) {
        InterfaceTest test = new InterfaceImpl();
    }
}
