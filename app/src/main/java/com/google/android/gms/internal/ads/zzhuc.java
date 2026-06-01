package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhuc extends zzhtn {
    static final zzhuc zza = new zzhuc();

    private zzhuc() {
    }

    @Override // com.google.android.gms.internal.ads.zzhtn
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final void zza(zzhun zzhunVar, zzhtg zzhtgVar) throws IOException {
        if (zzhtgVar == null || (zzhtgVar instanceof zzhth)) {
            zzhunVar.zzj();
            return;
        }
        if (zzhtgVar instanceof zzhtk) {
            zzhtk zzhtkVarZzg = zzhtgVar.zzg();
            if (zzhtkVarZzg.zzc()) {
                zzhunVar.zzi(zzhtkVarZzg.zzh());
                return;
            } else if (zzhtkVarZzg.zza()) {
                zzhunVar.zzh(zzhtkVarZzg.zzb());
                return;
            } else {
                zzhunVar.zzg(zzhtkVarZzg.zzd());
                return;
            }
        }
        if (zzhtgVar instanceof zzhtf) {
            zzhunVar.zzb();
            Iterator it = zzhtgVar.zzf().iterator();
            while (it.hasNext()) {
                zza(zzhunVar, (zzhtg) it.next());
            }
            zzhunVar.zzc();
            return;
        }
        if (!(zzhtgVar instanceof zzhti)) {
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(zzhtgVar.getClass())));
        }
        zzhunVar.zzd();
        for (Map.Entry entry : zzhtgVar.zze().zzb()) {
            zzhunVar.zzf((String) entry.getKey());
            zza(zzhunVar, (zzhtg) entry.getValue());
        }
        zzhunVar.zze();
    }
}
