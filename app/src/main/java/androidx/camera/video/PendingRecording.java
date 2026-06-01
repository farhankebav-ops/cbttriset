package androidx.camera.video;

import android.content.Context;
import androidx.annotation.CheckResult;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import q6.c0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PendingRecording {
    private final Context applicationContext;
    private Consumer<VideoRecordEvent> eventListener;
    private boolean isAudioEnabled;
    private boolean isAudioInitialMuted;
    private boolean isPersistent;
    private Executor listenerExecutor;
    private final OutputOptions outputOptions;
    private final Recorder recorder;

    public PendingRecording(Context context, Recorder recorder, OutputOptions outputOptions) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(recorder, "recorder");
        kotlin.jvm.internal.k.e(outputOptions, "outputOptions");
        this.recorder = recorder;
        this.outputOptions = outputOptions;
        Context applicationContext = ContextUtil.getApplicationContext(context);
        kotlin.jvm.internal.k.d(applicationContext, "getApplicationContext(...)");
        this.applicationContext = applicationContext;
    }

    public static /* synthetic */ PendingRecording withAudioEnabled$default(PendingRecording pendingRecording, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return pendingRecording.withAudioEnabled(z2);
    }

    @ExperimentalPersistentRecording
    public final PendingRecording asPersistentRecording() {
        this.isPersistent = true;
        return this;
    }

    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public final Consumer<VideoRecordEvent> getEventListener() {
        return this.eventListener;
    }

    public final Executor getListenerExecutor() {
        return this.listenerExecutor;
    }

    public final OutputOptions getOutputOptions() {
        return this.outputOptions;
    }

    public final Recorder getRecorder() {
        return this.recorder;
    }

    public final boolean isAudioEnabled() {
        return this.isAudioEnabled;
    }

    public final boolean isAudioInitialMuted() {
        return this.isAudioInitialMuted;
    }

    public final boolean isPersistent() {
        return this.isPersistent;
    }

    @CheckResult
    public final Recording start(Executor listenerExecutor, Consumer<VideoRecordEvent> listener) {
        kotlin.jvm.internal.k.e(listenerExecutor, "listenerExecutor");
        kotlin.jvm.internal.k.e(listener, "listener");
        Preconditions.checkNotNull(listenerExecutor, "Listener Executor can't be null.");
        Preconditions.checkNotNull(listener, "Event listener can't be null");
        this.listenerExecutor = listenerExecutor;
        this.eventListener = listener;
        Recording recordingStart = this.recorder.start(this);
        kotlin.jvm.internal.k.d(recordingStart, "start(...)");
        return recordingStart;
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    public final PendingRecording withAudioEnabled() {
        return withAudioEnabled$default(this, false, 1, null);
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    public final PendingRecording withAudioEnabled(boolean z2) {
        if (PermissionChecker.checkSelfPermission(this.applicationContext, "android.permission.RECORD_AUDIO") == -1) {
            throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
        }
        Preconditions.checkState(this.recorder.isAudioSupported(), "The Recorder this recording is associated to doesn't support audio.");
        this.isAudioEnabled = true;
        this.isAudioInitialMuted = z2;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Object start(Consumer<VideoRecordEvent> consumer, v5.c<? super Recording> cVar) {
        Executor executorDirectExecutor;
        v5.f fVar = cVar.getContext().get(v5.d.f17609a);
        q6.w wVar = fVar instanceof q6.w ? (q6.w) fVar : null;
        if (wVar != null) {
            executorDirectExecutor = c0.f(wVar);
        } else {
            executorDirectExecutor = CameraXExecutors.directExecutor();
            kotlin.jvm.internal.k.d(executorDirectExecutor, "directExecutor(...)");
        }
        return start(executorDirectExecutor, consumer);
    }
}
