package Practice6.Prototype;

public class PineTree extends Tree{

    public PineTree(String TreeName) {
        super(TreeName);
    }

    @Override
    public Tree clone() {
        return new PineTree(this.TreeName);
    }
}
