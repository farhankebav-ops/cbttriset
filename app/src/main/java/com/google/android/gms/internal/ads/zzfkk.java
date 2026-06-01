package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzfkk {
    private static final j2.q zza = zzgui.zza(null);
    private final zzgus zzb;
    private final ScheduledExecutorService zzc;
    private final zzfkl zzd;

    public zzfkk(zzgus zzgusVar, ScheduledExecutorService scheduledExecutorService, zzfkl zzfklVar) {
        this.zzb = zzgusVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfklVar;
    }

    public final zzfkj zza(Object obj, j2.q qVar) {
        return new zzfkj(this, obj, null, qVar, Collections.singletonList(qVar), qVar, null);
    }

    public final zzfkb zzb(Object obj, j2.q... qVarArr) {
        return new zzfkb(this, obj, Arrays.asList(qVarArr), null);
    }

    public abstract String zzc(Object obj);

    public final /* synthetic */ zzgus zze() {
        return this.zzb;
    }

    public final /* synthetic */ ScheduledExecutorService zzf() {
        return this.zzc;
    }

    public final /* synthetic */ zzfkl zzg() {
        return this.zzd;
    }
}
