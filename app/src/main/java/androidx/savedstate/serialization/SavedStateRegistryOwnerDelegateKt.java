package androidx.savedstate.serialization;

import androidx.savedstate.SavedStateRegistryOwner;
import b7.c;
import h6.b;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryOwnerDelegateKt {
    public static final <T> b saved(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration configuration, e6.a init) {
        k.e(savedStateRegistryOwner, "<this>");
        k.e(configuration, "configuration");
        k.e(init, "init");
        configuration.getSerializersModule();
        k.k();
        throw null;
    }

    public static b saved$default(SavedStateRegistryOwner savedStateRegistryOwner, String str, SavedStateConfiguration configuration, e6.a init, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            configuration = SavedStateConfiguration.DEFAULT;
        }
        k.e(savedStateRegistryOwner, "<this>");
        k.e(configuration, "configuration");
        k.e(init, "init");
        configuration.getSerializersModule();
        k.k();
        throw null;
    }

    public static final <T> b saved(SavedStateRegistryOwner savedStateRegistryOwner, c serializer, String str, SavedStateConfiguration configuration, e6.a init) {
        k.e(savedStateRegistryOwner, "<this>");
        k.e(serializer, "serializer");
        k.e(configuration, "configuration");
        k.e(init, "init");
        return new SavedStateRegistryOwnerDelegate(savedStateRegistryOwner.getSavedStateRegistry(), serializer, str, configuration, init);
    }

    public static /* synthetic */ b saved$default(SavedStateRegistryOwner savedStateRegistryOwner, c cVar, String str, SavedStateConfiguration savedStateConfiguration, e6.a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return saved(savedStateRegistryOwner, cVar, str, savedStateConfiguration, aVar);
    }
}
