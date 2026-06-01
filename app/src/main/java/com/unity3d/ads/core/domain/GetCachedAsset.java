package com.unity3d.ads.core.domain;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.jvm.internal.k;
import n6.m;
import q5.j;
import q6.c0;
import r2.q;
import v5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GetCachedAsset {
    private final CacheRepository cacheRepository;
    private final CacheWebViewAssets cacheWebViewAssets;
    private final Context context;

    public GetCachedAsset(CacheRepository cacheRepository, Context context, CacheWebViewAssets cacheWebViewAssets) {
        k.e(cacheRepository, "cacheRepository");
        k.e(context, "context");
        k.e(cacheWebViewAssets, "cacheWebViewAssets");
        this.cacheRepository = cacheRepository;
        this.context = context;
        this.cacheWebViewAssets = cacheWebViewAssets;
    }

    private final WebResourceResponse getBundledAsset(Uri uri) {
        String strN0 = m.N0(String.valueOf(uri.getPath()), "/");
        try {
            InputStream inputStreamOpen = this.context.getAssets().open(strN0);
            k.d(inputStreamOpen, "context.assets.open(fileName)");
            return new WebResourceResponse(StringExtensionsKt.guessMimeType(strN0), null, inputStreamOpen);
        } catch (Exception unused) {
            return null;
        }
    }

    private final WebResourceResponse getCachedAsset(Uri uri) {
        File file;
        Object objM;
        String string = uri.toString();
        k.d(string, "uri.toString()");
        CacheResult cacheResult = (CacheResult) c0.A(i.f17610a, new GetCachedAsset$getCachedAsset$result$1(this, m.P0(string, "/"), null));
        if ((cacheResult instanceof CacheResult.Success) && (file = ((CacheResult.Success) cacheResult).getCachedFile().getFile()) != null) {
            try {
                objM = new FileInputStream(file);
            } catch (Throwable th) {
                objM = q.M(th);
            }
            if (objM instanceof j) {
                objM = null;
            }
            FileInputStream fileInputStream = (FileInputStream) objM;
            if (fileInputStream != null) {
                String filePath = file.getAbsolutePath();
                k.d(filePath, "filePath");
                String strGuessMimeType = StringExtensionsKt.guessMimeType(filePath);
                if (strGuessMimeType != null && !m.A0(strGuessMimeType)) {
                    return new WebResourceResponse(strGuessMimeType, null, fileInputStream);
                }
            }
        }
        return null;
    }

    public static /* synthetic */ WebResourceResponse invoke$default(GetCachedAsset getCachedAsset, Uri uri, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        return getCachedAsset.invoke(uri, str);
    }

    private final WebResourceResponse tryGetWebViewAsset(Uri uri, String str) {
        Object objM;
        String strGuessMimeType;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('/');
        String string = uri.toString();
        k.d(string, "uri.toString()");
        int iY0 = m.y0(string, "?", 0, false, 6);
        if (iY0 != -1) {
            string = string.substring(0, iY0);
            k.d(string, "substring(...)");
        }
        sb.append(m.P0(string, "/"));
        String string2 = sb.toString();
        File file = this.cacheWebViewAssets.getCached().get(string2);
        if (file != null) {
            try {
                objM = new FileInputStream(file);
            } catch (Throwable th) {
                objM = q.M(th);
            }
            if (objM instanceof j) {
                objM = null;
            }
            FileInputStream fileInputStream = (FileInputStream) objM;
            if (fileInputStream != null && (strGuessMimeType = StringExtensionsKt.guessMimeType(string2)) != null && !m.A0(strGuessMimeType)) {
                return new WebResourceResponse(strGuessMimeType, null, fileInputStream);
            }
        }
        return null;
    }

    public final WebResourceResponse invoke(Uri uri, String webviewType) {
        k.e(uri, "uri");
        k.e(webviewType, "webviewType");
        String host = uri.getHost();
        if (host != null) {
            int iHashCode = host.hashCode();
            if (iHashCode != -1921537799) {
                if (iHashCode == -1920242293 && host.equals(UnityAdsConstants.DefaultUrls.AD_CACHE_DOMAIN)) {
                    return getCachedAsset(uri);
                }
            } else if (host.equals(UnityAdsConstants.DefaultUrls.AD_ASSET_DOMAIN)) {
                return getBundledAsset(uri);
            }
        }
        return tryGetWebViewAsset(uri, webviewType);
    }
}
