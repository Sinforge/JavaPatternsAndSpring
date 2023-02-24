package Practice6.Prototype;

public abstract class Tree {
    String TreeName;

    public Tree(String TreeName) {
        this.TreeName = TreeName;
    }

    public abstract Tree clone();
    
}
