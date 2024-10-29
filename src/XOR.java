public class XOR extends Block{
    public boolean auswerten(){
        if (inputs.get(0).equals(this) || inputs.get(1).equals(this) ){
            throw new InfinityException("Infinite Loop");
        }

        if(inputs.get(0).auswerten() ^ inputs.get(1).auswerten()){
            return true;
        }
        else{
            return false;
        }
    }

    public XOR() {
        numInputs = 2;
    }

    @Override
    public void setState(boolean state) {

    }
}
