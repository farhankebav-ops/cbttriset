package com.google.firebase.sessions.settings;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import g7.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.k;
import n6.a;
import n6.t;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionConfigsSerializer implements Serializer<SessionConfigs> {
    public static final SessionConfigsSerializer INSTANCE = new SessionConfigsSerializer();
    private static final SessionConfigs defaultValue = new SessionConfigs(null, null, null, null, null);

    private SessionConfigsSerializer() {
    }

    @Override // androidx.datastore.core.Serializer
    public Object readFrom(InputStream inputStream, c<? super SessionConfigs> cVar) throws CorruptionException {
        try {
            b bVar = g7.c.f11597d;
            String strE0 = t.e0(n7.b.K(inputStream));
            bVar.getClass();
            return (SessionConfigs) bVar.a(SessionConfigs.Companion.serializer(), strE0);
        } catch (Exception e) {
            throw new CorruptionException("Cannot parse session configs", e);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public /* bridge */ /* synthetic */ Object writeTo(SessionConfigs sessionConfigs, OutputStream outputStream, c cVar) {
        return writeTo2(sessionConfigs, outputStream, (c<? super x>) cVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.datastore.core.Serializer
    public SessionConfigs getDefaultValue() {
        return defaultValue;
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    public Object writeTo2(SessionConfigs sessionConfigs, OutputStream outputStream, c<? super x> cVar) throws IOException {
        byte[] bytes = g7.c.f11597d.b(SessionConfigs.Companion.serializer(), sessionConfigs).getBytes(a.f13073a);
        k.d(bytes, "getBytes(...)");
        outputStream.write(bytes);
        return x.f13520a;
    }
}
