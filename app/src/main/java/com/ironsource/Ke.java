package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.Me;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ke {
    public final void a(Context context, C2575te request, De tools, InterfaceC2541re listener) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(request, "request");
        kotlin.jvm.internal.k.e(tools, "tools");
        kotlin.jvm.internal.k.e(listener, "listener");
        String strF = request.f();
        if (strF == null) {
            strF = "";
        }
        tools.a("userId", strF);
        tools.a("appKey", request.d());
        tools.c().i(request.f());
        tools.a();
        C2660ye c2660yeB = b(context, tools, request);
        if (c2660yeB.b() == null) {
            C2473ne c2473neA = c2660yeB.a();
            if (c2473neA == null) {
                c2473neA = new C2473ne(510, "unknown error");
            }
            listener.a(c2473neA);
            return;
        }
        C2435le c2435le = new C2435le(c2660yeB.b());
        if (c2660yeB.c()) {
            listener.a(c2435le);
        } else {
            listener.a(new C2473ne(C2473ne.e, "serverResponseIsNotValid"));
        }
    }

    private final C2660ye b(Context context, De de, C2575te c2575te) throws Throwable {
        C2660ye c2660yeA = a(context, de, c2575te);
        if (c2660yeA.c()) {
            return c2660yeA;
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "Null or invalid response. Trying to get cached response", 0);
        Me meA = de.a(context, c2575te.d());
        if (meA == null) {
            return c2660yeA;
        }
        C2660ye c2660ye = new C2660ye(new C2592ue(meA));
        IronSourceError ironSourceErrorBuildUsingCachedConfigurationError = ErrorBuilder.buildUsingCachedConfigurationError(c2575te.d(), c2575te.f());
        IronSourceLoggerManager.getLogger().log(ironSourceTag, ironSourceErrorBuildUsingCachedConfigurationError + ": " + c2660ye.b(), 1);
        de.g();
        return c2660ye;
    }

    private final C2660ye a(Context context, De de, C2575te c2575te) throws Throwable {
        C2473ne c2473ne;
        try {
            String strA = de.a(context);
            if (TextUtils.isEmpty(strA)) {
                strA = de.b(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str = strA;
            C2270ca c2270caD = de.d();
            ArrayList<Pair<String, String>> arrayListF = c2270caD != null ? c2270caD.f() : null;
            kotlin.jvm.internal.a0 a0Var = new kotlin.jvm.internal.a0();
            String strA2 = C2375i7.a(Oe.a(context, c2575te.d(), c2575te.f(), str, null, true, arrayListF, false), C2359h9.a().toString(), new ah(a0Var, 1));
            if (strA2 == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return new C2660ye(a((String) a0Var.f12717a));
            }
            if (de.e()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("encrypt");
                JSONObject jSONObject = new JSONObject(strA2);
                String encryptedResponse = jSONObject.optString(Me.f7195n);
                if (TextUtils.isEmpty(encryptedResponse)) {
                    ironLog.warning("encryptedResponse is empty - return null");
                    return new C2660ye(new C2473ne(2100, C2525qe.h));
                }
                boolean zOptBoolean = jSONObject.optBoolean("compression", false);
                kotlin.jvm.internal.k.d(encryptedResponse, "encryptedResponse");
                strA2 = a(encryptedResponse, zOptBoolean);
                if (TextUtils.isEmpty(strA2)) {
                    ironLog.warning("encoded response invalid - return null");
                    de.f();
                    return new C2660ye(new C2473ne(C2473ne.f9516f, C2525qe.g));
                }
            }
            Me me = new Me(context, c2575te.d(), c2575te.f(), strA2);
            me.a(Me.a.SERVER);
            if (!me.p()) {
                IronLog.INTERNAL.warning("response invalid - return null");
                return new C2660ye(new C2473ne(C2473ne.e, "serverResponseIsNotValid"));
            }
            return new C2660ye(new C2592ue(me));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.warning("exception = " + e);
            if (e instanceof JSONException) {
                c2473ne = new C2473ne(C2473ne.e, "serverResponseIsNotValid");
            } else {
                c2473ne = new C2473ne(510, "internal error");
            }
            return new C2660ye(c2473ne);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(kotlin.jvm.internal.a0 reason, String errorMessage) {
        kotlin.jvm.internal.k.e(reason, "$reason");
        kotlin.jvm.internal.k.e(errorMessage, "errorMessage");
        reason.f12717a = errorMessage;
    }

    private final String a(String str, boolean z2) {
        if (z2) {
            String strD = L9.d(C2499p5.b().c(), str);
            kotlin.jvm.internal.k.d(strD, "{\n      IronSourceAES.de… encryptedResponse)\n    }");
            return strD;
        }
        String strB = L9.b(C2499p5.b().c(), str);
        kotlin.jvm.internal.k.d(strB, "{\n      IronSourceAES.de… encryptedResponse)\n    }");
        return strB;
    }

    private final C2473ne a(String str) {
        if (str != null) {
            return new C2473ne(C2473ne.h, str);
        }
        return new C2473ne(C2473ne.f9515d, "noServerResponse");
    }
}
