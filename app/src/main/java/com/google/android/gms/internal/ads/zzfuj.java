package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzfuj implements Closeable {
    public static zzfuv zza() {
        return new zzfuv();
    }

    public static zzfuv zzb(zzgmv<Integer> zzgmvVar, zzgmv<Integer> zzgmvVar2, zzful zzfulVar) {
        return new zzfuv(zzgmvVar, zzgmvVar2, zzfulVar);
    }

    public static zzfuv zzc(final int i2, zzful zzfulVar) {
        return new zzfuv(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzfui
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i2);
            }
        }, zzfuh.zza, zzfulVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer zzf() {
        return -1;
    }
}
