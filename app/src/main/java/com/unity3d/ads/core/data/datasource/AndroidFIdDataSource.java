package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.unity3d.services.core.fid.FIdBridge;
import com.unity3d.services.core.fid.FIdStaticBridge;
import kotlin.jvm.internal.k;
import q6.c0;
import r2.q;
import v5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidFIdDataSource implements FIdDataSource {
    private FIdStaticBridge bridge;
    private final Context context;

    public AndroidFIdDataSource(Context context) {
        k.e(context, "context");
        this.context = context;
        this.bridge = new FIdStaticBridge();
    }

    @Override // com.unity3d.ads.core.data.datasource.FIdDataSource
    public String invoke() {
        Task<String> appInstanceId;
        try {
            FIdBridge fIdStaticBridge = this.bridge.getInstance(this.context);
            if (fIdStaticBridge != null && (appInstanceId = fIdStaticBridge.getAppInstanceId()) != null) {
                return (String) c0.A(i.f17610a, new AndroidFIdDataSource$invoke$1$1(appInstanceId, null));
            }
            return null;
        } catch (Throwable th) {
            q.M(th);
            return null;
        }
    }
}
