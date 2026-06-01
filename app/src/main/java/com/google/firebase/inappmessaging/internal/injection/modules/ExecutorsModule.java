package com.google.firebase.inappmessaging.internal.injection.modules;

import androidx.annotation.NonNull;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class ExecutorsModule {
    private final Executor backgroundExecutor;
    private final Executor blockingExecutor;
    private final Executor lightWeightExecutor;

    public ExecutorsModule(@NonNull @Lightweight Executor executor, @NonNull @Background Executor executor2, @NonNull @Blocking Executor executor3) {
        this.lightWeightExecutor = executor;
        this.backgroundExecutor = executor2;
        this.blockingExecutor = executor3;
    }

    @NonNull
    @Provides
    @Background
    public Executor providesBackgroundExecutor() {
        return this.backgroundExecutor;
    }

    @NonNull
    @Provides
    @Blocking
    public Executor providesBlockingExecutor() {
        return this.blockingExecutor;
    }

    @NonNull
    @Provides
    @Lightweight
    public Executor providesLightWeightExecutor() {
        return this.lightWeightExecutor;
    }
}
