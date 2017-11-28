package PCM;

public class Cells {
    private String type ;
    private String unit;
    private String value;
    private int valueInt;
    private boolean isPartial;
    

    public Cells(String type,String unit, String value){
        this.value = value;
        this.type =type;
        this.unit = unit;
        setType();
    }

    private void setType() {
        if(type== "number") {
            valueInt = Integer.parseInt(value);
        }
    }
    @Override
    public String toString() {
        return "type: " + type + ", unit: " +unit;
    }
}
