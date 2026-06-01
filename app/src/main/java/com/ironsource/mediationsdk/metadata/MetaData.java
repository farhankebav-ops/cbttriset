package com.ironsource.mediationsdk.metadata;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class MetaData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f9234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<MetaDataValueTypes> f9235c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum MetaDataValueTypes {
        META_DATA_VALUE_STRING,
        META_DATA_VALUE_BOOLEAN,
        META_DATA_VALUE_INT,
        META_DATA_VALUE_LONG,
        META_DATA_VALUE_DOUBLE,
        META_DATA_VALUE_FLOAT
    }

    public MetaData(String str, List<String> list, List<MetaDataValueTypes> list2) {
        this.f9233a = str;
        this.f9234b = list;
        this.f9235c = list2;
    }

    public String getMetaDataKey() {
        return this.f9233a;
    }

    public List<String> getMetaDataValue() {
        return this.f9234b;
    }

    public List<MetaDataValueTypes> getMetaDataValueType() {
        return this.f9235c;
    }

    public MetaData(String str, List<String> list) {
        this.f9233a = str;
        this.f9234b = list;
        this.f9235c = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f9235c.add(MetaDataValueTypes.META_DATA_VALUE_STRING);
        }
    }
}
