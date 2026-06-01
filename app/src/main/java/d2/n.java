package d2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends zzeh implements zzfn {
    private static final n zzb;

    static {
        n nVar = new n();
        zzb = nVar;
        zzeh.zzV(n.class, nVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0000", null);
        }
        if (i8 == 3) {
            return new n();
        }
        if (i8 == 4) {
            return new k(zzb);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
