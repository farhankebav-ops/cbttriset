package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.serializers.SavedStateSerializer;
import e6.l;
import i4.c1;
import i7.d;
import i7.f;
import i7.h;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateConfigurationKt {
    private static final f DEFAULT_SERIALIZERS_MODULE;

    static {
        c1 c1Var = new c1();
        c1Var.b(b0.a(Bundle.class), SavedStateSerializer.INSTANCE);
        d dVarA = c1Var.a();
        f other = SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform();
        d dVar = h.f12046a;
        k.e(other, "other");
        c1 c1Var2 = new c1();
        dVarA.a(c1Var2);
        other.a(c1Var2);
        DEFAULT_SERIALIZERS_MODULE = c1Var2.a();
    }

    public static final SavedStateConfiguration SavedStateConfiguration(l builderAction) {
        k.e(builderAction, "builderAction");
        return SavedStateConfiguration$default(null, builderAction, 1, null);
    }

    public static /* synthetic */ SavedStateConfiguration SavedStateConfiguration$default(SavedStateConfiguration savedStateConfiguration, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return SavedStateConfiguration(savedStateConfiguration, lVar);
    }

    public static final SavedStateConfiguration SavedStateConfiguration(SavedStateConfiguration from, l builderAction) {
        k.e(from, "from");
        k.e(builderAction, "builderAction");
        SavedStateConfiguration.Builder builder = new SavedStateConfiguration.Builder(from);
        builderAction.invoke(builder);
        return builder.build$savedstate_release();
    }
}
