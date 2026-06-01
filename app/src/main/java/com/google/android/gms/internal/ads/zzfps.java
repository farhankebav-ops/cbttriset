package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfps {
    private static final zzfps zza = new zzfps();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfps() {
    }

    public static zzfps zza() {
        return zza;
    }

    public final void zzb(zzfoy zzfoyVar) {
        this.zzb.add(zzfoyVar);
    }

    public final void zzc(zzfoy zzfoyVar) {
        ArrayList arrayList = this.zzc;
        boolean zZzg = zzg();
        arrayList.add(zzfoyVar);
        if (zZzg) {
            return;
        }
        zzfqa.zza().zzc();
    }

    public final void zzd(zzfoy zzfoyVar) {
        ArrayList arrayList = this.zzb;
        boolean zZzg = zzg();
        arrayList.remove(zzfoyVar);
        this.zzc.remove(zzfoyVar);
        if (!zZzg || zzg()) {
            return;
        }
        zzfqa.zza().zze();
    }

    public final Collection zze() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final Collection zzf() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
