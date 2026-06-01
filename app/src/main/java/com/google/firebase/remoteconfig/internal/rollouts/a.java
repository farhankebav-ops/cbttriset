package com.google.firebase.remoteconfig.internal.rollouts;

import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RolloutsStateSubscriber f5731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RolloutsState f5732c;

    public /* synthetic */ a(RolloutsStateSubscriber rolloutsStateSubscriber, RolloutsState rolloutsState, int i2) {
        this.f5730a = i2;
        this.f5731b = rolloutsStateSubscriber;
        this.f5732c = rolloutsState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5730a) {
            case 0:
                this.f5731b.onRolloutsStateChanged(this.f5732c);
                break;
            default:
                this.f5731b.onRolloutsStateChanged(this.f5732c);
                break;
        }
    }
}
