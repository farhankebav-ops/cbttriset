package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhdt extends zzhtn {
    public static final zzhtg zzb(zzhul zzhulVar) throws IOException {
        String strZzh;
        int iZzm = zzhulVar.zzm();
        zzhtg zzhtgVarZze = zze(zzhulVar, iZzm);
        if (zzhtgVarZze == null) {
            return zzd(zzhulVar, iZzm);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzhulVar.zzf()) {
                if (zzhtgVarZze instanceof zzhti) {
                    strZzh = zzhulVar.zzh();
                    if (!zzhdv.zza(strZzh)) {
                        throw new IOException("illegal characters in string");
                    }
                } else {
                    strZzh = null;
                }
                int iZzm2 = zzhulVar.zzm();
                zzhtg zzhtgVarZze2 = zze(zzhulVar, iZzm2);
                zzhtg zzhtgVarZzd = zzhtgVarZze2 == null ? zzd(zzhulVar, iZzm2) : zzhtgVarZze2;
                if (zzhtgVarZze instanceof zzhtf) {
                    ((zzhtf) zzhtgVarZze).zza(zzhtgVarZzd);
                } else {
                    zzhti zzhtiVar = (zzhti) zzhtgVarZze;
                    if (zzhtiVar.zzc(strZzh)) {
                        throw new IOException("duplicate key: ".concat(String.valueOf(strZzh)));
                    }
                    zzhtiVar.zza(strZzh, zzhtgVarZzd);
                }
                if (zzhtgVarZze2 != null) {
                    arrayDeque.addLast(zzhtgVarZze);
                    if (arrayDeque.size() > 100) {
                        throw new IOException("too many recursions");
                    }
                    zzhtgVarZze = zzhtgVarZzd;
                } else {
                    continue;
                }
            } else {
                if (zzhtgVarZze instanceof zzhtf) {
                    zzhulVar.zzc();
                } else {
                    zzhulVar.zze();
                }
                if (arrayDeque.isEmpty()) {
                    return zzhtgVarZze;
                }
                zzhtgVarZze = (zzhtg) arrayDeque.removeLast();
            }
        }
    }

    private static final zzhtg zzd(zzhul zzhulVar, int i2) throws IOException {
        int i8 = i2 - 1;
        if (i8 == 5) {
            String strZzi = zzhulVar.zzi();
            if (zzhdv.zza(strZzi)) {
                return new zzhtk(strZzi);
            }
            throw new IOException("illegal characters in string");
        }
        if (i8 == 6) {
            return new zzhtk(new zzhdu(zzhulVar.zzi()));
        }
        if (i8 == 7) {
            return new zzhtk(Boolean.valueOf(zzhulVar.zzj()));
        }
        if (i8 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(zzhum.zza(i2)));
        }
        zzhulVar.zzk();
        return zzhth.zza;
    }

    private static final zzhtg zze(zzhul zzhulVar, int i2) throws IOException {
        int i8 = i2 - 1;
        if (i8 == 0) {
            zzhulVar.zzb();
            return new zzhtf();
        }
        if (i8 != 2) {
            return null;
        }
        zzhulVar.zzd();
        return new zzhti();
    }

    @Override // com.google.android.gms.internal.ads.zzhtn
    public final /* bridge */ /* synthetic */ void zza(zzhun zzhunVar, Object obj) throws IOException {
        throw null;
    }
}
