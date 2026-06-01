package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzamy {
    private final zzaem zza;
    private long zzb;
    private boolean zzc;
    private int zzd;
    private long zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private boolean zzm;

    public zzamy(zzaem zzaemVar) {
        this.zza = zzaemVar;
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
    private final void zze(int i2) {
        long j = this.zzl;
        if (j != -9223372036854775807L) {
            long j3 = this.zzb;
            long j8 = this.zzk;
            if (j3 == j8) {
                return;
            }
            int i8 = (int) (j3 - j8);
            this.zza.zzx(j, this.zzm ? 1 : 0, i8, i2, null);
        }
    }

    public final void zza() {
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
    }

    public final void zzb(long j, int i2, int i8, long j3, boolean z2) {
        this.zzg = false;
        this.zzh = false;
        this.zze = j3;
        this.zzd = 0;
        this.zzb = j;
        if (i8 >= 32 && i8 != 40) {
            if (this.zzi && !this.zzj) {
                if (z2) {
                    zze(i2);
                }
                this.zzi = false;
            }
            if (i8 <= 35 || i8 == 39) {
                this.zzh = !this.zzj;
                this.zzj = true;
            }
        }
        boolean z7 = i8 >= 16 && i8 <= 21;
        this.zzc = z7;
        this.zzf = z7 || i8 <= 9;
    }

    public final void zzc(byte[] bArr, int i2, int i8) {
        if (this.zzf) {
            int i9 = this.zzd;
            int i10 = (i2 + 2) - i9;
            if (i10 >= i8) {
                this.zzd = (i8 - i2) + i9;
            } else {
                this.zzg = (bArr[i10] & 128) != 0;
                this.zzf = false;
            }
        }
    }

    public final void zzd(long j, int i2, boolean z2) {
        if (this.zzj && this.zzg) {
            this.zzm = this.zzc;
            this.zzj = false;
        } else if (this.zzh || this.zzg) {
            if (z2 && this.zzi) {
                zze(i2 + ((int) (j - this.zzb)));
            }
            this.zzk = this.zzb;
            this.zzl = this.zze;
            this.zzm = this.zzc;
            this.zzi = true;
        }
    }
}
