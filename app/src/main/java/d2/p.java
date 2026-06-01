package d2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class p extends zzeh implements zzfn {
    private static final p zzb;

    static {
        p pVar = new p();
        zzb = pVar;
        zzeh.zzV(p.class, pVar);
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
            return new p();
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
