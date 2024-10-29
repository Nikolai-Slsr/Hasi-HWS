import java.util.*;
public class Main {
    private ArrayList<Block> inputs;
    private ArrayList<Block> outputs;
    private ArrayList<Block> blocks;
    private int ID = 0;

    public Main(){
        this.inputs = new ArrayList<Block>();
        this.outputs = new ArrayList<Block>();
        this.blocks = new ArrayList<Block>();
    }


    public static void main(String[] args){
        Main main = new Main();
        CommandLineInterface cli = new CommandLineInterface(main);
        cli.start();
    }
    public void run(){
        if (outputs.isEmpty()){
            System.out.println("Cant run: No outputs");
            return;
        }
        try {
            for (Block output : outputs) {
                System.out.println("Output: " + output.getName() + " state: " + output.auswerten());
            }
        }
        catch (Exception e){
            System.out.println("Cant run: Error: '" + e.getMessage() + "'\n" + "This is likely due to bad connections");
        }
    }
    public void addInput(Block b){
        inputs.add(b);
    }
    public void addBlock(Block b){
        blocks.add(b);
    }
    public void addOutput(Block b){
        outputs.add(b);
    }
    public void rmInput(Block b){
        inputs.remove(b);
    }
    public void rmBlock(Block b){
        blocks.remove(b);
    }
    public void rmOutput(Block b){
        outputs.remove(b);
    }
    public void setStateInput(Block b, boolean state){
        b.setState(state);
    }
    public void addConnection(Block b, Block input){
        b.addInput(input);
    }
    public Block getBlock(int ID){
        for (Block block : blocks) {
            if(block.getID() == ID){
                return block;
            }
        }
        for (Block block : inputs) {
            if(block.getID() == ID){
                return block;
            }
        }
        for (Block block : outputs) {
            if(block.getID() == ID){
                return block;
            }
        }
        return null;
    }
    public int getNewID(){
        ID++;
        return ID;
    }
    public int getIDFromName(String name){
        for (Block block : blocks) {
            if(block.getName().equals(name)){
                return block.getID();
            }
        }
        for (Block block : inputs) {
            if(block.getName().equals(name)){
                return block.getID();
            }
        }
        for (Block block : outputs) {
            if(block.getName().equals(name)){
                return block.getID();
            }
        }
        return -1;
    }
    public void clear(){
        inputs.clear();
        outputs.clear();
        blocks.clear();
        ID = 0;
    }

    public ArrayList<Block> getInputs() {
        return inputs;
    }

    public ArrayList<Block> getOutputs() {
        return outputs;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
}
