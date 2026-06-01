package s2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends zzeh implements zzfn {
    private static final n zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private m zzj;
    private m zzk;

    static {
        n nVar = new n();
        zzb = nVar;
        zzeh.zzV(n.class, nVar);
    }

    public static n c() {
        return zzb;
    }

    public final m a() {
        m mVar = this.zzk;
        return mVar == null ? m.e() : mVar;
    }

    public final m b() {
        m mVar = this.zzj;
        return mVar == null ? m.e() : mVar;
    }

    public final String zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i8 == 3) {
            return new n();
        }
        if (i8 == 4) {
            return new d2.k(zzb);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final String zzi() {
        return this.zzi;
    }

    public final String zzj() {
        return this.zze;
    }
}
