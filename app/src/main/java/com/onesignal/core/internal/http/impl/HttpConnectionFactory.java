package com.onesignal.core.internal.http.impl;

import com.onesignal.core.internal.config.ConfigModelStore;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpConnectionFactory implements IHttpConnectionFactory {
    private final ConfigModelStore _configModelStore;

    public HttpConnectionFactory(ConfigModelStore _configModelStore) {
        k.e(_configModelStore, "_configModelStore");
        this._configModelStore = _configModelStore;
    }

    @Override // com.onesignal.core.internal.http.impl.IHttpConnectionFactory
    public HttpURLConnection newHttpURLConnection(String url) throws IOException {
        k.e(url, "url");
        URLConnection uRLConnectionOpenConnection = new URL(this._configModelStore.getModel().getApiUrl() + url).openConnection();
        k.c(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        return (HttpURLConnection) uRLConnectionOpenConnection;
    }
}
