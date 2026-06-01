package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaiu {
    public static String zza(List list) {
        Iterator it = list.iterator();
        String str = null;
        boolean z2 = false;
        while (it.hasNext()) {
            String str2 = ((zzaji) it.next()).zza.zzg.zzo;
            if (zzas.zzb(str2)) {
                return "video/mp4";
            }
            if (zzas.zza(str2)) {
                z2 = true;
            } else if (zzas.zzc(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        return z2 ? "audio/mp4" : str != null ? str : "application/mp4";
    }
}
