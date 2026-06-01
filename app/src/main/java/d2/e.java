package d2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzem;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends zzeh implements zzfn {
    private static final e zzb;
    private int zzd;
    private zzem zze = zzeh.zzM();
    private zzem zzf = zzeh.zzM();
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        e eVar = new e();
        zzb = eVar;
        zzeh.zzV(e.class, eVar);
    }

    public static d a() {
        return (d) zzb.zzG();
    }

    public static /* synthetic */ void b(e eVar, int i2) {
        eVar.zzd |= 2;
        eVar.zzh = i2;
    }

    public static /* synthetic */ void c(e eVar, float f4) {
        zzem zzemVar = eVar.zze;
        if (!zzemVar.zzc()) {
            eVar.zze = zzeh.zzN(zzemVar);
        }
        eVar.zze.zzh(f4);
    }

    public static /* synthetic */ void d(e eVar, float f4) {
        zzem zzemVar = eVar.zzf;
        if (!zzemVar.zzc()) {
            eVar.zzf = zzeh.zzN(zzemVar);
        }
        eVar.zzf.zzh(f4);
    }

    public static /* synthetic */ void e(e eVar, int i2) {
        eVar.zzd |= 1;
        eVar.zzg = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0006ဋ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i8 == 3) {
            return new e();
        }
        if (i8 == 4) {
            return new d(zzb);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
