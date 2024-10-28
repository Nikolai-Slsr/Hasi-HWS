import java.util.ArrayList;
public class Block {
    private ArrayList<Block> inputs;
    private ArrayList<Block> outputs;

    public Block(){
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
    }

    public void setInput(Block b){
        inputs.add(b);
    }

    public void setOutput(Block b){
        outputs.add(b);
    }

    public boolean auswerten(){
        return false;
    }
}
