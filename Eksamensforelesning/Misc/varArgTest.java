package Eksamensforelesning.Misc;

public class varArgTest {
    
    private String variableString = "";

    private String getVariableString() {
        return variableString;
    }

    private void addToString(String... strenger) {
        for (String streng : strenger) {
            this.variableString += streng;
        }
    }

    public static void main(String[] args) {
        varArgTest testClass = new varArgTest();

        testClass.addToString("Velkommen ", "til ");

        System.out.println(testClass.getVariableString());
    }
}
