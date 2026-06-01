package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.ironsource.sdk.controller.v;
import com.ironsource.sdk.utils.Logger;
import java.lang.reflect.Method;
import java.security.AccessControlException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9884b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v.r f9885a;

    public b(v.r rVar) {
        this.f9885a = rVar;
    }

    public synchronized void a(String str, String str2) throws Exception {
        if (this.f9885a == null) {
            Logger.e(f9884b, "!!! nativeAPI == null !!!");
            return;
        }
        Method declaredMethod = v.r.class.getDeclaredMethod(str, String.class);
        if (declaredMethod.isAnnotationPresent(JavascriptInterface.class)) {
            declaredMethod.invoke(this.f9885a, str2);
        } else {
            throw new AccessControlException("Trying to access a private function: " + str);
        }
    }

    public void b(String str) {
        v.r rVar = this.f9885a;
        if (rVar != null) {
            rVar.d(str);
        }
    }

    public void a(String str) {
        v.r rVar = this.f9885a;
        if (rVar != null) {
            rVar.c(str);
        }
    }
}
