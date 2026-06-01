package androidx.camera.core.internal;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static Executor a(IoConfig ioConfig) {
        return (Executor) ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR);
    }

    public static Executor b(IoConfig ioConfig, Executor executor) {
        return (Executor) ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR, executor);
    }
}
