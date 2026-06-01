package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.lifecycle.internal.SavedStateHandleImpl_androidKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import t6.b1;
import t6.q0;
import t6.s0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandle {
    public static final Companion Companion = new Companion(null);
    private SavedStateHandleImpl impl;
    private final Map<String, SavingStateLiveData<?>> liveDatas;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                bundle = bundle2;
            }
            if (bundle == null) {
                return new SavedStateHandle();
            }
            ClassLoader classLoader = SavedStateHandle.class.getClassLoader();
            kotlin.jvm.internal.k.b(classLoader);
            bundle.setClassLoader(classLoader);
            return new SavedStateHandle(SavedStateReader.m164toMapimpl(SavedStateReader.m83constructorimpl(bundle)));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(Object obj) {
            return SavedStateHandleImpl_androidKt.isAcceptableType(obj);
        }

        private Companion() {
        }
    }

    public SavedStateHandle(Map<String, ? extends Object> initialState) {
        kotlin.jvm.internal.k.e(initialState, "initialState");
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl(initialState);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String str, boolean z2, T t3) {
        SavingStateLiveData<?> savingStateLiveData;
        if (this.impl.getMutableFlows().containsKey(str)) {
            throw new IllegalArgumentException(SavedStateHandle_androidKt.createMutuallyExclusiveErrorMessage(str).toString());
        }
        Map<String, SavingStateLiveData<?>> map = this.liveDatas;
        SavingStateLiveData<?> savingStateLiveData2 = map.get(str);
        if (savingStateLiveData2 == null) {
            if (this.impl.getRegular().containsKey(str)) {
                savingStateLiveData = new SavingStateLiveData<>(this, str, this.impl.getRegular().get(str));
            } else if (z2) {
                this.impl.getRegular().put(str, t3);
                savingStateLiveData = new SavingStateLiveData<>(this, str, t3);
            } else {
                savingStateLiveData = new SavingStateLiveData<>(this, str);
            }
            savingStateLiveData2 = savingStateLiveData;
            map.put(str, savingStateLiveData2);
        }
        return savingStateLiveData2;
    }

    @MainThread
    public final void clearSavedStateProvider(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        this.impl.clearSavedStateProvider(key);
    }

    @MainThread
    public final boolean contains(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        return this.impl.contains(key);
    }

    @MainThread
    public final <T> T get(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        return (T) this.impl.get(key);
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(key, false, null);
        kotlin.jvm.internal.k.c(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    @MainThread
    public final <T> q0 getMutableStateFlow(String key, T t3) {
        kotlin.jvm.internal.k.e(key, "key");
        if (this.liveDatas.containsKey(key)) {
            throw new IllegalArgumentException(SavedStateHandle_androidKt.createMutuallyExclusiveErrorMessage(key).toString());
        }
        return this.impl.getMutableStateFlow(key, t3);
    }

    @MainThread
    public final <T> b1 getStateFlow(String key, T t3) {
        kotlin.jvm.internal.k.e(key, "key");
        return this.impl.getMutableFlows().containsKey(key) ? new s0(this.impl.getMutableStateFlow(key, t3)) : this.impl.getStateFlow(key, t3);
    }

    @MainThread
    public final Set<String> keys() {
        return n7.b.G(this.impl.keys(), this.liveDatas.keySet());
    }

    @MainThread
    public final <T> T remove(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        T t3 = (T) this.impl.remove(key);
        SavingStateLiveData<?> savingStateLiveDataRemove = this.liveDatas.remove(key);
        if (savingStateLiveDataRemove != null) {
            savingStateLiveDataRemove.detach();
        }
        return t3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.impl.getSavedStateProvider();
    }

    @MainThread
    public final <T> void set(String key, T t3) {
        kotlin.jvm.internal.k.e(key, "key");
        if (!Companion.validateValue(t3)) {
            StringBuilder sb = new StringBuilder("Can't put value with type ");
            kotlin.jvm.internal.k.b(t3);
            sb.append(t3.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString().toString());
        }
        SavingStateLiveData<?> savingStateLiveData = this.liveDatas.get(key);
        SavingStateLiveData<?> savingStateLiveData2 = savingStateLiveData instanceof MutableLiveData ? savingStateLiveData : null;
        if (savingStateLiveData2 != null) {
            savingStateLiveData2.setValue(t3);
        }
        this.impl.set(key, t3);
    }

    @MainThread
    public final void setSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(provider, "provider");
        this.impl.setSavedStateProvider(key, provider);
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String key, T t3) {
        kotlin.jvm.internal.k.e(key, "key");
        return getLiveDataInternal(key, true, t3);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(SavedStateHandle savedStateHandle, String key, T t3) {
            super(t3);
            kotlin.jvm.internal.k.e(key, "key");
            this.key = key;
            this.handle = savedStateHandle;
        }

        public final void detach() {
            this.handle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t3) {
            SavedStateHandleImpl savedStateHandleImpl;
            SavedStateHandle savedStateHandle = this.handle;
            if (savedStateHandle != null && (savedStateHandleImpl = savedStateHandle.impl) != null) {
                savedStateHandleImpl.set(this.key, t3);
            }
            super.setValue(t3);
        }

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String key) {
            kotlin.jvm.internal.k.e(key, "key");
            this.key = key;
            this.handle = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl(null, 1, 0 == true ? 1 : 0);
    }
}
