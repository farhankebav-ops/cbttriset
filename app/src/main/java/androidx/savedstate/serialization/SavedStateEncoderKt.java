package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateWriter;
import b7.j;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateEncoderKt {
    public static final <T> Bundle encodeToSavedState(j serializer, T value) {
        k.e(serializer, "serializer");
        k.e(value, "value");
        return encodeToSavedState$default(serializer, value, null, 4, null);
    }

    public static Bundle encodeToSavedState$default(Object value, SavedStateConfiguration configuration, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            configuration = SavedStateConfiguration.DEFAULT;
        }
        k.e(value, "value");
        k.e(configuration, "configuration");
        configuration.getSerializersModule();
        k.k();
        throw null;
    }

    public static final <T> Bundle encodeToSavedState(T value, SavedStateConfiguration configuration) {
        k.e(value, "value");
        k.e(configuration, "configuration");
        configuration.getSerializersModule();
        k.k();
        throw null;
    }

    public static final <T> Bundle encodeToSavedState(j serializer, T value, SavedStateConfiguration configuration) {
        k.e(serializer, "serializer");
        k.e(value, "value");
        k.e(configuration, "configuration");
        i[] iVarArr = new i[0];
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m169constructorimpl(bundleBundleOf);
        new SavedStateEncoder(bundleBundleOf, configuration).encodeSerializableValue(serializer, value);
        return bundleBundleOf;
    }

    public static /* synthetic */ Bundle encodeToSavedState$default(j jVar, Object obj, SavedStateConfiguration savedStateConfiguration, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return encodeToSavedState(jVar, obj, savedStateConfiguration);
    }
}
