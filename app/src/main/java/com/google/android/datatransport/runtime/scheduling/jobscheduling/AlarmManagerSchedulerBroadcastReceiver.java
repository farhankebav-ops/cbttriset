package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.camera.core.processing.i;
import com.ironsource.dj;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import m0.e;
import p0.k;
import p0.v;
import v0.f;
import z0.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5211a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY)).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        v.b(context);
        if (queryParameter == null) {
            throw new NullPointerException("Null backendName");
        }
        e eVarB = a.b(iIntValue);
        byte[] bArrDecode = queryParameter2 != null ? Base64.decode(queryParameter2, 0) : null;
        f fVar = v.a().f13315d;
        fVar.e.execute(new dj(fVar, new k(queryParameter, bArrDecode, eVarB), i2, new i(5), 1));
    }
}
