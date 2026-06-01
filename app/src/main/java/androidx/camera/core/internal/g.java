package androidx.camera.core.internal;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class g {
    public static Executor a(ThreadConfig threadConfig) {
        return (Executor) threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
    }

    public static Executor b(ThreadConfig threadConfig, Executor executor) {
        return (Executor) threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
    }
}
