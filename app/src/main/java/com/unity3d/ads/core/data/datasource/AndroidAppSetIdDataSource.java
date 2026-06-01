package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import androidx.activity.result.a;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import t6.d1;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidAppSetIdDataSource {
    private final q0 _appSetIdFlow;
    private final Context applicationContext;
    private final q0 isCollecting;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidAppSetIdDataSource$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        public AnonymousClass2() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AppSetIdInfo) obj);
            return x.f13520a;
        }

        public final void invoke(AppSetIdInfo appSetIdInfo) {
            String id = appSetIdInfo.getId();
            k.d(id, "it.id");
            d1 d1Var = (d1) AndroidAppSetIdDataSource.this._appSetIdFlow;
            d1Var.getClass();
            d1Var.i(null, id);
        }
    }

    public AndroidAppSetIdDataSource(Context applicationContext) {
        k.e(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
        this.isCollecting = x0.c(Boolean.FALSE);
        this._appSetIdFlow = x0.c(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(e6.l tmp0, Object obj) {
        k.e(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final String getAppSetId() {
        return (String) ((d1) this._appSetIdFlow).getValue();
    }

    public final void invoke() {
        d1 d1Var;
        Object value;
        Boolean bool;
        q0 q0Var = this.isCollecting;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            bool = (Boolean) value;
            bool.getClass();
        } while (!d1Var.g(value, Boolean.TRUE));
        if (bool.booleanValue()) {
            return;
        }
        try {
            AppSet.getClient(this.applicationContext).getAppSetIdInfo().addOnSuccessListener(new a(2, new AnonymousClass2()));
        } catch (Throwable unused) {
        }
    }
}
