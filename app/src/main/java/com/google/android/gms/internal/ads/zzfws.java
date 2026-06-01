package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import q6.y0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfws {
    public static final zzfwq zza(final ExecutorService executorService) {
        kotlin.jvm.internal.k.e(executorService, "executorService");
        return new zzfwq() { // from class: com.google.android.gms.internal.ads.zzfwr
            @Override // com.google.android.gms.internal.ads.zzfwq
            public final q6.a0 zza() {
                return q6.c0.b(new y0(executorService));
            }
        };
    }
}
