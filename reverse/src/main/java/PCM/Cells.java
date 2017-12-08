package PCM;

import org.json.JSONObject;

public class Cells {

    private String featureId;
    private String type ;
    private String unit;
    private Object value;
    private boolean isPartial;

    public Cells(String featureId,String type,String unit, Object value, Boolean isPartial){
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

    public Object getValue() {
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

    public void setValue(Object value) {
        this.value = value;
    }

    public void setPartial(boolean partial) {
        isPartial = partial;
    }

    private void setType() {


    }

    @Override
    public String toString() {
        return "featureId: "+ featureId+ "type: " + type + ", isPartial: "+isPartial + ", unit: " +unit + ", value: " +value;
    }
}
