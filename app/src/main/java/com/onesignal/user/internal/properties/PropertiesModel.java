package com.onesignal.user.internal.properties;

import com.onesignal.common.modeling.MapModel;
import com.onesignal.common.modeling.Model;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PropertiesModel extends Model {
    public PropertiesModel() {
        super(null, null, 3, null);
    }

    @Override // com.onesignal.common.modeling.Model
    public Model createModelForProperty(String property, JSONObject jsonObject) throws JSONException {
        k.e(property, "property");
        k.e(jsonObject, "jsonObject");
        if (!property.equals("tags")) {
            return null;
        }
        MapModel mapModel = new MapModel(this, "tags");
        Iterator<String> itKeys = jsonObject.keys();
        k.d(itKeys, "jsonObject.keys()");
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            k.d(key, "key");
            String string = jsonObject.getString(key);
            k.d(string, "jsonObject.getString(key)");
            Model.setStringProperty$default(mapModel, key, string, null, false, 12, null);
        }
        return mapModel;
    }

    public final String getCountry() {
        return getStringProperty("country", PropertiesModel$country$2.INSTANCE);
    }

    public final String getLanguage() {
        return Model.getOptStringProperty$default(this, "language", null, 2, null);
    }

    public final Float getLocationAccuracy() {
        return Model.getOptFloatProperty$default(this, "locationAccuracy", null, 2, null);
    }

    public final Boolean getLocationBackground() {
        return Model.getOptBooleanProperty$default(this, "locationBackground", null, 2, null);
    }

    public final Double getLocationLatitude() {
        return Model.getOptDoubleProperty$default(this, "locationLatitude", null, 2, null);
    }

    public final Double getLocationLongitude() {
        return Model.getOptDoubleProperty$default(this, "locationLongitude", null, 2, null);
    }

    public final Long getLocationTimestamp() {
        return Model.getOptLongProperty$default(this, "locationTimestamp", null, 2, null);
    }

    public final Integer getLocationType() {
        return Model.getOptIntProperty$default(this, "locationType", null, 2, null);
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignalId", null, 2, null);
    }

    public final MapModel<String> getTags() {
        return getMapModelProperty("tags", new PropertiesModel$tags$2(this));
    }

    public final String getTimezone() {
        return Model.getOptStringProperty$default(this, "timezone", null, 2, null);
    }

    public final void setCountry(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, "country", value, null, false, 12, null);
    }

    public final void setLanguage(String str) {
        Model.setOptStringProperty$default(this, "language", str, null, false, 12, null);
    }

    public final void setLocationAccuracy(Float f4) {
        Model.setOptFloatProperty$default(this, "locationAccuracy", f4, null, false, 12, null);
    }

    public final void setLocationBackground(Boolean bool) {
        Model.setOptBooleanProperty$default(this, "locationBackground", bool, null, false, 12, null);
    }

    public final void setLocationLatitude(Double d8) {
        Model.setOptDoubleProperty$default(this, "locationLatitude", d8, null, false, 12, null);
    }

    public final void setLocationLongitude(Double d8) {
        Model.setOptDoubleProperty$default(this, "locationLongitude", d8, null, false, 12, null);
    }

    public final void setLocationTimestamp(Long l) {
        Model.setOptLongProperty$default(this, "locationTimestamp", l, null, false, 12, null);
    }

    public final void setLocationType(Integer num) {
        Model.setOptIntProperty$default(this, "locationType", num, null, false, 12, null);
    }

    public final void setOnesignalId(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, "onesignalId", value, null, false, 12, null);
    }

    public final void setTimezone(String str) {
        Model.setOptStringProperty$default(this, "timezone", str, null, false, 12, null);
    }
}
