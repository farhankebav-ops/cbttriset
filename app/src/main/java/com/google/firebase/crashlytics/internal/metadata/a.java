package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5588b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f5587a = i2;
        this.f5588b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5587a) {
            case 0:
                ((UserMetadata.SerializeableKeysMap) this.f5588b).lambda$scheduleSerializationTaskIfNeeded$0();
                break;
            default:
                ((UserMetadata) this.f5588b).serializeUserDataIfNeeded();
                break;
        }
    }
}
