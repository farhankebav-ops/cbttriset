package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.concurrent.futures.ListenableFutureKt;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessCameraProviderExtKt {
    public static final Object awaitInstance(ProcessCameraProvider.Companion companion, Context context, c<? super ProcessCameraProvider> cVar) {
        return ListenableFutureKt.await(companion.getInstance(context), cVar);
    }
}
