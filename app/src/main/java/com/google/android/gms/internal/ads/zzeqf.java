package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzeqf implements zzgtq {
    static final /* synthetic */ zzeqf zza = new zzeqf();

    private /* synthetic */ zzeqf() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ j2.q zza(Object obj) {
        return ((Throwable) obj) instanceof TimeoutException ? zzgui.zza(new zzeqi(Integer.toString(17))) : zzgui.zza(new zzeqi(null));
    }
}
