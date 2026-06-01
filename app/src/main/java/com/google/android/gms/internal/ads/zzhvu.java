package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhvu implements zzhzr {
    private final zzhvt zza;

    private zzhvu(zzhvt zzhvtVar) {
        zzhxb.zza(zzhvtVar, "output");
        this.zza = zzhvtVar;
        zzhvtVar.zze = this;
    }

    public static zzhvu zza(zzhvt zzhvtVar) {
        Object obj = zzhvtVar.zze;
        return obj != null ? (zzhvu) obj : new zzhvu(zzhvtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzA(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhxn)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzh(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).getClass();
                i9 += 8;
            }
            zzhvtVar.zzs(i9);
            while (i8 < list.size()) {
                zzhvtVar.zzv(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzhxn zzhxnVar = (zzhxn) list;
        if (!z2) {
            while (i8 < zzhxnVar.size()) {
                this.zza.zzh(i2, zzhxnVar.zzc(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhxnVar.size(); i12++) {
            zzhxnVar.zzc(i12);
            i11 += 8;
        }
        zzhvtVar2.zzs(i11);
        while (i8 < zzhxnVar.size()) {
            zzhvtVar2.zzv(zzhxnVar.zzc(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzB(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhwf)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzM(i2, Float.floatToRawIntBits(((Float) list.get(i8)).floatValue()));
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Float) list.get(i10)).getClass();
                i9 += 4;
            }
            zzhvtVar.zzs(i9);
            while (i8 < list.size()) {
                zzhvtVar.zzt(Float.floatToRawIntBits(((Float) list.get(i8)).floatValue()));
                i8++;
            }
            return;
        }
        zzhwf zzhwfVar = (zzhwf) list;
        if (!z2) {
            while (i8 < zzhwfVar.size()) {
                this.zza.zzM(i2, Float.floatToRawIntBits(zzhwfVar.zzf(i8)));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhwfVar.size(); i12++) {
            zzhwfVar.zzf(i12);
            i11 += 4;
        }
        zzhvtVar2.zzs(i11);
        while (i8 < zzhwfVar.size()) {
            zzhvtVar2.zzt(Float.floatToRawIntBits(zzhwfVar.zzf(i8)));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzC(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhvv)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzh(i2, Double.doubleToRawLongBits(((Double) list.get(i8)).doubleValue()));
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Double) list.get(i10)).getClass();
                i9 += 8;
            }
            zzhvtVar.zzs(i9);
            while (i8 < list.size()) {
                zzhvtVar.zzv(Double.doubleToRawLongBits(((Double) list.get(i8)).doubleValue()));
                i8++;
            }
            return;
        }
        zzhvv zzhvvVar = (zzhvv) list;
        if (!z2) {
            while (i8 < zzhvvVar.size()) {
                this.zza.zzh(i2, Double.doubleToRawLongBits(zzhvvVar.zzf(i8)));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhvvVar.size(); i12++) {
            zzhvvVar.zzf(i12);
            i11 += 8;
        }
        zzhvtVar2.zzs(i11);
        while (i8 < zzhvvVar.size()) {
            zzhvtVar2.zzv(Double.doubleToRawLongBits(zzhvvVar.zzf(i8)));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzD(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhwp)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzK(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzB += zzhvt.zzB(((Integer) list.get(i9)).intValue());
            }
            zzhvtVar.zzs(iZzB);
            while (i8 < list.size()) {
                zzhvtVar.zzr(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        if (!z2) {
            while (i8 < zzhwpVar.size()) {
                this.zza.zzK(i2, zzhwpVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzhwpVar.size(); i10++) {
            iZzB2 += zzhvt.zzB(zzhwpVar.zzf(i10));
        }
        zzhvtVar2.zzs(iZzB2);
        while (i8 < zzhwpVar.size()) {
            zzhvtVar2.zzr(zzhwpVar.zzf(i8));
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
    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzE(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhuy)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzi(i2, ((Boolean) list.get(i8)).booleanValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Boolean) list.get(i10)).getClass();
                i9++;
            }
            zzhvtVar.zzs(i9);
            while (i8 < list.size()) {
                zzhvtVar.zzq(((Boolean) list.get(i8)).booleanValue() ? (byte) 1 : (byte) 0);
                i8++;
            }
            return;
        }
        zzhuy zzhuyVar = (zzhuy) list;
        if (!z2) {
            while (i8 < zzhuyVar.size()) {
                this.zza.zzi(i2, zzhuyVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhuyVar.size(); i12++) {
            zzhuyVar.zzf(i12);
            i11++;
        }
        zzhvtVar2.zzs(i11);
        while (i8 < zzhuyVar.size()) {
            zzhvtVar2.zzq(zzhuyVar.zzf(i8) ? (byte) 1 : (byte) 0);
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzF(int i2, List list) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhxk)) {
            while (i8 < list.size()) {
                this.zza.zzj(i2, (String) list.get(i8));
                i8++;
            }
            return;
        }
        zzhxk zzhxkVar = (zzhxk) list;
        while (i8 < list.size()) {
            Object objZzc = zzhxkVar.zzc();
            if (objZzc instanceof String) {
                this.zza.zzj(i2, (String) objZzc);
            } else {
                this.zza.zzk(i2, (zzhvi) objZzc);
            }
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzG(int i2, List list) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.zza.zzk(i2, (zzhvi) list.get(i8));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzH(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhwp)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzL(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzhvt.zzA(((Integer) list.get(i9)).intValue());
            }
            zzhvtVar.zzs(iZzA);
            while (i8 < list.size()) {
                zzhvtVar.zzs(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        if (!z2) {
            while (i8 < zzhwpVar.size()) {
                this.zza.zzL(i2, zzhwpVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzhwpVar.size(); i10++) {
            iZzA2 += zzhvt.zzA(zzhwpVar.zzf(i10));
        }
        zzhvtVar2.zzs(iZzA2);
        while (i8 < zzhwpVar.size()) {
            zzhvtVar2.zzs(zzhwpVar.zzf(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzI(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhwp)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzM(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).getClass();
                i9 += 4;
            }
            zzhvtVar.zzs(i9);
            while (i8 < list.size()) {
                zzhvtVar.zzt(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        if (!z2) {
            while (i8 < zzhwpVar.size()) {
                this.zza.zzM(i2, zzhwpVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhwpVar.size(); i12++) {
            zzhwpVar.zzf(i12);
            i11 += 4;
        }
        zzhvtVar2.zzs(i11);
        while (i8 < zzhwpVar.size()) {
            zzhvtVar2.zzt(zzhwpVar.zzf(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzJ(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhxn)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzh(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).getClass();
                i9 += 8;
            }
            zzhvtVar.zzs(i9);
            while (i8 < list.size()) {
                zzhvtVar.zzv(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzhxn zzhxnVar = (zzhxn) list;
        if (!z2) {
            while (i8 < zzhxnVar.size()) {
                this.zza.zzh(i2, zzhxnVar.zzc(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhxnVar.size(); i12++) {
            zzhxnVar.zzc(i12);
            i11 += 8;
        }
        zzhvtVar2.zzs(i11);
        while (i8 < zzhxnVar.size()) {
            zzhvtVar2.zzv(zzhxnVar.zzc(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzK(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhwp)) {
            if (!z2) {
                while (i8 < list.size()) {
                    zzhvt zzhvtVar = this.zza;
                    int iIntValue = ((Integer) list.get(i8)).intValue();
                    zzhvtVar.zzL(i2, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar2 = this.zza;
            zzhvtVar2.zzJ(i2, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                int iIntValue2 = ((Integer) list.get(i9)).intValue();
                iZzA += zzhvt.zzA((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzhvtVar2.zzs(iZzA);
            while (i8 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i8)).intValue();
                zzhvtVar2.zzs((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i8++;
            }
            return;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        if (!z2) {
            while (i8 < zzhwpVar.size()) {
                zzhvt zzhvtVar3 = this.zza;
                int iZzf = zzhwpVar.zzf(i8);
                zzhvtVar3.zzL(i2, (iZzf >> 31) ^ (iZzf + iZzf));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar4 = this.zza;
        zzhvtVar4.zzJ(i2, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzhwpVar.size(); i10++) {
            int iZzf2 = zzhwpVar.zzf(i10);
            iZzA2 += zzhvt.zzA((iZzf2 >> 31) ^ (iZzf2 + iZzf2));
        }
        zzhvtVar4.zzs(iZzA2);
        while (i8 < zzhwpVar.size()) {
            int iZzf3 = zzhwpVar.zzf(i8);
            zzhvtVar4.zzs((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzL(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhxn)) {
            if (!z2) {
                while (i8 < list.size()) {
                    zzhvt zzhvtVar = this.zza;
                    long jLongValue = ((Long) list.get(i8)).longValue();
                    zzhvtVar.zzN(i2, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar2 = this.zza;
            zzhvtVar2.zzJ(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                long jLongValue2 = ((Long) list.get(i9)).longValue();
                iZzB += zzhvt.zzB((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            zzhvtVar2.zzs(iZzB);
            while (i8 < list.size()) {
                long jLongValue3 = ((Long) list.get(i8)).longValue();
                zzhvtVar2.zzu((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i8++;
            }
            return;
        }
        zzhxn zzhxnVar = (zzhxn) list;
        if (!z2) {
            while (i8 < zzhxnVar.size()) {
                zzhvt zzhvtVar3 = this.zza;
                long jZzc = zzhxnVar.zzc(i8);
                zzhvtVar3.zzN(i2, (jZzc >> 63) ^ (jZzc + jZzc));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar4 = this.zza;
        zzhvtVar4.zzJ(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzhxnVar.size(); i10++) {
            long jZzc2 = zzhxnVar.zzc(i10);
            iZzB2 += zzhvt.zzB((jZzc2 >> 63) ^ (jZzc2 + jZzc2));
        }
        zzhvtVar4.zzs(iZzB2);
        while (i8 < zzhxnVar.size()) {
            long jZzc3 = zzhxnVar.zzc(i8);
            zzhvtVar4.zzu((jZzc3 >> 63) ^ (jZzc3 + jZzc3));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzM(int i2, zzhxr zzhxrVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            zzhvtVar.zzs(zzhxs.zzc(zzhxrVar, entry.getKey(), entry.getValue()));
            zzhxs.zzb(zzhvtVar, zzhxrVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzb(int i2, int i8) throws IOException {
        this.zza.zzM(i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzc(int i2, long j) throws IOException {
        this.zza.zzN(i2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzd(int i2, long j) throws IOException {
        this.zza.zzh(i2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zze(int i2, float f4) throws IOException {
        this.zza.zzM(i2, Float.floatToRawIntBits(f4));
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzf(int i2, double d8) throws IOException {
        this.zza.zzh(i2, Double.doubleToRawLongBits(d8));
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzg(int i2, int i8) throws IOException {
        this.zza.zzK(i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzh(int i2, long j) throws IOException {
        this.zza.zzN(i2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzi(int i2, int i8) throws IOException {
        this.zza.zzK(i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzj(int i2, long j) throws IOException {
        this.zza.zzh(i2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzk(int i2, int i8) throws IOException {
        this.zza.zzM(i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzl(int i2, boolean z2) throws IOException {
        this.zza.zzi(i2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzm(int i2, String str) throws IOException {
        this.zza.zzj(i2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzn(int i2, zzhvi zzhviVar) throws IOException {
        this.zza.zzk(i2, zzhviVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzo(int i2, int i8) throws IOException {
        this.zza.zzL(i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzp(int i2, int i8) throws IOException {
        this.zza.zzL(i2, (i8 >> 31) ^ (i8 + i8));
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzq(int i2, long j) throws IOException {
        this.zza.zzN(i2, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzr(int i2, Object obj, zzhyr zzhyrVar) throws IOException {
        zzhvt zzhvtVar = this.zza;
        zzhur zzhurVar = (zzhur) obj;
        zzhvtVar.zzJ(i2, 2);
        zzhvtVar.zzs(zzhurVar.zzaT(zzhyrVar));
        zzhyrVar.zzf(zzhurVar, this);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzs(int i2, Object obj, zzhyr zzhyrVar) throws IOException {
        zzhvt zzhvtVar = this.zza;
        zzhvtVar.zzJ(i2, 3);
        zzhyrVar.zzf((zzhur) obj, this);
        zzhvtVar.zzJ(i2, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    @Deprecated
    public final void zzt(int i2) throws IOException {
        this.zza.zzJ(i2, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    @Deprecated
    public final void zzu(int i2) throws IOException {
        this.zza.zzJ(i2, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzv(int i2, Object obj) throws IOException {
        if (obj instanceof zzhvi) {
            this.zza.zzo(i2, (zzhvi) obj);
        } else {
            this.zza.zzn(i2, (zzhxz) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzw(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhwp)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzK(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzB += zzhvt.zzB(((Integer) list.get(i9)).intValue());
            }
            zzhvtVar.zzs(iZzB);
            while (i8 < list.size()) {
                zzhvtVar.zzr(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        if (!z2) {
            while (i8 < zzhwpVar.size()) {
                this.zza.zzK(i2, zzhwpVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzhwpVar.size(); i10++) {
            iZzB2 += zzhvt.zzB(zzhwpVar.zzf(i10));
        }
        zzhvtVar2.zzs(iZzB2);
        while (i8 < zzhwpVar.size()) {
            zzhvtVar2.zzr(zzhwpVar.zzf(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzx(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhwp)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzM(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).getClass();
                i9 += 4;
            }
            zzhvtVar.zzs(i9);
            while (i8 < list.size()) {
                zzhvtVar.zzt(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzhwp zzhwpVar = (zzhwp) list;
        if (!z2) {
            while (i8 < zzhwpVar.size()) {
                this.zza.zzM(i2, zzhwpVar.zzf(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzhwpVar.size(); i12++) {
            zzhwpVar.zzf(i12);
            i11 += 4;
        }
        zzhvtVar2.zzs(i11);
        while (i8 < zzhwpVar.size()) {
            zzhvtVar2.zzt(zzhwpVar.zzf(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzy(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhxn)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzN(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzB += zzhvt.zzB(((Long) list.get(i9)).longValue());
            }
            zzhvtVar.zzs(iZzB);
            while (i8 < list.size()) {
                zzhvtVar.zzu(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzhxn zzhxnVar = (zzhxn) list;
        if (!z2) {
            while (i8 < zzhxnVar.size()) {
                this.zza.zzN(i2, zzhxnVar.zzc(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzhxnVar.size(); i10++) {
            iZzB2 += zzhvt.zzB(zzhxnVar.zzc(i10));
        }
        zzhvtVar2.zzs(iZzB2);
        while (i8 < zzhxnVar.size()) {
            zzhvtVar2.zzu(zzhxnVar.zzc(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzr
    public final void zzz(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzhxn)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzN(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            zzhvt zzhvtVar = this.zza;
            zzhvtVar.zzJ(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzB += zzhvt.zzB(((Long) list.get(i9)).longValue());
            }
            zzhvtVar.zzs(iZzB);
            while (i8 < list.size()) {
                zzhvtVar.zzu(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzhxn zzhxnVar = (zzhxn) list;
        if (!z2) {
            while (i8 < zzhxnVar.size()) {
                this.zza.zzN(i2, zzhxnVar.zzc(i8));
                i8++;
            }
            return;
        }
        zzhvt zzhvtVar2 = this.zza;
        zzhvtVar2.zzJ(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzhxnVar.size(); i10++) {
            iZzB2 += zzhvt.zzB(zzhxnVar.zzc(i10));
        }
        zzhvtVar2.zzs(iZzB2);
        while (i8 < zzhxnVar.size()) {
            zzhvtVar2.zzu(zzhxnVar.zzc(i8));
            i8++;
        }
    }
}
