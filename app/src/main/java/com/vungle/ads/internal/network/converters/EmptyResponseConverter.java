package com.vungle.ads.internal.network.converters;

import java.io.IOException;
import okhttp3.ResponseBody;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class EmptyResponseConverter implements Converter<ResponseBody, Void> {
    @Override // com.vungle.ads.internal.network.converters.Converter
    public Void convert(ResponseBody responseBody) throws IOException {
        if (responseBody == null) {
            return null;
        }
        try {
            responseBody.close();
            responseBody.close();
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                q.I(responseBody, th);
                throw th2;
            }
        }
    }
}
