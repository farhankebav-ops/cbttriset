package com.unity3d.ads.core.data.model;

import java.util.Locale;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum OperationType {
    UNKNOWN,
    INITIALIZATION,
    LOAD,
    LOAD_HEADER_BIDDING,
    SHOW,
    REFRESH,
    PRIVACY_UPDATE,
    INITIALIZATION_COMPLETED,
    TRANSACTION_EVENT,
    GET_TOKEN,
    UNIVERSAL_EVENT;

    @Override // java.lang.Enum
    public String toString() {
        String string = super.toString();
        Locale locale = Locale.getDefault();
        k.d(locale, "getDefault()");
        String lowerCase = string.toLowerCase(locale);
        k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}
