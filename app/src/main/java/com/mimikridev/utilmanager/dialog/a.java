package com.mimikridev.utilmanager.dialog;

import android.app.Activity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.mimikridev.utilmanager.firebase.FirebaseUtil;
import q.f;
import q.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements f, OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f10697a;

    public /* synthetic */ a(Activity activity) {
        this.f10697a = activity;
    }

    @Override // q.f
    public void a(g gVar) {
        DialogUtil.lambda$showErrorDialogExit$2(this.f10697a, gVar);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        FirebaseUtil.lambda$checkInAppUpdate$6(this.f10697a, (AppUpdateInfo) obj);
    }
}
