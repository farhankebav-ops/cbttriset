package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbev {
    public static List zza() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbge.zzd("gad:dynamite_module:experiment_id", ""));
        zzc(arrayList, zzbgr.zza);
        zzc(arrayList, zzbgr.zzb);
        zzc(arrayList, zzbgr.zzc);
        zzc(arrayList, zzbgr.zzd);
        zzc(arrayList, zzbgr.zze);
        zzc(arrayList, zzbgr.zzu);
        zzc(arrayList, zzbgr.zzf);
        zzc(arrayList, zzbgr.zzm);
        zzc(arrayList, zzbgr.zzn);
        zzc(arrayList, zzbgr.zzo);
        zzc(arrayList, zzbgr.zzp);
        zzc(arrayList, zzbgr.zzq);
        zzc(arrayList, zzbgr.zzr);
        zzc(arrayList, zzbgr.zzs);
        zzc(arrayList, zzbgr.zzt);
        zzc(arrayList, zzbgr.zzg);
        zzc(arrayList, zzbgr.zzh);
        zzc(arrayList, zzbgr.zzi);
        zzc(arrayList, zzbgr.zzj);
        zzc(arrayList, zzbgr.zzk);
        zzc(arrayList, zzbgr.zzl);
        return arrayList;
    }

    public static List zzb() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbhg.zza);
        return arrayList;
    }

    private static void zzc(List list, zzbge zzbgeVar) {
        String str = (String) zzbgeVar.zze();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        list.add(str);
    }
}
