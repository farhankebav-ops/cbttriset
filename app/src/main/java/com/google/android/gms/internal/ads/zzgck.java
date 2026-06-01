package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgck extends zzgdh {
    private final Activity zza;
    private final View zzb;

    public zzgck(zzauc zzaucVar, zzgcd zzgcdVar, View view, Activity activity, zzgjd zzgjdVar) {
        super("71irZxeyztMVPxtkZNjCXCWzc9uBzzqfxPgw1LkoaIGD1YWtoRaLj8ZtqyMHro2I", "sazFFsabItlse3qDY43b32ZnLCjQJ0+CJQYLaEeKmSw=", zzaucVar, zzgcdVar, zzgjdVar.zza(111));
        this.zzb = view;
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    public final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = (Object[]) method.invoke("", this.zzb, this.zza);
        objArr.getClass();
        synchronized (zzaucVar) {
            zzaucVar.zzS(((Long) objArr[0]).longValue());
            zzaucVar.zzT(((Long) objArr[1]).longValue());
            zzaucVar.zzU((String) objArr[2]);
        }
    }
}
