package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ae implements Ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Ae f6342a = new Ae();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final De f6343b = new De();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2541re {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC2541re f6344a;

        public a(InterfaceC2541re interfaceC2541re) {
            this.f6344a = interfaceC2541re;
        }

        @Override // com.ironsource.InterfaceC2541re
        public void a(C2435le sdkConfig) {
            kotlin.jvm.internal.k.e(sdkConfig, "sdkConfig");
            Ae.f6343b.a(new dh(sdkConfig, this.f6344a));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(C2435le sdkConfig, InterfaceC2541re listener) {
            kotlin.jvm.internal.k.e(sdkConfig, "$sdkConfig");
            kotlin.jvm.internal.k.e(listener, "$listener");
            Ae.f6342a.a(sdkConfig, listener);
        }

        @Override // com.ironsource.InterfaceC2541re
        public void a(C2473ne error) {
            kotlin.jvm.internal.k.e(error, "error");
            Ae.f6343b.d(new eh(this.f6344a, error, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(InterfaceC2541re listener, C2473ne error) {
            kotlin.jvm.internal.k.e(listener, "$listener");
            kotlin.jvm.internal.k.e(error, "$error");
            listener.a(error);
        }
    }

    private Ae() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, C2575te initRequest, InterfaceC2541re listener) {
        kotlin.jvm.internal.k.e(context, "$context");
        kotlin.jvm.internal.k.e(initRequest, "$initRequest");
        kotlin.jvm.internal.k.e(listener, "$listener");
        new V9().a(EnumC2558se.LEVEL_PLAY_INIT);
        f6342a.a(context, initRequest, listener, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, C2575te initRequest, InterfaceC2541re listener) {
        kotlin.jvm.internal.k.e(context, "$context");
        kotlin.jvm.internal.k.e(initRequest, "$initRequest");
        kotlin.jvm.internal.k.e(listener, "$listener");
        com.ironsource.mediationsdk.r rVarM = com.ironsource.mediationsdk.r.m();
        String strD = initRequest.d();
        IronSource.a[] aVarArr = (IronSource.a[]) initRequest.e().toArray(new IronSource.a[0]);
        List<IronSource.a> validAdUnitsList = rVarM.a(context, strD, false, (IronSource.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
        kotlin.jvm.internal.k.d(validAdUnitsList, "validAdUnitsList");
        initRequest.a(validAdUnitsList);
        new V9().a(EnumC2558se.EXTERNAL_MEDIATION_INIT);
        f6342a.a(context, initRequest, listener, true);
    }

    public final void c(Context context, C2575te initRequest, InterfaceC2541re listener) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(initRequest, "initRequest");
        kotlin.jvm.internal.k.e(listener, "listener");
        f6343b.c(new bh(context, initRequest, listener, 1));
    }

    @Override // com.ironsource.Ec
    public void onInitFailed(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "error");
        f6343b.a(new ch(error, 1));
    }

    public final void a(Context context, C2575te initRequest, InterfaceC2541re listener) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(initRequest, "initRequest");
        kotlin.jvm.internal.k.e(listener, "listener");
        f6343b.c(new bh(context, initRequest, listener, 0));
    }

    private final void a(Context context, C2575te c2575te, InterfaceC2541re interfaceC2541re, boolean z2) {
        String strF = c2575te.f();
        if (strF != null && strF.length() > 0) {
            com.ironsource.mediationsdk.r.m().o(c2575te.f());
        } else {
            c2575te = new C2575te(c2575te.d(), com.ironsource.mediationsdk.r.m().o(), r5.l.o1(c2575te.e()));
        }
        com.ironsource.mediationsdk.r rVarM = com.ironsource.mediationsdk.r.m();
        String strD = c2575te.d();
        IronSource.a[] aVarArr = (IronSource.a[]) c2575te.e().toArray(new IronSource.a[0]);
        IronSourceError ironSourceErrorA = rVarM.a(context, strD, z2, this, (IronSource.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
        if (ironSourceErrorA != null && ironSourceErrorA.getErrorCode() != 2020) {
            if (ironSourceErrorA.getErrorCode() == 2040) {
                Me meH = com.ironsource.mediationsdk.r.m().h();
                if (meH != null) {
                    a(new C2435le(new C2592ue(meH)), interfaceC2541re);
                    return;
                }
            } else if (ironSourceErrorA.getErrorCode() == 2030) {
                C2677ze.f10647a.e();
                return;
            }
            f6343b.d(new ti(2, interfaceC2541re, ironSourceErrorA));
            return;
        }
        C2677ze.f10647a.a(context, c2575te, new a(interfaceC2541re));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Me serverResponse) {
        kotlin.jvm.internal.k.e(serverResponse, "$serverResponse");
        C2677ze.f10647a.a(new C2592ue(serverResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterfaceC2541re listener, IronSourceError error) {
        kotlin.jvm.internal.k.e(listener, "$listener");
        kotlin.jvm.internal.k.d(error, "error");
        listener.a(new C2473ne(error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(C2435le c2435le, InterfaceC2541re interfaceC2541re) {
        if (!com.ironsource.mediationsdk.r.m().a(false, c2435le.d())) {
            f6343b.d(new ch(interfaceC2541re, 0));
        } else {
            f6343b.d(new dh(interfaceC2541re, c2435le, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterfaceC2541re listener) {
        kotlin.jvm.internal.k.e(listener, "$listener");
        listener.a(new C2473ne(IronSourceError.ERROR_LEGACY_INIT_POST_FAILED, "An unknown error has occurred"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterfaceC2541re listener, C2435le sdkInitResponse) {
        kotlin.jvm.internal.k.e(listener, "$listener");
        kotlin.jvm.internal.k.e(sdkInitResponse, "$sdkInitResponse");
        listener.a(sdkInitResponse);
    }

    @Override // com.ironsource.Ec
    public void a(Me serverResponse) {
        kotlin.jvm.internal.k.e(serverResponse, "serverResponse");
        f6343b.a(new ch(serverResponse, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "$error");
        C2677ze.f10647a.b(new C2473ne(error));
    }
}
