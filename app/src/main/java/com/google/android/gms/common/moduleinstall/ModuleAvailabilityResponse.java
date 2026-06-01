package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "ModuleAvailabilityResponseCreator")
public class ModuleAvailabilityResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new zaa();

    @SafeParcelable.Field(getter = "areModulesAvailable", id = 1)
    private final boolean zaa;

    @SafeParcelable.Field(getter = "getAvailabilityStatus", id = 2)
    private final int zab;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.CLASS)
    public @interface AvailabilityStatus {
        public static final int STATUS_ALREADY_AVAILABLE = 0;
        public static final int STATUS_READY_TO_DOWNLOAD = 1;
        public static final int STATUS_UNKNOWN_MODULE = 2;
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public ModuleAvailabilityResponse(@SafeParcelable.Param(id = 1) boolean z2, @SafeParcelable.Param(id = 2) int i2) {
        this.zaa = z2;
        this.zab = i2;
    }

    public boolean areModulesAvailable() {
        return this.zaa;
    }

    @AvailabilityStatus
    public int getAvailabilityStatus() {
        return this.zab;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, areModulesAvailable());
        SafeParcelWriter.writeInt(parcel, 2, getAvailabilityStatus());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
