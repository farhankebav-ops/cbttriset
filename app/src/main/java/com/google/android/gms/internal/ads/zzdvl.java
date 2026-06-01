package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdvl implements zzfkt {
    private final zzdvc zzb;
    private final Clock zzc;
    private final Map zza = new HashMap();
    private final Map zzd = new HashMap();

    public zzdvl(zzdvc zzdvcVar, Set set, Clock clock) {
        this.zzb = zzdvcVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdvk zzdvkVar = (zzdvk) it.next();
            this.zzd.put(zzdvkVar.zzc(), zzdvkVar);
        }
        this.zzc = clock;
    }

    private final void zze(zzfkm zzfkmVar, boolean z2) {
        zzdvk zzdvkVar = (zzdvk) this.zzd.get(zzfkmVar);
        if (zzdvkVar == null) {
            return;
        }
        String str = true != z2 ? "f." : "s.";
        Map map = this.zza;
        zzfkm zzfkmVarZzb = zzdvkVar.zzb();
        if (map.containsKey(zzfkmVarZzb)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) map.get(zzfkmVarZzb)).longValue();
            zzdvc zzdvcVar = this.zzb;
            String strZza = zzdvkVar.zza();
            int length = str.length();
            Map mapZzc = zzdvcVar.zzc();
            StringBuilder sb = new StringBuilder(length + String.valueOf(jElapsedRealtime).length());
            sb.append(str);
            sb.append(jElapsedRealtime);
            mapZzc.put("label.".concat(strZza), sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdQ(zzfkm zzfkmVar, String str) {
        this.zza.put(zzfkmVar, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdR(zzfkm zzfkmVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) map.get(zzfkmVar)).longValue();
            this.zzb.zzc().put("task.".concat(String.valueOf(str)), "f.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfkmVar)) {
            zze(zzfkmVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdS(zzfkm zzfkmVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) map.get(zzfkmVar)).longValue();
            this.zzb.zzc().put("task.".concat(String.valueOf(str)), "s.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfkmVar)) {
            zze(zzfkmVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdP(zzfkm zzfkmVar, String str) {
    }
}
