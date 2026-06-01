package com.onesignal.session.internal.influence;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum InfluenceChannel {
    IAM("iam"),
    NOTIFICATION(OneSignalDbContract.NotificationTable.TABLE_NAME);

    public static final Companion Companion = new Companion(null);
    private final String nameValue;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x001f A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.onesignal.session.internal.influence.InfluenceChannel fromString(java.lang.String r5) {
            /*
                r4 = this;
                if (r5 == 0) goto L20
                com.onesignal.session.internal.influence.InfluenceChannel[] r0 = com.onesignal.session.internal.influence.InfluenceChannel.values()
                int r1 = r0.length
                int r1 = r1 + (-1)
                if (r1 < 0) goto L1b
            Lb:
                int r2 = r1 + (-1)
                r1 = r0[r1]
                boolean r3 = r1.equalsName(r5)
                if (r3 == 0) goto L16
                goto L1c
            L16:
                if (r2 >= 0) goto L19
                goto L1b
            L19:
                r1 = r2
                goto Lb
            L1b:
                r1 = 0
            L1c:
                if (r1 != 0) goto L1f
                goto L20
            L1f:
                return r1
            L20:
                com.onesignal.session.internal.influence.InfluenceChannel r5 = com.onesignal.session.internal.influence.InfluenceChannel.NOTIFICATION
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.influence.InfluenceChannel.Companion.fromString(java.lang.String):com.onesignal.session.internal.influence.InfluenceChannel");
        }

        private Companion() {
        }
    }

    InfluenceChannel(String str) {
        this.nameValue = str;
    }

    public static final InfluenceChannel fromString(String str) {
        return Companion.fromString(str);
    }

    public final boolean equalsName(String otherName) {
        k.e(otherName, "otherName");
        return k.a(this.nameValue, otherName);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.nameValue;
    }
}
