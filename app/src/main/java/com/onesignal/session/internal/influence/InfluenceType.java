package com.onesignal.session.internal.influence;

import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum InfluenceType {
    DIRECT,
    INDIRECT,
    UNATTRIBUTED,
    DISABLED;

    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0023 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.onesignal.session.internal.influence.InfluenceType fromString(java.lang.String r5) {
            /*
                r4 = this;
                if (r5 == 0) goto L24
                com.onesignal.session.internal.influence.InfluenceType[] r0 = com.onesignal.session.internal.influence.InfluenceType.values()
                int r1 = r0.length
                int r1 = r1 + (-1)
                if (r1 < 0) goto L1f
            Lb:
                int r2 = r1 + (-1)
                r1 = r0[r1]
                java.lang.String r3 = r1.name()
                boolean r3 = n6.t.g0(r3, r5)
                if (r3 == 0) goto L1a
                goto L20
            L1a:
                if (r2 >= 0) goto L1d
                goto L1f
            L1d:
                r1 = r2
                goto Lb
            L1f:
                r1 = 0
            L20:
                if (r1 != 0) goto L23
                goto L24
            L23:
                return r1
            L24:
                com.onesignal.session.internal.influence.InfluenceType r5 = com.onesignal.session.internal.influence.InfluenceType.UNATTRIBUTED
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.influence.InfluenceType.Companion.fromString(java.lang.String):com.onesignal.session.internal.influence.InfluenceType");
        }

        private Companion() {
        }
    }

    public static final InfluenceType fromString(String str) {
        return Companion.fromString(str);
    }

    public final boolean isAttributed() {
        return isDirect() || isIndirect();
    }

    public final boolean isDirect() {
        return this == DIRECT;
    }

    public final boolean isDisabled() {
        return this == DISABLED;
    }

    public final boolean isIndirect() {
        return this == INDIRECT;
    }

    public final boolean isUnattributed() {
        return this == UNATTRIBUTED;
    }
}
