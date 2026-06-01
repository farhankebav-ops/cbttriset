package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzes implements zzao {
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzes(java.lang.String r5, byte[] r6, int r7, int r8) {
        /*
            r4 = this;
            r4.<init>()
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1949883051: goto L5e;
                case -269399509: goto L41;
                case 1011693540: goto L28;
                case 1098277265: goto L1f;
                case 2002123038: goto Le;
                default: goto Lc;
            }
        Lc:
            goto L75
        Le:
            java.lang.String r0 = "auxiliary.tracks.map"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
            if (r8 != 0) goto L19
            goto L1a
        L19:
            r1 = r2
        L1a:
            com.google.android.gms.internal.ads.zzgmd.zza(r1)
            goto L75
        L1f:
            java.lang.String r0 = "auxiliary.tracks.offset"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
            goto L30
        L28:
            java.lang.String r0 = "auxiliary.tracks.length"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
        L30:
            r0 = 78
            if (r8 != r0) goto L3c
            int r8 = r6.length
            r3 = 8
            if (r8 != r3) goto L3b
            r8 = r0
            goto L3d
        L3b:
            r8 = r0
        L3c:
            r1 = r2
        L3d:
            com.google.android.gms.internal.ads.zzgmd.zza(r1)
            goto L75
        L41:
            java.lang.String r0 = "auxiliary.tracks.interleaved"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
            r0 = 75
            if (r8 != r0) goto L59
            int r8 = r6.length
            if (r8 != r1) goto L58
            r8 = r6[r2]
            if (r8 == 0) goto L56
            if (r8 != r1) goto L58
        L56:
            r8 = r0
            goto L5a
        L58:
            r8 = r0
        L59:
            r1 = r2
        L5a:
            com.google.android.gms.internal.ads.zzgmd.zza(r1)
            goto L75
        L5e:
            java.lang.String r0 = "com.android.capture.fps"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L75
            r0 = 23
            if (r8 != r0) goto L71
            int r8 = r6.length
            r3 = 4
            if (r8 != r3) goto L70
            r8 = r0
            goto L72
        L70:
            r8 = r0
        L71:
            r1 = r2
        L72:
            com.google.android.gms.internal.ads.zzgmd.zza(r1)
        L75:
            r4.zza = r5
            r4.zzb = r6
            r4.zzc = r7
            r4.zzd = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzes.<init>(java.lang.String, byte[], int, int):void");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzes.class == obj.getClass()) {
            zzes zzesVar = (zzes) obj;
            if (this.zza.equals(zzesVar.zza) && Arrays.equals(this.zzb, zzesVar.zzb) && this.zzc == zzesVar.zzc && this.zzd == zzesVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        return ((((Arrays.hashCode(this.zzb) + (iHashCode * 31)) * 31) + this.zzc) * 31) + this.zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzes.toString():java.lang.String");
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final /* synthetic */ void zza(zzam zzamVar) {
        g.a(this, zzamVar);
    }

    public final List zzb() {
        zzgmd.zzi(this.zza.equals("auxiliary.tracks.map"), "Metadata is not an auxiliary tracks map");
        byte[] bArr = this.zzb;
        byte b8 = bArr[1];
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < b8; i2++) {
            arrayList.add(Integer.valueOf(bArr[i2 + 2]));
        }
        return arrayList;
    }
}
