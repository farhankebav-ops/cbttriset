package com.unity3d.services.core.domain.task;

import c6.k;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.properties.SdkProperties;
import e6.p;
import java.io.File;
import java.util.concurrent.CancellationException;
import org.json.JSONObject;
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
@e(c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$2", f = "ConfigFileFromLocalStorage.kt", l = {}, m = "invokeSuspend")
public final class ConfigFileFromLocalStorage$doWork$2 extends i implements p {
    final /* synthetic */ ConfigFileFromLocalStorage.Params $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigFileFromLocalStorage$doWork$2(ConfigFileFromLocalStorage.Params params, c<? super ConfigFileFromLocalStorage$doWork$2> cVar) {
        super(2, cVar);
        this.$params = params;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new ConfigFileFromLocalStorage$doWork$2(this.$params, cVar);
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
        ConfigFileFromLocalStorage.Params params = this.$params;
        try {
            File file = new File(SdkProperties.getLocalConfigurationFilepath());
            objM = !file.exists() ? params.getDefaultConfiguration() : new Configuration(new JSONObject(k.c0(file)));
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
        return ((ConfigFileFromLocalStorage$doWork$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
