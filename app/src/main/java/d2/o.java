package d2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class o extends zzeh implements zzfn {
    private static final o zzb;
    private int zzd;
    private zzhk zzf;
    private zzdf zze = zzdf.zzb;
    private int zzg = 1;
    private float zzh = 0.75f;
    private boolean zzi = true;

    static {
        o oVar = new o();
        zzb = oVar;
        zzeh.zzV(o.class, oVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ည\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ခ\u0003\u0005ဇ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i8 == 3) {
            return new o();
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
