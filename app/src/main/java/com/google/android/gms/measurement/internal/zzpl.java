package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzpl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpl> CREATOR = new zzpm();

    @SafeParcelable.Field(id = 1)
    public final int zza;

    @SafeParcelable.Field(id = 2)
    public final String zzb;

    @SafeParcelable.Field(id = 3)
    public final long zzc;

    @Nullable
    @SafeParcelable.Field(id = 4)
    public final Long zzd;

    @Nullable
    @SafeParcelable.Field(id = 6)
    public final String zze;

    @SafeParcelable.Field(id = 7)
    public final String zzf;

    @Nullable
    @SafeParcelable.Field(id = 8)
    public final Double zzg;

    @SafeParcelable.Constructor
    public zzpl(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @Nullable @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) Float f4, @Nullable @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @Nullable @SafeParcelable.Param(id = 8) Double d8) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = j;
        this.zzd = l;
        this.zzg = i2 == 1 ? f4 != null ? Double.valueOf(f4.doubleValue()) : null : d8;
        this.zze = str2;
        this.zzf = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        zzpm.zza(this, parcel, i2);
    }

    @Nullable
    public final Object zza() {
        Long l = this.zzd;
        if (l != null) {
            return l;
        }
        Double d8 = this.zzg;
        if (d8 != null) {
            return d8;
        }
        String str = this.zze;
        if (str != null) {
            return str;
        }
        return null;
    }

    public zzpl(zzpn zzpnVar) {
        this(zzpnVar.zzc, zzpnVar.zzd, zzpnVar.zze, zzpnVar.zzb);
    }

    public zzpl(String str, long j, @Nullable Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.zza = 2;
        this.zzb = str;
        this.zzc = j;
        this.zzf = str2;
        if (obj == null) {
            this.zzd = null;
            this.zzg = null;
            this.zze = null;
            return;
        }
        if (obj instanceof Long) {
            this.zzd = (Long) obj;
            this.zzg = null;
            this.zze = null;
        } else if (obj instanceof String) {
            this.zzd = null;
            this.zzg = null;
            this.zze = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.zzd = null;
                this.zzg = (Double) obj;
                this.zze = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
