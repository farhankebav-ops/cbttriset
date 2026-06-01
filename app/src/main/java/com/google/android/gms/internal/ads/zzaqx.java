package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import com.ironsource.G5;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzaqx extends zzapu {
    private final Object zza;

    @Nullable
    @GuardedBy("mLock")
    private final zzapz zzb;

    public zzaqx(int i2, String str, zzapz zzapzVar, @Nullable zzapy zzapyVar) {
        super(i2, str, zzapyVar);
        this.zza = new Object();
        this.zzb = zzapzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    public final zzaqa zzr(zzapq zzapqVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzapqVar.zzb;
            Map map = zzapqVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
                String[] strArrSplit = str2.split(";", 0);
                int i2 = 1;
                while (true) {
                    if (i2 >= strArrSplit.length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i2].trim().split(C2300e4.i.f8399b, 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals(G5.M)) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                    i2++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapqVar.zzb);
        }
        return zzaqa.zza(str, zzaqr.zza(zzapqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzapu
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzs(String str) {
        zzapz zzapzVar;
        synchronized (this.zza) {
            zzapzVar = this.zzb;
        }
        zzapzVar.zza(str);
    }
}
