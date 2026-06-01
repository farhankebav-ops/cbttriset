package s2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends zzeh implements zzfn {
    private static final a zzb;
    private int zzd;
    private int zzf;
    private byte zzi = 2;
    private zzeo zze = zzeh.zzP();
    private String zzg = "";
    private zzdf zzh = zzdf.zzb;

    static {
        a aVar = new a();
        zzb = aVar;
        zzeh.zzV(a.class, aVar);
    }

    public static a a(byte[] bArr, zzds zzdsVar) {
        return (a) zzeh.zzL(zzb, bArr, zzdsVar);
    }

    public final zzeo b() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0002\u0001Л\u0002ᴌ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", k.class, "zzf", g.f13678b, "zzg", "zzh"});
        }
        if (i8 == 3) {
            return new a();
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
