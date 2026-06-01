package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeu extends zzew {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzeu(int i2, long j) {
        super(i2, null);
        this.zza = j;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final String toString() {
        List list = this.zzb;
        String strZze = zzew.zze(this.zzd);
        String string = Arrays.toString(list.toArray());
        String string2 = Arrays.toString(this.zzc.toArray());
        int length = strZze.length();
        StringBuilder sb = new StringBuilder(length + 9 + String.valueOf(string).length() + 13 + String.valueOf(string2).length());
        androidx.camera.core.processing.util.a.A(sb, strZze, " leaves: ", string, " containers: ");
        sb.append(string2);
        return sb.toString();
    }

    public final void zza(zzev zzevVar) {
        this.zzb.add(zzevVar);
    }

    public final void zzb(zzeu zzeuVar) {
        this.zzc.add(zzeuVar);
    }

    @Nullable
    public final zzev zzc(int i2) {
        List list = this.zzb;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            zzev zzevVar = (zzev) list.get(i8);
            if (zzevVar.zzd == i2) {
                return zzevVar;
            }
        }
        return null;
    }

    @Nullable
    public final zzeu zzd(int i2) {
        List list = this.zzc;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            zzeu zzeuVar = (zzeu) list.get(i8);
            if (zzeuVar.zzd == i2) {
                return zzeuVar;
            }
        }
        return null;
    }
}
