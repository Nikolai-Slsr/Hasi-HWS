public class NOT extends Block{
    public boolean auswerten(){
        if(inputs.get(0).auswerten()){
            return false;
        }
        else{
            return true;
        }
    }

    public NOT() {
        numInputs = 1;
    }

    @Override
    public void setState(boolean state) {

    }
}
