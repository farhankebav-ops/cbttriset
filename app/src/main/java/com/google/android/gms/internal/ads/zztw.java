package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zztw implements zzvn {
    private final zzadg zza;

    @Nullable
    private zzada zzb;

    @Nullable
    private zzadb zzc;

    public zztw(zzadg zzadgVar) {
        this.zza = zzadgVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // com.google.android.gms.internal.ads.zzvn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzj r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzadd r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzacr r1 = new com.google.android.gms.internal.ads.zzacr
            r2 = r8
            r3 = r11
            r5 = r13
            r1.<init>(r2, r3, r5)
            r7.zzc = r1
            com.google.android.gms.internal.ads.zzada r8 = r7.zzb
            if (r8 == 0) goto Lf
            return
        Lf:
            com.google.android.gms.internal.ads.zzadg r8 = r7.zza
            com.google.android.gms.internal.ads.zzada[] r8 = r8.zzb(r9, r10)
            int r10 = r8.length
            com.google.android.gms.internal.ads.zzgpb r11 = com.google.android.gms.internal.ads.zzgpe.zzv(r10)
            r12 = 0
            r13 = 1
            if (r10 != r13) goto L23
            r8 = r8[r12]
            r7.zzb = r8
            goto L7f
        L23:
            r14 = r12
        L24:
            if (r14 >= r10) goto L7b
            r0 = r8[r14]
            boolean r2 = r0.zza(r1)     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L6b
            if (r2 == 0) goto L3a
            r7.zzb = r0     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L6b
            com.google.android.gms.internal.ads.zzgmd.zzh(r13)
            r1.zzl()
            goto L7b
        L37:
            r0 = move-exception
            r8 = r0
            goto L57
        L3a:
            java.util.List r0 = r0.zzb()     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L6b
            r11.zzh(r0)     // Catch: java.lang.Throwable -> L37 java.io.EOFException -> L6b
            com.google.android.gms.internal.ads.zzada r0 = r7.zzb
            if (r0 != 0) goto L4d
            long r5 = r1.zzn()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L4f
        L4d:
            r0 = r13
            goto L50
        L4f:
            r0 = r12
        L50:
            com.google.android.gms.internal.ads.zzgmd.zzh(r0)
            r1.zzl()
            goto L78
        L57:
            com.google.android.gms.internal.ads.zzada r9 = r7.zzb
            if (r9 != 0) goto L63
            long r9 = r1.zzn()
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 != 0) goto L64
        L63:
            r12 = r13
        L64:
            com.google.android.gms.internal.ads.zzgmd.zzh(r12)
            r1.zzl()
            throw r8
        L6b:
            com.google.android.gms.internal.ads.zzada r0 = r7.zzb
            if (r0 != 0) goto L4d
            long r5 = r1.zzn()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L4f
            goto L4d
        L78:
            int r14 = r14 + 1
            goto L24
        L7b:
            com.google.android.gms.internal.ads.zzada r10 = r7.zzb
            if (r10 == 0) goto L85
        L7f:
            com.google.android.gms.internal.ads.zzada r8 = r7.zzb
            r8.zzc(r15)
            return
        L85:
            com.google.android.gms.internal.ads.zzww r10 = new com.google.android.gms.internal.ads.zzww
            com.google.android.gms.internal.ads.zzgpe r8 = com.google.android.gms.internal.ads.zzgpe.zzr(r8)
            com.google.android.gms.internal.ads.zztv r12 = com.google.android.gms.internal.ads.zztv.zza
            java.util.List r8 = com.google.android.gms.internal.ads.zzgqe.zzc(r8, r12)
            java.lang.String r12 = ", "
            java.lang.String r8 = com.google.android.gms.internal.ads.zzglx.zzd(r8, r12)
            int r12 = r8.length()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            int r12 = r12 + 58
            r13.<init>(r12)
            java.lang.String r12 = "None of the available extractors ("
            java.lang.String r14 = ") could read the stream."
            java.lang.String r8 = a1.a.s(r13, r12, r8, r14)
            com.google.android.gms.internal.ads.zzgpe r11 = r11.zzi()
            r10.<init>(r8, r9, r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztw.zza(com.google.android.gms.internal.ads.zzj, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzadd):void");
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzb() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzc() {
        zzada zzadaVar = this.zzb;
        if (zzadaVar != null && (zzadaVar instanceof zzahs)) {
            ((zzahs) zzadaVar).zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final long zzd() {
        zzadb zzadbVar = this.zzc;
        if (zzadbVar != null) {
            return zzadbVar.zzn();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zze(long j, long j3) {
        zzada zzadaVar = this.zzb;
        zzadaVar.getClass();
        zzadaVar.zze(j, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final int zzf(zzaea zzaeaVar) throws IOException {
        zzadb zzadbVar;
        zzada zzadaVar = this.zzb;
        if (zzadaVar == null || (zzadbVar = this.zzc) == null) {
            throw null;
        }
        return zzadaVar.zzd(zzadbVar, zzaeaVar);
    }
}
