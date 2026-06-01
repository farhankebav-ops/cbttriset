package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfqz implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (zzfrc.zzc != null) {
            zzfrc.zzc.post(zzfrc.zzk);
            zzfrc.zzc.postDelayed(zzfrc.zzl, 200L);
        }
    }
}
