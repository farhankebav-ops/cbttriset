package androidx.lifecycle.serialization;

import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.serialization.SavedStateConfiguration;
import b7.c;
import h6.b;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleDelegateKt {
    public static final <T> b saved(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration configuration, e6.a init) {
        k.e(savedStateHandle, "<this>");
        k.e(configuration, "configuration");
        k.e(init, "init");
        configuration.getSerializersModule();
        k.k();
        throw null;
    }

    public static b saved$default(SavedStateHandle savedStateHandle, String str, SavedStateConfiguration configuration, e6.a init, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            configuration = SavedStateConfiguration.DEFAULT;
        }
        k.e(savedStateHandle, "<this>");
        k.e(configuration, "configuration");
        k.e(init, "init");
        configuration.getSerializersModule();
        k.k();
        throw null;
    }

    public static final <T> b saved(SavedStateHandle savedStateHandle, c serializer, String str, SavedStateConfiguration configuration, e6.a init) {
        k.e(savedStateHandle, "<this>");
        k.e(serializer, "serializer");
        k.e(configuration, "configuration");
        k.e(init, "init");
        return new SavedStateHandleDelegate(savedStateHandle, serializer, str, configuration, init);
    }

    public static /* synthetic */ b saved$default(SavedStateHandle savedStateHandle, c cVar, String str, SavedStateConfiguration savedStateConfiguration, e6.a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return saved(savedStateHandle, cVar, str, savedStateConfiguration, aVar);
    }
}
