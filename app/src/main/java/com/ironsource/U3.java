package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class U3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7666a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IronSourceError f7667b = null;

    public void a(IronSourceError ironSourceError) {
        this.f7666a = false;
        this.f7667b = ironSourceError;
    }

    public boolean b() {
        return this.f7666a;
    }

    public void c() {
        this.f7666a = true;
        this.f7667b = null;
    }

    public String toString() {
        if (b()) {
            return "valid:" + this.f7666a;
        }
        return "valid:" + this.f7666a + ", IronSourceError:" + this.f7667b;
    }

    public IronSourceError a() {
        return this.f7667b;
    }
}
