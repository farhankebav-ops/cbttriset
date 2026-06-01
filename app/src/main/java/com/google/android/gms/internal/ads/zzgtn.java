package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgtn extends zzgtl {
    private zzgtn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtl
    public final void zza(zzgto zzgtoVar, Set set, Set set2) {
        synchronized (zzgtoVar) {
            try {
                if (zzgtoVar.seenExceptionsField == null) {
                    zzgtoVar.seenExceptionsField = set2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtl
    public final int zzb(zzgto zzgtoVar) {
        int i2;
        synchronized (zzgtoVar) {
            i2 = zzgtoVar.remainingField - 1;
            zzgtoVar.remainingField = i2;
        }
        return i2;
    }

    public /* synthetic */ zzgtn(byte[] bArr) {
        super(null);
    }
}
