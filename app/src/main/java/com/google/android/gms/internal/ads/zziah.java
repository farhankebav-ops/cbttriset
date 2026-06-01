package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zziah implements zzhwu {
    static final zzhwu zza = new zziah();

    private zziah() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwu
    public final boolean zza(int i2) {
        if (i2 != 0 && i2 != 1 && i2 != 2 && i2 != 1999) {
            switch (i2) {
                case 1000:
                case 1001:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case 1006:
                case 1007:
                case 1008:
                case 1009:
                case 1010:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
