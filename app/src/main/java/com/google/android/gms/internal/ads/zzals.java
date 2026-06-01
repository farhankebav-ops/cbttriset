package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzals {

    @ColorInt
    private int zzf;
    private int zzh;
    private float zzn;
    private String zza = "";
    private String zzb = "";
    private Set zzc = Collections.EMPTY_SET;
    private String zzd = "";

    @Nullable
    private String zze = null;
    private boolean zzg = false;
    private boolean zzi = false;
    private int zzj = -1;
    private int zzk = -1;
    private int zzl = -1;
    private int zzm = -1;
    private int zzo = -1;
    private boolean zzp = false;

    private static int zzA(int i2, String str, @Nullable String str2, int i8) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i8;
        }
        return -1;
    }

    public final void zza(String str) {
        this.zza = str;
    }

    public final void zzb(String str) {
        this.zzb = str;
    }

    public final void zzc(String[] strArr) {
        this.zzc = new HashSet(Arrays.asList(strArr));
    }

    public final void zzd(String str) {
        this.zzd = str;
    }

    public final int zze(@Nullable String str, @Nullable String str2, Set set, @Nullable String str3) {
        if (this.zza.isEmpty() && this.zzb.isEmpty() && this.zzc.isEmpty() && this.zzd.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iZzA = zzA(zzA(zzA(0, this.zza, str, BasicMeasure.EXACTLY), this.zzb, str2, 2), this.zzd, str3, 4);
        if (iZzA == -1 || !set.containsAll(this.zzc)) {
            return 0;
        }
        return (this.zzc.size() * 4) + iZzA;
    }

    public final int zzf() {
        int i2 = this.zzk;
        if (i2 == -1 && this.zzl == -1) {
            return -1;
        }
        return (i2 == 1 ? 1 : 0) | (this.zzl == 1 ? 2 : 0);
    }

    public final boolean zzg() {
        return this.zzj == 1;
    }

    public final zzals zzh(boolean z2) {
        this.zzj = 1;
        return this;
    }

    public final zzals zzi(boolean z2) {
        this.zzk = 1;
        return this;
    }

    public final zzals zzj(boolean z2) {
        this.zzl = 1;
        return this;
    }

    @Nullable
    public final String zzk() {
        return this.zze;
    }

    public final zzals zzl(@Nullable String str) {
        this.zze = zzglm.zza(str);
        return this;
    }

    public final int zzm() {
        if (this.zzg) {
            return this.zzf;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public final zzals zzn(int i2) {
        this.zzf = i2;
        this.zzg = true;
        return this;
    }

    public final boolean zzo() {
        return this.zzg;
    }

    public final int zzp() {
        if (this.zzi) {
            return this.zzh;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public final zzals zzq(int i2) {
        this.zzh = i2;
        this.zzi = true;
        return this;
    }

    public final boolean zzr() {
        return this.zzi;
    }

    public final zzals zzs(float f4) {
        this.zzn = f4;
        return this;
    }

    public final zzals zzt(int i2) {
        this.zzm = i2;
        return this;
    }

    public final int zzu() {
        return this.zzm;
    }

    public final float zzv() {
        return this.zzn;
    }

    public final zzals zzw(int i2) {
        this.zzo = i2;
        return this;
    }

    public final int zzx() {
        return this.zzo;
    }

    public final zzals zzy(boolean z2) {
        this.zzp = z2;
        return this;
    }

    public final boolean zzz() {
        return this.zzp;
    }
}
