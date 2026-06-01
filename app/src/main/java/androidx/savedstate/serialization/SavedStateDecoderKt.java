package androidx.savedstate.serialization;

import android.os.Bundle;
import b7.b;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateDecoderKt {
    public static final <T> T decodeFromSavedState(b deserializer, Bundle savedState) {
        k.e(deserializer, "deserializer");
        k.e(savedState, "savedState");
        return (T) decodeFromSavedState$default(deserializer, savedState, null, 4, null);
    }

    public static Object decodeFromSavedState$default(Bundle savedState, SavedStateConfiguration configuration, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            configuration = SavedStateConfiguration.DEFAULT;
        }
        k.e(savedState, "savedState");
        k.e(configuration, "configuration");
        configuration.getSerializersModule();
        k.k();
        throw null;
    }

    public static final <T> T decodeFromSavedState(Bundle savedState, SavedStateConfiguration configuration) {
        k.e(savedState, "savedState");
        k.e(configuration, "configuration");
        configuration.getSerializersModule();
        k.k();
        throw null;
    }

    public static final <T> T decodeFromSavedState(b deserializer, Bundle savedState, SavedStateConfiguration configuration) {
        k.e(deserializer, "deserializer");
        k.e(savedState, "savedState");
        k.e(configuration, "configuration");
        return (T) new SavedStateDecoder(savedState, configuration).decodeSerializableValue(deserializer);
    }

    public static /* synthetic */ Object decodeFromSavedState$default(b bVar, Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return decodeFromSavedState(bVar, bundle, savedStateConfiguration);
    }
}
