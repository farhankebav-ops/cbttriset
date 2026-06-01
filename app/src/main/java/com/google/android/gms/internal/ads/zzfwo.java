package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfwo implements zzfvh {
    private final q6.a0 zza;
    private final z6.a zzb;
    private final z6.a zzc;
    private final z6.a zzd;
    private boolean zze;
    private zzfvf zzf;
    private boolean zzg;
    private final DataStore zzh;
    private final zzdss zzi;

    public zzfwo(DataStore adQualityDataStore, zzfwq coroutineScopeProvider, zzdss dataPinger, zzfvq clock) {
        kotlin.jvm.internal.k.e(adQualityDataStore, "adQualityDataStore");
        kotlin.jvm.internal.k.e(coroutineScopeProvider, "coroutineScopeProvider");
        kotlin.jvm.internal.k.e(dataPinger, "dataPinger");
        kotlin.jvm.internal.k.e(clock, "clock");
        this.zzi = dataPinger;
        this.zza = coroutineScopeProvider.zza();
        this.zzb = z6.d.a();
        this.zzc = z6.d.a();
        this.zzd = z6.d.a();
        this.zzh = adQualityDataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzs(java.lang.String r8, v5.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.google.android.gms.internal.ads.zzfvt
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.gms.internal.ads.zzfvt r0 = (com.google.android.gms.internal.ads.zzfvt) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfvt r0 = new com.google.android.gms.internal.ads.zzfvt
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.zzc
            w5.a r1 = w5.a.f17774a
            int r2 = r0.zze
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.zza
            z6.a r8 = (z6.a) r8
            r2.q.z0(r9)     // Catch: java.lang.Throwable -> L2f
            goto L70
        L2f:
            r9 = move-exception
            goto L7e
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            java.lang.Object r8 = r0.zzb
            z6.a r8 = (z6.a) r8
            java.lang.Object r2 = r0.zza
            java.lang.String r2 = (java.lang.String) r2
            r2.q.z0(r9)
            r9 = r8
            r8 = r2
            goto L5a
        L47:
            r2.q.z0(r9)
            z6.a r9 = r7.zzd
            r0.zza = r8
            r0.zzb = r9
            r0.zze = r4
            z6.c r9 = (z6.c) r9
            java.lang.Object r2 = r9.d(r0)
            if (r2 == r1) goto L84
        L5a:
            androidx.datastore.core.DataStore r2 = r7.zzh     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.internal.ads.zzfvu r4 = new com.google.android.gms.internal.ads.zzfvu     // Catch: java.lang.Throwable -> L7a
            r4.<init>(r8, r5)     // Catch: java.lang.Throwable -> L7a
            r0.zza = r9     // Catch: java.lang.Throwable -> L7a
            r0.zzb = r5     // Catch: java.lang.Throwable -> L7a
            r0.zze = r3     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r8 = r2.updateData(r4, r0)     // Catch: java.lang.Throwable -> L7a
            if (r8 == r1) goto L84
            r6 = r9
            r9 = r8
            r8 = r6
        L70:
            com.google.android.gms.internal.ads.zzfvk r9 = (com.google.android.gms.internal.ads.zzfvk) r9     // Catch: java.lang.Throwable -> L2f
            z6.c r8 = (z6.c) r8
            r8.f(r5)
            q5.x r8 = q5.x.f13520a
            return r8
        L7a:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L7e:
            z6.c r8 = (z6.c) r8
            r8.f(r5)
            throw r9
        L84:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzs(java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzt(v5.c r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfvw
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfvw r0 = (com.google.android.gms.internal.ads.zzfvw) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfvw r0 = new com.google.android.gms.internal.ads.zzfvw
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.zzb
            w5.a r1 = w5.a.f17774a
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L42
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r0 = r0.zza
            z6.a r0 = (z6.a) r0
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L2f
            goto L67
        L2f:
            r8 = move-exception
            goto L75
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L39:
            java.lang.Object r2 = r0.zza
            z6.a r2 = (z6.a) r2
            r2.q.z0(r8)
            r8 = r2
            goto L53
        L42:
            r2.q.z0(r8)
            z6.a r8 = r7.zzd
            r0.zza = r8
            r0.zzd = r4
            z6.c r8 = (z6.c) r8
            java.lang.Object r2 = r8.d(r0)
            if (r2 == r1) goto L7b
        L53:
            androidx.datastore.core.DataStore r2 = r7.zzh     // Catch: java.lang.Throwable -> L71
            com.google.android.gms.internal.ads.zzfvx r4 = new com.google.android.gms.internal.ads.zzfvx     // Catch: java.lang.Throwable -> L71
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L71
            r0.zza = r8     // Catch: java.lang.Throwable -> L71
            r0.zzd = r3     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r2.updateData(r4, r0)     // Catch: java.lang.Throwable -> L71
            if (r0 == r1) goto L7b
            r6 = r0
            r0 = r8
            r8 = r6
        L67:
            com.google.android.gms.internal.ads.zzfvk r8 = (com.google.android.gms.internal.ads.zzfvk) r8     // Catch: java.lang.Throwable -> L2f
            z6.c r0 = (z6.c) r0
            r0.f(r5)
            q5.x r8 = q5.x.f13520a
            return r8
        L71:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L75:
            z6.c r0 = (z6.c) r0
            r0.f(r5)
            throw r8
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzt(v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzu(long r6, v5.c r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfvv
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfvv r0 = (com.google.android.gms.internal.ads.zzfvv) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfvv r0 = new com.google.android.gms.internal.ads.zzfvv
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.zzc
            w5.a r1 = w5.a.f17774a
            int r2 = r0.zze
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            long r6 = r0.zza
            java.lang.Object r0 = r0.zzb
            z6.a r0 = (z6.a) r0
            r2.q.z0(r8)
            goto L49
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            r2.q.z0(r8)
            z6.a r8 = r5.zzb
            r0.zzb = r8
            r0.zza = r6
            r0.zze = r3
            z6.c r8 = (z6.c) r8
            java.lang.Object r0 = r8.d(r0)
            if (r0 == r1) goto L79
            r0 = r8
        L49:
            r8 = 0
            com.google.android.gms.internal.ads.zzfvf r1 = r5.zzf     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "adQualityDataBuilder"
            if (r1 == 0) goto L6f
            long r3 = r1.zzi()     // Catch: java.lang.Throwable -> L69
            long r6 = r6 - r3
            com.google.android.gms.internal.ads.zzfvf r3 = r5.zzf     // Catch: java.lang.Throwable -> L69
            if (r3 == 0) goto L6b
            long r2 = r3.zzg()     // Catch: java.lang.Throwable -> L69
            long r6 = r6 - r2
            r1.zzb(r6)     // Catch: java.lang.Throwable -> L69
            z6.c r0 = (z6.c) r0
            r0.f(r8)
            q5.x r6 = q5.x.f13520a
            return r6
        L69:
            r6 = move-exception
            goto L73
        L6b:
            kotlin.jvm.internal.k.l(r2)     // Catch: java.lang.Throwable -> L69
            throw r8     // Catch: java.lang.Throwable -> L69
        L6f:
            kotlin.jvm.internal.k.l(r2)     // Catch: java.lang.Throwable -> L69
            throw r8     // Catch: java.lang.Throwable -> L69
        L73:
            z6.c r0 = (z6.c) r0
            r0.f(r8)
            throw r6
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzu(long, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzv(v5.c r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfwa
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfwa r0 = (com.google.android.gms.internal.ads.zzfwa) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfwa r0 = new com.google.android.gms.internal.ads.zzfwa
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.zzc
            w5.a r1 = w5.a.f17774a
            int r2 = r0.zze
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L51
            if (r2 == r5) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r0 = r0.zza
            z6.a r0 = (z6.a) r0
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L32
            goto L9a
        L32:
            r8 = move-exception
            goto La6
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3d:
            java.lang.Object r2 = r0.zzb
            z6.a r2 = (z6.a) r2
            java.lang.Object r4 = r0.zza
            com.google.android.gms.internal.ads.zzfvg r4 = (com.google.android.gms.internal.ads.zzfvg) r4
            r2.q.z0(r8)
            goto L86
        L49:
            java.lang.Object r2 = r0.zza
            z6.a r2 = (z6.a) r2
            r2.q.z0(r8)
            goto L63
        L51:
            r2.q.z0(r8)
            z6.a r8 = r7.zzb
            r0.zza = r8
            r0.zze = r5
            r2 = r8
            z6.c r2 = (z6.c) r2
            java.lang.Object r8 = r2.d(r0)
            if (r8 == r1) goto Lba
        L63:
            com.google.android.gms.internal.ads.zzfvf r8 = r7.zzf     // Catch: java.lang.Throwable -> Lac
            if (r8 == 0) goto Lae
            com.google.android.gms.internal.ads.zzhwo r8 = r8.zzbu()     // Catch: java.lang.Throwable -> Lac
            com.google.android.gms.internal.ads.zzfvg r8 = (com.google.android.gms.internal.ads.zzfvg) r8     // Catch: java.lang.Throwable -> Lac
            z6.c r2 = (z6.c) r2
            r2.f(r6)
            kotlin.jvm.internal.k.b(r8)
            z6.a r2 = r7.zzd
            r0.zza = r8
            r0.zzb = r2
            r0.zze = r4
            z6.c r2 = (z6.c) r2
            java.lang.Object r4 = r2.d(r0)
            if (r4 == r1) goto Lba
            r4 = r8
        L86:
            androidx.datastore.core.DataStore r8 = r7.zzh     // Catch: java.lang.Throwable -> La4
            com.google.android.gms.internal.ads.zzfwb r5 = new com.google.android.gms.internal.ads.zzfwb     // Catch: java.lang.Throwable -> La4
            r5.<init>(r4, r6)     // Catch: java.lang.Throwable -> La4
            r0.zza = r2     // Catch: java.lang.Throwable -> La4
            r0.zzb = r6     // Catch: java.lang.Throwable -> La4
            r0.zze = r3     // Catch: java.lang.Throwable -> La4
            java.lang.Object r8 = r8.updateData(r5, r0)     // Catch: java.lang.Throwable -> La4
            if (r8 == r1) goto Lba
            r0 = r2
        L9a:
            com.google.android.gms.internal.ads.zzfvk r8 = (com.google.android.gms.internal.ads.zzfvk) r8     // Catch: java.lang.Throwable -> L32
            z6.c r0 = (z6.c) r0
            r0.f(r6)
            q5.x r8 = q5.x.f13520a
            return r8
        La4:
            r8 = move-exception
            r0 = r2
        La6:
            z6.c r0 = (z6.c) r0
            r0.f(r6)
            throw r8
        Lac:
            r8 = move-exception
            goto Lb4
        Lae:
            java.lang.String r8 = "adQualityDataBuilder"
            kotlin.jvm.internal.k.l(r8)     // Catch: java.lang.Throwable -> Lac
            throw r6     // Catch: java.lang.Throwable -> Lac
        Lb4:
            z6.c r2 = (z6.c) r2
            r2.f(r6)
            throw r8
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzv(v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean zzw(com.google.android.gms.internal.ads.zzfvg r9) {
        /*
            java.util.List r0 = r9.zzk()
            if (r0 == 0) goto Ld
            java.lang.Object r0 = r5.l.e1(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            goto Le
        Ld:
            r0 = 0
        Le:
            int r1 = r9.zzl()
            int r2 = r9.zzm()
            r3 = 1
            r4 = 0
            if (r1 <= r2) goto L22
            boolean r1 = r9.zzd()
            if (r1 != 0) goto L22
            r1 = r3
            goto L23
        L22:
            r1 = r4
        L23:
            if (r0 == 0) goto L36
            long r5 = r0.longValue()
            long r7 = r9.zzi()
            long r7 = r7 - r5
            r5 = 5000(0x1388, double:2.4703E-320)
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 <= 0) goto L36
            r9 = r3
            goto L37
        L36:
            r9 = r4
        L37:
            if (r1 != 0) goto L3d
            if (r9 == 0) goto L3c
            goto L3d
        L3c:
            return r4
        L3d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzw(com.google.android.gms.internal.ads.zzfvg):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zza() {
        q6.c0.u(this.zza, null, new zzfwj(this, null), 3);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzb(String gwsQueryId) {
        kotlin.jvm.internal.k.e(gwsQueryId, "gwsQueryId");
        q6.c0.u(this.zza, null, new zzfwd(this, gwsQueryId, null), 3);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzc() {
        q6.c0.u(this.zza, null, new zzfvz(this, null), 3);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzd() {
        q6.c0.u(this.zza, null, new zzfwn(this, null), 3);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zze() {
        q6.c0.u(this.zza, null, new zzfwh(this, null), 3);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzf() {
        q6.c0.u(this.zza, null, new zzfwl(this, null), 3);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzg() {
        q6.c0.u(this.zza, null, new zzfwf(this, null), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.android.gms.internal.ads.zzfwo] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzh(v5.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzh(v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzi(java.lang.String r7, v5.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfwc
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfwc r0 = (com.google.android.gms.internal.ads.zzfwc) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfwc r0 = new com.google.android.gms.internal.ads.zzfwc
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.zzc
            w5.a r1 = w5.a.f17774a
            int r2 = r0.zze
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            long r1 = r0.zzb
            java.lang.Object r7 = r0.zza
            z6.a r7 = (z6.a) r7
            java.lang.String r0 = r0.zzf
            r2.q.z0(r8)
            goto L53
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            r2.q.z0(r8)
            z6.a r8 = r6.zzb
            long r4 = java.lang.System.currentTimeMillis()
            r0.zzf = r7
            r0.zza = r8
            r0.zzb = r4
            r0.zze = r3
            z6.c r8 = (z6.c) r8
            java.lang.Object r0 = r8.d(r0)
            if (r0 == r1) goto L81
            r0 = r7
            r7 = r8
            r1 = r4
        L53:
            r8 = 0
            boolean r4 = r6.zze     // Catch: java.lang.Throwable -> L7a
            q5.x r5 = q5.x.f13520a
            if (r4 == 0) goto L60
        L5a:
            z6.c r7 = (z6.c) r7
            r7.f(r8)
            return r5
        L60:
            r6.zze = r3     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.internal.ads.zzfvg r3 = com.google.android.gms.internal.ads.zzfvg.zzp()     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.internal.ads.zzhwi r3 = r3.zzcc()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r4 = "toBuilder(...)"
            kotlin.jvm.internal.k.d(r3, r4)     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.internal.ads.zzfvf r3 = (com.google.android.gms.internal.ads.zzfvf) r3     // Catch: java.lang.Throwable -> L7a
            r6.zzf = r3     // Catch: java.lang.Throwable -> L7a
            r3.zza(r0)     // Catch: java.lang.Throwable -> L7a
            r3.zzj(r1)     // Catch: java.lang.Throwable -> L7a
            goto L5a
        L7a:
            r0 = move-exception
            z6.c r7 = (z6.c) r7
            r7.f(r8)
            throw r0
        L81:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzi(java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008e A[Catch: all -> 0x00aa, TRY_LEAVE, TryCatch #1 {all -> 0x00aa, blocks: (B:31:0x008a, B:33:0x008e, B:42:0x00ac, B:43:0x00b1), top: B:52:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ac A[Catch: all -> 0x00aa, TRY_ENTER, TryCatch #1 {all -> 0x00aa, blocks: (B:31:0x008a, B:33:0x008e, B:42:0x00ac, B:43:0x00b1), top: B:52:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzj(v5.c r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.google.android.gms.internal.ads.zzfvy
            if (r0 == 0) goto L13
            r0 = r12
            com.google.android.gms.internal.ads.zzfvy r0 = (com.google.android.gms.internal.ads.zzfvy) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfvy r0 = new com.google.android.gms.internal.ads.zzfvy
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.zzc
            w5.a r1 = w5.a.f17774a
            int r2 = r0.zze
            q5.x r3 = q5.x.f13520a
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L51
            if (r2 == r7) goto L49
            if (r2 == r6) goto L3f
            if (r2 == r5) goto L3b
            if (r2 != r4) goto L33
            r2.q.z0(r12)
            return r3
        L33:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L3b:
            r2.q.z0(r12)
            goto La0
        L3f:
            long r6 = r0.zzb
            java.lang.Object r2 = r0.zza
            z6.a r2 = (z6.a) r2
            r2.q.z0(r12)
            goto L8a
        L49:
            java.lang.Object r2 = r0.zza
            z6.a r2 = (z6.a) r2
            r2.q.z0(r12)
            goto L63
        L51:
            r2.q.z0(r12)
            z6.a r12 = r11.zzc
            r0.zza = r12
            r0.zze = r7
            r2 = r12
            z6.c r2 = (z6.c) r2
            java.lang.Object r12 = r2.d(r0)
            if (r12 == r1) goto Lbf
        L63:
            boolean r12 = r11.zzg     // Catch: java.lang.Throwable -> Lb8
            if (r12 == 0) goto L6d
            z6.c r2 = (z6.c) r2
            r2.f(r8)
            return r3
        L6d:
            r11.zzg = r7     // Catch: java.lang.Throwable -> Lb8
            z6.c r2 = (z6.c) r2
            r2.f(r8)
            z6.a r12 = r11.zzb
            long r9 = java.lang.System.currentTimeMillis()
            r0.zza = r12
            r0.zzb = r9
            r0.zze = r6
            r2 = r12
            z6.c r2 = (z6.c) r2
            java.lang.Object r12 = r2.d(r0)
            if (r12 == r1) goto Lbf
            r6 = r9
        L8a:
            com.google.android.gms.internal.ads.zzfvf r12 = r11.zzf     // Catch: java.lang.Throwable -> Laa
            if (r12 == 0) goto Lac
            r12.zzo(r6)     // Catch: java.lang.Throwable -> Laa
            z6.c r2 = (z6.c) r2
            r2.f(r8)
            r0.zza = r8
            r0.zze = r5
            java.lang.Object r12 = r11.zzu(r6, r0)
            if (r12 == r1) goto Lbf
        La0:
            r0.zze = r4
            java.lang.Object r12 = r11.zzv(r0)
            if (r12 != r1) goto La9
            goto Lbf
        La9:
            return r3
        Laa:
            r12 = move-exception
            goto Lb2
        Lac:
            java.lang.String r12 = "adQualityDataBuilder"
            kotlin.jvm.internal.k.l(r12)     // Catch: java.lang.Throwable -> Laa
            throw r8     // Catch: java.lang.Throwable -> Laa
        Lb2:
            z6.c r2 = (z6.c) r2
            r2.f(r8)
            throw r12
        Lb8:
            r12 = move-exception
            z6.c r2 = (z6.c) r2
            r2.f(r8)
            throw r12
        Lbf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzj(v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0083 A[Catch: all -> 0x00c1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c1, blocks: (B:27:0x007d, B:30:0x0083, B:33:0x008b, B:35:0x008f, B:37:0x00ab, B:39:0x00b4, B:41:0x00b8, B:44:0x00c3, B:45:0x00c6, B:46:0x00c7, B:47:0x00ca, B:48:0x00cb, B:49:0x00ce, B:50:0x00cf, B:52:0x00d3, B:54:0x00d9, B:56:0x00dd, B:58:0x00f9, B:59:0x0102, B:60:0x0105, B:61:0x0106, B:62:0x0109, B:63:0x010a, B:65:0x010e, B:68:0x0117, B:69:0x011a, B:70:0x011b, B:71:0x011e, B:72:0x011f, B:73:0x0122), top: B:80:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011f A[Catch: all -> 0x00c1, TryCatch #0 {all -> 0x00c1, blocks: (B:27:0x007d, B:30:0x0083, B:33:0x008b, B:35:0x008f, B:37:0x00ab, B:39:0x00b4, B:41:0x00b8, B:44:0x00c3, B:45:0x00c6, B:46:0x00c7, B:47:0x00ca, B:48:0x00cb, B:49:0x00ce, B:50:0x00cf, B:52:0x00d3, B:54:0x00d9, B:56:0x00dd, B:58:0x00f9, B:59:0x0102, B:60:0x0105, B:61:0x0106, B:62:0x0109, B:63:0x010a, B:65:0x010e, B:68:0x0117, B:69:0x011a, B:70:0x011b, B:71:0x011e, B:72:0x011f, B:73:0x0122), top: B:80:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzk(v5.c r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzk(v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0096 A[Catch: all -> 0x00e9, TRY_ENTER, TryCatch #1 {all -> 0x00e9, blocks: (B:32:0x0090, B:35:0x0096, B:37:0x00a0, B:39:0x00ac, B:41:0x00b3, B:53:0x00eb, B:54:0x00ee, B:55:0x00ef, B:56:0x00f2, B:57:0x00f3, B:58:0x00f6, B:59:0x00f7, B:60:0x00fa), top: B:69:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f7 A[Catch: all -> 0x00e9, TryCatch #1 {all -> 0x00e9, blocks: (B:32:0x0090, B:35:0x0096, B:37:0x00a0, B:39:0x00ac, B:41:0x00b3, B:53:0x00eb, B:54:0x00ee, B:55:0x00ef, B:56:0x00f2, B:57:0x00f3, B:58:0x00f6, B:59:0x00f7, B:60:0x00fa), top: B:69:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzl(v5.c r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzl(v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0099 A[Catch: all -> 0x00f3, TRY_ENTER, TryCatch #0 {all -> 0x00f3, blocks: (B:31:0x0093, B:34:0x0099, B:36:0x00a3, B:38:0x00af, B:40:0x00b6, B:42:0x00bd, B:54:0x00f5, B:55:0x00f8, B:56:0x00f9, B:57:0x00fc, B:58:0x00fd, B:59:0x0100, B:60:0x0101, B:61:0x0104, B:62:0x0105, B:63:0x0108), top: B:70:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105 A[Catch: all -> 0x00f3, TryCatch #0 {all -> 0x00f3, blocks: (B:31:0x0093, B:34:0x0099, B:36:0x00a3, B:38:0x00af, B:40:0x00b6, B:42:0x00bd, B:54:0x00f5, B:55:0x00f8, B:56:0x00f9, B:57:0x00fc, B:58:0x00fd, B:59:0x0100, B:60:0x0101, B:61:0x0104, B:62:0x0105, B:63:0x0108), top: B:70:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzm(v5.c r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzm(v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzn(v5.c r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.google.android.gms.internal.ads.zzfwe
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.gms.internal.ads.zzfwe r0 = (com.google.android.gms.internal.ads.zzfwe) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfwe r0 = new com.google.android.gms.internal.ads.zzfwe
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.zzc
            w5.a r1 = w5.a.f17774a
            int r2 = r0.zze
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            long r1 = r0.zza
            java.lang.Object r0 = r0.zzb
            z6.a r0 = (z6.a) r0
            r2.q.z0(r7)
            goto L4e
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            r2.q.z0(r7)
            z6.a r7 = r6.zzb
            long r4 = java.lang.System.currentTimeMillis()
            r0.zzb = r7
            r0.zza = r4
            r0.zze = r3
            z6.c r7 = (z6.c) r7
            java.lang.Object r0 = r7.d(r0)
            if (r0 == r1) goto L6c
            r0 = r7
            r1 = r4
        L4e:
            r7 = 0
            com.google.android.gms.internal.ads.zzfvf r3 = r6.zzf     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L60
            r3.zzs(r1)     // Catch: java.lang.Throwable -> L5e
            z6.c r0 = (z6.c) r0
            r0.f(r7)
            q5.x r7 = q5.x.f13520a
            return r7
        L5e:
            r1 = move-exception
            goto L66
        L60:
            java.lang.String r1 = "adQualityDataBuilder"
            kotlin.jvm.internal.k.l(r1)     // Catch: java.lang.Throwable -> L5e
            throw r7     // Catch: java.lang.Throwable -> L5e
        L66:
            z6.c r0 = (z6.c) r0
            r0.f(r7)
            throw r1
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzn(v5.c):java.lang.Object");
    }
}
