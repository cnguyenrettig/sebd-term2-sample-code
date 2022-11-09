//Add to supporting materials to illustrate deep copy and copy constructor

//This is after changes done during topic session to show encapsulation, defensive copying, copy constructors

//Original main code was refactors with the changes


public class DeepCopy {

    public static void main(String[] args) {
        Shell firstShell;
        Shell secondShell;
        Shell thirdShell;

        firstShell = new Shell(2);
        secondShell = new Shell(3);

        //shallow copy
        thirdShell = secondShell; //<-- this causes problems

        //better copy using a copy constructor
        thirdShell = new Shell(secondShell);

        thirdShell.updatePearls(5);

        System.out.println("How many pearls does secondShell have?");
        System.out.println(secondShell.getNumOfPearls());

    }

}

class Category {
    private double price;
    private String color;

    public Category (double price, String color){
        this.price = price;
        this.color = color;
    }
    //methods

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}


class Shell{
    private int numOfPearls;
    private String type;
    private Category pearlCategory;


    public Shell(Shell shell){
        this.numOfPearls = shell.numOfPearls;
        this.type = shell.type;

    }

    public Shell(int numOfPearls){
        this.numOfPearls = numOfPearls;
    }

    //deep copy -
    public Shell(int numOfPearls, String type){
        this(numOfPearls);
        this.type = type;
    }

    //defensive copy
    public Category getPearlCategory(){
        //what if I just return the Category?
        Category copyCategory = new Category(pearlCategory.getPrice(), pearlCategory.getColor());

        return copyCategory;
    }

    public void updatePearls(int numOfPearls){
        //if numOfPearls > 0 and < 10
        if (numOfPearls > 0 && numOfPearls < 10) {
            this.numOfPearls = numOfPearls;
        }
        else {
            throw new IllegalArgumentException("Number of pearls must be between 0 and 10");
        }

    }

    public int getNumOfPearls() {
        return numOfPearls;
    }

    public String getType() {
        return type;
    }

}
