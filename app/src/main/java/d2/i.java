package d2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhk;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends zzeh implements zzfn {
    private static final i zzb;
    private int zzd;
    private g zzj;
    private zzhk zzl;
    private String zze = "";
    private zzdf zzf = zzdf.zzb;
    private int zzg = 10;
    private float zzh = 0.5f;
    private float zzi = 0.05f;
    private int zzk = 1;
    private int zzm = Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE;
    private int zzn = 4;
    private int zzo = 2;

    static {
        i iVar = new i();
        zzb = iVar;
        zzeh.zzV(i.class, iVar);
    }

    public static h a() {
        return (h) zzb.zzG();
    }

    public static /* synthetic */ void b(i iVar, g gVar) {
        gVar.getClass();
        iVar.zzj = gVar;
        iVar.zzd |= 32;
    }

    public static /* synthetic */ void c(i iVar, zzdf zzdfVar) {
        zzdfVar.getClass();
        iVar.zzd |= 2;
        iVar.zzf = zzdfVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u000b\u0000\u0001\u0001\f\u000b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ဉ\u0005\bင\u0006\tဉ\u0007\nင\b\u000bင\t\fင\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
        }
        if (i8 == 3) {
            return new i();
        }
        if (i8 == 4) {
            return new h(zzb);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
