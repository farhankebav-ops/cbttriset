package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.savedstate.Recreator;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistry {
    private final SavedStateRegistryImpl impl;
    private Recreator.SavedStateProvider recreatorProvider;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface SavedStateProvider {
        Bundle saveState();
    }

    public SavedStateRegistry(SavedStateRegistryImpl impl) {
        k.e(impl, "impl");
        this.impl = impl;
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String key) {
        k.e(key, "key");
        return this.impl.consumeRestoredStateForKey(key);
    }

    public final SavedStateProvider getSavedStateProvider(String key) {
        k.e(key, "key");
        return this.impl.getSavedStateProvider(key);
    }

    @MainThread
    public final boolean isRestored() {
        return this.impl.isRestored();
    }

    @MainThread
    public final void registerSavedStateProvider(String key, SavedStateProvider provider) {
        k.e(key, "key");
        k.e(provider, "provider");
        this.impl.registerSavedStateProvider(key, provider);
    }

    @MainThread
    public final void runOnNextRecreation(Class<? extends AutoRecreated> clazz) {
        k.e(clazz, "clazz");
        if (!this.impl.isAllowingSavingState$savedstate_release()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
        if (savedStateProvider == null) {
            savedStateProvider = new Recreator.SavedStateProvider(this);
        }
        this.recreatorProvider = savedStateProvider;
        try {
            clazz.getDeclaredConstructor(null);
            Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
            if (savedStateProvider2 != null) {
                savedStateProvider2.add(clazz.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    @MainThread
    public final void unregisterSavedStateProvider(String key) {
        k.e(key, "key");
        this.impl.unregisterSavedStateProvider(key);
    }
}
