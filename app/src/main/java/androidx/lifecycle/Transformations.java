package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.w;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Transformations {

    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$switchMap$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 implements Observer {
        final /* synthetic */ MediatorLiveData $result;
        final /* synthetic */ Function $switchMapFunction;
        private LiveData liveData;

        public AnonymousClass2(Function function, MediatorLiveData mediatorLiveData) {
            this.$switchMapFunction = function;
            this.$result = mediatorLiveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x onChanged$lambda$0(MediatorLiveData mediatorLiveData, Object obj) {
            mediatorLiveData.setValue(obj);
            return x.f13520a;
        }

        public final LiveData getLiveData() {
            return this.liveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object obj) {
            LiveData liveData = (LiveData) this.$switchMapFunction.apply(obj);
            LiveData liveData2 = this.liveData;
            if (liveData2 == liveData) {
                return;
            }
            if (liveData2 != null) {
                this.$result.removeSource(liveData2);
            }
            this.liveData = liveData;
            if (liveData != null) {
                MediatorLiveData mediatorLiveData = this.$result;
                mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new c(mediatorLiveData, 2)));
            }
        }

        public final void setLiveData(LiveData liveData) {
            this.liveData = liveData;
        }
    }

    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData;
        kotlin.jvm.internal.k.e(liveData, "<this>");
        w wVar = new w();
        wVar.f12728a = true;
        if (liveData.isInitialized()) {
            wVar.f12728a = false;
            mediatorLiveData = new MediatorLiveData(liveData.getValue());
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new m(mediatorLiveData, wVar, 1)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x distinctUntilChanged$lambda$4(MediatorLiveData mediatorLiveData, w wVar, Object obj) {
        T value = mediatorLiveData.getValue();
        if (wVar.f12728a || ((value == 0 && obj != null) || (value != 0 && !value.equals(obj)))) {
            wVar.f12728a = false;
            mediatorLiveData.setValue(obj);
        }
        return x.f13520a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, e6.l transform) {
        kotlin.jvm.internal.k.e(liveData, "<this>");
        kotlin.jvm.internal.k.e(transform, "transform");
        MediatorLiveData mediatorLiveData = liveData.isInitialized() ? new MediatorLiveData(transform.invoke(liveData.getValue())) : new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new m(mediatorLiveData, transform, 0)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x map$lambda$0(MediatorLiveData mediatorLiveData, e6.l lVar, Object obj) {
        mediatorLiveData.setValue(lVar.invoke(obj));
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x map$lambda$1(MediatorLiveData mediatorLiveData, Function function, Object obj) {
        mediatorLiveData.setValue(function.apply(obj));
        return x.f13520a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final e6.l transform) {
        LiveData liveData2;
        kotlin.jvm.internal.k.e(liveData, "<this>");
        kotlin.jvm.internal.k.e(transform, "transform");
        final a0 a0Var = new a0();
        final MediatorLiveData mediatorLiveData = (liveData.isInitialized() && (liveData2 = (LiveData) transform.invoke(liveData.getValue())) != null && liveData2.isInitialized()) ? new MediatorLiveData(liveData2.getValue()) : new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new e6.l() { // from class: androidx.lifecycle.l
            @Override // e6.l
            public final Object invoke(Object obj) {
                return Transformations.switchMap$lambda$3(transform, a0Var, mediatorLiveData, obj);
            }
        }));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x switchMap$lambda$3(e6.l lVar, a0 a0Var, MediatorLiveData mediatorLiveData, Object obj) {
        LiveData liveData = (LiveData) lVar.invoke(obj);
        Object obj2 = a0Var.f12717a;
        if (obj2 != liveData) {
            if (obj2 != null) {
                mediatorLiveData.removeSource((LiveData) obj2);
            }
            a0Var.f12717a = liveData;
            if (liveData != null) {
                mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new c(mediatorLiveData, 1)));
            }
        }
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x switchMap$lambda$3$lambda$2(MediatorLiveData mediatorLiveData, Object obj) {
        mediatorLiveData.setValue(obj);
        return x.f13520a;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function mapFunction) {
        kotlin.jvm.internal.k.e(liveData, "<this>");
        kotlin.jvm.internal.k.e(mapFunction, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new m(mediatorLiveData, mapFunction, 2)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, Function switchMapFunction) {
        kotlin.jvm.internal.k.e(liveData, "<this>");
        kotlin.jvm.internal.k.e(switchMapFunction, "switchMapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new AnonymousClass2(switchMapFunction, mediatorLiveData));
        return mediatorLiveData;
    }
}
