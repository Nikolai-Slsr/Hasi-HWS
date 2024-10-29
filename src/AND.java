public class AND extends Block{
    public boolean auswerten(){
        return inputs.get(0).auswerten() && inputs.get(1).auswerten();
    }

    public AND() {
        numInputs = 2;
    }

    @Override
    public void setState(boolean state) {
    }
}
