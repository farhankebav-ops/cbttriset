package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzama implements zzaki {
    private final zzeg zza = new zzeg();
    private final zzalr zzb = new zzalr();

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i2, int i8, zzakh zzakhVar, zzdg zzdgVar) {
        zzeg zzegVar = this.zza;
        zzegVar.zzb(bArr, i8 + i2);
        zzegVar.zzh(i2);
        ArrayList arrayList = new ArrayList();
        try {
            int iZzg = zzegVar.zzg();
            Charset charset = StandardCharsets.UTF_8;
            String strZzN = zzegVar.zzN(charset);
            if (strZzN == null || !strZzN.startsWith("WEBVTT")) {
                zzegVar.zzh(iZzg);
                throw zzat.zzb("Expected WEBVTT. Got ".concat(String.valueOf(zzegVar.zzN(charset))), null);
            }
            while (!TextUtils.isEmpty(zzegVar.zzN(StandardCharsets.UTF_8))) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                byte b8 = -1;
                int iZzg2 = 0;
                while (b8 == -1) {
                    iZzg2 = zzegVar.zzg();
                    String strZzN2 = zzegVar.zzN(StandardCharsets.UTF_8);
                    b8 = strZzN2 == null ? (byte) 0 : "STYLE".equals(strZzN2) ? (byte) 2 : strZzN2.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                }
                zzegVar.zzh(iZzg2);
                if (b8 == 0) {
                    zzakc.zza(new zzamd(arrayList2), zzakhVar, zzdgVar);
                    return;
                }
                if (b8 == 1) {
                    while (!TextUtils.isEmpty(zzegVar.zzN(StandardCharsets.UTF_8))) {
                    }
                } else if (b8 != 2) {
                    zzalt zzaltVarZza = zzalz.zza(zzegVar, arrayList);
                    if (zzaltVarZza != null) {
                        arrayList2.add(zzaltVarZza);
                    }
                } else {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    zzegVar.zzN(StandardCharsets.UTF_8);
                    arrayList.addAll(this.zzb.zza(zzegVar));
                }
            }
        } catch (zzat e) {
            throw new IllegalArgumentException(e);
        }
    }
}
