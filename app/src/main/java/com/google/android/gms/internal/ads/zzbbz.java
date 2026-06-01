package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbbz {
    private final int zza;
    private final zzbbw zzb = new zzbcb();

    public zzbbz(int i2) {
        this.zza = i2;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(((String) arrayList.get(i2)).toLowerCase(Locale.US));
            sb.append('\n');
        }
        String[] strArrSplit = sb.toString().split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zzbby zzbbyVar = new zzbby();
        int i8 = this.zza;
        PriorityQueue priorityQueue = new PriorityQueue(i8, new zzbbx(this));
        for (String str : strArrSplit) {
            String[] strArrZzb = zzbca.zzb(str, false);
            if (strArrZzb.length != 0) {
                zzbcd.zza(strArrZzb, i8, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzbbyVar.zzb.write(this.zzb.zza(((zzbcc) it.next()).zzb));
            } catch (IOException e) {
                int i9 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Error while writing hash to byteStream", e);
            }
        }
        return zzbbyVar.toString();
    }
}
