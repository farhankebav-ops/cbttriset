package androidx.lifecycle;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final q5.f viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, ViewModelStoreOwner viewModelStoreOwner) {
        kotlin.jvm.internal.k.e(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.k.e(viewModelStoreOwner, "viewModelStoreOwner");
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel$delegate = n7.b.C(new b(viewModelStoreOwner, 1));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public final Bundle consumeRestoredStateForKey(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        performRestore();
        Bundle bundle = this.restoredState;
        if (bundle == null || !SavedStateReader.m84containsimpl(SavedStateReader.m83constructorimpl(bundle), key)) {
            return null;
        }
        Bundle bundleM145getSavedStateOrNullimpl = SavedStateReader.m145getSavedStateOrNullimpl(SavedStateReader.m83constructorimpl(bundle), key);
        if (bundleM145getSavedStateOrNullimpl == null) {
            q5.i[] iVarArr = new q5.i[0];
            bundleM145getSavedStateOrNullimpl = BundleKt.bundleOf((q5.i[]) Arrays.copyOf(iVarArr, iVarArr.length));
            SavedStateWriter.m169constructorimpl(bundleM145getSavedStateOrNullimpl);
        }
        SavedStateWriter.m205removeimpl(SavedStateWriter.m169constructorimpl(bundle), key);
        if (SavedStateReader.m161isEmptyimpl(SavedStateReader.m83constructorimpl(bundle))) {
            this.restoredState = null;
        }
        return bundleM145getSavedStateOrNullimpl;
    }

    public final void performRestore() {
        if (this.restored) {
            return;
        }
        Bundle bundleConsumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey(SavedStateHandleSupport.SAVED_STATE_KEY);
        q5.i[] iVarArr = new q5.i[0];
        Bundle bundleBundleOf = BundleKt.bundleOf((q5.i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        Bundle bundleM169constructorimpl = SavedStateWriter.m169constructorimpl(bundleBundleOf);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            SavedStateWriter.m173putAllimpl(bundleM169constructorimpl, bundle);
        }
        if (bundleConsumeRestoredStateForKey != null) {
            SavedStateWriter.m173putAllimpl(bundleM169constructorimpl, bundleConsumeRestoredStateForKey);
        }
        this.restoredState = bundleBundleOf;
        this.restored = true;
        getViewModel();
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle saveState() {
        Bundle bundleBundleOf = BundleKt.bundleOf((q5.i[]) Arrays.copyOf(new q5.i[0], 0));
        Bundle bundleM169constructorimpl = SavedStateWriter.m169constructorimpl(bundleBundleOf);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            SavedStateWriter.m173putAllimpl(bundleM169constructorimpl, bundle);
        }
        for (Map.Entry<String, SavedStateHandle> entry : getViewModel().getHandles().entrySet()) {
            String key = entry.getKey();
            Bundle bundleSaveState = entry.getValue().savedStateProvider().saveState();
            if (!SavedStateReader.m161isEmptyimpl(SavedStateReader.m83constructorimpl(bundleSaveState))) {
                SavedStateWriter.m196putSavedStateimpl(bundleM169constructorimpl, key, bundleSaveState);
            }
        }
        this.restored = false;
        return bundleBundleOf;
    }
}
