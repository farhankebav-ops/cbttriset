package com.mimikridev.utilmanager.config;

import android.database.Cursor;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule;
import com.mimikridev.ads.listener.OnRewardedAdCompleteListener;
import com.mimikridev.ads.listener.OnRewardedAdDismissedListener;
import com.mimikridev.ads.listener.OnRewardedAdErrorListener;
import com.unity3d.services.ads.token.INativeTokenGeneratorListener;
import com.unity3d.services.ads.token.InMemoryTokenStorage;
import com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker;
import com.unity3d.services.core.webview.bridge.Invocation;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.vungle.ads.internal.ui.AdActivity;
import com.vungle.ads.internal.util.FileUtility;
import e2.n;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import m0.e;
import m0.f;
import m0.i;
import okhttp3.logging.HttpLoggingInterceptor;
import p0.k;
import w0.g;
import z1.z;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements HttpLoggingInterceptor.Logger, INativeTokenGeneratorListener, IInvocationCallbackInvoker, OnApplyWindowInsetsListener, FileUtility.ObjectInputStreamProvider, n, OnRewardedAdCompleteListener, OnRewardedAdDismissedListener, OnRewardedAdErrorListener, f, i, g, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10695a;

    public /* synthetic */ b(int i2) {
        this.f10695a = i2;
    }

    @Override // m0.f, x4.c
    public Object apply(Object obj) {
        switch (this.f10695a) {
            case 9:
                return TransportClientModule.lambda$providesMetricsLoggerClient$0((byte[]) obj);
            default:
                Cursor cursor = (Cursor) obj;
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(1);
                    if (string == null) {
                        throw new NullPointerException("Null backendName");
                    }
                    e eVarB = z0.a.b(cursor.getInt(2));
                    String string2 = cursor.getString(3);
                    arrayList.add(new k(string, string2 == null ? null : Base64.decode(string2, 0), eVarB));
                }
                return arrayList;
        }
    }

    @Override // e2.n
    public Object get() {
        throw new IllegalStateException();
    }

    @Override // com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker
    public void invokeCallback(Invocation invocation) {
        SharedInstances.webViewAppInvocationCallbackInvoker$lambda$0(invocation);
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
    public void log(String str) {
        Log.d("OkHttp", str);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return AdActivity.m3362onCreate$lambda9(view, windowInsetsCompat);
    }

    @Override // com.unity3d.services.ads.token.INativeTokenGeneratorListener
    public void onReady(String str) {
        InMemoryTokenStorage._get_nativeGeneratedToken_$lambda$2(str);
    }

    @Override // com.mimikridev.ads.listener.OnRewardedAdCompleteListener
    public void onRewardedAdComplete() {
        Log.d("AdNetwork_admanager", "Rewarded complete");
    }

    @Override // com.mimikridev.ads.listener.OnRewardedAdDismissedListener
    public void onRewardedAdDismissed() {
        Log.d("AdNetwork_admanager", "Rewarded dismissed");
    }

    @Override // com.mimikridev.ads.listener.OnRewardedAdErrorListener
    public void onRewardedAdError() {
        Log.d("AdNetwork_admanager", "Rewarded error");
    }

    @Override // com.vungle.ads.internal.util.FileUtility.ObjectInputStreamProvider
    public ObjectInputStream provideObjectInputStream(InputStream inputStream) {
        return FileUtility.m3377objectInputStreamProvider$lambda0(inputStream);
    }

    @Override // m0.i
    public void a(Exception exc) {
    }
}
