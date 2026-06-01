package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {

    @Nullable
    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, ResultT> {
        private RemoteCall zaa;
        private Feature[] zac;
        private boolean zab = true;
        private int zad = 0;

        private Builder() {
        }

        @NonNull
        @KeepForSdk
        public TaskApiCall<A, ResultT> build() {
            Preconditions.checkArgument(this.zaa != null, "execute parameter required");
            return new zacv(this, this.zac, this.zab, this.zad);
        }

        @NonNull
        @KeepForSdk
        @Deprecated
        public Builder<A, ResultT> execute(@NonNull final BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.zaa = new RemoteCall() { // from class: com.google.android.gms.common.api.internal.zacu
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    biConsumer.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
                }
            };
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> run(@NonNull RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z2) {
            this.zab = z2;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> setFeatures(@NonNull Feature... featureArr) {
            this.zac = featureArr;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> setMethodKey(int i2) {
            this.zad = i2;
            return this;
        }

        public /* synthetic */ Builder(zacw zacwVar) {
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>(null);
    }

    @KeepForSdk
    public abstract void doExecute(@NonNull A a8, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final int zaa() {
        return this.zac;
    }

    @Nullable
    public final Feature[] zab() {
        return this.zaa;
    }

    @KeepForSdk
    public TaskApiCall(@Nullable Feature[] featureArr, boolean z2, int i2) {
        this.zaa = featureArr;
        boolean z7 = false;
        if (featureArr != null && z2) {
            z7 = true;
        }
        this.zab = z7;
        this.zac = i2;
    }
}
