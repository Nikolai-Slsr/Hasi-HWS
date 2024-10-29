public class Input extends Block {
    private boolean state;
    public boolean auswerten(){
        return state;
    }

    public Input() {
        this.state = false;
        numInputs = 0;
    }

    public void setState(boolean state){
        this.state = state;
    }
}
