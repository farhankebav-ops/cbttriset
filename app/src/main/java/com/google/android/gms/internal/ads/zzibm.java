package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzibm extends zzhwo implements zzhya {
    private static final zzibm zzh;
    private static volatile zzhyh zzi;
    private int zza;
    private zzibl zzb;
    private zzhvi zzd;
    private zzhvi zze;
    private int zzf;
    private byte zzg = 2;
    private zzhxa zzc = zzhwo.zzbM();

    static {
        zzibm zzibmVar = new zzibm();
        zzh = zzibmVar;
        zzhwo.zzbu(zzibm.class, zzibmVar);
    }

    private zzibm() {
        zzhvi zzhviVar = zzhvi.zzb;
        this.zzd = zzhviVar;
        this.zze = zzhviVar;
    }

    public static zzibj zzc() {
        return (zzibj) zzh.zzbn();
    }

    public final /* synthetic */ void zzd(zzibi zzibiVar) {
        zzibiVar.getClass();
        zzhxa zzhxaVar = this.zzc;
        if (!zzhxaVar.zza()) {
            this.zzc = zzhwo.zzbN(zzhxaVar);
        }
        this.zzc.add(zzibiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    public final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        byte[] bArr = null;
        switch (zzhwnVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzg);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzg = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzhwo.zzbv(zzh, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zza", "zzb", "zzc", zzibi.class, "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzibm();
            case NEW_BUILDER:
                return new zzibj(bArr);
            case GET_DEFAULT_INSTANCE:
                return zzh;
            case GET_PARSER:
                zzhyh zzhyhVar = zzi;
                if (zzhyhVar != null) {
                    return zzhyhVar;
                }
                synchronized (zzibm.class) {
                    try {
                        zzhwjVar = zzi;
                        if (zzhwjVar == null) {
                            zzhwjVar = new zzhwj(zzh);
                            zzi = zzhwjVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return zzhwjVar;
            default:
                throw null;
        }
    }
}
