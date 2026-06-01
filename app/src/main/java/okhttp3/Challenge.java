package okhttp3;

import com.ironsource.G5;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.k;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String scheme, Map<String, String> authParams) {
        String lowerCase;
        k.e(scheme, "scheme");
        k.e(authParams, "authParams");
        this.scheme = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                k.d(US, "US");
                lowerCase = key.toLowerCase(US);
                k.d(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        k.d(mapUnmodifiableMap, "unmodifiableMap(...)");
        this.authParams = mapUnmodifiableMap;
    }

    /* JADX INFO: renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m3482deprecated_authParams() {
        return this.authParams;
    }

    /* JADX INFO: renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m3483deprecated_charset() {
        return charset();
    }

    /* JADX INFO: renamed from: -deprecated_realm, reason: not valid java name */
    public final String m3484deprecated_realm() {
        return realm();
    }

    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m3485deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        String str = this.authParams.get(G5.M);
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                k.d(charsetForName, "forName(...)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        return n6.a.f13076d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Challenge)) {
            return false;
        }
        Challenge challenge = (Challenge) obj;
        return k.a(challenge.scheme, this.scheme) && k.a(challenge.authParams, this.authParams);
    }

    public int hashCode() {
        return this.authParams.hashCode() + androidx.camera.core.processing.util.a.b(899, 31, this.scheme);
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset charset) {
        k.e(charset, "charset");
        LinkedHashMap linkedHashMapO0 = x.o0(this.authParams);
        linkedHashMapO0.put(G5.M, charset.name());
        return new Challenge(this.scheme, linkedHashMapO0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Challenge(String scheme, String realm) {
        k.e(scheme, "scheme");
        k.e(realm, "realm");
        Map mapSingletonMap = Collections.singletonMap("realm", realm);
        k.d(mapSingletonMap, "singletonMap(...)");
        this(scheme, (Map<String, String>) mapSingletonMap);
    }
}
