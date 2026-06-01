package d2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends zzeh implements zzfn {
    private static final l zzb;
    private int zzd = 0;
    private Object zze;

    static {
        l lVar = new l();
        zzb = lVar;
        zzeh.zzV(l.class, lVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zze", "zzd", n.class, p.class, o.class});
        }
        if (i8 == 3) {
            return new l();
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
