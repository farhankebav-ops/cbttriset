package com.ironsource;

import android.app.Activity;
import android.content.Context;
import com.ironsource.C2569t8;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.v2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2597v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static C2597v2 f10429a;

    /* JADX INFO: renamed from: com.ironsource.v2$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10430a;

        static {
            int[] iArr = new int[C2569t8.a.values().length];
            f10430a = iArr;
            try {
                iArr[C2569t8.a.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10430a[C2569t8.a.Device.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10430a[C2569t8.a.Controller.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static C2597v2 a() {
        C2597v2 c2597v2 = f10429a;
        return c2597v2 == null ? new C2597v2() : c2597v2;
    }

    public boolean a(Activity activity) {
        if (a.f10430a[C2306ea.e().b().ordinal()] != 3) {
            return false;
        }
        try {
            com.ironsource.sdk.controller.v vVar = (com.ironsource.sdk.controller.v) Q9.b((Context) activity).a().k();
            if (vVar == null) {
                return true;
            }
            vVar.k("back");
            return true;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }
}
