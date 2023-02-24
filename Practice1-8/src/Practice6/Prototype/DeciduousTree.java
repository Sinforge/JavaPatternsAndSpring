package Practice6.Prototype;

public class DeciduousTree extends Tree{

    public DeciduousTree(String TreeName) {
        super(TreeName);
    }

    @Override
    public Tree clone() {

        return new DeciduousTree(this.TreeName);
    }
}
