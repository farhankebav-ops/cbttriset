package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzm extends zzj {
    private static final WeakReference zzb = new WeakReference(null);
    private WeakReference zza;

    public zzm(byte[] bArr) {
        super(bArr);
        this.zza = zzb;
    }

    public abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzj
    public final byte[] zzc() {
        byte[] bArrZzb;
        synchronized (this) {
            try {
                bArrZzb = (byte[]) this.zza.get();
                if (bArrZzb == null) {
                    bArrZzb = zzb();
                    this.zza = new WeakReference(bArrZzb);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrZzb;
    }
}
