package com.google.mlkit.common.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class CustomRemoteModel extends RemoteModel {
    private final RemoteModelSource zzb;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {

        @NonNull
        private final RemoteModelSource zza;

        public Builder(@NonNull RemoteModelSource remoteModelSource) {
            Preconditions.checkNotNull(remoteModelSource);
            this.zza = remoteModelSource;
        }

        @NonNull
        public CustomRemoteModel build() {
            return new CustomRemoteModel(this.zza, null);
        }
    }

    public /* synthetic */ CustomRemoteModel(RemoteModelSource remoteModelSource, zza zzaVar) {
        super(TextUtils.isEmpty(remoteModelSource.zza()) ? "no_model_name" : remoteModelSource.zza(), null, ModelType.CUSTOM);
        this.zzb = remoteModelSource;
    }

    @NonNull
    @KeepForSdk
    public RemoteModelSource getRemoteModelSource() {
        return this.zzb;
    }
}
