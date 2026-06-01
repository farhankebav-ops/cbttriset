package com.unity3d.ads.core.domain.work;

import androidx.work.Data;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UniversalRequestWorkerData {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_UNIVERSAL_REQUEST_ID = "universalRequestId";
    private final String universalRequestId;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public UniversalRequestWorkerData(String universalRequestId) {
        k.e(universalRequestId, "universalRequestId");
        this.universalRequestId = universalRequestId;
    }

    public final Data invoke() throws Throwable {
        Data dataBuild = new Data.Builder().putString(KEY_UNIVERSAL_REQUEST_ID, this.universalRequestId).build();
        k.d(dataBuild, "Builder()\n            .p…tId)\n            .build()");
        return dataBuild;
    }
}
