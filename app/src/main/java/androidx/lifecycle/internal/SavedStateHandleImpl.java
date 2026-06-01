package androidx.lifecycle.internal;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.core.os.BundleKt;
import androidx.fragment.app.d;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;
import q5.i;
import r5.s;
import r5.x;
import t6.b1;
import t6.d1;
import t6.q0;
import t6.s0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleImpl {
    private final Map<String, q0> flows;
    private final Map<String, q0> mutableFlows;
    private final Map<String, SavedStateRegistry.SavedStateProvider> providers;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;

    public SavedStateHandleImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandleImpl savedStateHandleImpl) {
        i[] iVarArr;
        for (Map.Entry entry : x.n0(savedStateHandleImpl.mutableFlows).entrySet()) {
            savedStateHandleImpl.set((String) entry.getKey(), ((d1) ((q0) entry.getValue())).getValue());
        }
        for (Map.Entry entry2 : x.n0(savedStateHandleImpl.providers).entrySet()) {
            savedStateHandleImpl.set((String) entry2.getKey(), ((SavedStateRegistry.SavedStateProvider) entry2.getValue()).saveState());
        }
        Map<String, Object> map = savedStateHandleImpl.regular;
        if (map.isEmpty()) {
            iVarArr = new i[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, Object> entry3 : map.entrySet()) {
                arrayList.add(new i(entry3.getKey(), entry3.getValue()));
            }
            iVarArr = (i[]) arrayList.toArray(new i[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m169constructorimpl(bundleBundleOf);
        return bundleBundleOf;
    }

    @MainThread
    public final void clearSavedStateProvider(String key) {
        k.e(key, "key");
        this.providers.remove(key);
    }

    @MainThread
    public final boolean contains(String key) {
        k.e(key, "key");
        return this.regular.containsKey(key);
    }

    @MainThread
    public final <T> T get(String key) {
        T t3;
        k.e(key, "key");
        try {
            q0 q0Var = this.mutableFlows.get(key);
            if (q0Var != null && (t3 = (T) ((d1) q0Var).getValue()) != null) {
                return t3;
            }
            return (T) this.regular.get(key);
        } catch (ClassCastException unused) {
            remove(key);
            return null;
        }
    }

    public final Map<String, q0> getMutableFlows() {
        return this.mutableFlows;
    }

    @MainThread
    public final <T> q0 getMutableStateFlow(String key, T t3) {
        k.e(key, "key");
        Map<String, q0> map = this.mutableFlows;
        q0 q0VarC = map.get(key);
        if (q0VarC == null) {
            if (!this.regular.containsKey(key)) {
                this.regular.put(key, t3);
            }
            q0VarC = x0.c(this.regular.get(key));
            map.put(key, q0VarC);
        }
        return q0VarC;
    }

    public final Map<String, Object> getRegular() {
        return this.regular;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> b1 getStateFlow(String key, T t3) {
        k.e(key, "key");
        Map<String, q0> map = this.flows;
        q0 q0VarC = map.get(key);
        if (q0VarC == null) {
            if (!this.regular.containsKey(key)) {
                this.regular.put(key, t3);
            }
            q0VarC = x0.c(this.regular.get(key));
            map.put(key, q0VarC);
        }
        return new s0(q0VarC);
    }

    @MainThread
    public final Set<String> keys() {
        return b.G(this.regular.keySet(), this.providers.keySet());
    }

    @MainThread
    public final <T> T remove(String key) {
        k.e(key, "key");
        T t3 = (T) this.regular.remove(key);
        this.flows.remove(key);
        this.mutableFlows.remove(key);
        return t3;
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(String key, T t3) {
        k.e(key, "key");
        this.regular.put(key, t3);
        q0 q0Var = this.flows.get(key);
        if (q0Var != null) {
            ((d1) q0Var).h(t3);
        }
        q0 q0Var2 = this.mutableFlows.get(key);
        if (q0Var2 != null) {
            ((d1) q0Var2).h(t3);
        }
    }

    @MainThread
    public final void setSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        k.e(key, "key");
        k.e(provider, "provider");
        this.providers.put(key, provider);
    }

    public SavedStateHandleImpl(Map<String, ? extends Object> initialState) {
        k.e(initialState, "initialState");
        this.regular = x.o0(initialState);
        this.providers = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.mutableFlows = new LinkedHashMap();
        this.savedStateProvider = new d(this, 2);
    }

    public /* synthetic */ SavedStateHandleImpl(Map map, int i2, f fVar) {
        this((i2 & 1) != 0 ? s.f13639a : map);
    }
}
