package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbbl {

    @VisibleForTesting
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    public final boolean zza(zzbbk zzbbkVar) {
        synchronized (this.zzb) {
            try {
                return this.zzc.contains(zzbbkVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzb(zzbbk zzbbkVar) {
        synchronized (this.zzb) {
            try {
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    zzbbk zzbbkVar2 = (zzbbk) it.next();
                    if (com.google.android.gms.ads.internal.zzt.zzh().zzo().zzc()) {
                        if (!com.google.android.gms.ads.internal.zzt.zzh().zzo().zze() && !zzbbkVar.equals(zzbbkVar2) && zzbbkVar2.zzc().equals(zzbbkVar.zzc())) {
                            it.remove();
                            return true;
                        }
                    } else if (!zzbbkVar.equals(zzbbkVar2) && zzbbkVar2.zzb().equals(zzbbkVar.zzb())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(zzbbk zzbbkVar) {
        synchronized (this.zzb) {
            try {
                List list = this.zzc;
                if (list.size() >= 10) {
                    int size = list.size();
                    StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 30);
                    sb.append("Queue is full, current size = ");
                    sb.append(size);
                    String string = sb.toString();
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
                    list.remove(0);
                }
                int i8 = this.zza;
                this.zza = i8 + 1;
                zzbbkVar.zzk(i8);
                zzbbkVar.zzh();
                list.add(zzbbkVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
