package androidx.savedstate.internal;

import android.os.Bundle;
import androidx.activity.m;
import androidx.annotation.MainThread;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.SavedStateWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryImpl {
    private static final Companion Companion = new Companion(null);
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private boolean isAllowingSavingState;
    private boolean isRestored;
    private final Map<String, SavedStateRegistry.SavedStateProvider> keyToProviders;
    private final SynchronizedObject lock;
    private final e6.a onAttach;
    private final SavedStateRegistryOwner owner;
    private Bundle restoredState;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public SavedStateRegistryImpl(SavedStateRegistryOwner owner, e6.a onAttach) {
        k.e(owner, "owner");
        k.e(onAttach, "onAttach");
        this.owner = owner;
        this.onAttach = onAttach;
        this.lock = new SynchronizedObject();
        this.keyToProviders = new LinkedHashMap();
        this.isAllowingSavingState = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performAttach$lambda$12(SavedStateRegistryImpl savedStateRegistryImpl, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        k.e(lifecycleOwner, "<unused var>");
        k.e(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistryImpl.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistryImpl.isAllowingSavingState = false;
        }
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String key) {
        k.e(key, "key");
        if (!this.isRestored) {
            throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
        }
        Bundle bundle = this.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundleM83constructorimpl = SavedStateReader.m83constructorimpl(bundle);
        Bundle bundleM140getSavedStateimpl = SavedStateReader.m84containsimpl(bundleM83constructorimpl, key) ? SavedStateReader.m140getSavedStateimpl(bundleM83constructorimpl, key) : null;
        SavedStateWriter.m205removeimpl(SavedStateWriter.m169constructorimpl(bundle), key);
        if (SavedStateReader.m161isEmptyimpl(SavedStateReader.m83constructorimpl(bundle))) {
            this.restoredState = null;
        }
        return bundleM140getSavedStateimpl;
    }

    public final e6.a getOnAttach$savedstate_release() {
        return this.onAttach;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider(String key) {
        SavedStateRegistry.SavedStateProvider savedStateProvider;
        k.e(key, "key");
        synchronized (this.lock) {
            Iterator it = this.keyToProviders.entrySet().iterator();
            do {
                savedStateProvider = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                SavedStateRegistry.SavedStateProvider savedStateProvider2 = (SavedStateRegistry.SavedStateProvider) entry.getValue();
                if (k.a(str, key)) {
                    savedStateProvider = savedStateProvider2;
                }
            } while (savedStateProvider == null);
        }
        return savedStateProvider;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    @MainThread
    public final boolean isRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach() {
        if (this.owner.getLifecycle().getCurrentState() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        if (this.attached) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        this.onAttach.invoke();
        this.owner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.savedstate.internal.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                SavedStateRegistryImpl.performAttach$lambda$12(this.f4079a, lifecycleOwner, event);
            }
        });
        this.attached = true;
    }

    @MainThread
    public final void performRestore$savedstate_release(Bundle bundle) {
        if (!this.attached) {
            performAttach();
        }
        if (this.owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + this.owner.getLifecycle().getCurrentState()).toString());
        }
        if (this.isRestored) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        Bundle bundleM140getSavedStateimpl = null;
        if (bundle != null) {
            Bundle bundleM83constructorimpl = SavedStateReader.m83constructorimpl(bundle);
            if (SavedStateReader.m84containsimpl(bundleM83constructorimpl, SAVED_COMPONENTS_KEY)) {
                bundleM140getSavedStateimpl = SavedStateReader.m140getSavedStateimpl(bundleM83constructorimpl, SAVED_COMPONENTS_KEY);
            }
        }
        this.restoredState = bundleM140getSavedStateimpl;
        this.isRestored = true;
    }

    @MainThread
    public final void performSave$savedstate_release(Bundle outBundle) {
        k.e(outBundle, "outBundle");
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(new i[0], 0));
        Bundle bundleM169constructorimpl = SavedStateWriter.m169constructorimpl(bundleBundleOf);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            SavedStateWriter.m173putAllimpl(bundleM169constructorimpl, bundle);
        }
        synchronized (this.lock) {
            for (Map.Entry entry : this.keyToProviders.entrySet()) {
                SavedStateWriter.m196putSavedStateimpl(bundleM169constructorimpl, (String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
            }
        }
        if (SavedStateReader.m161isEmptyimpl(SavedStateReader.m83constructorimpl(bundleBundleOf))) {
            return;
        }
        SavedStateWriter.m196putSavedStateimpl(SavedStateWriter.m169constructorimpl(outBundle), SAVED_COMPONENTS_KEY, bundleBundleOf);
    }

    @MainThread
    public final void registerSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        k.e(key, "key");
        k.e(provider, "provider");
        synchronized (this.lock) {
            if (this.keyToProviders.containsKey(key)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            this.keyToProviders.put(key, provider);
        }
    }

    public final void setAllowingSavingState$savedstate_release(boolean z2) {
        this.isAllowingSavingState = z2;
    }

    @MainThread
    public final void unregisterSavedStateProvider(String key) {
        k.e(key, "key");
        synchronized (this.lock) {
        }
    }

    public /* synthetic */ SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, e6.a aVar, int i2, f fVar) {
        this(savedStateRegistryOwner, (i2 & 2) != 0 ? new m(3) : aVar);
    }
}
