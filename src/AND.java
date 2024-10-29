public class AND extends Block{
    public boolean auswerten(){
        if (inputs.get(0).equals(this) || inputs.get(1).equals(this) ){
            throw new InfinityException("Infinite Loop");
        }
        return inputs.get(0).auswerten() && inputs.get(1).auswerten();
    }

    public AND() {
        numInputs = 2;
    }

    @Override
    public void setState(boolean state) {
    }
}
