package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfkd {
    public static final zzfkj zza(j2.q qVar, Object obj, zzfkk zzfkkVar) {
        return new zzfkj(zzfkkVar, obj, null, zzfkk.zza, Collections.EMPTY_LIST, qVar, null);
    }

    public static final zzfkj zzb(Callable callable, Object obj, zzfkk zzfkkVar) {
        return zzc(callable, zzfkkVar.zze(), obj, zzfkkVar);
    }

    public static final zzfkj zzc(Callable callable, zzgus zzgusVar, Object obj, zzfkk zzfkkVar) {
        return new zzfkj(zzfkkVar, obj, null, zzfkk.zza, Collections.EMPTY_LIST, zzgusVar.zzc(callable), null);
    }

    public static final zzfkj zzd(final zzfjy zzfjyVar, zzgus zzgusVar, Object obj, zzfkk zzfkkVar) {
        return zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzfkc
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                zzfjyVar.zza();
                return null;
            }
        }, zzgusVar, obj, zzfkkVar);
    }
}
