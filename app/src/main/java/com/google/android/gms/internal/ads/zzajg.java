package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzajg {
    public final boolean zza;

    @Nullable
    public final String zzb;
    public final zzael zzc;
    public final int zzd;

    @Nullable
    public final byte[] zze;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzajg(boolean r4, @androidx.annotation.Nullable java.lang.String r5, int r6, byte[] r7, int r8, int r9, @androidx.annotation.Nullable byte[] r10) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L9
            r2 = r1
            goto La
        L9:
            r2 = r0
        La:
            if (r10 != 0) goto Ld
            r0 = r1
        Ld:
            r0 = r0 ^ r2
            com.google.android.gms.internal.ads.zzgmd.zza(r0)
            r3.zza = r4
            r3.zzb = r5
            r3.zzd = r6
            r3.zze = r10
            com.google.android.gms.internal.ads.zzael r4 = new com.google.android.gms.internal.ads.zzael
            if (r5 != 0) goto L1e
            goto L6c
        L1e:
            int r6 = r5.hashCode()
            switch(r6) {
                case 3046605: goto L41;
                case 3046671: goto L38;
                case 3049879: goto L2f;
                case 3049895: goto L26;
                default: goto L25;
            }
        L25:
            goto L4b
        L26:
            java.lang.String r6 = "cens"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L4b
            goto L6c
        L2f:
            java.lang.String r6 = "cenc"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L4b
            goto L6c
        L38:
            java.lang.String r6 = "cbcs"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L4b
            goto L49
        L41:
            java.lang.String r6 = "cbc1"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L4b
        L49:
            r1 = 2
            goto L6c
        L4b:
            int r6 = r5.length()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            int r6 = r6 + 68
            r10.<init>(r6)
            java.lang.String r6 = "Unsupported protection scheme type '"
            r10.append(r6)
            r10.append(r5)
            java.lang.String r5 = "'. Assuming AES-CTR crypto mode."
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            java.lang.String r6 = "TrackEncryptionBox"
            com.google.android.gms.internal.ads.zzdt.zzc(r6, r5)
        L6c:
            r4.<init>(r1, r7, r8, r9)
            r3.zzc = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajg.<init>(boolean, java.lang.String, int, byte[], int, int, byte[]):void");
    }
}
