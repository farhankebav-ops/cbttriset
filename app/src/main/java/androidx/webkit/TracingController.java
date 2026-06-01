package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.TracingControllerImpl;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@AnyThread
public abstract class TracingController {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class LAZY_HOLDER {
        static final TracingController INSTANCE = new TracingControllerImpl();

        private LAZY_HOLDER() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TracingController() {
    }

    @NonNull
    public static TracingController getInstance() {
        return LAZY_HOLDER.INSTANCE;
    }

    public abstract boolean isTracing();

    public abstract void start(@NonNull TracingConfig tracingConfig);

    public abstract boolean stop(@Nullable OutputStream outputStream, @NonNull Executor executor);
}
