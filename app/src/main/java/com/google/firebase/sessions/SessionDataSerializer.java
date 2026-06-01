package com.google.firebase.sessions;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionDataSerializer implements Serializer<SessionData> {
    private final SessionGenerator sessionGenerator;

    public SessionDataSerializer(SessionGenerator sessionGenerator) {
        k.e(sessionGenerator, "sessionGenerator");
        this.sessionGenerator = sessionGenerator;
    }

    @Override // androidx.datastore.core.Serializer
    public Object readFrom(InputStream inputStream, v5.c<? super SessionData> cVar) throws CorruptionException {
        try {
            g7.b bVar = g7.c.f11597d;
            String strE0 = t.e0(n7.b.K(inputStream));
            bVar.getClass();
            return (SessionData) bVar.a(SessionData.Companion.serializer(), strE0);
        } catch (Exception e) {
            throw new CorruptionException("Cannot parse session data", e);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public /* bridge */ /* synthetic */ Object writeTo(SessionData sessionData, OutputStream outputStream, v5.c cVar) {
        return writeTo2(sessionData, outputStream, (v5.c<? super x>) cVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.datastore.core.Serializer
    public SessionData getDefaultValue() {
        return new SessionData(this.sessionGenerator.generateNewSession(null), (Time) null, (Map) null, 6, (f) null);
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    public Object writeTo2(SessionData sessionData, OutputStream outputStream, v5.c<? super x> cVar) throws IOException {
        byte[] bytes = g7.c.f11597d.b(SessionData.Companion.serializer(), sessionData).getBytes(n6.a.f13073a);
        k.d(bytes, "getBytes(...)");
        outputStream.write(bytes);
        return x.f13520a;
    }
}
