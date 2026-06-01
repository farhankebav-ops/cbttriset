package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdo implements zzhh {
    private final zzdn zza;

    private zzdo(zzdn zzdnVar) {
        byte[] bArr = zzep.zzb;
        this.zza = zzdnVar;
        zzdnVar.zza = this;
    }

    public static zzdo zza(zzdn zzdnVar) {
        zzdo zzdoVar = zzdnVar.zza;
        return zzdoVar != null ? zzdoVar : new zzdo(zzdnVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzA(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzfb)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzh(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).getClass();
                i9 += 8;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzi(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z2) {
            while (i8 < zzfbVar.size()) {
                this.zza.zzh(i2, zzfbVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzfbVar.size(); i12++) {
            zzfbVar.zze(i12);
            i11 += 8;
        }
        this.zza.zzt(i11);
        while (i8 < zzfbVar.size()) {
            this.zza.zzi(zzfbVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzB(int i2, int i8) throws IOException {
        this.zza.zzs(i2, (i8 >> 31) ^ (i8 + i8));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzC(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzei)) {
            if (!z2) {
                while (i8 < list.size()) {
                    zzdn zzdnVar = this.zza;
                    int iIntValue = ((Integer) list.get(i8)).intValue();
                    zzdnVar.zzs(i2, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                int iIntValue2 = ((Integer) list.get(i9)).intValue();
                iZzA += zzdn.zzA((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zza.zzt(iZzA);
            while (i8 < list.size()) {
                zzdn zzdnVar2 = this.zza;
                int iIntValue3 = ((Integer) list.get(i8)).intValue();
                zzdnVar2.zzt((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i8++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z2) {
            while (i8 < zzeiVar.size()) {
                zzdn zzdnVar3 = this.zza;
                int iZze = zzeiVar.zze(i8);
                zzdnVar3.zzs(i2, (iZze >> 31) ^ (iZze + iZze));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzeiVar.size(); i10++) {
            int iZze2 = zzeiVar.zze(i10);
            iZzA2 += zzdn.zzA((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        this.zza.zzt(iZzA2);
        while (i8 < zzeiVar.size()) {
            zzdn zzdnVar4 = this.zza;
            int iZze3 = zzeiVar.zze(i8);
            zzdnVar4.zzt((iZze3 >> 31) ^ (iZze3 + iZze3));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzD(int i2, long j) throws IOException {
        this.zza.zzu(i2, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzE(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzfb)) {
            if (!z2) {
                while (i8 < list.size()) {
                    zzdn zzdnVar = this.zza;
                    long jLongValue = ((Long) list.get(i8)).longValue();
                    zzdnVar.zzu(i2, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                long jLongValue2 = ((Long) list.get(i9)).longValue();
                iZzB += zzdn.zzB((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zza.zzt(iZzB);
            while (i8 < list.size()) {
                zzdn zzdnVar2 = this.zza;
                long jLongValue3 = ((Long) list.get(i8)).longValue();
                zzdnVar2.zzv((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i8++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z2) {
            while (i8 < zzfbVar.size()) {
                zzdn zzdnVar3 = this.zza;
                long jZze = zzfbVar.zze(i8);
                zzdnVar3.zzu(i2, (jZze >> 63) ^ (jZze + jZze));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzfbVar.size(); i10++) {
            long jZze2 = zzfbVar.zze(i10);
            iZzB2 += zzdn.zzB((jZze2 >> 63) ^ (jZze2 + jZze2));
        }
        this.zza.zzt(iZzB2);
        while (i8 < zzfbVar.size()) {
            zzdn zzdnVar4 = this.zza;
            long jZze3 = zzfbVar.zze(i8);
            zzdnVar4.zzv((jZze3 >> 63) ^ (jZze3 + jZze3));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    @Deprecated
    public final void zzF(int i2) throws IOException {
        this.zza.zzr(i2, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzG(int i2, String str) throws IOException {
        this.zza.zzp(i2, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzH(int i2, List list) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzey)) {
            while (i8 < list.size()) {
                this.zza.zzp(i2, (String) list.get(i8));
                i8++;
            }
            return;
        }
        zzey zzeyVar = (zzey) list;
        while (i8 < list.size()) {
            Object objZza = zzeyVar.zza();
            if (objZza instanceof String) {
                this.zza.zzp(i2, (String) objZza);
            } else {
                this.zza.zze(i2, (zzdf) objZza);
            }
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzI(int i2, int i8) throws IOException {
        this.zza.zzs(i2, i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzJ(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzei)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzs(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int iZzA = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzA += zzdn.zzA(((Integer) list.get(i9)).intValue());
            }
            this.zza.zzt(iZzA);
            while (i8 < list.size()) {
                this.zza.zzt(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z2) {
            while (i8 < zzeiVar.size()) {
                this.zza.zzs(i2, zzeiVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int iZzA2 = 0;
        for (int i10 = 0; i10 < zzeiVar.size(); i10++) {
            iZzA2 += zzdn.zzA(zzeiVar.zze(i10));
        }
        this.zza.zzt(iZzA2);
        while (i8 < zzeiVar.size()) {
            this.zza.zzt(zzeiVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzK(int i2, long j) throws IOException {
        this.zza.zzu(i2, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzL(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzfb)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzu(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzB += zzdn.zzB(((Long) list.get(i9)).longValue());
            }
            this.zza.zzt(iZzB);
            while (i8 < list.size()) {
                this.zza.zzv(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z2) {
            while (i8 < zzfbVar.size()) {
                this.zza.zzu(i2, zzfbVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzfbVar.size(); i10++) {
            iZzB2 += zzdn.zzB(zzfbVar.zze(i10));
        }
        this.zza.zzt(iZzB2);
        while (i8 < zzfbVar.size()) {
            this.zza.zzv(zzfbVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzb(int i2, boolean z2) throws IOException {
        this.zza.zzd(i2, z2);
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
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzc(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzcw)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzd(i2, ((Boolean) list.get(i8)).booleanValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Boolean) list.get(i10)).getClass();
                i9++;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i8)).booleanValue() ? (byte) 1 : (byte) 0);
                i8++;
            }
            return;
        }
        zzcw zzcwVar = (zzcw) list;
        if (!z2) {
            while (i8 < zzcwVar.size()) {
                this.zza.zzd(i2, zzcwVar.zzf(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzcwVar.size(); i12++) {
            zzcwVar.zzf(i12);
            i11++;
        }
        this.zza.zzt(i11);
        while (i8 < zzcwVar.size()) {
            this.zza.zzb(zzcwVar.zzf(i8) ? (byte) 1 : (byte) 0);
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzd(int i2, zzdf zzdfVar) throws IOException {
        this.zza.zze(i2, zzdfVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zze(int i2, List list) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.zza.zze(i2, (zzdf) list.get(i8));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzf(int i2, double d8) throws IOException {
        this.zza.zzh(i2, Double.doubleToRawLongBits(d8));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzg(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzdp)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzh(i2, Double.doubleToRawLongBits(((Double) list.get(i8)).doubleValue()));
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Double) list.get(i10)).getClass();
                i9 += 8;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i8)).doubleValue()));
                i8++;
            }
            return;
        }
        zzdp zzdpVar = (zzdp) list;
        if (!z2) {
            while (i8 < zzdpVar.size()) {
                this.zza.zzh(i2, Double.doubleToRawLongBits(zzdpVar.zze(i8)));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzdpVar.size(); i12++) {
            zzdpVar.zze(i12);
            i11 += 8;
        }
        this.zza.zzt(i11);
        while (i8 < zzdpVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzdpVar.zze(i8)));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    @Deprecated
    public final void zzh(int i2) throws IOException {
        this.zza.zzr(i2, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzi(int i2, int i8) throws IOException {
        this.zza.zzj(i2, i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzj(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzei)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzj(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzB += zzdn.zzB(((Integer) list.get(i9)).intValue());
            }
            this.zza.zzt(iZzB);
            while (i8 < list.size()) {
                this.zza.zzk(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z2) {
            while (i8 < zzeiVar.size()) {
                this.zza.zzj(i2, zzeiVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzeiVar.size(); i10++) {
            iZzB2 += zzdn.zzB(zzeiVar.zze(i10));
        }
        this.zza.zzt(iZzB2);
        while (i8 < zzeiVar.size()) {
            this.zza.zzk(zzeiVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzk(int i2, int i8) throws IOException {
        this.zza.zzf(i2, i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzl(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzei)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzf(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).getClass();
                i9 += 4;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzg(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z2) {
            while (i8 < zzeiVar.size()) {
                this.zza.zzf(i2, zzeiVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzeiVar.size(); i12++) {
            zzeiVar.zze(i12);
            i11 += 4;
        }
        this.zza.zzt(i11);
        while (i8 < zzeiVar.size()) {
            this.zza.zzg(zzeiVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzm(int i2, long j) throws IOException {
        this.zza.zzh(i2, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzn(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzfb)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzh(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Long) list.get(i10)).getClass();
                i9 += 8;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzi(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z2) {
            while (i8 < zzfbVar.size()) {
                this.zza.zzh(i2, zzfbVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzfbVar.size(); i12++) {
            zzfbVar.zze(i12);
            i11 += 8;
        }
        this.zza.zzt(i11);
        while (i8 < zzfbVar.size()) {
            this.zza.zzi(zzfbVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzo(int i2, float f4) throws IOException {
        this.zza.zzf(i2, Float.floatToRawIntBits(f4));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzp(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzdz)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzf(i2, Float.floatToRawIntBits(((Float) list.get(i8)).floatValue()));
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Float) list.get(i10)).getClass();
                i9 += 4;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i8)).floatValue()));
                i8++;
            }
            return;
        }
        zzdz zzdzVar = (zzdz) list;
        if (!z2) {
            while (i8 < zzdzVar.size()) {
                this.zza.zzf(i2, Float.floatToRawIntBits(zzdzVar.zze(i8)));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzdzVar.size(); i12++) {
            zzdzVar.zze(i12);
            i11 += 4;
        }
        this.zza.zzt(i11);
        while (i8 < zzdzVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzdzVar.zze(i8)));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzq(int i2, Object obj, zzge zzgeVar) throws IOException {
        zzdn zzdnVar = this.zza;
        zzdnVar.zzr(i2, 3);
        zzgeVar.zzi((zzfm) obj, zzdnVar.zza);
        zzdnVar.zzr(i2, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzr(int i2, int i8) throws IOException {
        this.zza.zzj(i2, i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzs(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzei)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzj(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzB += zzdn.zzB(((Integer) list.get(i9)).intValue());
            }
            this.zza.zzt(iZzB);
            while (i8 < list.size()) {
                this.zza.zzk(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z2) {
            while (i8 < zzeiVar.size()) {
                this.zza.zzj(i2, zzeiVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzeiVar.size(); i10++) {
            iZzB2 += zzdn.zzB(zzeiVar.zze(i10));
        }
        this.zza.zzt(iZzB2);
        while (i8 < zzeiVar.size()) {
            this.zza.zzk(zzeiVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzt(int i2, long j) throws IOException {
        this.zza.zzu(i2, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzu(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzfb)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzu(i2, ((Long) list.get(i8)).longValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int iZzB = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iZzB += zzdn.zzB(((Long) list.get(i9)).longValue());
            }
            this.zza.zzt(iZzB);
            while (i8 < list.size()) {
                this.zza.zzv(((Long) list.get(i8)).longValue());
                i8++;
            }
            return;
        }
        zzfb zzfbVar = (zzfb) list;
        if (!z2) {
            while (i8 < zzfbVar.size()) {
                this.zza.zzu(i2, zzfbVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int iZzB2 = 0;
        for (int i10 = 0; i10 < zzfbVar.size(); i10++) {
            iZzB2 += zzdn.zzB(zzfbVar.zze(i10));
        }
        this.zza.zzt(iZzB2);
        while (i8 < zzfbVar.size()) {
            this.zza.zzv(zzfbVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzv(int i2, Object obj, zzge zzgeVar) throws IOException {
        this.zza.zzm(i2, (zzfm) obj, zzgeVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzw(int i2, Object obj) throws IOException {
        if (obj instanceof zzdf) {
            this.zza.zzo(i2, (zzdf) obj);
        } else {
            this.zza.zzn(i2, (zzfm) obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzx(int i2, int i8) throws IOException {
        this.zza.zzf(i2, i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzy(int i2, List list, boolean z2) throws IOException {
        int i8 = 0;
        if (!(list instanceof zzei)) {
            if (!z2) {
                while (i8 < list.size()) {
                    this.zza.zzf(i2, ((Integer) list.get(i8)).intValue());
                    i8++;
                }
                return;
            }
            this.zza.zzr(i2, 2);
            int i9 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ((Integer) list.get(i10)).getClass();
                i9 += 4;
            }
            this.zza.zzt(i9);
            while (i8 < list.size()) {
                this.zza.zzg(((Integer) list.get(i8)).intValue());
                i8++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z2) {
            while (i8 < zzeiVar.size()) {
                this.zza.zzf(i2, zzeiVar.zze(i8));
                i8++;
            }
            return;
        }
        this.zza.zzr(i2, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < zzeiVar.size(); i12++) {
            zzeiVar.zze(i12);
            i11 += 4;
        }
        this.zza.zzt(i11);
        while (i8 < zzeiVar.size()) {
            this.zza.zzg(zzeiVar.zze(i8));
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void zzz(int i2, long j) throws IOException {
        this.zza.zzh(i2, j);
    }
}
