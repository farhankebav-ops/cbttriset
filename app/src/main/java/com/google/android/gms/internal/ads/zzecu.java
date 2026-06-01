package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzecu implements zzgtq {
    static final /* synthetic */ zzecu zza = new zzecu();

    private /* synthetic */ zzecu() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ j2.q zza(Object obj) {
        Throwable cause = (ExecutionException) obj;
        if (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return zzgui.zzc(cause);
    }
}
