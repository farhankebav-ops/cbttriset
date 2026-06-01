package com.google.android.gms.internal.ads;

import com.onesignal.inAppMessages.internal.InAppMessageContent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzfox {
    HTML(InAppMessageContent.HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    private final String zzd;

    zzfox(String str) {
        this.zzd = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzd;
    }
}
