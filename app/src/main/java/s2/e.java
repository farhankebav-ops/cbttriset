package s2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends zzeh implements zzfn {
    private static final e zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        e eVar = new e();
        zzb = eVar;
        zzeh.zzV(e.class, eVar);
    }

    public static d c() {
        return (d) zzb.zzG();
    }

    public static /* synthetic */ void d(int i2, e eVar) {
        eVar.zzd |= 1;
        eVar.zze = i2;
    }

    public static /* synthetic */ void e(int i2, e eVar) {
        eVar.zzd |= 2;
        eVar.zzf = i2;
    }

    public final int a() {
        return this.zze;
    }

    public final int b() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i8 == 3) {
            return new e();
        }
        if (i8 == 4) {
            return new d(zzb);
        }
        if (i8 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
