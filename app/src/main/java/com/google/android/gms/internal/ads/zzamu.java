package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzamu {
    private final zzaem zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    public zzamu(zzaem zzaemVar) {
        this.zza = zzaemVar;
    }

    public final void zza() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }

    public final void zzb(int i2, long j) {
        boolean z2;
        this.zze = i2;
        this.zzd = false;
        if (i2 == 182) {
            z2 = true;
        } else if (i2 == 179) {
            i2 = 179;
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = i2 == 182;
        this.zzf = 0;
        this.zzh = j;
    }

    public final void zzc(byte[] bArr, int i2, int i8) {
        if (this.zzc) {
            int i9 = this.zzf;
            int i10 = (i2 + 1) - i9;
            if (i10 >= i8) {
                this.zzf = (i8 - i2) + i9;
            } else {
                this.zzd = ((bArr[i10] & 192) >> 6) == 0;
                this.zzc = false;
            }
        }
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
    public final void zzd(long j, int i2, boolean z2) {
        zzgmd.zzh(this.zzh != -9223372036854775807L);
        if (this.zze == 182 && z2 && this.zzb) {
            this.zza.zzx(this.zzh, this.zzd ? 1 : 0, (int) (j - this.zzg), i2, null);
        }
        if (this.zze != 179) {
            this.zzg = j;
        }
    }
}
