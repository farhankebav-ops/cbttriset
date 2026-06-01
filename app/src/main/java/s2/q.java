package s2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends zzeh implements zzfn {
    private static final q zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        q qVar = new q();
        zzb = qVar;
        zzeh.zzV(q.class, qVar);
    }

    public static q a() {
        return zzb;
    }

    public final int b() {
        int i2;
        int i8 = this.zze;
        if (i8 != 0) {
            i2 = 2;
            if (i8 != 1) {
                i2 = i8 != 2 ? 0 : 3;
            }
        } else {
            i2 = 1;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzh;
    }

    public final String zze() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", g.f13681f, "zzf", "zzg", "zzh"});
        }
        if (i8 == 3) {
            return new q();
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
