package com.unity3d.services.store.gpbl.bridges.billingclient.v8;

import com.unity3d.services.core.reflection.GenericBridge;
import com.unity3d.services.store.gpbl.BillingOriginalJsonResponse;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import n6.t;
import org.json.JSONException;
import org.json.JSONObject;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ProductDetailsBridge extends GenericBridge implements BillingOriginalJsonResponse {
    public static final Companion Companion = new Companion(null);
    private static final String TO_STRING_METHOD = "toString";
    private final Object internalRef;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailsBridge(Object internalRef) {
        super(x.c0(new i(TO_STRING_METHOD, new Class[0])));
        k.e(internalRef, "internalRef");
        this.internalRef = internalRef;
    }

    private final String parseOriginalJson(String str) {
        try {
            int iY0 = m.y0(str, "jsonString='", 0, false, 6) + 12;
            int iY02 = m.y0(str, "', parsedJson=", 0, false, 6);
            if (1 > iY0 || iY0 >= iY02) {
                return null;
            }
            String strSubstring = str.substring(iY0, iY02);
            k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return t.l0(strSubstring, "\\/", "/");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return "com.android.billingclient.api.ProductDetails";
    }

    @Override // com.unity3d.services.store.gpbl.BillingOriginalJsonResponse
    public JSONObject getOriginalJson() {
        try {
            String originalJson = parseOriginalJson(toString());
            return originalJson != null ? new JSONObject(originalJson) : new JSONObject();
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public String toString() {
        Object objCallNonVoidMethod = callNonVoidMethod(TO_STRING_METHOD, this.internalRef, new Object[0]);
        k.c(objCallNonVoidMethod, "null cannot be cast to non-null type kotlin.String");
        return (String) objCallNonVoidMethod;
    }
}
