package com.onesignal.user.internal.backend;

import java.util.Map;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PropertiesObject {
    private final String country;
    private final String language;
    private final Double latitude;
    private final Double longitude;
    private final Map<String, String> tags;
    private final String timezoneId;

    public PropertiesObject() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final String getCountry() {
        return this.country;
    }

    public final boolean getHasAtLeastOnePropertySet() {
        return (this.tags == null && this.language == null && this.timezoneId == null && this.country == null && this.latitude == null && this.longitude == null) ? false : true;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final Map<String, String> getTags() {
        return this.tags;
    }

    public final String getTimezoneId() {
        return this.timezoneId;
    }

    public PropertiesObject(Map<String, String> map, String str, String str2, String str3, Double d8, Double d9) {
        this.tags = map;
        this.language = str;
        this.timezoneId = str2;
        this.country = str3;
        this.latitude = d8;
        this.longitude = d9;
    }

    public /* synthetic */ PropertiesObject(Map map, String str, String str2, String str3, Double d8, Double d9, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : map, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : d8, (i2 & 32) != 0 ? null : d9);
    }
}
