package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyi extends zzyo implements zzlo {
    public static final /* synthetic */ int zzb = 0;
    private static final zzgqy zzc = zzgqy.zzc(zzxo.zza);

    @Nullable
    public final Context zza;
    private final Object zzd;

    @GuardedBy("lock")
    private zzxt zze;

    @Nullable
    @GuardedBy("lock")
    private Thread zzf;

    @Nullable
    private zzxx zzg;
    private zzd zzh;
    private Boolean zzi;
    private final zzxb zzj;

    public zzyi(Context context) {
        zzxb zzxbVar = new zzxb();
        zzxt zzxtVar = zzxt.zzJ;
        this.zzd = new Object();
        byte[] bArr = null;
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzxbVar;
        if (zzxtVar != null) {
            this.zze = zzxtVar;
        } else {
            zzxs zzxsVar = new zzxs(zzxtVar, bArr);
            zzxsVar.zzx((zzbl) zzxtVar);
            this.zze = new zzxt(zzxsVar, bArr);
        }
        this.zzh = zzd.zza;
        if (this.zze.zzU && context == null) {
            zzdt.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    @Nullable
    public static String zzi(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static int zzj(zzv zzvVar, @Nullable String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(zzvVar.zzd)) {
            return 4;
        }
        String strZzi = zzi(str);
        String strZzi2 = zzi(zzvVar.zzd);
        if (strZzi2 == null || strZzi == null) {
            return (z2 && strZzi2 == null) ? 1 : 0;
        }
        if (strZzi2.startsWith(strZzi) || strZzi.startsWith(strZzi2)) {
            return 3;
        }
        String str2 = zzep.zza;
        return strZzi2.split("-", 2)[0].equals(strZzi.split("-", 2)[0]) ? 2 : 0;
    }

    public static /* synthetic */ int zzm(int i2, int i8) {
        if (i2 == 0 || i2 != i8) {
            return Integer.bitCount(i2 & i8);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ int zzn(com.google.android.gms.internal.ads.zzv r5, com.google.android.gms.internal.ads.zzgpe r6) {
        /*
            r0 = 0
            r1 = r0
        L2:
            int r2 = r6.size()
            if (r1 >= r2) goto L2a
            r2 = r0
        L9:
            java.util.List r3 = r5.zzc
            int r4 = r3.size()
            if (r2 >= r4) goto L27
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.ads.zzx r3 = (com.google.android.gms.internal.ads.zzx) r3
            java.lang.String r3 = r3.zzb
            java.lang.Object r4 = r6.get(r1)
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L24
            return r1
        L24:
            int r2 = r2 + 1
            goto L9
        L27:
            int r1 = r1 + 1
            goto L2
        L2a:
            r5 = 2147483647(0x7fffffff, float:NaN)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyi.zzn(com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzgpe):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final void zzl() {
        boolean z2;
        zzxx zzxxVar;
        synchronized (this.zzd) {
            try {
                z2 = false;
                if (this.zze.zzU && Build.VERSION.SDK_INT >= 32 && (zzxxVar = this.zzg) != null && zzxxVar.zza()) {
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            zzs();
        }
    }

    private static void zzv(zzwv zzwvVar, zzbl zzblVar, Map map) {
        for (int i2 = 0; i2 < zzwvVar.zzb; i2++) {
            if (((zzbh) zzblVar.zzH.get(zzwvVar.zza(i2))) != null) {
                throw null;
            }
        }
    }

    @Nullable
    private static final Pair zzw(int i2, zzyn zzynVar, int[][][] iArr, zzxz zzxzVar, Comparator comparator) {
        RandomAccess randomAccessZzj;
        zzyn zzynVar2 = zzynVar;
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        while (i8 < 2) {
            if (i2 == zzynVar2.zza(i8)) {
                zzwv zzwvVarZzb = zzynVar2.zzb(i8);
                for (int i9 = 0; i9 < zzwvVarZzb.zzb; i9++) {
                    zzbg zzbgVarZza = zzwvVarZzb.zza(i9);
                    List listZza = zzxzVar.zza(i8, zzbgVarZza, iArr[i8][i9]);
                    int i10 = zzbgVarZza.zza;
                    boolean[] zArr = new boolean[i10];
                    int i11 = 0;
                    while (i11 < i10) {
                        int i12 = i11 + 1;
                        zzya zzyaVar = (zzya) listZza.get(i11);
                        int iZza = zzyaVar.zza();
                        if (!zArr[i11] && iZza != 0) {
                            if (iZza == 1) {
                                randomAccessZzj = zzgpe.zzj(zzyaVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzyaVar);
                                for (int i13 = i12; i13 < i10; i13++) {
                                    zzya zzyaVar2 = (zzya) listZza.get(i13);
                                    if (zzyaVar2.zza() == 2 && zzyaVar.zzc(zzyaVar2)) {
                                        arrayList2.add(zzyaVar2);
                                        zArr[i13] = true;
                                    }
                                }
                                randomAccessZzj = arrayList2;
                            }
                            arrayList.add(randomAccessZzj);
                        }
                        i11 = i12;
                    }
                }
            }
            i8++;
            zzynVar2 = zzynVar;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i14 = 0; i14 < list.size(); i14++) {
            iArr2[i14] = ((zzya) list.get(i14)).zzc;
        }
        zzya zzyaVar3 = (zzya) list.get(0);
        return Pair.create(new zzyj(zzyaVar3.zzb, iArr2, 0), Integer.valueOf(zzyaVar3.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zza(zzln zzlnVar) {
        synchronized (this.zzd) {
            boolean z2 = this.zze.zzY;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void zzb() {
        zzxx zzxxVar;
        synchronized (this.zzd) {
            try {
                Thread thread = this.zzf;
                if (thread != null) {
                    zzgmd.zzi(thread == Thread.currentThread(), "DefaultTrackSelector is accessed on the wrong thread.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzxxVar = this.zzg) != null) {
            zzxxVar.zze();
            this.zzg = null;
        }
        super.zzb();
    }

    public final zzxt zzc() {
        zzxt zzxtVar;
        synchronized (this.zzd) {
            zzxtVar = this.zze;
        }
        return zzxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final boolean zzd() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void zze(zzd zzdVar) {
        if (this.zzh.equals(zzdVar)) {
            return;
        }
        this.zzh = zzdVar;
        zzl();
    }

    public final void zzf(zzxs zzxsVar) {
        boolean zEquals;
        zzxt zzxtVar = new zzxt(zzxsVar, null);
        synchronized (this.zzd) {
            zEquals = this.zze.equals(zzxtVar);
            this.zze = zzxtVar;
        }
        if (zEquals) {
            return;
        }
        if (zzxtVar.zzU && this.zza == null) {
            zzdt.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final Pair zzh(zzyn zzynVar, int[][][] iArr, final int[] iArr2, zzuu zzuuVar, zzbf zzbfVar) throws zzib {
        final zzxt zzxtVar;
        int i2;
        final boolean z2;
        final String str;
        final String languageTag;
        int[] iArr3;
        int length;
        Context context;
        CaptioningManager captioningManager;
        Locale locale;
        Context context2;
        Context context3;
        synchronized (this.zzd) {
            this.zzf = Thread.currentThread();
            zzxtVar = this.zze;
        }
        if (this.zzi == null && (context3 = this.zza) != null) {
            this.zzi = Boolean.valueOf(zzep.zzN(context3));
        }
        if (zzxtVar.zzU && Build.VERSION.SDK_INT >= 32 && this.zzg == null) {
            this.zzg = new zzxx(this.zza, this, this.zzi);
        }
        int i8 = 2;
        zzyj[] zzyjVarArr = new zzyj[2];
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i2 = 1;
            if (i10 >= 2) {
                z2 = false;
                break;
            }
            if (zzynVar.zza(i10) == 2 && zzynVar.zzb(i10).zzb > 0) {
                z2 = true;
                break;
            }
            i10++;
        }
        Pair pairZzw = zzw(1, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxk
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i11, zzbg zzbgVar, int[] iArr4) {
                final zzyi zzyiVar = this.zza;
                final zzxt zzxtVar2 = zzxtVar;
                zzgme zzgmeVar = new zzgme() { // from class: com.google.android.gms.internal.ads.zzxn
                    @Override // com.google.android.gms.internal.ads.zzgme
                    public final /* synthetic */ boolean zza(Object obj) {
                        return zzyiVar.zzk(zzxtVar2, (zzv) obj);
                    }
                };
                int i12 = iArr2[i11];
                int i13 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                for (int i14 = 0; i14 < zzbgVar.zza; i14++) {
                    zzgpbVar.zzf(new zzxf(i11, zzbgVar, i14, zzxtVar2, iArr4[i14], z2, zzgmeVar, i12));
                }
                return zzgpbVar.zzi();
            }
        }, zzxg.zza);
        if (pairZzw != null) {
            zzyjVarArr[((Integer) pairZzw.second).intValue()] = (zzyj) pairZzw.first;
        }
        if (pairZzw == null) {
            str = null;
        } else {
            Object obj = pairZzw.first;
            str = ((zzyj) obj).zza.zza(((zzyj) obj).zzb[0]).zzd;
        }
        int i11 = zzxtVar.zzw.zzb;
        final Point pointZzP = (!zzxtVar.zzk || (context2 = this.zza) == null) ? null : zzep.zzP(context2);
        Pair pairZzw2 = zzw(2, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxp
            /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
            @Override // com.google.android.gms.internal.ads.zzxz
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final /* synthetic */ java.util.List zza(int r18, com.google.android.gms.internal.ads.zzbg r19, int[] r20) {
                /*
                    Method dump skipped, instruction units count: 207
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxp.zza(int, com.google.android.gms.internal.ads.zzbg, int[]):java.util.List");
            }
        }, zzxj.zza);
        int i12 = 4;
        Pair pairZzw3 = pairZzw2 == null ? zzw(4, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxm
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i13, zzbg zzbgVar, int[] iArr4) {
                int i14 = zzyi.zzb;
                int i15 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                for (int i16 = 0; i16 < zzbgVar.zza; i16++) {
                    zzgpbVar.zzf(new zzxq(i13, zzbgVar, i16, zzxtVar, iArr4[i16]));
                }
                return zzgpbVar.zzi();
            }
        }, zzxh.zza) : null;
        if (pairZzw3 != null) {
            zzyjVarArr[((Integer) pairZzw3.second).intValue()] = (zzyj) pairZzw3.first;
        } else if (pairZzw2 != null) {
            zzyjVarArr[((Integer) pairZzw2.second).intValue()] = (zzyj) pairZzw2.first;
        }
        if (!zzxtVar.zzB || (context = this.zza) == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
            languageTag = null;
        } else {
            String str2 = zzep.zza;
            languageTag = locale.toLanguageTag();
        }
        int i13 = 3;
        Pair pairZzw4 = zzw(3, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxl
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i14, zzbg zzbgVar, int[] iArr4) {
                int i15 = zzyi.zzb;
                int i16 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                for (int i17 = 0; i17 < zzbgVar.zza; i17++) {
                    zzgpbVar.zzf(new zzxy(i14, zzbgVar, i17, zzxtVar, iArr4[i17], str, languageTag));
                }
                return zzgpbVar.zzi();
            }
        }, zzxi.zza);
        if (pairZzw4 != null) {
            zzyjVarArr[((Integer) pairZzw4.second).intValue()] = (zzyj) pairZzw4.first;
        }
        int i14 = 0;
        while (i14 < i8) {
            int iZza = zzynVar.zza(i14);
            if (iZza != i8 && iZza != i2 && iZza != i13 && iZza != i12) {
                zzwv zzwvVarZzb = zzynVar.zzb(i14);
                int[][] iArr4 = iArr[i14];
                int i15 = i9;
                int i16 = i15;
                zzbg zzbgVar = null;
                zzxr zzxrVar = null;
                while (i15 < zzwvVarZzb.zzb) {
                    zzbg zzbgVarZza = zzwvVarZzb.zza(i15);
                    int[] iArr5 = iArr4[i15];
                    zzxr zzxrVar2 = zzxrVar;
                    for (int i17 = i9; i17 < zzbgVarZza.zza; i17++) {
                        if (h0.c(iArr5[i17], zzxtVar.zzV)) {
                            zzxr zzxrVar3 = new zzxr(zzbgVarZza.zza(i17), iArr5[i17]);
                            if (zzxrVar2 == null || zzxrVar3.compareTo(zzxrVar2) > 0) {
                                zzbgVar = zzbgVarZza;
                                zzxrVar2 = zzxrVar3;
                                i16 = i17;
                            }
                        }
                    }
                    i15++;
                    zzxrVar = zzxrVar2;
                    i9 = 0;
                }
                zzyjVarArr[i14] = zzbgVar == null ? null : new zzyj(zzbgVar, new int[]{i16}, 0);
            }
            i14++;
            i8 = 2;
            i9 = 0;
            i13 = 3;
            i2 = 1;
            i12 = 4;
        }
        HashMap map = new HashMap();
        int i18 = 2;
        for (int i19 = 0; i19 < 2; i19++) {
            zzv(zzynVar.zzb(i19), zzxtVar, map);
        }
        zzv(zzynVar.zze(), zzxtVar, map);
        for (int i20 = 0; i20 < 2; i20++) {
            if (((zzbh) map.get(Integer.valueOf(zzynVar.zza(i20)))) != null) {
                throw null;
            }
        }
        int i21 = 0;
        while (i21 < i18) {
            zzwv zzwvVarZzb2 = zzynVar.zzb(i21);
            if (zzxtVar.zzb(i21, zzwvVarZzb2)) {
                if (zzxtVar.zzc(i21, zzwvVarZzb2) != null) {
                    throw null;
                }
                zzyjVarArr[i21] = null;
            }
            i21++;
            i18 = 2;
        }
        int i22 = 0;
        while (i22 < i18) {
            int iZza2 = zzynVar.zza(i22);
            if (zzxtVar.zza(i22) || zzxtVar.zzI.contains(Integer.valueOf(iZza2))) {
                zzyjVarArr[i22] = null;
            }
            i22++;
            i18 = 2;
        }
        zzxb zzxbVar = this.zzj;
        zzza zzzaVarZzt = zzt();
        zzgpe zzgpeVarZzd = zzxc.zzd(zzyjVarArr);
        int i23 = 2;
        zzyk[] zzykVarArr = new zzyk[2];
        int i24 = 0;
        while (i24 < i23) {
            zzyj zzyjVar = zzyjVarArr[i24];
            if (zzyjVar != null && (length = (iArr3 = zzyjVar.zzb).length) != 0) {
                zzykVarArr[i24] = length == 1 ? new zzyl(zzyjVar.zza, iArr3[0], 0, 0, null) : zzxbVar.zza(zzyjVar.zza, iArr3, 0, zzzaVarZzt, (zzgpe) zzgpeVarZzd.get(i24));
            }
            i24++;
            i23 = 2;
        }
        zzlq[] zzlqVarArr = new zzlq[i23];
        for (int i25 = 0; i25 < i23; i25++) {
            zzlqVarArr[i25] = (zzxtVar.zza(i25) || zzxtVar.zzI.contains(Integer.valueOf(zzynVar.zza(i25))) || (zzynVar.zza(i25) != -2 && zzykVarArr[i25] == null)) ? null : zzlq.zza;
        }
        return Pair.create(zzlqVarArr, zzykVarArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ boolean zzk(com.google.android.gms.internal.ads.zzxt r4, com.google.android.gms.internal.ads.zzv r5) {
        /*
            r3 = this;
            boolean r4 = r4.zzU
            r0 = 1
            if (r4 == 0) goto L83
            java.lang.Boolean r4 = r3.zzi
            if (r4 == 0) goto L11
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L10
            goto L11
        L10:
            return r0
        L11:
            int r4 = r5.zzG
            r1 = -1
            if (r4 == r1) goto L83
            r1 = 2
            if (r4 <= r1) goto L83
            java.lang.String r4 = r5.zzo
            r1 = 32
            if (r4 != 0) goto L20
            goto L5a
        L20:
            int r2 = r4.hashCode()
            switch(r2) {
                case -2123537834: goto L43;
                case 187078296: goto L3a;
                case 187078297: goto L31;
                case 1504578661: goto L28;
                default: goto L27;
            }
        L27:
            goto L5a
        L28:
            java.lang.String r2 = "audio/eac3"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L5a
            goto L4b
        L31:
            java.lang.String r2 = "audio/ac4"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L5a
            goto L4b
        L3a:
            java.lang.String r2 = "audio/ac3"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L5a
            goto L4b
        L43:
            java.lang.String r2 = "audio/eac3-joc"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L5a
        L4b:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r1) goto L59
            com.google.android.gms.internal.ads.zzxx r4 = r3.zzg
            if (r4 == 0) goto L59
            boolean r4 = r4.zza()
            if (r4 != 0) goto L5a
        L59:
            return r0
        L5a:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            if (r4 < r1) goto L82
            com.google.android.gms.internal.ads.zzxx r4 = r3.zzg
            if (r4 == 0) goto L82
            boolean r1 = r4.zza()
            if (r1 == 0) goto L82
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L82
            com.google.android.gms.internal.ads.zzxx r4 = r3.zzg
            boolean r4 = r4.zzc()
            if (r4 == 0) goto L82
            com.google.android.gms.internal.ads.zzxx r4 = r3.zzg
            com.google.android.gms.internal.ads.zzd r1 = r3.zzh
            boolean r4 = r4.zzd(r1, r5)
            if (r4 == 0) goto L82
            return r0
        L82:
            return r2
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyi.zzk(com.google.android.gms.internal.ads.zzxt, com.google.android.gms.internal.ads.zzv):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    @Nullable
    public final zzlo zzg() {
        return this;
    }
}
