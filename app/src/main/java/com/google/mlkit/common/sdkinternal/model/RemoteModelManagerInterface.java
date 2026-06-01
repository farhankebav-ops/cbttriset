package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public interface RemoteModelManagerInterface<RemoteT extends RemoteModel> {
    @NonNull
    @KeepForSdk
    Task<Void> deleteDownloadedModel(@NonNull RemoteT remotet);

    @NonNull
    @KeepForSdk
    Task<Void> download(@NonNull RemoteT remotet, @NonNull DownloadConditions downloadConditions);

    @NonNull
    @KeepForSdk
    Task<Set<RemoteT>> getDownloadedModels();

    @NonNull
    @KeepForSdk
    Task<Boolean> isModelDownloaded(@NonNull RemoteT remotet);
}
