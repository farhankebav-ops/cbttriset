package com.unity3d.services.core.domain.task;

import com.bumptech.glide.load.Key;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import e6.p;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import q5.j;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2", f = "InitializeStateLoadCache.kt", l = {}, m = "invokeSuspend")
public final class InitializeStateLoadCache$doWork$2 extends i implements p {
    final /* synthetic */ InitializeStateLoadCache.Params $params;
    int label;
    final /* synthetic */ InitializeStateLoadCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateLoadCache$doWork$2(InitializeStateLoadCache initializeStateLoadCache, InitializeStateLoadCache.Params params, c<? super InitializeStateLoadCache$doWork$2> cVar) {
        super(2, cVar);
        this.this$0 = initializeStateLoadCache;
        this.$params = params;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new InitializeStateLoadCache$doWork$2(this.this$0, this.$params, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM;
        Throwable thA;
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        InitializeStateLoadCache initializeStateLoadCache = this.this$0;
        InitializeStateLoadCache.Params params = this.$params;
        try {
            DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
            byte[] webViewData = initializeStateLoadCache.getWebViewData();
            boolean z2 = true;
            if (webViewData == null) {
                objM = new InitializeStateLoadCache.LoadCacheResult(z2, null, 2, 0 == true ? 1 : 0);
            } else {
                String strSha256 = Utilities.Sha256(webViewData);
                Charset charsetForName = Charset.forName(Key.STRING_CHARSET_NAME);
                k.d(charsetForName, "forName(\"UTF-8\")");
                String str = new String(webViewData, charsetForName);
                if (strSha256 != null && strSha256.equals(params.getConfig().getWebViewHash())) {
                    z2 = false;
                }
                if (!z2) {
                    DeviceLog.info("Unity Ads init: webapp loaded from local cache");
                }
                objM = new InitializeStateLoadCache.LoadCacheResult(z2, str);
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if ((objM instanceof j) && (thA = q5.k.a(objM)) != null) {
            objM = q.M(thA);
        }
        return new q5.k(objM);
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super q5.k> cVar) {
        return ((InitializeStateLoadCache$doWork$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
