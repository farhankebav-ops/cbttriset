package androidx.camera.core.impl.utils;

import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataUtil {
    public static final LiveDataUtil INSTANCE = new LiveDataUtil();

    private LiveDataUtil() {
    }

    @MainThread
    public static final <I, O> LiveData<O> map(LiveData<I> source, Function<I, O> mapFunction) {
        k.e(source, "source");
        k.e(mapFunction, "mapFunction");
        MappingRedirectableLiveData mappingRedirectableLiveData = new MappingRedirectableLiveData(mapFunction.apply(source.getValue()), mapFunction);
        mappingRedirectableLiveData.redirectTo(source);
        return mappingRedirectableLiveData;
    }
}
