package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzasy implements Comparator {
    private final boolean zza;

    public zzasy(boolean z2) {
        this.zza = z2;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparator comparatorZza;
        Object objZzn;
        Object objZzn2;
        int[] iArr = {446703183, 1862618146, 1081639777, -1087935358, -803036955, 1104011716, 5522510, 2017461929, 496612959};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        int i15 = i14 % 496612959;
        zzatc zzatcVar = (zzatc) obj;
        zzatc zzatcVar2 = (zzatc) obj2;
        int i16 = zzatcVar.zza;
        if (i16 != zzatcVar2.zza) {
            throw new IllegalArgumentException();
        }
        int i17 = i15 ^ iC;
        try {
            if (i16 == 0) {
                throw null;
            }
            switch (i16 + i17) {
                case 0:
                    return 0;
                case 1:
                    if (this.zza) {
                        return zzatcVar.zzl() != zzatcVar2.zzl() ? 1 : 0;
                    }
                    throw new IllegalArgumentException();
                case 2:
                    return Long.compare(zzatcVar.zzm(), zzatcVar2.zzm());
                case 3:
                    comparatorZza = zzasg.zzc;
                    objZzn = zzatcVar.zzn();
                    objZzn2 = zzatcVar2.zzn();
                    break;
                case 4:
                    objZzn = zzatcVar.zzo();
                    objZzn2 = zzatcVar2.zzo();
                    comparatorZza = zzgoq.zza(this);
                    break;
                case 5:
                    if (this.zza) {
                        return zzatcVar.zzp() != zzatcVar2.zzp() ? 1 : 0;
                    }
                    throw new IllegalArgumentException();
                case 6:
                    return Double.compare(zzatcVar.zzq(), zzatcVar2.zzq());
                default:
                    return 0;
            }
            return comparatorZza.compare(objZzn, objZzn2);
        } catch (zzasz e) {
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        }
    }
}
