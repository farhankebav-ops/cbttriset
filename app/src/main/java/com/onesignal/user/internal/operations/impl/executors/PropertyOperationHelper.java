package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.user.internal.backend.PropertiesObject;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.SetPropertyOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PropertyOperationHelper {
    public static final PropertyOperationHelper INSTANCE = new PropertyOperationHelper();

    private PropertyOperationHelper() {
    }

    public final PropertiesObject createPropertiesFromOperation(SetTagOperation operation, PropertiesObject propertiesObject) {
        k.e(operation, "operation");
        k.e(propertiesObject, "propertiesObject");
        Map<String, String> tags = propertiesObject.getTags();
        LinkedHashMap linkedHashMapO0 = tags != null ? x.o0(tags) : null;
        if (linkedHashMapO0 == null) {
            linkedHashMapO0 = new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = linkedHashMapO0;
        linkedHashMap.put(operation.getKey(), operation.getValue());
        return new PropertiesObject(linkedHashMap, propertiesObject.getLanguage(), propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
    }

    public final PropertiesObject createPropertiesFromOperation(DeleteTagOperation operation, PropertiesObject propertiesObject) {
        k.e(operation, "operation");
        k.e(propertiesObject, "propertiesObject");
        Map<String, String> tags = propertiesObject.getTags();
        LinkedHashMap linkedHashMapO0 = tags != null ? x.o0(tags) : null;
        if (linkedHashMapO0 == null) {
            linkedHashMapO0 = new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = linkedHashMapO0;
        linkedHashMap.put(operation.getKey(), null);
        return new PropertiesObject(linkedHashMap, propertiesObject.getLanguage(), propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PropertiesObject createPropertiesFromOperation(SetPropertyOperation operation, PropertiesObject propertiesObject) {
        String string;
        String string2;
        k.e(operation, "operation");
        k.e(propertiesObject, "propertiesObject");
        String property = operation.getProperty();
        if (k.a(property, "language")) {
            Map<String, String> tags = propertiesObject.getTags();
            Object value = operation.getValue();
            return new PropertiesObject(tags, value != null ? value.toString() : null, propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
        }
        if (k.a(property, "timezone")) {
            Map<String, String> tags2 = propertiesObject.getTags();
            String language = propertiesObject.getLanguage();
            Object value2 = operation.getValue();
            return new PropertiesObject(tags2, language, value2 != null ? value2.toString() : null, propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
        }
        if (k.a(property, "country")) {
            Map<String, String> tags3 = propertiesObject.getTags();
            String language2 = propertiesObject.getLanguage();
            String timezoneId = propertiesObject.getTimezoneId();
            Object value3 = operation.getValue();
            return new PropertiesObject(tags3, language2, timezoneId, value3 != null ? value3.toString() : null, propertiesObject.getLatitude(), propertiesObject.getLongitude());
        }
        if (k.a(property, "locationLatitude")) {
            Map<String, String> tags4 = propertiesObject.getTags();
            String language3 = propertiesObject.getLanguage();
            String timezoneId2 = propertiesObject.getTimezoneId();
            String country = propertiesObject.getCountry();
            Object value4 = operation.getValue();
            if (value4 != null && (string2 = value4.toString()) != null) {
                objValueOf = Double.valueOf(Double.parseDouble(string2));
            }
            return new PropertiesObject(tags4, language3, timezoneId2, country, objValueOf, propertiesObject.getLongitude());
        }
        if (k.a(property, "locationLongitude")) {
            Map<String, String> tags5 = propertiesObject.getTags();
            String language4 = propertiesObject.getLanguage();
            String timezoneId3 = propertiesObject.getTimezoneId();
            String country2 = propertiesObject.getCountry();
            Double latitude = propertiesObject.getLatitude();
            Object value5 = operation.getValue();
            if (value5 != null && (string = value5.toString()) != null) {
                objValueOf = Double.valueOf(Double.parseDouble(string));
            }
            return new PropertiesObject(tags5, language4, timezoneId3, country2, latitude, objValueOf);
        }
        return new PropertiesObject(propertiesObject.getTags(), propertiesObject.getLanguage(), propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
    }
}
