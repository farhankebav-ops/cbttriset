package com.unity3d.services.core.device.reader.pii;

import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum NonBehavioralFlag {
    UNKNOWN,
    TRUE,
    FALSE;

    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final NonBehavioralFlag fromString(String value) {
            Object objM;
            k.e(value, "value");
            try {
                String upperCase = value.toUpperCase(Locale.ROOT);
                k.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                objM = NonBehavioralFlag.valueOf(upperCase);
            } catch (Throwable th) {
                objM = q.M(th);
            }
            Object obj = NonBehavioralFlag.UNKNOWN;
            if (objM instanceof j) {
                objM = obj;
            }
            return (NonBehavioralFlag) objM;
        }

        private Companion() {
        }
    }
}
