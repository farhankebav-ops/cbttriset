package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public interface RemoteModelFileMover {
    @NonNull
    @KeepForSdk
    File getModelFileDestination() throws MlKitException;

    @Nullable
    @KeepForSdk
    File moveAllFilesFromPrivateTempToPrivateDestination(@NonNull File file) throws MlKitException;
}
