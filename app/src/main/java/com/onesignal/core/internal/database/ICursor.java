package com.onesignal.core.internal.database;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ICursor {
    int getCount();

    float getFloat(String str);

    int getInt(String str);

    long getLong(String str);

    Float getOptFloat(String str);

    Integer getOptInt(String str);

    Long getOptLong(String str);

    String getOptString(String str);

    String getString(String str);

    boolean moveToFirst();

    boolean moveToNext();
}
