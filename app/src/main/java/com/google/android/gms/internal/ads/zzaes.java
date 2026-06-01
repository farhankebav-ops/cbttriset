package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaes {
    public static int zza(int i2) {
        int i8 = 0;
        while (i2 > 0) {
            i2 >>>= 1;
            i8++;
        }
        return i8;
    }

    public static zzaep zzb(zzeg zzegVar, boolean z2, boolean z7) throws zzat {
        if (z2) {
            zzd(3, zzegVar, false);
        }
        String strZzK = zzegVar.zzK((int) zzegVar.zzA(), StandardCharsets.UTF_8);
        int length = strZzK.length();
        long jZzA = zzegVar.zzA();
        String[] strArr = new String[(int) jZzA];
        int length2 = length + 15;
        for (int i2 = 0; i2 < jZzA; i2++) {
            String strZzK2 = zzegVar.zzK((int) zzegVar.zzA(), StandardCharsets.UTF_8);
            strArr[i2] = strZzK2;
            length2 = length2 + 4 + strZzK2.length();
        }
        if (z7 && (zzegVar.zzs() & 1) == 0) {
            throw zzat.zzb("framing bit expected to be set", null);
        }
        return new zzaep(strZzK, strArr, length2 + 1);
    }

    @Nullable
    public static zzap zzc(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = (String) list.get(i2);
            String str2 = zzep.zza;
            String[] strArrSplit = str.split(C2300e4.i.f8399b, 2);
            if (strArrSplit.length != 2) {
                zzdt.zzc("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzagd.zzb(new zzeg(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e) {
                    zzdt.zzd("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzahb(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzap(arrayList);
    }

    public static boolean zzd(int i2, zzeg zzegVar, boolean z2) throws zzat {
        if (zzegVar.zzd() < 7) {
            if (z2) {
                return false;
            }
            int iZzd = zzegVar.zzd();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzd).length() + 18);
            sb.append("too short header: ");
            sb.append(iZzd);
            throw zzat.zzb(sb.toString(), null);
        }
        if (zzegVar.zzs() != i2) {
            if (z2) {
                return false;
            }
            throw zzat.zzb("expected header type ".concat(String.valueOf(Integer.toHexString(i2))), null);
        }
        if (zzegVar.zzs() == 118 && zzegVar.zzs() == 111 && zzegVar.zzs() == 114 && zzegVar.zzs() == 98 && zzegVar.zzs() == 105 && zzegVar.zzs() == 115) {
            return true;
        }
        if (z2) {
            return false;
        }
        throw zzat.zzb("expected characters 'vorbis'", null);
    }
}
