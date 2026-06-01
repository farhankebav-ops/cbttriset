package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhxl {
    public static final List zza(Object obj, long j) {
        zzhxa zzhxaVar = (zzhxa) zzhzj.zzn(obj, j);
        if (zzhxaVar.zza()) {
            return zzhxaVar;
        }
        int size = zzhxaVar.size();
        zzhxa zzhxaVarZzh = zzhxaVar.zzh(size == 0 ? 10 : size + size);
        zzhzj.zzo(obj, j, zzhxaVarZzh);
        return zzhxaVarZzh;
    }
}
