package com.onesignal.inAppMessages;

import com.ironsource.C2300e4;
import kotlin.jvm.internal.f;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum InAppMessageActionUrlType {
    IN_APP_WEBVIEW(C2300e4.h.K),
    BROWSER("browser"),
    REPLACE_CONTENT("replacement");

    public static final Companion Companion = new Companion(null);
    private final String text;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final InAppMessageActionUrlType fromString(String str) {
            for (InAppMessageActionUrlType inAppMessageActionUrlType : InAppMessageActionUrlType.values()) {
                if (t.g0(inAppMessageActionUrlType.text, str)) {
                    return inAppMessageActionUrlType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    InAppMessageActionUrlType(String str) {
        this.text = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.text;
    }
}
