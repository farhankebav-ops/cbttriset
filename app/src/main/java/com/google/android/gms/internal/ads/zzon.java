package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzon {
    private final zzbd zza;
    private zzgpe zzb = zzgpe.zzi();
    private zzgph zzc = zzgph.zza();

    @Nullable
    private zzuu zzd;
    private zzuu zze;
    private zzuu zzf;

    public zzon(zzbd zzbdVar) {
        this.zza = zzbdVar;
    }

    private final void zzj(zzbf zzbfVar) {
        zzgpg zzgpgVar = new zzgpg();
        if (this.zzb.isEmpty()) {
            zzk(zzgpgVar, this.zze, zzbfVar);
            if (!Objects.equals(this.zzf, this.zze)) {
                zzk(zzgpgVar, this.zzf, zzbfVar);
            }
            if (!Objects.equals(this.zzd, this.zze) && !Objects.equals(this.zzd, this.zzf)) {
                zzk(zzgpgVar, this.zzd, zzbfVar);
            }
        } else {
            for (int i2 = 0; i2 < this.zzb.size(); i2++) {
                zzk(zzgpgVar, (zzuu) this.zzb.get(i2), zzbfVar);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzgpgVar, this.zzd, zzbfVar);
            }
        }
        this.zzc = zzgpgVar.zzc();
    }

    private final void zzk(zzgpg zzgpgVar, @Nullable zzuu zzuuVar, zzbf zzbfVar) {
        if (zzuuVar == null) {
            return;
        }
        if (zzbfVar.zze(zzuuVar.zza) != -1) {
            zzgpgVar.zza(zzuuVar, zzbfVar);
            return;
        }
        zzbf zzbfVar2 = (zzbf) this.zzc.get(zzuuVar);
        if (zzbfVar2 != null) {
            zzgpgVar.zza(zzuuVar, zzbfVar2);
        }
    }

    @Nullable
    private static zzuu zzl(zzbb zzbbVar, zzgpe zzgpeVar, @Nullable zzuu zzuuVar, zzbd zzbdVar) {
        zzbf zzbfVarZzq = zzbbVar.zzq();
        int iZzr = zzbbVar.zzr();
        Object objZzf = zzbfVarZzq.zzg() ? null : zzbfVarZzq.zzf(iZzr);
        int iZzf = -1;
        if (!zzbbVar.zzx() && !zzbfVarZzq.zzg()) {
            iZzf = zzbfVarZzq.zzd(iZzr, zzbdVar, false).zzf(zzep.zzq(zzbbVar.zzu()));
        }
        int i2 = iZzf;
        for (int i8 = 0; i8 < zzgpeVar.size(); i8++) {
            zzuu zzuuVar2 = (zzuu) zzgpeVar.get(i8);
            if (zzm(zzuuVar2, objZzf, zzbbVar.zzx(), zzbbVar.zzy(), zzbbVar.zzz(), i2)) {
                return zzuuVar2;
            }
        }
        if (zzgpeVar.isEmpty() && zzuuVar != null && zzm(zzuuVar, objZzf, zzbbVar.zzx(), zzbbVar.zzy(), zzbbVar.zzz(), i2)) {
            return zzuuVar;
        }
        return null;
    }

    private static boolean zzm(zzuu zzuuVar, @Nullable Object obj, boolean z2, int i2, int i8, int i9) {
        if (zzuuVar.zza.equals(obj)) {
            return z2 ? zzuuVar.zzb == i2 && zzuuVar.zzc == i8 : zzuuVar.zzb == -1 && zzuuVar.zze == i9;
        }
        return false;
    }

    @Nullable
    public final zzuu zza() {
        return this.zzd;
    }

    @Nullable
    public final zzuu zzb() {
        return this.zze;
    }

    @Nullable
    public final zzuu zzc() {
        return this.zzf;
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
    @Nullable
    public final zzuu zzd() {
        Object next;
        Object objLast;
        if (this.zzb.isEmpty()) {
            return null;
        }
        List list = this.zzb;
        if (list != null) {
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            objLast = list.get(list.size() - 1);
        } else if (list instanceof SortedSet) {
            objLast = ((SortedSet) list).last();
        } else {
            Iterator it = list.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            objLast = next;
        }
        return (zzuu) objLast;
    }

    @Nullable
    public final zzbf zze(zzuu zzuuVar) {
        return (zzbf) this.zzc.get(zzuuVar);
    }

    public final void zzf(zzbb zzbbVar) {
        this.zzd = zzl(zzbbVar, this.zzb, this.zze, this.zza);
    }

    public final void zzg(zzbb zzbbVar) {
        this.zzd = zzl(zzbbVar, this.zzb, this.zze, this.zza);
        zzj(zzbbVar.zzq());
    }

    public final void zzh(List list, @Nullable zzuu zzuuVar, zzbb zzbbVar) {
        this.zzb = zzgpe.zzq(list);
        if (!list.isEmpty()) {
            this.zze = (zzuu) list.get(0);
            zzuuVar.getClass();
            this.zzf = zzuuVar;
        }
        if (this.zzd == null) {
            this.zzd = zzl(zzbbVar, this.zzb, this.zze, this.zza);
        }
        zzj(zzbbVar.zzq());
    }

    public final /* synthetic */ zzgpe zzi() {
        return this.zzb;
    }
}
