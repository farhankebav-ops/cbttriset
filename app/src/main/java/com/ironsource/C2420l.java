package com.ironsource;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.ironsource.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2420l implements tg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f8873a;

    public C2420l(Activity activity) {
        this.f8873a = new WeakReference<>(activity);
    }

    @Override // com.ironsource.tg
    public void a() {
        Activity activity = this.f8873a.get();
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }
}
