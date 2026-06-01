package androidx.camera.core.internal;

import androidx.annotation.RestrictTo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.StreamSpec;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.Map;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StreamSpecQueryResult {
    private final int maxSupportedFrameRate;
    private final Map<UseCase, StreamSpec> streamSpecs;

    public StreamSpecQueryResult() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StreamSpecQueryResult copy$default(StreamSpecQueryResult streamSpecQueryResult, Map map, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            map = streamSpecQueryResult.streamSpecs;
        }
        if ((i8 & 2) != 0) {
            i2 = streamSpecQueryResult.maxSupportedFrameRate;
        }
        return streamSpecQueryResult.copy(map, i2);
    }

    public final Map<UseCase, StreamSpec> component1() {
        return this.streamSpecs;
    }

    public final int component2() {
        return this.maxSupportedFrameRate;
    }

    public final StreamSpecQueryResult copy(Map<UseCase, ? extends StreamSpec> streamSpecs, int i2) {
        k.e(streamSpecs, "streamSpecs");
        return new StreamSpecQueryResult(streamSpecs, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreamSpecQueryResult)) {
            return false;
        }
        StreamSpecQueryResult streamSpecQueryResult = (StreamSpecQueryResult) obj;
        return k.a(this.streamSpecs, streamSpecQueryResult.streamSpecs) && this.maxSupportedFrameRate == streamSpecQueryResult.maxSupportedFrameRate;
    }

    public final int getMaxSupportedFrameRate() {
        return this.maxSupportedFrameRate;
    }

    public final Map<UseCase, StreamSpec> getStreamSpecs() {
        return this.streamSpecs;
    }

    public int hashCode() {
        return (this.streamSpecs.hashCode() * 31) + this.maxSupportedFrameRate;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StreamSpecQueryResult(streamSpecs=");
        sb.append(this.streamSpecs);
        sb.append(", maxSupportedFrameRate=");
        return a0.c(sb, this.maxSupportedFrameRate, ')');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StreamSpecQueryResult(Map<UseCase, ? extends StreamSpec> streamSpecs, int i2) {
        k.e(streamSpecs, "streamSpecs");
        this.streamSpecs = streamSpecs;
        this.maxSupportedFrameRate = i2;
    }

    public /* synthetic */ StreamSpecQueryResult(Map map, int i2, int i8, kotlin.jvm.internal.f fVar) {
        this((i8 & 1) != 0 ? s.f13639a : map, (i8 & 2) != 0 ? Integer.MAX_VALUE : i2);
    }
}
