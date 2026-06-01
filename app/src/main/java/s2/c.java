package s2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends zzeh implements zzfn {
    private static final c zzb;
    private zzeo zzd = zzeh.zzP();

    static {
        c cVar = new c();
        zzb = cVar;
        zzeh.zzV(c.class, cVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", b.class});
        }
        if (i8 == 3) {
            return new c();
        }
        if (i8 == 4) {
            return new d2.k(zzb);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
