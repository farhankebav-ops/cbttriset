package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.InterfaceC2364he;
import com.ironsource.Q9;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SSAFactory {
    public static InterfaceC2364he getPublisherInstance(Activity activity) throws Exception {
        return Q9.b((Context) activity);
    }

    public static InterfaceC2364he getPublisherTestInstance(Activity activity, int i2) throws Exception {
        return Q9.a(activity, i2);
    }
}
