package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgpp extends zzgpk {
    public final zzgpp zzb(Object obj, Object... objArr) {
        List listAsList = Arrays.asList(objArr);
        if (obj == null) {
            Iterator it = listAsList.iterator();
            StringBuilder sb = new StringBuilder(C2300e4.i.f8403d);
            boolean z2 = true;
            while (it.hasNext()) {
                if (!z2) {
                    sb.append(", ");
                }
                sb.append(it.next());
                z2 = false;
            }
            sb.append(']');
            throw new NullPointerException("null key in entry: null=".concat(sb.toString()));
        }
        Iterator it2 = listAsList.iterator();
        if (it2.hasNext()) {
            zzgoz zzgozVarZzs = (zzgoz) zza().get(obj);
            if (zzgozVarZzs == null) {
                zzgozVarZzs = zzgpo.zzs(listAsList instanceof Set ? Math.max(4, ((Set) listAsList).size()) : 4);
                zza().put(obj, zzgozVarZzs);
            }
            while (it2.hasNext()) {
                Object next = it2.next();
                zzgoc.zza(obj, next);
                zzgozVarZzs.zzd(next);
            }
        }
        return this;
    }

    public final zzgpr zzc() {
        Map map = this.zza;
        if (map == null) {
            return zzgou.zza;
        }
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return zzgou.zza;
        }
        zzgpg zzgpgVar = new zzgpg(setEntrySet.size());
        int size = 0;
        for (Map.Entry entry : setEntrySet) {
            Object key = entry.getKey();
            zzgpo zzgpoVarZzo = zzgpo.zzo(((zzgpn) entry.getValue()).zzi());
            if (!zzgpoVarZzo.isEmpty()) {
                zzgpgVar.zza(key, zzgpoVarZzo);
                size += zzgpoVarZzo.size();
            }
        }
        return new zzgpr(zzgpgVar.zzc(), size, null);
    }
}
