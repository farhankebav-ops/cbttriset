package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgtb;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgux extends zzgtb.zzf implements Runnable {
    private final Runnable zza;

    public zzgux(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzb(th);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final String zzd() {
        String string = this.zza.toString();
        return a1.a.s(new StringBuilder(string.length() + 7), "task=[", string, C2300e4.i.e);
    }
}
