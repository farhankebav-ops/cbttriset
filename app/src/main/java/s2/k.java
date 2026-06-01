package s2;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzen;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends zzeh implements zzfn {
    private static final k zzb;
    private byte zzA = 2;
    private int zzd;
    private int zze;
    private zzdf zzf;
    private String zzg;
    private c zzh;
    private int zzi;
    private o zzj;
    private q zzk;
    private zzco zzl;
    private f zzm;
    private i zzn;
    private h zzo;
    private s zzp;
    private n zzq;
    private p zzr;
    private l zzs;
    private zzeo zzt;
    private zzen zzu;
    private String zzv;
    private zzeo zzw;
    private boolean zzx;
    private double zzy;
    private zzdf zzz;

    static {
        k kVar = new k();
        zzb = kVar;
        zzeh.zzV(k.class, kVar);
    }

    public k() {
        zzdf zzdfVar = zzdf.zzb;
        this.zzf = zzdfVar;
        this.zzg = "";
        this.zzt = zzeh.zzP();
        this.zzu = zzeh.zzO();
        this.zzv = "";
        this.zzw = zzeh.zzP();
        this.zzx = true;
        this.zzz = zzdfVar;
    }

    public static /* synthetic */ void n(k kVar, int i2, e eVar) {
        eVar.getClass();
        zzeo zzeoVar = kVar.zzt;
        if (!zzeoVar.zzc()) {
            kVar.zzt = zzeh.zzQ(zzeoVar);
        }
        kVar.zzt.set(i2, eVar);
    }

    public final int a() {
        int iW = n7.b.W(this.zzi);
        if (iW == 0) {
            return 1;
        }
        return iW;
    }

    public final int b() {
        return this.zzt.size();
    }

    public final n c() {
        n nVar = this.zzq;
        return nVar == null ? n.c() : nVar;
    }

    public final o d() {
        o oVar = this.zzj;
        return oVar == null ? o.a() : oVar;
    }

    public final p e() {
        p pVar = this.zzr;
        return pVar == null ? p.a() : pVar;
    }

    public final q f() {
        q qVar = this.zzk;
        return qVar == null ? q.a() : qVar;
    }

    public final s g() {
        s sVar = this.zzp;
        return sVar == null ? s.c() : sVar;
    }

    public final f h() {
        f fVar = this.zzm;
        return fVar == null ? f.a() : fVar;
    }

    public final h i() {
        h hVar = this.zzo;
        return hVar == null ? h.a() : hVar;
    }

    public final i j() {
        i iVar = this.zzn;
        return iVar == null ? i.a() : iVar;
    }

    public final zzdf k() {
        return this.zzf;
    }

    public final String l() {
        return this.zzg;
    }

    public final zzeo m() {
        return this.zzt;
    }

    public final boolean o() {
        return (this.zzd & 4096) != 0;
    }

    public final boolean p() {
        return (this.zzd & 32) != 0;
    }

    public final boolean q() {
        return (this.zzd & 8192) != 0;
    }

    public final boolean r() {
        return (this.zzd & 64) != 0;
    }

    public final boolean s() {
        return (this.zzd & 2048) != 0;
    }

    public final boolean t() {
        return (this.zzd & 128) != 0;
    }

    public final boolean u() {
        return (this.zzd & 256) != 0;
    }

    public final boolean v() {
        return (this.zzd & 1024) != 0;
    }

    public final boolean w() {
        return (this.zzd & 512) != 0;
    }

    public final int x() {
        int iA0 = a.a.a0(this.zze);
        if (iA0 == 0) {
            return 1;
        }
        return iA0;
    }

    public final zzco zzb() {
        zzco zzcoVar = this.zzl;
        return zzcoVar == null ? zzco.zzb() : zzcoVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i2, Object obj, Object obj2) {
        int i8 = i2 - 1;
        if (i8 == 0) {
            return Byte.valueOf(this.zzA);
        }
        if (i8 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0016\u0000\u0001\u0001\u0017\u0016\u0000\u0003\u000b\u0001ᴌ\u0000\u0002ᔊ\u0001\u0003ᔈ\u0002\u0004ᴌ\u0004\u0005ᐉ\u0005\u0006ဉ\u0006\u0007ဉ\u0007\bᐉ\b\tᐉ\t\nᐉ\n\u000bЛ\fဈ\u000f\rЛ\u000eည\u0012\u000fᐉ\u000b\u0010ဉ\f\u0011ဉ\r\u0012\u0016\u0013ဉ\u000e\u0014ဇ\u0010\u0015က\u0011\u0017ဉ\u0003", new Object[]{"zzd", "zze", g.f13680d, "zzf", "zzg", "zzi", g.e, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzt", e.class, "zzv", "zzw", e.class, "zzz", "zzp", "zzq", "zzr", "zzu", "zzs", "zzx", "zzy", "zzh"});
        }
        if (i8 == 3) {
            return new k();
        }
        if (i8 == 4) {
            return new j(zzb);
        }
        if (i8 == 5) {
            return zzb;
        }
        this.zzA = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
