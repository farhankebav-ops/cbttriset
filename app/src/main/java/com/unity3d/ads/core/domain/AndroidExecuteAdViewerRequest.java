package com.unity3d.ads.core.domain;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.unity3d.ads.core.extensions.JSONArrayExtensionsKt;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import e6.p;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import n7.b;
import org.json.JSONArray;
import q5.x;
import q6.a0;
import q6.c0;
import q6.w;
import r2.q;
import r5.j;
import r5.s;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidExecuteAdViewerRequest implements ExecuteAdViewerRequest {
    private final GetCachedAsset getCachedAsset;
    private final HttpClient httpClient;
    private final w ioDispatcher;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestType.values().length];
            try {
                iArr[RequestType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestType.HEAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestType.POST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest$invoke$2", f = "AndroidExecuteAdViewerRequest.kt", l = {29}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Object[] $parameters;
        final /* synthetic */ RequestType $type;
        int label;
        final /* synthetic */ AndroidExecuteAdViewerRequest this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object[] objArr, AndroidExecuteAdViewerRequest androidExecuteAdViewerRequest, RequestType requestType, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$parameters = objArr;
            this.this$0 = androidExecuteAdViewerRequest;
            this.$type = requestType;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$parameters, this.this$0, this.$type, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM;
            WebResourceResponse webResourceResponseInvoke$default;
            InputStream data;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            Object objP0 = j.p0(1, this.$parameters);
            byte[] bArrK = null;
            String str = objP0 instanceof String ? (String) objP0 : null;
            if (str == null) {
                str = "";
            }
            if (str.length() <= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            try {
                objM = Uri.parse(str);
                k.d(objM, "parse(this)");
            } catch (Throwable th) {
                objM = q.M(th);
            }
            if (objM instanceof q5.j) {
                objM = null;
            }
            Uri uri = (Uri) objM;
            if (uri != null) {
                if (this.$type != RequestType.GET) {
                    uri = null;
                }
                if (uri != null && (webResourceResponseInvoke$default = GetCachedAsset.invoke$default(this.this$0.getCachedAsset, uri, null, 2, null)) != null && (data = webResourceResponseInvoke$default.getData()) != null) {
                    bArrK = b.K(data);
                }
            }
            byte[] bArr = bArrK;
            if (bArr != null) {
                return new HttpResponse(bArr, 0, null, null, null, null, 0L, 126, null);
            }
            HttpClient httpClient = this.this$0.httpClient;
            HttpRequest httpRequestCreateRequest = this.this$0.createRequest(this.$type, this.$parameters);
            this.label = 1;
            Object objExecute = httpClient.execute(httpRequestCreateRequest, this);
            return objExecute == aVar ? aVar : objExecute;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidExecuteAdViewerRequest(w ioDispatcher, HttpClient httpClient, GetCachedAsset getCachedAsset) {
        k.e(ioDispatcher, "ioDispatcher");
        k.e(httpClient, "httpClient");
        k.e(getCachedAsset, "getCachedAsset");
        this.ioDispatcher = ioDispatcher;
        this.httpClient = httpClient;
        this.getCachedAsset = getCachedAsset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpRequest createRequest(RequestType requestType, Object[] objArr) {
        Map<String, List<String>> headersMap;
        Map<String, List<String>> headersMap2;
        String str = (String) j.p0(1, objArr);
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[requestType.ordinal()];
        Map<String, List<String>> map = s.f13639a;
        if (i2 == 1 || i2 == 2) {
            JSONArray jSONArray = (JSONArray) j.p0(2, objArr);
            Integer num = (Integer) j.p0(3, objArr);
            Integer num2 = (Integer) j.p0(4, objArr);
            if (jSONArray == null || (headersMap = JSONArrayExtensionsKt.getHeadersMap(jSONArray)) == null) {
                headersMap = map;
            }
            return new HttpRequest(str, null, requestType, null, headersMap, null, null, null, null, num != null ? num.intValue() : 30000, num2 != null ? num2.intValue() : 30000, 0, 0, false, null, null, 0, 129514, null);
        }
        if (i2 != 3) {
            throw new e2.s(3);
        }
        String str2 = (String) j.p0(2, objArr);
        JSONArray jSONArray2 = (JSONArray) j.p0(3, objArr);
        Integer num3 = (Integer) j.p0(4, objArr);
        Integer num4 = (Integer) j.p0(5, objArr);
        if (jSONArray2 != null && (headersMap2 = JSONArrayExtensionsKt.getHeadersMap(jSONArray2)) != null) {
            map = headersMap2;
        }
        return new HttpRequest(str, null, requestType, str2, map, null, null, null, null, num3 != null ? num3.intValue() : 30000, num4 != null ? num4.intValue() : 30000, 0, 0, false, null, null, 0, 129506, null);
    }

    @Override // com.unity3d.ads.core.domain.ExecuteAdViewerRequest
    public Object invoke(RequestType requestType, Object[] objArr, c<? super HttpResponse> cVar) {
        return c0.H(new AnonymousClass2(objArr, this, requestType, null), this.ioDispatcher, cVar);
    }
}
