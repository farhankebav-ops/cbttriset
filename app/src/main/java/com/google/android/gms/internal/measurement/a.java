package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class a {
    public static zzao a(zzak zzakVar, zzao zzaoVar, zzg zzgVar, List list) {
        if (zzakVar.zzj(zzaoVar.zzc())) {
            zzao zzaoVarZzk = zzakVar.zzk(zzaoVar.zzc());
            if (zzaoVarZzk instanceof zzai) {
                return ((zzai) zzaoVarZzk).zza(zzgVar, list);
            }
            throw new IllegalArgumentException(a1.a.C(zzaoVar.zzc(), " is not a function"));
        }
        if (!"hasOwnProperty".equals(zzaoVar.zzc())) {
            throw new IllegalArgumentException(a1.a.l("Object has no function ", zzaoVar.zzc()));
        }
        zzh.zza("hasOwnProperty", 1, list);
        return zzakVar.zzj(zzgVar.zza((zzao) list.get(0)).zzc()) ? zzao.zzk : zzao.zzl;
    }

    public static Iterator b(Map map) {
        return new zzaj(map.keySet().iterator());
    }
}
