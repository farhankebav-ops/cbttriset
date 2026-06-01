package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgn extends zzmf implements zznn {
    private static final zzgn zzd;
    private zzmo zzb = zzmf.zzcv();

    static {
        zzgn zzgnVar = new zzgn();
        zzd = zzgnVar;
        zzmf.zzcp(zzgn.class, zzgnVar);
    }

    private zzgn() {
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzmf.zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i8 == 3) {
            return new zzgn();
        }
        byte[] bArr = null;
        if (i8 == 4) {
            return new zzgm(bArr);
        }
        if (i8 == 5) {
            return zzd;
        }
        throw null;
    }
}
