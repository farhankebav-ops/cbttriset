package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzarw implements zzaru {
    private int zza = (((((~1539942439) & 2070175971) | 1100945533) + ((1539942439 & (-1166483302)) | (-2145608135))) - 96382817) ^ (1143565421 % 981914693);
    private final byte[] zzb = new byte[(((((~991039875) & 475472926) | 1225689584) + ((991039875 & 357672014) | 1805818736)) - (-1256743880)) ^ (1671581032 % 1337434154)];
    private final zzary zzc;

    public zzarw(zzary zzaryVar) {
        this.zzc = zzaryVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final byte zza(zzasg zzasgVar, int i2) {
        int i8 = ((((~1264448664) & 231739608) | 1128901767) + ((1264448664 & 479203675) | 860794247)) - 1823332376;
        int i9 = 1761855727 % 1384724137;
        int i10 = (((((~143154913) & 992498304) | 439467622) + ((143154913 & 1627930754) | 1212551295)) - (-2089988634)) ^ (2033018190 % 70061690);
        int i11 = ((((~1661299468) & 613450408) | 2017391535) + ((1661299468 & 109051904) | 2071555381)) - (-441392543);
        int i12 = 1694830070 % 1383960411;
        int i13 = i2 >>> i10;
        if (i13 != this.zza) {
            this.zzc.zza(i13, this.zzb);
            this.zza = i13;
        }
        int i14 = i11 ^ i12;
        return (byte) (((zzasgVar.zzb(i2) ^ this.zzb[i2 % (i8 ^ i9)]) << i14) >> i14);
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final zzasg zzb(zzasg zzasgVar, int i2, int i8) {
        if (i2 < 0 || i2 > i8 || i8 > zzasgVar.zza.length) {
            throw new IndexOutOfBoundsException();
        }
        byte[] bArr = new byte[i8 - i2];
        int i9 = 0;
        while (i2 < i8) {
            bArr[i9] = zza(zzasgVar, i2);
            i2++;
            i9++;
        }
        return zzasg.zze(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final /* bridge */ /* synthetic */ zzaru zzc() {
        return new zzarw(this.zzc);
    }
}
