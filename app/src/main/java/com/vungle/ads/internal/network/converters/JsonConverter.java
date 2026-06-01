package com.vungle.ads.internal.network.converters;

import a.a;
import g7.c;
import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l6.r;
import okhttp3.ResponseBody;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JsonConverter<E> implements Converter<ResponseBody, E> {
    public static final Companion Companion = new Companion(null);
    private static final c json = a.b(JsonConverter$Companion$json$1.INSTANCE);
    private final r kType;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public JsonConverter(r kType) {
        k.e(kType, "kType");
        this.kType = kType;
    }

    @Override // com.vungle.ads.internal.network.converters.Converter
    public E convert(ResponseBody responseBody) throws IOException {
        if (responseBody != null) {
            try {
                String strString = responseBody.string();
                if (strString != null) {
                    E e = (E) json.a(q.q0(c.f11597d.f11599b, this.kType), strString);
                    q.I(responseBody, null);
                    return e;
                }
            } finally {
            }
        }
        q.I(responseBody, null);
        return null;
    }
}
