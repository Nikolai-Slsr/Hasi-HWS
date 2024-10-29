import java.util.*;
public class CommandLineInterface {
    Main main;
    public CommandLineInterface(Main main) {
        this.main = main;
    }

    public void start(){
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while(running){
            String Input = input.nextLine();
            String[] parts = Input.split(" ");
            String command = parts[0];
            parts = Arrays.copyOfRange(parts, 1, parts.length);
            switch (command) {
                case "exit":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                case "run":
                    run(parts,main);
                    break;
                case "add":
                    add(parts,main);
                    break;
                case "rm":
                    rm(parts,main);
                    break;
                case "setInput":
                    setStateInput(parts,main);
                    break;
                case "help":
                    help();
                    break;
                case "clear":
                    clear();
                    break;
                case "list":
                    list(parts,main);
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }


        }

    }
    private void run(String[] parts, Main main){
        main.run();
    }
    private void add(String[] argsIn, Main main){
        String[] args = argsIn;
        String command = args[0];
        args = Arrays.copyOfRange(args, 1, args.length);
        switch (command) {
            case "input":
                Block newInput = new Input();
                newInput.setName(args[0]);
                newInput.setID(main.getNewID());
                main.addInput(newInput);
                System.out.println("Added input: " + newInput.getName() + " with ID: " + newInput.getID());
                break;
            case "output":
                Block newOutput = new Output();
                newOutput.setName(args[0]);
                newOutput.setID(main.getNewID());
                main.addOutput(newOutput);
                System.out.println("Added output: " + newOutput.getName() + " with ID: " + newOutput.getID());
                break;
            case "block":
                command = args[0];
                args = Arrays.copyOfRange(args, 1, args.length);
                switch (command) {
                    case "and":
                        Block newAnd = new AND();
                        newAnd.setName(args[0]);
                        newAnd.setID(main.getNewID());
                        main.addBlock(newAnd);
                        System.out.println("Added block: " + newAnd.getName() + " with ID: " + newAnd.getID());
                        break;
                    case "or":
                        Block newOr = new OR();
                        newOr.setName(args[0]);
                        newOr.setID(main.getNewID());
                        main.addBlock(newOr);
                        System.out.println("Added block: " + newOr.getName() + " with ID: " + newOr.getID());
                        break;
                    case "not":
                        Block newNot = new NOT();
                        newNot.setName(args[0]);
                        newNot.setID(main.getNewID());
                        main.addBlock(newNot);
                        System.out.println("Added block: " + newNot.getName() + " with ID: " + newNot.getID());
                        break;
                    case "xor":
                        Block newXor = new XOR();
                        newXor.setName(args[0]);
                        newXor.setID(main.getNewID());
                        main.addBlock(newXor);
                        System.out.println("Added block: " + newXor.getName() + " with ID: " + newXor.getID());
                        break;
                    default:
                        System.out.println("Unknown command for block: " + command);
                        break;
                }
                break;
            case "connection":
                if (main.getIDFromName(args[1]) == -1 || main.getIDFromName(args[0]) == -1) {
                    System.out.println("Could not find block with name: " + args[0] + " or " + args[1]);
                    return;
                }
                    Block blockTo = main.getBlock(main.getIDFromName(args[0]));
                    Block blockFrom = main.getBlock(main.getIDFromName(args[1]));

                if (blockTo.getNumberOfInputs() + 1 <= blockTo.getNumInputs()){
                    try {
                        main.addConnection(blockTo, blockFrom);
                        System.out.println("Added connection from " + args[0] + " to " + args[1]);
                    }
                    catch (Exception e){
                        System.out.println("Could not add connection: " + e.getMessage());
                    }
                }
                else{
                    System.out.println("Cant add connection: " + blockTo.getName() + " cant have more than " + blockTo.getNumInputs() + " inputs");
                }

                break;
            default:
                System.out.println("Unknown argument for command add: " + command);
        }
    }
    private void rm(String[] parts, Main main){

    }
    private void setStateInput(String[] argsIn, Main main){
        String[] args = argsIn;
        String inputName = args[0];
        args = Arrays.copyOfRange(args, 1, args.length);
        try {
            main.setStateInput(main.getBlock(main.getIDFromName(inputName)), Boolean.parseBoolean(args[0]));
            System.out.println("Set state of input " + inputName + " to " + args[0]);
        }
        catch (Exception e){
            System.out.println("Could not set state: " + e.getMessage());
        }
    }
    private void help(){
        System.out.println("Commands:");
        System.out.println("add: adds a block, input, or output");
        System.out.println("  Usage: add <type> <name>");
        System.out.println("  Example: add block MyBlock, add input MyInput, add output MyOutput");
        System.out.println("clear: clears all blocks, inputs, and outputs");
        System.out.println("exit: exits the program");
        System.out.println("help: prints this message");
        System.out.println("rm: removes a block, input, or output");
        System.out.println("  Usage: rm <type> <name>");
        System.out.println("  Example: rm block MyBlock, rm input MyInput, rm output MyOutput");
        System.out.println("run: runs the program");
        System.out.println("setStateInput: sets the state of an input");
        System.out.println("  Usage: setStateInput <inputName> <state>");
        System.out.println("  Example: setStateInput MyInput true, setStateInput MyInput false");
    }
    private void clear(){
        main.clear();
        System.out.println("Cleared all blocks, inputs, and outputs");
    }
    public void list(String[] argsIn, Main main) {
        String[] args = argsIn;
        String type = args[0];
        ArrayList<Block> blocks = main.getBlocks();
        ArrayList<Block> inputs = main.getInputs();
        ArrayList<Block> outputs = main.getOutputs();
        switch (type) {
            case "block":
                if (blocks.isEmpty()) {
                    System.out.println("No blocks to list");
                    return;
                }
                for (Block block : blocks) {
                    System.out.println("Block: " + block.getName() + " with ID: " + block.getID());
                }
                break;
            case "input":
                if (inputs.isEmpty()) {
                    System.out.println("No inputs to list");
                    return;
                }
                for (Block block : inputs) {
                    System.out.println("Input: " + block.getName() + " with ID: " + block.getID());
                }
                break;
            case "output":
                if (outputs.isEmpty()) {
                    System.out.println("No outputs to list");
                    return;
                }
                for (Block block : outputs) {
                    System.out.println("Output: " + block.getName() + " with ID: " + block.getID());
                }
                break;
            default:
                System.out.println("Unknown argument for command list: " + type);
        }
    }

}

