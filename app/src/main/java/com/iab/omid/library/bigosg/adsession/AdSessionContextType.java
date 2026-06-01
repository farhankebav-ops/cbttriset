package com.iab.omid.library.bigosg.adsession;

import com.onesignal.inAppMessages.internal.InAppMessageContent;

/* JADX INFO: loaded from: classes3.dex */
public enum AdSessionContextType {
    HTML(InAppMessageContent.HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    private final String typeString;

    AdSessionContextType(String str) {
        this.typeString = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.typeString;
    }
}
