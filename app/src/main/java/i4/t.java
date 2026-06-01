package i4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e2.f f11954c = new e2.f(String.valueOf(','), 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f11955d = new t(j.f11874b, false, new t(new j(2), true, new t()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f11957b;

    public t(k kVar, boolean z2, t tVar) {
        String messageEncoding = kVar.getMessageEncoding();
        r2.q.y(!messageEncoding.contains(","), "Comma is currently not allowed in message encoding");
        int size = tVar.f11956a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(tVar.f11956a.containsKey(kVar.getMessageEncoding()) ? size : size + 1);
        for (s sVar : tVar.f11956a.values()) {
            String messageEncoding2 = sVar.f11949a.getMessageEncoding();
            if (!messageEncoding2.equals(messageEncoding)) {
                linkedHashMap.put(messageEncoding2, new s(sVar.f11949a, sVar.f11950b));
            }
        }
        linkedHashMap.put(messageEncoding, new s(kVar, z2));
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.f11956a = mapUnmodifiableMap;
        HashSet hashSet = new HashSet(mapUnmodifiableMap.size());
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            if (((s) entry.getValue()).f11950b) {
                hashSet.add((String) entry.getKey());
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        e2.f fVar = f11954c;
        fVar.getClass();
        Iterator it = setUnmodifiableSet.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                Object next = it.next();
                Objects.requireNonNull(next);
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb.append((CharSequence) fVar.f11230b);
                    Object next2 = it.next();
                    Objects.requireNonNull(next2);
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
            this.f11957b = sb.toString().getBytes(Charset.forName("US-ASCII"));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public t() {
        this.f11956a = new LinkedHashMap(0);
        this.f11957b = new byte[0];
    }
}
