package androidx.savedstate.serialization;

import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.activity.u;
import androidx.savedstate.serialization.serializers.SizeFSerializer;
import androidx.savedstate.serialization.serializers.SizeSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import b7.c;
import i4.c1;
import i7.f;
import java.util.List;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateConfig_androidKt {
    public static final f getDefaultSerializersModuleOnPlatform() {
        c1 c1Var = new c1();
        c1Var.b(b0.a(Size.class), SizeSerializer.INSTANCE);
        c1Var.b(b0.a(SizeF.class), SizeFSerializer.INSTANCE);
        c1Var.g(b0.a(SparseArray.class), new u(4));
        return c1Var.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0(List argSerializers) {
        k.e(argSerializers, "argSerializers");
        return new SparseArraySerializer((c) l.X0(argSerializers));
    }
}
