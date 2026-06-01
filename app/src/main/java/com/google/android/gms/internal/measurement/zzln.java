package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzln implements zzov {
    private final zzlm zza;

    private zzln(zzlm zzlmVar) {
        byte[] bArr = zzmp.zzb;
        this.zza = zzlmVar;
        zzlmVar.zza = this;
    }

    public static zzln zza(zzlm zzlmVar) {
        zzln zzlnVar = zzlmVar.zza;
        return zzlnVar != null ? zzlnVar : new zzln(zzlmVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzA(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzf(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).getClass();
                i9 += 8;
            }
            zzlmVar.zzr(i9);
            while (i8 < list.size()) {
                zzlmVar.zzu(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i8 < zznaVar.size()) {
                this.zza.zzf(i2, zznaVar.zzc(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zznaVar.size(); i12++) {
            zznaVar.zzc(i12);
            i11 += 8;
        }
        zzlmVar2.zzr(i11);
        while (i8 < zznaVar.size()) {
            zzlmVar2.zzu(zznaVar.zzc(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzB(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzly)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzd(i2, Float.floatToRawIntBits(((Float) list.get(i8)).floatValue()));
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Float) list.get(i10)).getClass();
                i9 += 4;
            }
            zzlmVar.zzr(i9);
            while (i8 < list.size()) {
                zzlmVar.zzs(Float.floatToRawIntBits(((Float) list.get(i8)).floatValue()));
                i8++;
            }
            return;
        }
        zzly zzlyVar = (zzly) list;
        if (!z2) {
            while (i8 < zzlyVar.size()) {
                this.zza.zzd(i2, Float.floatToRawIntBits(zzlyVar.zze(i8)));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzlyVar.size(); i12++) {
            zzlyVar.zze(i12);
            i11 += 4;
        }
        zzlmVar2.zzr(i11);
        while (i8 < zzlyVar.size()) {
            zzlmVar2.zzs(Float.floatToRawIntBits(zzlyVar.zze(i8)));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzC(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzlo)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzf(i2, Double.doubleToRawLongBits(((Double) list.get(i8)).doubleValue()));
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Double) list.get(i10)).getClass();
                i9 += 8;
            }
            zzlmVar.zzr(i9);
            while (i8 < list.size()) {
                zzlmVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i8)).doubleValue()));
                i8++;
            }
            return;
        }
        zzlo zzloVar = (zzlo) list;
        if (!z2) {
            while (i8 < zzloVar.size()) {
                this.zza.zzf(i2, Double.doubleToRawLongBits(zzloVar.zze(i8)));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzloVar.size(); i12++) {
            zzloVar.zze(i12);
            i11 += 8;
        }
        zzlmVar2.zzr(i11);
        while (i8 < zzloVar.size()) {
            zzlmVar2.zzu(Double.doubleToRawLongBits(zzloVar.zze(i8)));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzD(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzb(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzlm.zzA(((Integer) list.get(i9)).intValue());
            }
            zzlmVar.zzr(iZzA);
            while (i8 < list.size()) {
                zzlmVar.zzq(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i8 < zzmgVar.size()) {
                this.zza.zzb(i2, zzmgVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzmgVar.size(); i10++) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i10));
        }
        zzlmVar2.zzr(iZzA2);
        while (i8 < zzmgVar.size()) {
            zzlmVar2.zzq(zzmgVar.zzf(i8));
            i8++;
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
    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzE(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzky)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzg(i2, ((Boolean) list.get(i8)).booleanValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Boolean) list.get(i10)).getClass();
                i9++;
            }
            zzlmVar.zzr(i9);
            while (i8 < list.size()) {
                zzlmVar.zzp(((Boolean) list.get(i8)).booleanValue() ? (byte) 1 : (byte) 0);
                i8++;
            }
            return;
        }
        zzky zzkyVar = (zzky) list;
        if (!z2) {
            while (i8 < zzkyVar.size()) {
                this.zza.zzg(i2, zzkyVar.zze(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzkyVar.size(); i12++) {
            zzkyVar.zze(i12);
            i11++;
        }
        zzlmVar2.zzr(i11);
        while (i8 < zzkyVar.size()) {
            zzlmVar2.zzp(zzkyVar.zze(i8) ? (byte) 1 : (byte) 0);
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzF(int i2, List list) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzmx)) {
            while (i8 < list.size()) {
                this.zza.zzh(i2, (String) list.get(i8));
                i8++;
            }
            return;
        }
        zzmx zzmxVar = (zzmx) list;
        while (i8 < list.size()) {
            Object objZzc = zzmxVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzh(i2, (String) objZzc);
            } else {
                this.zza.zzi(i2, (zzlh) objZzc);
            }
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzG(int i2, List list) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.zza.zzi(i2, (zzlh) list.get(i8));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzH(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzc(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int iZzz = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzz += zzlm.zzz(((Integer) list.get(i9)).intValue());
            }
            zzlmVar.zzr(iZzz);
            while (i8 < list.size()) {
                zzlmVar.zzr(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i8 < zzmgVar.size()) {
                this.zza.zzc(i2, zzmgVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int iZzz2 = 0;
        for (int i10 = 0; i10 < zzmgVar.size(); i10++) {
            iZzz2 += zzlm.zzz(zzmgVar.zzf(i10));
        }
        zzlmVar2.zzr(iZzz2);
        while (i8 < zzmgVar.size()) {
            zzlmVar2.zzr(zzmgVar.zzf(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzI(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzd(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).getClass();
                i9 += 4;
            }
            zzlmVar.zzr(i9);
            while (i8 < list.size()) {
                zzlmVar.zzs(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i8 < zzmgVar.size()) {
                this.zza.zzd(i2, zzmgVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzmgVar.size(); i12++) {
            zzmgVar.zzf(i12);
            i11 += 4;
        }
        zzlmVar2.zzr(i11);
        while (i8 < zzmgVar.size()) {
            zzlmVar2.zzs(zzmgVar.zzf(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzJ(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzf(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).getClass();
                i9 += 8;
            }
            zzlmVar.zzr(i9);
            while (i8 < list.size()) {
                zzlmVar.zzu(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i8 < zznaVar.size()) {
                this.zza.zzf(i2, zznaVar.zzc(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zznaVar.size(); i12++) {
            zznaVar.zzc(i12);
            i11 += 8;
        }
        zzlmVar2.zzr(i11);
        while (i8 < zznaVar.size()) {
            zzlmVar2.zzu(zznaVar.zzc(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzK(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i8 < list.size()) {
                    zzlm zzlmVar = this.zza;
                    int iIntValue = ((Integer) list.get(i8)).intValue();
                    zzlmVar.zzc(i2, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i8++;
                }
                return;
            }
            zzlm zzlmVar2 = this.zza;
            zzlmVar2.zza(i2, 2);
            int iZzz = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                int iIntValue2 = ((Integer) list.get(i9)).intValue();
                iZzz += zzlm.zzz((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzlmVar2.zzr(iZzz);
            while (i8 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i8)).intValue();
                zzlmVar2.zzr((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i8++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i8 < zzmgVar.size()) {
                zzlm zzlmVar3 = this.zza;
                int iZzf = zzmgVar.zzf(i8);
                zzlmVar3.zzc(i2, (iZzf >> 31) ^ (iZzf + iZzf));
                i8++;
            }
            return;
        }
        zzlm zzlmVar4 = this.zza;
        zzlmVar4.zza(i2, 2);
        int iZzz2 = 0;
        for (int i10 = 0; i10 < zzmgVar.size(); i10++) {
            int iZzf2 = zzmgVar.zzf(i10);
            iZzz2 += zzlm.zzz((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzlmVar4.zzr(iZzz2);
        while (i8 < zzmgVar.size()) {
            int iZzf3 = zzmgVar.zzf(i8);
            zzlmVar4.zzr((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzL(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i8 < list.size()) {
                    zzlm zzlmVar = this.zza;
                    long jLongValue = ((Long) list.get(i8)).longValue();
                    zzlmVar.zze(i2, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i8++;
                }
                return;
            }
            zzlm zzlmVar2 = this.zza;
            zzlmVar2.zza(i2, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                long jLongValue2 = ((Long) list.get(i9)).longValue();
                iZzA += zzlm.zzA((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzlmVar2.zzr(iZzA);
            while (i8 < list.size()) {
                long jLongValue3 = ((Long) list.get(i8)).longValue();
                zzlmVar2.zzt((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i8++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i8 < zznaVar.size()) {
                zzlm zzlmVar3 = this.zza;
                long jZzc = zznaVar.zzc(i8);
                zzlmVar3.zze(i2, (jZzc >> 63) ^ (jZzc + jZzc));
                i8++;
            }
            return;
        }
        zzlm zzlmVar4 = this.zza;
        zzlmVar4.zza(i2, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zznaVar.size(); i10++) {
            long jZzc2 = zznaVar.zzc(i10);
            iZzA2 += zzlm.zzA((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        zzlmVar4.zzr(iZzA2);
        while (i8 < zznaVar.size()) {
            long jZzc3 = zznaVar.zzc(i8);
            zzlmVar4.zzt((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzM(int i2, zzne zzneVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            zzlmVar.zzr(zznf.zzc(zzneVar, entry.getKey(), entry.getValue()));
            zznf.zzb(zzlmVar, zzneVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzb(int i2, int i8) throws IOException {
        this.zza.zzd(i2, i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzc(int i2, long j) throws IOException {
        this.zza.zze(i2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzd(int i2, long j) throws IOException {
        this.zza.zzf(i2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zze(int i2, float f4) throws IOException {
        this.zza.zzd(i2, Float.floatToRawIntBits(f4));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzf(int i2, double d8) throws IOException {
        this.zza.zzf(i2, Double.doubleToRawLongBits(d8));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzg(int i2, int i8) throws IOException {
        this.zza.zzb(i2, i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzh(int i2, long j) throws IOException {
        this.zza.zze(i2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzi(int i2, int i8) throws IOException {
        this.zza.zzb(i2, i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzj(int i2, long j) throws IOException {
        this.zza.zzf(i2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzk(int i2, int i8) throws IOException {
        this.zza.zzd(i2, i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzl(int i2, boolean z2) throws IOException {
        this.zza.zzg(i2, z2);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzm(int i2, String str) throws IOException {
        this.zza.zzh(i2, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzn(int i2, zzlh zzlhVar) throws IOException {
        this.zza.zzi(i2, zzlhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzo(int i2, int i8) throws IOException {
        this.zza.zzc(i2, i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzp(int i2, int i8) throws IOException {
        this.zza.zzc(i2, (i8 >> 31) ^ (i8 + i8));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzq(int i2, long j) throws IOException {
        this.zza.zze(i2, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzr(int i2, Object obj, zznx zznxVar) throws IOException {
        this.zza.zzl(i2, (zznm) obj, zznxVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzs(int i2, Object obj, zznx zznxVar) throws IOException {
        zzlm zzlmVar = this.zza;
        zzlmVar.zza(i2, 3);
        zznxVar.zzf((zznm) obj, zzlmVar.zza);
        zzlmVar.zza(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    @Deprecated
    public final void zzt(int i2) throws IOException {
        this.zza.zza(i2, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    @Deprecated
    public final void zzu(int i2) throws IOException {
        this.zza.zza(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzv(int i2, Object obj) throws IOException {
        if (obj instanceof zzlh) {
            this.zza.zzn(i2, (zzlh) obj);
        } else {
            this.zza.zzm(i2, (zznm) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzw(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzb(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzlm.zzA(((Integer) list.get(i9)).intValue());
            }
            zzlmVar.zzr(iZzA);
            while (i8 < list.size()) {
                zzlmVar.zzq(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i8 < zzmgVar.size()) {
                this.zza.zzb(i2, zzmgVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzmgVar.size(); i10++) {
            iZzA2 += zzlm.zzA(zzmgVar.zzf(i10));
        }
        zzlmVar2.zzr(iZzA2);
        while (i8 < zzmgVar.size()) {
            zzlmVar2.zzq(zzmgVar.zzf(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzx(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzmg)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzd(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).getClass();
                i9 += 4;
            }
            zzlmVar.zzr(i9);
            while (i8 < list.size()) {
                zzlmVar.zzs(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzmg zzmgVar = (zzmg) list;
        if (!z2) {
            while (i8 < zzmgVar.size()) {
                this.zza.zzd(i2, zzmgVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzmgVar.size(); i12++) {
            zzmgVar.zzf(i12);
            i11 += 4;
        }
        zzlmVar2.zzr(i11);
        while (i8 < zzmgVar.size()) {
            zzlmVar2.zzs(zzmgVar.zzf(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzy(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zze(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzlm.zzA(((Long) list.get(i9)).longValue());
            }
            zzlmVar.zzr(iZzA);
            while (i8 < list.size()) {
                zzlmVar.zzt(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i8 < zznaVar.size()) {
                this.zza.zze(i2, zznaVar.zzc(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zznaVar.size(); i10++) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i10));
        }
        zzlmVar2.zzr(iZzA2);
        while (i8 < zznaVar.size()) {
            zzlmVar2.zzt(zznaVar.zzc(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final void zzz(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzna)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zze(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            zzlm zzlmVar = this.zza;
            zzlmVar.zza(i2, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzlm.zzA(((Long) list.get(i9)).longValue());
            }
            zzlmVar.zzr(iZzA);
            while (i8 < list.size()) {
                zzlmVar.zzt(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzna zznaVar = (zzna) list;
        if (!z2) {
            while (i8 < zznaVar.size()) {
                this.zza.zze(i2, zznaVar.zzc(i8));
                i8++;
            }
            return;
        }
        zzlm zzlmVar2 = this.zza;
        zzlmVar2.zza(i2, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zznaVar.size(); i10++) {
            iZzA2 += zzlm.zzA(zznaVar.zzc(i10));
        }
        zzlmVar2.zzr(iZzA2);
        while (i8 < zznaVar.size()) {
            zzlmVar2.zzt(zznaVar.zzc(i8));
            i8++;
        }
    }
}
