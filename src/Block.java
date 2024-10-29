import java.util.ArrayList;
public abstract class Block {
    protected ArrayList<Block> inputs;
    protected ArrayList<Block> outputs;
    public int ID;
    public String name;
    public int numInputs;

    public int getNumInputs() {
        return numInputs;
    }

    public Block(){
        this.ID = 0;
        this.name = "default";
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addInput(Block b){
        inputs.add(b);
    }

    public void addOutput(Block b){
        outputs.add(b);
    }
    public abstract void setState(boolean state);

    public abstract boolean auswerten();

    public int getID() {
        return ID;
    }

    public Object getName() {
        return name;
    }
    public int getNumberOfInputs(){
        return inputs.size();
    }
}
