package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class l implements OnSuccessListener, OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s4.i f5642a;

    public /* synthetic */ l(s4.i iVar) {
        this.f5642a = iVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        InAppMessageStreamManager.lambda$taskToMaybe$29(this.f5642a, exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        InAppMessageStreamManager.lambda$taskToMaybe$28(this.f5642a, obj);
    }
}
