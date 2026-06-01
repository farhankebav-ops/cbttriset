package com.google.mlkit.common.model;

import a1.a;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteModelManager {
    private final Map zza = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @KeepForSdk
    public static class RemoteModelManagerRegistration {
        private final Class zza;
        private final Provider zzb;

        @KeepForSdk
        public <RemoteT extends RemoteModel> RemoteModelManagerRegistration(@NonNull Class<RemoteT> cls, @NonNull Provider<? extends RemoteModelManagerInterface<RemoteT>> provider) {
            this.zza = cls;
            this.zzb = provider;
        }

        public final Provider zza() {
            return this.zzb;
        }

        public final Class zzb() {
            return this.zza;
        }
    }

    @KeepForSdk
    public RemoteModelManager(@NonNull Set<RemoteModelManagerRegistration> set) {
        for (RemoteModelManagerRegistration remoteModelManagerRegistration : set) {
            this.zza.put(remoteModelManagerRegistration.zzb(), remoteModelManagerRegistration.zza());
        }
    }

    @NonNull
    public static synchronized RemoteModelManager getInstance() {
        return (RemoteModelManager) MlKitContext.getInstance().get(RemoteModelManager.class);
    }

    private final RemoteModelManagerInterface zza(Class cls) {
        return (RemoteModelManagerInterface) ((Provider) Preconditions.checkNotNull((Provider) this.zza.get(cls))).get();
    }

    @NonNull
    public Task<Void> deleteDownloadedModel(@NonNull RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        return zza(remoteModel.getClass()).deleteDownloadedModel(remoteModel);
    }

    @NonNull
    public Task<Void> download(@NonNull RemoteModel remoteModel, @NonNull DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions cannot be null");
        return this.zza.containsKey(remoteModel.getClass()) ? zza(remoteModel.getClass()).download(remoteModel, downloadConditions) : Tasks.forException(new MlKitException(a.m("Feature model '", remoteModel.getClass().getSimpleName(), "' doesn't have a corresponding modelmanager registered."), 13));
    }

    @NonNull
    public <T extends RemoteModel> Task<Set<T>> getDownloadedModels(@NonNull Class<T> cls) {
        return ((RemoteModelManagerInterface) ((Provider) Preconditions.checkNotNull((Provider) this.zza.get(cls))).get()).getDownloadedModels();
    }

    @NonNull
    public Task<Boolean> isModelDownloaded(@NonNull RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        return zza(remoteModel.getClass()).isModelDownloaded(remoteModel);
    }
}
