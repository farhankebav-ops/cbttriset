package androidx.camera.video;

import androidx.annotation.RestrictTo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class StreamInfo {
    static final int STREAM_ID_ANY = 0;
    static final int STREAM_ID_ERROR = -1;
    static final StreamInfo STREAM_INFO_ANY_INACTIVE = of(0, StreamState.INACTIVE);
    static final Set<Integer> NON_SURFACE_STREAM_ID = Collections.unmodifiableSet(new HashSet(Arrays.asList(0, -1)));
    static final Observable<StreamInfo> ALWAYS_ACTIVE_OBSERVABLE = ConstantObservable.withValue(of(0, StreamState.ACTIVE));

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public enum StreamState {
        ACTIVE,
        INACTIVE
    }

    public static StreamInfo of(int i2, StreamState streamState) {
        return new AutoValue_StreamInfo(i2, streamState, null);
    }

    public abstract int getId();

    public abstract SurfaceRequest.TransformationInfo getInProgressTransformationInfo();

    public abstract StreamState getStreamState();

    public static StreamInfo of(int i2, StreamState streamState, SurfaceRequest.TransformationInfo transformationInfo) {
        return new AutoValue_StreamInfo(i2, streamState, transformationInfo);
    }
}
