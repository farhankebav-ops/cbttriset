package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzasx {
    public final zzars zza;
    public final zzast zzb;
    public final zzasq zzc;
    public final zzasl zzd;

    public zzasx(zzars zzarsVar, zzast zzastVar, zzasl zzaslVar) {
        int[] iArr = {343945053, 300943123, 276960570, 1098387973, 1376531620, 1545514151, 271059426, 857490000, 454333378};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        this.zza = zzarsVar;
        this.zzb = zzastVar;
        this.zzd = zzaslVar;
        this.zzc = new zzasq(com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13) ^ (i14 % 454333378));
    }

    public final Optional zza() {
        zzarm zzarmVar;
        try {
            ArrayDeque arrayDeque = this.zzc.zza;
            if (arrayDeque.isEmpty()) {
                throw new zzasp();
            }
            zzasn zzasnVar = (zzasn) arrayDeque.pop();
            long j = zzasnVar.zza;
            long j3 = zzasnVar.zzb;
            long j8 = zzasnVar.zzc;
            zzast zzastVar = this.zzb;
            if (zzastVar.zzb < j3) {
                return Optional.of(zzarm.zzG);
            }
            this.zzd.zza(j);
            if (j8 == 0) {
                while (zzastVar.zzb > j3) {
                    zzastVar.zzc();
                }
            }
            return Optional.empty();
        } catch (zzasj e) {
            e = e;
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        } catch (zzask e4) {
            e = e4;
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        } catch (zzasp unused) {
            zzarmVar = zzarm.zzw;
            return Optional.of(zzarmVar);
        } catch (zzasr unused2) {
            zzarmVar = zzarm.zzG;
            return Optional.of(zzarmVar);
        }
    }
}
