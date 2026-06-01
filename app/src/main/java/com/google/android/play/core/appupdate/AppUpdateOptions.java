package com.google.android.play.core.appupdate;

import androidx.annotation.NonNull;
import com.google.android.play.core.install.model.AppUpdateType;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AppUpdateOptions {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder {
        @NonNull
        public abstract AppUpdateOptions build();

        @NonNull
        public abstract Builder setAllowAssetPackDeletion(boolean z2);

        @NonNull
        public abstract Builder setAppUpdateType(@AppUpdateType int i2);
    }

    @NonNull
    public static AppUpdateOptions defaultOptions(@AppUpdateType int i2) {
        return newBuilder(i2).build();
    }

    @NonNull
    public static Builder newBuilder(@AppUpdateType int i2) {
        zzv zzvVar = new zzv();
        zzvVar.setAppUpdateType(i2);
        zzvVar.setAllowAssetPackDeletion(false);
        return zzvVar;
    }

    public abstract boolean allowAssetPackDeletion();

    @AppUpdateType
    public abstract int appUpdateType();
}
