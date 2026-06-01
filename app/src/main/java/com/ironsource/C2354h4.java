package com.ironsource;

import android.app.Activity;
import android.content.MutableContextWrapper;

/* JADX INFO: renamed from: com.ironsource.h4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2354h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MutableContextWrapper f8638a;

    public synchronized void a(Activity activity) {
        try {
            if (this.f8638a == null) {
                this.f8638a = new MutableContextWrapper(activity);
            }
            this.f8638a.setBaseContext(activity);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        this.f8638a = null;
    }

    public Activity a() {
        return (Activity) this.f8638a.getBaseContext();
    }
}
