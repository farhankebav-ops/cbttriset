package com.vungle.ads.internal.locale;

import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SystemLocaleInfo implements LocaleInfo {
    @Override // com.vungle.ads.internal.locale.LocaleInfo
    public String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        k.d(language, "getDefault().language");
        return language;
    }

    @Override // com.vungle.ads.internal.locale.LocaleInfo
    public String getTimeZoneId() {
        String id = TimeZone.getDefault().getID();
        k.d(id, "getDefault().id");
        return id;
    }
}
