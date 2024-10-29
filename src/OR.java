public class OR extends Block{
    public boolean auswerten(){
        if (inputs.get(0).auswerten() || inputs.get(1).auswerten()){
            return true;
        }
        else{
            return false;
        }
    }

    public OR() {
        numInputs = 2;
    }

    @Override
    public void setState(boolean state) {

    }
}
