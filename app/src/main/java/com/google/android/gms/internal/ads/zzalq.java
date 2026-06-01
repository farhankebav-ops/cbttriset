package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzalq implements zzaki {
    private final zzeg zza = new zzeg();

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i2, int i8, zzakh zzakhVar, zzdg zzdgVar) {
        zzcm zzcmVarZzr;
        zzeg zzegVar = this.zza;
        zzegVar.zzb(bArr, i8 + i2);
        zzegVar.zzh(i2);
        ArrayList arrayList = new ArrayList();
        while (zzegVar.zzd() > 0) {
            zzgmd.zzb(zzegVar.zzd() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int iZzB = zzegVar.zzB() - 8;
            if (zzegVar.zzB() == 1987343459) {
                CharSequence charSequenceZzc = null;
                zzcl zzclVarZzb = null;
                while (iZzB > 0) {
                    zzgmd.zzb(iZzB >= 8, "Incomplete vtt cue box header found.");
                    int iZzB2 = zzegVar.zzB();
                    int iZzB3 = zzegVar.zzB();
                    int i9 = iZzB - 8;
                    int i10 = iZzB2 - 8;
                    String strZzj = zzep.zzj(zzegVar.zzi(), zzegVar.zzg(), i10);
                    zzegVar.zzk(i10);
                    if (iZzB3 == 1937011815) {
                        zzclVarZzb = zzalz.zzb(strZzj);
                    } else if (iZzB3 == 1885436268) {
                        charSequenceZzc = zzalz.zzc(null, strZzj.trim(), Collections.EMPTY_LIST);
                    }
                    iZzB = i9 - i10;
                }
                if (charSequenceZzc == null) {
                    charSequenceZzc = "";
                }
                if (zzclVarZzb != null) {
                    zzclVarZzb.zza(charSequenceZzc);
                    zzcmVarZzr = zzclVarZzb.zzr();
                } else {
                    Pattern pattern = zzalz.zza;
                    zzaly zzalyVar = new zzaly();
                    zzalyVar.zzc = charSequenceZzc;
                    zzcmVarZzr = zzalyVar.zza().zzr();
                }
                arrayList.add(zzcmVarZzr);
            } else {
                zzegVar.zzk(iZzB);
            }
        }
        zzdgVar.zza(new zzaka(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
