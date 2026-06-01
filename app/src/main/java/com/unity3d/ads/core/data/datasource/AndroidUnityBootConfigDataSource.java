package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import com.ironsource.C2300e4;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import n6.a;
import n7.b;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidUnityBootConfigDataSource implements UnityBootConfigDataSource {
    private final Context context;

    public AndroidUnityBootConfigDataSource(Context context) {
        k.e(context, "context");
        this.context = context;
    }

    @Override // com.unity3d.ads.core.data.datasource.UnityBootConfigDataSource
    public String getValue(String key) {
        Object objM;
        k.e(key, "key");
        try {
            String strConcat = key.concat(C2300e4.i.f8399b);
            a0 a0Var = new a0();
            InputStream stream = this.context.getAssets().open("bin/Data/boot.config");
            try {
                k.d(stream, "stream");
                b.r(new BufferedReader(new InputStreamReader(stream, a.f13073a), 8192), new AndroidUnityBootConfigDataSource$getValue$1$1$1(strConcat, a0Var));
                stream.close();
                objM = (String) a0Var.f12717a;
            } finally {
            }
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if (objM instanceof j) {
            objM = null;
        }
        return (String) objM;
    }
}
