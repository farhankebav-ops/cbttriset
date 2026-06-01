package d2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends zzeh implements zzfn {
    private static final a zzb;
    private int zzd;
    private i zze;
    private c zzf;
    private m zzg;

    static {
        a aVar = new a();
        zzb = aVar;
        zzeh.zzV(a.class, aVar);
    }

    public static j a() {
        return (j) zzb.zzG();
    }

    public static /* synthetic */ void b(a aVar, i iVar) {
        iVar.getClass();
        aVar.zze = iVar;
        aVar.zzd |= 1;
    }

    public static /* synthetic */ void c(a aVar, c cVar) {
        cVar.getClass();
        aVar.zzf = cVar;
        aVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i8 == 3) {
            return new a();
        }
        if (i8 == 4) {
            return new j(zzb);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
