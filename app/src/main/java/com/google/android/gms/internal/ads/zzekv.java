package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzekv {
    private final Clock zza;
    private final zzekx zzb;
    private final zzfng zzc;

    @GuardedBy("this")
    private final LinkedHashMap zzd = new LinkedHashMap();
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhq)).booleanValue();
    private final zzehp zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;

    public zzekv(Clock clock, zzekx zzekxVar, zzehp zzehpVar, zzfng zzfngVar) {
        this.zza = clock;
        this.zzb = zzekxVar;
        this.zzf = zzehpVar;
        this.zzc = zzfngVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public final synchronized boolean zzi(zzffu zzffuVar) {
        zzeku zzekuVar = (zzeku) this.zzd.get(zzffuVar);
        if (zzekuVar == null) {
            return false;
        }
        return zzekuVar.zzc == 8;
    }

    public final synchronized void zza() {
        this.zzi = this.zza.elapsedRealtime();
    }

    public final synchronized void zzb() {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzc(List list) {
        this.zzi = this.zza.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzffu zzffuVar = (zzffu) it.next();
            String str = zzffuVar.zzw;
            if (!TextUtils.isEmpty(str)) {
                this.zzd.put(zzffuVar, new zzeku(str, zzffuVar.zzaf, Integer.MAX_VALUE, 0L, null));
            }
        }
    }

    public final synchronized void zzd(@Nullable zzffu zzffuVar) {
        try {
            this.zzh = this.zza.elapsedRealtime() - this.zzi;
            if (zzffuVar != null) {
                this.zzf.zzi(zzffuVar);
            }
            this.zzg = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized j2.q zze(zzfgf zzfgfVar, zzffu zzffuVar, j2.q qVar, zzfnc zzfncVar) {
        zzffx zzffxVar = zzfgfVar.zzb.zzb;
        long jElapsedRealtime = this.zza.elapsedRealtime();
        String str = zzffuVar.zzw;
        if (str != null) {
            this.zzd.put(zzffuVar, new zzeku(str, zzffuVar.zzaf, 9, 0L, null));
            zzgui.zzr(qVar, new zzekt(this, jElapsedRealtime, zzffxVar, zzffuVar, str, zzfncVar, zzfgfVar), zzcbv.zzg);
        }
        return qVar;
    }

    public final synchronized void zzf(zzffu zzffuVar) {
        zzeku zzekuVar = (zzeku) this.zzd.get(zzffuVar);
        if (zzekuVar == null || this.zzg) {
            return;
        }
        zzekuVar.zzc = 8;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.zzd.entrySet().iterator();
            while (it.hasNext()) {
                zzeku zzekuVar = (zzeku) ((Map.Entry) it.next()).getValue();
                if (zzekuVar.zzc != Integer.MAX_VALUE) {
                    arrayList.add(zzekuVar.toString());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized long zzh() {
        return this.zzh;
    }

    public final /* synthetic */ Clock zzj() {
        return this.zza;
    }

    public final /* synthetic */ zzekx zzk() {
        return this.zzb;
    }

    public final /* synthetic */ zzfng zzl() {
        return this.zzc;
    }

    public final /* synthetic */ LinkedHashMap zzm() {
        return this.zzd;
    }

    public final /* synthetic */ boolean zzn() {
        return this.zze;
    }

    public final /* synthetic */ zzehp zzo() {
        return this.zzf;
    }

    public final /* synthetic */ boolean zzp() {
        return this.zzg;
    }
}
