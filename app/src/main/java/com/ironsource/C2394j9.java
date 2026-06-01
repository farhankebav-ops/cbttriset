package com.ironsource;

import android.content.Context;
import com.ironsource.Me;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.j9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2394j9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8791a = new a(null);

    /* JADX INFO: renamed from: com.ironsource.j9$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private final JSONObject a(Context context) {
            try {
                return new JSONObject(IronSourceUtils.e(context));
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }

        public final boolean b(Context context) {
            kotlin.jvm.internal.k.e(context, "context");
            G3 g3D = d(context);
            return g3D.d().length() > 0 && g3D.e().length() > 0;
        }

        public final Me c(Context context) {
            kotlin.jvm.internal.k.e(context, "context");
            G3 g3D = d(context);
            if (g3D.d().length() <= 0 || g3D.e().length() <= 0) {
                g3D = null;
            }
            if (g3D == null) {
                return null;
            }
            Me me = new Me(context, g3D.d(), g3D.f(), g3D.e());
            me.a(Me.a.CACHE);
            return me;
        }

        public final G3 d(Context context) {
            kotlin.jvm.internal.k.e(context, "context");
            JSONObject jSONObjectA = a(context);
            String cachedAppKey = jSONObjectA.optString("appKey");
            String cachedUserId = jSONObjectA.optString("userId");
            String cachedSettings = jSONObjectA.optString(Me.f7195n);
            kotlin.jvm.internal.k.d(cachedAppKey, "cachedAppKey");
            kotlin.jvm.internal.k.d(cachedUserId, "cachedUserId");
            kotlin.jvm.internal.k.d(cachedSettings, "cachedSettings");
            return new G3(cachedAppKey, cachedUserId, cachedSettings);
        }

        private a() {
        }
    }

    public static final boolean a(Context context) {
        return f8791a.b(context);
    }

    public static final Me b(Context context) {
        return f8791a.c(context);
    }

    public static final G3 c(Context context) {
        return f8791a.d(context);
    }
}
