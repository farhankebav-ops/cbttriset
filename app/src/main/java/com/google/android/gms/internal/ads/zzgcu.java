package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgcu extends zzgdh {
    private final zzfxt zza;

    public zzgcu(zzauc zzaucVar, zzgcd zzgcdVar, zzfxt zzfxtVar, zzgjd zzgjdVar) {
        super("By5K9EmVfikEcCFMOZQd1jxZLLuKkdFWcNBLbmtQ/cGwaIFZzYRhON9QKnCD3h+X", "jO4sZLvDsqH0XT1pMychedS7fP8lDaqZlRwqYI2S90Y=", zzaucVar, zzgcdVar, zzgjdVar.zza(116));
        this.zza = zzfxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    public final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = (Object[]) method.invoke("", this.zza.zzb());
        objArr.getClass();
        synchronized (zzaucVar) {
            zzaucVar.zzb((String) objArr[0]);
            zzaucVar.zzaa((String) objArr[1]);
        }
    }
}
