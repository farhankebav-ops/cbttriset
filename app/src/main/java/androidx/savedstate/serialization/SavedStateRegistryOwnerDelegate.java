package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.internal.CanonicalName_jvmKt;
import b7.c;
import h6.b;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import l6.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class SavedStateRegistryOwnerDelegate<T> implements b {
    private final SavedStateConfiguration configuration;
    private final e6.a init;
    private final String key;
    private final SavedStateRegistry registry;
    private final c serializer;
    private T value;

    public SavedStateRegistryOwnerDelegate(SavedStateRegistry registry, c serializer, String str, SavedStateConfiguration configuration, e6.a init) {
        k.e(registry, "registry");
        k.e(serializer, "serializer");
        k.e(configuration, "configuration");
        k.e(init, "init");
        this.registry = registry;
        this.serializer = serializer;
        this.key = str;
        this.configuration = configuration;
        this.init = init;
    }

    private final String createDefaultKey(Object obj, q qVar) {
        String str;
        if (obj != null) {
            str = CanonicalName_jvmKt.getCanonicalName(b0.a(obj.getClass())) + '.';
        } else {
            str = "";
        }
        StringBuilder sbR = androidx.camera.core.processing.util.a.r(str);
        sbR.append(qVar.getName());
        return sbR.toString();
    }

    private final T loadValue(String str) {
        Bundle bundleConsumeRestoredStateForKey = this.registry.consumeRestoredStateForKey(str);
        if (bundleConsumeRestoredStateForKey != null) {
            return (T) SavedStateDecoderKt.decodeFromSavedState(this.serializer, bundleConsumeRestoredStateForKey, this.configuration);
        }
        return null;
    }

    private final void registerSave(String str) {
        this.registry.registerSavedStateProvider(str, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.savedstate.serialization.a
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                return SavedStateRegistryOwnerDelegate.registerSave$lambda$1(this.f4080a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle registerSave$lambda$1(SavedStateRegistryOwnerDelegate savedStateRegistryOwnerDelegate) {
        c cVar = savedStateRegistryOwnerDelegate.serializer;
        T t3 = savedStateRegistryOwnerDelegate.value;
        if (t3 != null) {
            return SavedStateEncoderKt.encodeToSavedState(cVar, t3, savedStateRegistryOwnerDelegate.configuration);
        }
        k.l("value");
        throw null;
    }

    @Override // h6.a
    public T getValue(Object obj, q property) {
        k.e(property, "property");
        if (this.value == null) {
            String strCreateDefaultKey = this.key;
            if (strCreateDefaultKey == null) {
                strCreateDefaultKey = createDefaultKey(obj, property);
            }
            registerSave(strCreateDefaultKey);
            T tLoadValue = loadValue(strCreateDefaultKey);
            if (tLoadValue == null) {
                tLoadValue = (T) this.init.invoke();
            }
            this.value = tLoadValue;
        }
        T t3 = this.value;
        if (t3 != null) {
            return t3;
        }
        k.l("value");
        throw null;
    }

    public void setValue(Object obj, q property, T value) {
        k.e(property, "property");
        k.e(value, "value");
        if (this.value == null) {
            String strCreateDefaultKey = this.key;
            if (strCreateDefaultKey == null) {
                strCreateDefaultKey = createDefaultKey(obj, property);
            }
            registerSave(strCreateDefaultKey);
        }
        this.value = value;
    }
}
