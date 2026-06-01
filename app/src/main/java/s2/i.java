package s2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends zzeh implements zzfn {
    private static final i zzb;
    private int zzd;
    private int zzf;
    private boolean zzh;
    private byte zzi = 2;
    private String zze = "";
    private String zzg = "";

    static {
        i iVar = new i();
        zzb = iVar;
        zzeh.zzV(i.class, iVar);
    }

    public static i a() {
        return zzb;
    }

    public final int b() {
        int i2;
        int i8 = this.zzf;
        if (i8 != 0) {
            i2 = 2;
            if (i8 != 1) {
                if (i8 != 2) {
                    i2 = 4;
                    if (i8 != 3) {
                        i2 = i8 != 4 ? 0 : 5;
                    }
                } else {
                    i2 = 3;
                }
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
        return this.zzg;
    }

    public final String zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ᔈ\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", g.f13679c, "zzg", "zzh"});
        }
        if (i8 == 3) {
            return new i();
        }
        if (i8 == 4) {
            return new d2.k(zzb);
        }
        if (i8 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
