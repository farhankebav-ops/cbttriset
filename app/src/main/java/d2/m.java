package d2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends zzeh implements zzfn {
    private static final m zzb;
    private zzeo zzd = zzeh.zzP();
    private zzeo zze = zzeh.zzP();

    static {
        m mVar = new m();
        zzb = mVar;
        zzeh.zzV(m.class, mVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", l.class, "zze", l.class});
        }
        if (i8 == 3) {
            return new m();
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
