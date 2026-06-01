package com.google.android.gms.internal.ads;

import android.content.Context;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgde extends zzgdh {
    private static final Long zza = -1L;
    private final zzfyq zzb;
    private final Context zzc;
    private final Map zzd;

    public zzgde(zzauc zzaucVar, zzgcd zzgcdVar, zzfyq zzfyqVar, Context context, Map map, zzgjd zzgjdVar) {
        super("3U4DEAJT9Pq66npH/ZEsiPizUaU6oaGuzbq27Rp3Iz/R6ssq6OsViFqc+1XsG+SQ", "oHImj5OTIs8LNvX9EwNQkQ3bSJ9XioOM1m8VTLsnF8I=", zzaucVar, zzgcdVar, zzgjdVar.zza(Sdk.SDKError.Reason.TPAT_ERROR_VALUE));
        this.zzb = zzfyqVar;
        this.zzc = context;
        this.zzd = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    public final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        zzfyq zzfyqVar = this.zzb;
        Object[] objArr = (Object[]) method.invoke("", Integer.valueOf(zzfyqVar.ordinal()), this.zzc, zzgma.zza(this.zzd.get("up"), Boolean.TRUE));
        objArr.getClass();
        synchronized (zzaucVar) {
            try {
                if (zzfyqVar == zzfyq.QUERY) {
                    Object obj = objArr[0];
                    Long l = zza;
                    zzaucVar.zzq(((Long) zzgma.zza(obj, l)).longValue());
                    zzaucVar.zzr(((Long) zzgma.zza(objArr[1], l)).longValue());
                }
                zzaucVar.zzg(((Long) objArr[2]).longValue());
                zzaucVar.zzQ(((Long) objArr[3]).longValue());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
