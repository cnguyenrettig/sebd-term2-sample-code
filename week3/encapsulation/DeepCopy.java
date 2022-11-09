//Add to supporting materials to illustrate deep copy and copy constructor


public class DeepCopy {

    public static void main(String[] args) {
        Shell firstShell;
        Shell secondShell;
        Shell thirdShell;

        firstShell = new Shell(2);
        secondShell = new Shell(3);
        thirdShell = secondShell;

        thirdShell.numOfPearls = 5;

        System.out.println("How many pearls does secondShell have?");

    }
    
}

class Shell{
    int numOfPearls;
    String type;

    public Shell(int numOfPearls){
        this.numOfPearls = numOfPearls;
    }

    public Shell(int numOfPearls, String type){
        this(numOfPearls);
        this.type = type;

    }
}
