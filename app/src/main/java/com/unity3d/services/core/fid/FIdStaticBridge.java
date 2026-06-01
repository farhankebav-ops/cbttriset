package com.unity3d.services.core.fid;

import android.content.Context;
import com.unity3d.services.core.reflection.GenericBridge;
import kotlin.jvm.internal.k;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FIdStaticBridge extends GenericBridge {
    public FIdStaticBridge() {
        super(x.e0(new i(Constants.GET_INSTANCE, new Class[]{Context.class})), false);
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return Constants.Companion.getClassName();
    }

    public final FIdBridge getInstance(Context context) {
        k.e(context, "context");
        Object objCallNonVoidMethod = callNonVoidMethod(Constants.GET_INSTANCE, null, context);
        if (objCallNonVoidMethod != null) {
            return new FIdBridge(objCallNonVoidMethod);
        }
        return null;
    }
}
