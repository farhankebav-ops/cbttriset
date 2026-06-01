package androidx.savedstate.serialization;

import d7.g;
import f7.c;
import f7.c0;
import f7.f;
import f7.k0;
import f7.l0;
import f7.o;
import f7.p0;
import f7.q1;
import f7.t;
import kotlin.jvm.internal.b0;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateCodecUtilsKt {
    private static final g booleanArrayDescriptor;
    private static final g charArrayDescriptor;
    private static final g doubleArrayDescriptor;
    private static final g floatArrayDescriptor;
    private static final g intArrayDescriptor;
    private static final g intListDescriptor = (c) q.c(l0.f11478a).f11432c;
    private static final g longArrayDescriptor;
    private static final g stringArrayDescriptor;
    private static final g stringListDescriptor;

    static {
        q1 q1Var = q1.f11501a;
        stringListDescriptor = (c) q.c(q1Var).f11432c;
        booleanArrayDescriptor = f.f11449c.f11464b;
        charArrayDescriptor = o.f11490c.f11464b;
        doubleArrayDescriptor = t.f11517c.f11464b;
        floatArrayDescriptor = c0.f11426c.f11464b;
        intArrayDescriptor = k0.f11475c.f11464b;
        longArrayDescriptor = p0.f11496c.f11464b;
        stringArrayDescriptor = q.a(b0.a(String.class), q1Var).f11477c;
    }

    public static final g getBooleanArrayDescriptor() {
        return booleanArrayDescriptor;
    }

    public static final g getCharArrayDescriptor() {
        return charArrayDescriptor;
    }

    public static final g getDoubleArrayDescriptor() {
        return doubleArrayDescriptor;
    }

    public static final g getFloatArrayDescriptor() {
        return floatArrayDescriptor;
    }

    public static final g getIntArrayDescriptor() {
        return intArrayDescriptor;
    }

    public static final g getIntListDescriptor() {
        return intListDescriptor;
    }

    public static final g getLongArrayDescriptor() {
        return longArrayDescriptor;
    }

    public static final g getStringArrayDescriptor() {
        return stringArrayDescriptor;
    }

    public static final g getStringListDescriptor() {
        return stringListDescriptor;
    }

    public static /* synthetic */ void getStringArrayDescriptor$annotations() {
    }
}
