package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.camera.core.processing.util.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
public final class WakeLockEvent extends StatsEvent {

    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();

    @SafeParcelable.VersionField(id = 1)
    final int zza;

    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    private final long zzb;

    @SafeParcelable.Field(getter = "getEventType", id = 11)
    private final int zzc;

    @SafeParcelable.Field(getter = "getWakeLockName", id = 4)
    private final String zzd;

    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)
    private final String zze;

    @SafeParcelable.Field(getter = "getCodePackage", id = 17)
    private final String zzf;

    @SafeParcelable.Field(getter = "getWakeLockType", id = 5)
    private final int zzg;

    @SafeParcelable.Field(getter = "getCallingPackages", id = 6)
    private final List zzh;

    @SafeParcelable.Field(getter = "getEventKey", id = 12)
    private final String zzi;

    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)
    private final long zzj;

    @SafeParcelable.Field(getter = "getDeviceState", id = 14)
    private final int zzk;

    @SafeParcelable.Field(getter = "getHostPackage", id = 13)
    private final String zzl;

    @SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)
    private final float zzm;

    @SafeParcelable.Field(getter = "getTimeout", id = 16)
    private final long zzn;

    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", id = 18)
    private final boolean zzo;

    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 11) int i8, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i9, @SafeParcelable.Param(id = 6) List list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j3, @SafeParcelable.Param(id = 14) int i10, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f4, @SafeParcelable.Param(id = 16) long j8, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z2) {
        this.zza = i2;
        this.zzb = j;
        this.zzc = i8;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i9;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j3;
        this.zzk = i10;
        this.zzl = str4;
        this.zzm = f4;
        this.zzn = j8;
        this.zzo = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzj);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzc);
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
        SafeParcelWriter.writeLong(parcel, 16, this.zzn);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @NonNull
    public final String zzc() {
        List list = this.zzh;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        int i2 = this.zzk;
        String str = this.zze;
        String str2 = this.zzl;
        float f4 = this.zzm;
        String str3 = this.zzf;
        int i8 = this.zzg;
        String str4 = this.zzd;
        boolean z2 = this.zzo;
        int length = String.valueOf(i2).length() + String.valueOf(i8).length() + String.valueOf(str4).length() + 2 + 1 + String.valueOf(strJoin).length() + 1;
        if (str == null) {
            str = "";
        }
        int iD = a.D(length + 1, 1, str);
        if (str2 == null) {
            str2 = "";
        }
        int length2 = String.valueOf(f4).length() + a.D(iD, 1, str2) + 1;
        String str5 = str3 != null ? str3 : "";
        StringBuilder sb = new StringBuilder(a.D(length2, 1, str5) + String.valueOf(z2).length());
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(i8);
        sb.append("\t");
        sb.append(strJoin);
        sb.append("\t");
        sb.append(i2);
        a.A(sb, "\t", str, "\t", str2);
        sb.append("\t");
        sb.append(f4);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z2);
        return sb.toString();
    }
}
