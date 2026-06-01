package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgvs implements zzgwf {
    private static final Charset zza = Charset.forName(Key.STRING_CHARSET_NAME);
    private final InputStream zzb;

    private zzgvs(InputStream inputStream) {
        this.zzb = inputStream;
    }

    public static zzgvs zza(String str) {
        return new zzgvs(new ByteArrayInputStream(str.getBytes(zza)));
    }

    private static int zzc(zzhtg zzhtgVar) throws IOException {
        if (!(zzhtgVar instanceof zzhtk)) {
            throw new IOException("invalid key id: not a JSON primitive");
        }
        if (!zzhtgVar.zzg().zzc()) {
            throw new IOException("invalid key id: not a JSON number");
        }
        try {
            long jZzc = zzhdv.zzc(zzhtgVar.zzg().zzh());
            if (jZzc > 4294967295L || jZzc < -2147483648L) {
                throw new IOException("invalid key id");
            }
            return (int) jZzc;
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01dc A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0144 A[Catch: all -> 0x0033, IllegalStateException -> 0x0036, zzhtj -> 0x0039, TryCatch #1 {all -> 0x0033, blocks: (B:3:0x0014, B:4:0x0023, B:6:0x002d, B:13:0x003c, B:15:0x0053, B:17:0x005b, B:19:0x0065, B:21:0x006f, B:23:0x007b, B:25:0x0081, B:27:0x008f, B:29:0x0095, B:31:0x009b, B:33:0x00a1, B:35:0x00a9, B:51:0x00eb, B:56:0x0114, B:69:0x0137, B:71:0x0144, B:73:0x014a, B:75:0x0150, B:80:0x0191, B:93:0x01b4, B:84:0x019c, B:88:0x01a7, B:92:0x01b2, B:94:0x01d2, B:95:0x01db, B:96:0x01dc, B:97:0x01e3, B:60:0x011f, B:64:0x012a, B:68:0x0135, B:98:0x01e4, B:99:0x01ed, B:100:0x01ee, B:101:0x01f7, B:102:0x01f8, B:103:0x01ff, B:104:0x0200, B:105:0x0207, B:106:0x0208, B:109:0x0214, B:110:0x021b, B:111:0x021c, B:112:0x0223, B:113:0x0224, B:114:0x022b, B:115:0x022c, B:116:0x0231), top: B:119:0x0014 }] */
    @Override // com.google.android.gms.internal.ads.zzgwf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzhlg zzb() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgvs.zzb():com.google.android.gms.internal.ads.zzhlg");
    }
}
