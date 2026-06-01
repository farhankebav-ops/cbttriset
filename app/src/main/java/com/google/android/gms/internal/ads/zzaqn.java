package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
final class zzaqn {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    public zzaqn(String str, zzapd zzapdVar) {
        String str2 = zzapdVar.zzb;
        long j = zzapdVar.zzc;
        long j3 = zzapdVar.zzd;
        long j8 = zzapdVar.zze;
        long j9 = zzapdVar.zzf;
        ?? arrayList = zzapdVar.zzh;
        if (arrayList == 0) {
            Map map = zzapdVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzapm((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j3, j8, j9, arrayList);
    }

    public static zzaqn zza(zzaqo zzaqoVar) throws IOException {
        if (zzaqq.zzi(zzaqoVar) != 538247942) {
            throw new IOException();
        }
        String strZzm = zzaqq.zzm(zzaqoVar);
        String strZzm2 = zzaqq.zzm(zzaqoVar);
        long jZzk = zzaqq.zzk(zzaqoVar);
        long jZzk2 = zzaqq.zzk(zzaqoVar);
        long jZzk3 = zzaqq.zzk(zzaqoVar);
        long jZzk4 = zzaqq.zzk(zzaqoVar);
        int iZzi = zzaqq.zzi(zzaqoVar);
        if (iZzi < 0) {
            throw new IOException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iZzi).length() + 20), "readHeaderList size=", iZzi));
        }
        List arrayList = iZzi == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for (int i2 = 0; i2 < iZzi; i2++) {
            arrayList.add(new zzapm(zzaqq.zzm(zzaqoVar).intern(), zzaqq.zzm(zzaqoVar).intern()));
        }
        return new zzaqn(strZzm, strZzm2, jZzk, jZzk2, jZzk3, jZzk4, arrayList);
    }

    private zzaqn(String str, String str2, long j, long j3, long j8, long j9, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j3;
        this.zzf = j8;
        this.zzg = j9;
        this.zzh = list;
    }
}
