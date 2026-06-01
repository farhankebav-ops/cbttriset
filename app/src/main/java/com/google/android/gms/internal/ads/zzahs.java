package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzahs implements zzada {
    public static final /* synthetic */ int zza = 0;
    private final zzeg zzb;
    private final zzadw zzc;
    private final zzads zzd;
    private final zzadu zze;
    private final zzaem zzf;
    private zzadd zzg;
    private zzaem zzh;
    private zzaem zzi;
    private int zzj;

    @Nullable
    private zzap zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private zzahu zzq;
    private boolean zzr;

    public zzahs() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x022d  */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [com.google.android.gms.internal.ads.zzaed, com.google.android.gms.internal.ads.zzahu] */
    /* JADX WARN: Type inference failed for: r2v51, types: [com.google.android.gms.internal.ads.zzaht] */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.google.android.gms.internal.ads.zzadd] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput", "realTrackOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzh(com.google.android.gms.internal.ads.zzadb r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 760
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahs.zzh(com.google.android.gms.internal.ads.zzadb):int");
    }

    private final long zzi(long j) {
        zzadw zzadwVar = this.zzc;
        return ((j * 1000000) / ((long) zzadwVar.zzd)) + this.zzl;
    }

    private final boolean zzj(zzadb zzadbVar, boolean z2) throws IOException {
        int iZzm;
        int i2;
        int iZza;
        zzadbVar.zzl();
        long jZzn = zzadbVar.zzn();
        int i8 = true != z2 ? 131072 : 32768;
        if (jZzn == 0) {
            zzap zzapVarZza = this.zze.zza(zzadbVar, null, i8);
            this.zzk = zzapVarZza;
            if (zzapVarZza != null) {
                this.zzd.zza(zzapVarZza);
            }
            iZzm = (int) zzadbVar.zzm();
            if (!z2) {
                zzadbVar.zzf(iZzm);
            }
            i2 = 0;
        } else {
            iZzm = 0;
            i2 = 0;
        }
        int i9 = i2;
        int i10 = i9;
        while (true) {
            if (!zzk(zzadbVar)) {
                zzeg zzegVar = this.zzb;
                zzegVar.zzh(0);
                int iZzB = zzegVar.zzB();
                if ((i2 == 0 || zzm(iZzB, i2)) && (iZza = zzadx.zza(iZzB)) != -1) {
                    i9++;
                    if (i9 != 1) {
                        if (i9 == 4) {
                            break;
                        }
                    } else {
                        this.zzc.zza(iZzB);
                        i2 = iZzB;
                    }
                    zzadbVar.zzk(iZza - 4);
                } else {
                    int i11 = i10 + 1;
                    if (i10 == i8) {
                        if (z2) {
                            return false;
                        }
                        zzl();
                        throw new EOFException();
                    }
                    if (z2) {
                        zzadbVar.zzl();
                        zzadbVar.zzk(iZzm + i11);
                    } else {
                        zzadbVar.zzf(1);
                    }
                    i9 = 0;
                    i10 = i11;
                    i2 = 0;
                }
            } else if (i9 <= 0) {
                zzl();
                throw new EOFException();
            }
        }
        if (z2) {
            zzadbVar.zzf(iZzm + i10);
        } else {
            zzadbVar.zzl();
        }
        this.zzj = i2;
        return true;
    }

    private final boolean zzk(zzadb zzadbVar) throws IOException {
        zzahu zzahuVar = this.zzq;
        if (zzahuVar != null) {
            long jZzf = zzahuVar.zzf();
            if (jZzf != -1 && zzadbVar.zzm() > jZzf - 4) {
                return true;
            }
        }
        try {
            return !zzadbVar.zzh(this.zzb.zzi(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final void zzl() {
        zzahu zzahuVar = this.zzq;
        if ((zzahuVar instanceof zzahn) && zzahuVar.zzb()) {
            long j = this.zzo;
            if (j == -1 || j == this.zzq.zzf()) {
                return;
            }
            this.zzq = ((zzahn) this.zzq).zzh(this.zzo);
            zzadd zzaddVar = this.zzg;
            zzaddVar.getClass();
            zzaddVar.zzw(this.zzq);
            this.zzh.getClass();
            this.zzq.zza();
        }
    }

    private static boolean zzm(int i2, long j) {
        return ((long) (i2 & (-128000))) == (j & (-128000));
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        return zzj(zzadbVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return d.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zzg = zzaddVar;
        zzaem zzaemVarZzu = zzaddVar.zzu(0, 1);
        this.zzh = zzaemVarZzu;
        this.zzi = zzaemVarZzu;
        this.zzg.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws Throwable {
        this.zzh.getClass();
        String str = zzep.zza;
        int iZzh = zzh(zzadbVar);
        if (iZzh == -1 && (this.zzq instanceof zzaho)) {
            if (this.zzq.zza() != zzi(this.zzm)) {
                throw null;
            }
        }
        return iZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j3) {
        this.zzj = 0;
        this.zzl = -9223372036854775807L;
        this.zzm = 0L;
        this.zzp = 0;
        if (this.zzq instanceof zzaho) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ zzada zzf() {
        return d.b(this);
    }

    public final void zzg() {
        this.zzr = true;
    }

    public zzahs(int i2) {
        this.zzb = new zzeg(10);
        this.zzc = new zzadw();
        this.zzd = new zzads();
        this.zzl = -9223372036854775807L;
        this.zze = new zzadu();
        zzacx zzacxVar = new zzacx();
        this.zzf = zzacxVar;
        this.zzi = zzacxVar;
        this.zzo = -1L;
    }
}
