package androidx.lifecycle.serialization;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.internal.CanonicalName_jvmKt;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.SavedStateDecoderKt;
import androidx.savedstate.serialization.SavedStateEncoderKt;
import b7.c;
import h6.b;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import l6.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class SavedStateHandleDelegate<T> implements b {
    private final SavedStateConfiguration configuration;
    private final e6.a init;
    private final String key;
    private final SavedStateHandle savedStateHandle;
    private final c serializer;
    private T value;

    public SavedStateHandleDelegate(SavedStateHandle savedStateHandle, c serializer, String str, SavedStateConfiguration configuration, e6.a init) {
        k.e(savedStateHandle, "savedStateHandle");
        k.e(serializer, "serializer");
        k.e(configuration, "configuration");
        k.e(init, "init");
        this.savedStateHandle = savedStateHandle;
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
        Bundle bundle = (Bundle) this.savedStateHandle.get(str);
        if (bundle != null) {
            return (T) SavedStateDecoderKt.decodeFromSavedState(this.serializer, bundle, this.configuration);
        }
        return null;
    }

    private final void registerSave(String str) {
        this.savedStateHandle.setSavedStateProvider(str, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.serialization.a
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                return SavedStateHandleDelegate.registerSave$lambda$1(this.f4052a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle registerSave$lambda$1(SavedStateHandleDelegate savedStateHandleDelegate) {
        c cVar = savedStateHandleDelegate.serializer;
        T t3 = savedStateHandleDelegate.value;
        if (t3 != null) {
            return SavedStateEncoderKt.encodeToSavedState(cVar, t3, savedStateHandleDelegate.configuration);
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
