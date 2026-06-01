package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzamw {
    private final zzaem zza;
    private final SparseArray zzb = new SparseArray();
    private final SparseArray zzc = new SparseArray();
    private final byte[] zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;

    public zzamw(zzaem zzaemVar, boolean z2, boolean z7) {
        this.zza = zzaemVar;
        byte[] bArr = new byte[128];
        this.zzd = bArr;
        new zzfn(bArr, 0, 0);
        this.zzh = false;
    }

    public final void zza(zzfl zzflVar) {
        this.zzb.append(zzflVar.zzd, zzflVar);
    }

    public final void zzb(zzfk zzfkVar) {
        this.zzc.append(zzfkVar.zza, zzfkVar);
    }

    public final void zzc() {
        this.zzh = false;
    }

    public final void zzd(long j, int i2, long j3, boolean z2) {
        this.zze = i2;
        this.zzg = j3;
        this.zzf = j;
        this.zzl = z2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean zze(long j, int i2, boolean z2) {
        boolean z7 = false;
        if (this.zze == 9) {
            if (z2 && this.zzh) {
                long j3 = this.zzf;
                int i8 = i2 + ((int) (j - j3));
                long j8 = this.zzj;
                if (j8 != -9223372036854775807L) {
                    long j9 = this.zzi;
                    if (j3 != j9) {
                        this.zza.zzx(j8, this.zzk ? 1 : 0, (int) (j3 - j9), i8, null);
                    }
                }
            }
            this.zzi = this.zzf;
            this.zzj = this.zzg;
            this.zzk = false;
            this.zzh = true;
        }
        boolean z8 = this.zzl;
        boolean z9 = this.zzk;
        int i9 = this.zze;
        if (i9 == 5 || (z8 && i9 == 1)) {
            z7 = true;
        }
        boolean z10 = z9 | z7;
        this.zzk = z10;
        this.zze = 24;
        return z10;
    }
}
