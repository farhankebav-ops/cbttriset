package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqm extends zzch {

    @Nullable
    private int[] zzd;

    @Nullable
    private int[] zze;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ed  */
    @Override // com.google.android.gms.internal.ads.zzcg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(java.nio.ByteBuffer r17) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqm.zzd(java.nio.ByteBuffer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final zzcd zzm(zzcd zzcdVar) throws zzcf {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzcd.zza;
        }
        int i2 = zzcdVar.zzd;
        if (!zzep.zzA(i2)) {
            throw new zzcf("Unhandled input format:", zzcdVar);
        }
        int i8 = zzcdVar.zzc;
        boolean z2 = i8 != iArr.length;
        int i9 = 0;
        while (true) {
            int length = iArr.length;
            if (i9 >= length) {
                return z2 ? new zzcd(zzcdVar.zzb, length, i2) : zzcd.zza;
            }
            int i10 = iArr[i9];
            if (i10 >= i8) {
                String string = Arrays.toString(iArr);
                throw new zzcf(a1.a.s(new StringBuilder(String.valueOf(string).length() + 59), "Channel map (", string, ") trying to access non-existent input channel."), zzcdVar);
            }
            z2 |= i10 != i9;
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final void zzo() {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final void zzp() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzq(@Nullable int[] iArr) {
        this.zzd = iArr;
    }
}
