package PCM;

import org.json.JSONObject;

public class Cells {

    private String featureId;
    private String type ;
    private String unit;
    private String value;
    private int valueInt;
    private boolean isPartial;

    public Cells(){}
    public Cells(String featureId,String type,String unit, String value, Boolean isPartial){
        this.featureId = featureId;
        this.value = value;
        this.type =type;
        this.unit = unit;
        this.isPartial = isPartial;
        this.setType();
    }

    public String getFeatureId() {
        return featureId;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public String getValue() {
        return value;
    }

    public Boolean getIsPartial() {
        return isPartial;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }
    public void setType(String type) {
        this.type = type;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPartial(boolean partial) {
        isPartial = partial;
    }

    private void setType() {
        if(type== "number") {
            valueInt = Integer.parseInt(value);
        }
    }

    @Override
    public String toString() {
        return "FeaturId: "+ featureId+ "type: " + type + ", isPartial: "+isPartial + ", unit: " +unit + ", value: " +value;
    }
}
