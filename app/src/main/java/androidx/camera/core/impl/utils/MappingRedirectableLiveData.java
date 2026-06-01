package androidx.camera.core.impl.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.k;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MappingRedirectableLiveData<I, O> extends MediatorLiveData<O> {
    private final O initialValue;
    private LiveData<I> liveDataSource;
    private final Function<I, O> mapFunction;

    public MappingRedirectableLiveData(O o2, Function<I, O> mapFunction) {
        k.e(mapFunction, "mapFunction");
        this.initialValue = o2;
        this.mapFunction = mapFunction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void redirectTo$lambda$2(MappingRedirectableLiveData mappingRedirectableLiveData, LiveData liveData) {
        final a aVar = new a(mappingRedirectableLiveData, 0);
        super.addSource(liveData, new Observer() { // from class: androidx.camera.core.impl.utils.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aVar.invoke(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x redirectTo$lambda$2$lambda$0(MappingRedirectableLiveData mappingRedirectableLiveData, Object obj) {
        mappingRedirectableLiveData.setValue(mappingRedirectableLiveData.mapFunction.apply(obj));
        return x.f13520a;
    }

    @Override // androidx.lifecycle.MediatorLiveData
    public <S> void addSource(LiveData<S> source, Observer<? super S> onChanged) {
        k.e(source, "source");
        k.e(onChanged, "onChanged");
        throw new UnsupportedOperationException();
    }

    @Override // androidx.lifecycle.LiveData
    public O getValue() {
        LiveData<I> liveData = this.liveDataSource;
        return liveData == null ? this.initialValue : this.mapFunction.apply(liveData.getValue());
    }

    public final void redirectTo(LiveData<I> liveDataSource) {
        k.e(liveDataSource, "liveDataSource");
        LiveData<I> liveData = this.liveDataSource;
        if (liveData != null) {
            super.removeSource(liveData);
        }
        this.liveDataSource = liveDataSource;
        Threads.runOnMain(new a3.c(2, this, liveDataSource));
    }
}
