public class Output extends Block {
    private boolean state;
    public boolean auswerten(){
        state = inputs.getFirst().auswerten();
        return state;
    }

    public Output() {
        this.state = false;
        numInputs = 1;
    }

    public void setState(boolean state){
        this.state = state;
    }
}
