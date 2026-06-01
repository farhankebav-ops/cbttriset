package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaqh implements zzapt {
    private final Map zza = new HashMap();

    @Nullable
    private final zzapg zzb;

    @Nullable
    private final BlockingQueue zzc;
    private final zzapl zzd;

    public zzaqh(@NonNull zzapg zzapgVar, @NonNull BlockingQueue blockingQueue, zzapl zzaplVar) {
        this.zzd = zzaplVar;
        this.zzb = zzapgVar;
        this.zzc = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza(zzapu zzapuVar, zzaqa zzaqaVar) {
        List list;
        zzapd zzapdVar = zzaqaVar.zzb;
        if (zzapdVar == null || zzapdVar.zza(System.currentTimeMillis())) {
            zzb(zzapuVar);
            return;
        }
        String strZzi = zzapuVar.zzi();
        synchronized (this) {
            list = (List) this.zza.remove(strZzi);
        }
        if (list != null) {
            if (zzaqg.zzb) {
                zzaqg.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strZzi);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzd.zza((zzapu) it.next(), zzaqaVar, null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final synchronized void zzb(zzapu zzapuVar) {
        try {
            Map map = this.zza;
            String strZzi = zzapuVar.zzi();
            List list = (List) map.remove(strZzi);
            if (list == null || list.isEmpty()) {
                return;
            }
            if (zzaqg.zzb) {
                zzaqg.zza("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strZzi);
            }
            zzapu zzapuVar2 = (zzapu) list.remove(0);
            map.put(strZzi, list);
            zzapuVar2.zzu(this);
            try {
                this.zzc.put(zzapuVar2);
            } catch (InterruptedException e) {
                zzaqg.zzc("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzb.zza();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean zzc(zzapu zzapuVar) {
        try {
            Map map = this.zza;
            String strZzi = zzapuVar.zzi();
            if (!map.containsKey(strZzi)) {
                map.put(strZzi, null);
                zzapuVar.zzu(this);
                if (zzaqg.zzb) {
                    zzaqg.zzb("new request, sending to network %s", strZzi);
                }
                return false;
            }
            List arrayList = (List) map.get(strZzi);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            zzapuVar.zzc("waiting-for-response");
            arrayList.add(zzapuVar);
            map.put(strZzi, arrayList);
            if (zzaqg.zzb) {
                zzaqg.zzb("Request for cacheKey=%s is in flight, putting on hold.", strZzi);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
