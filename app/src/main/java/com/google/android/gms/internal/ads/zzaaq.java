package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaaq implements zzabx {
    final /* synthetic */ zzaaw zza;
    private zzgpe zzb;

    @Nullable
    private zzv zzc;
    private long zzd;
    private long zze;
    private int zzf;

    public zzaaq(zzaaw zzaawVar, Context context, int i2) {
        Objects.requireNonNull(zzaawVar);
        this.zza = zzaawVar;
        zzep.zzS(context);
        this.zzb = zzgpe.zzi();
        this.zze = -9223372036854775807L;
        zzabu zzabuVar = zzabu.zzb;
    }

    private static final void zzy(zzv zzvVar) {
        zzt zztVarZza = zzvVar.zza();
        zztVarZza.zzC(zzaaw.zzC(zzvVar.zzE));
        zztVarZza.zzM();
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zza() {
        zzaaw zzaawVar = this.zza;
        if (zzaawVar.zzt()) {
            zzaawVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzb() {
        zzaaw zzaawVar = this.zza;
        if (zzaawVar.zzt()) {
            zzaawVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzd(zzv zzvVar) throws zzabw {
        return this.zza.zzi(zzvVar, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzg(boolean z2) {
        this.zze = -9223372036854775807L;
        this.zza.zzm(z2);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzh(boolean z2) {
        return this.zza.zzj(false);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzi() {
        zzaaw zzaawVar = this.zza;
        zzaawVar.zzA(this.zze);
        if (zzaawVar.zzy() >= zzaawVar.zzz()) {
            zzaawVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzj() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final Surface zzk() {
        zzgmd.zzh(false);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzl(zzaax zzaaxVar) {
        this.zza.zzp(zzaaxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzm(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        this.zza.zzq(f4);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzn(List list) {
        if (this.zzb.equals(list)) {
            return;
        }
        this.zzb = zzgpe.zzq(list);
        zzv zzvVar = this.zzc;
        if (zzvVar != null) {
            zzy(zzvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzo(long j) {
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzp(Surface surface, zzeh zzehVar) {
        this.zza.zzc(surface, zzehVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzq() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzr(int i2) {
        this.zza.zzr(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzs(int i2, zzv zzvVar, long j, int i8, List list) {
        zzgmd.zzh(false);
        this.zzb = zzgpe.zzq(list);
        this.zzc = zzvVar;
        zzaaw zzaawVar = this.zza;
        zzaawVar.zzA(-9223372036854775807L);
        zzy(zzvVar);
        long j3 = this.zze;
        long j8 = -4611686018427387904L;
        if (zzaawVar.zzt()) {
            if (j3 != -9223372036854775807L) {
                j8 = j3 + 1;
            }
        } else if (j3 != -9223372036854775807L) {
            return;
        }
        long j9 = j8;
        zzaawVar.zzw().zza(j9, new zzaav(j + this.zzd, i8, j9));
    }

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
    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzt() {
        zzaaw zzaawVar = this.zza;
        if (zzaawVar.zzw().zzc() == 0) {
            zzaawVar.zzo();
            return;
        }
        zzel zzelVar = new zzel(10);
        boolean z2 = true;
        while (zzaawVar.zzw().zzc() > 0) {
            zzaav zzaavVar = (zzaav) zzaawVar.zzw().zzd();
            zzaavVar.getClass();
            if (z2) {
                int i2 = zzaavVar.zzb;
                if (i2 == 0 || i2 == 1) {
                    zzaavVar = new zzaav(zzaavVar.zza, 0, zzaavVar.zzc);
                } else {
                    zzaawVar.zzo();
                }
            }
            zzelVar.zza(zzaavVar.zzc, zzaavVar);
            z2 = false;
        }
        zzaawVar.zzx(zzelVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzu(long j, zzabv zzabvVar) {
        int i2;
        zzgmd.zzh(false);
        long j3 = j + this.zzd;
        zzaaw zzaawVar = this.zza;
        long jZzb = zzaawVar.zzv().zzb(j3);
        if (jZzb == -9223372036854775807L || zzaawVar.zzu() == -9223372036854775807L || jZzb >= zzaawVar.zzu() || (i2 = this.zzf) >= 2) {
            if (zzaawVar.zzs()) {
                throw null;
            }
            return false;
        }
        this.zzf = i2 + 1;
        zzabvVar.zzb();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzv(long j, long j3) throws zzabw {
        this.zza.zzl(j + this.zzd, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzw(boolean z2) {
        zzaaw zzaawVar = this.zza;
        if (zzaawVar.zzt()) {
            zzaawVar.zzn(z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzx() {
        this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzc(zzabu zzabuVar, Executor executor) {
    }
}
