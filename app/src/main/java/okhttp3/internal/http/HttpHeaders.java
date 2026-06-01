package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;
import l7.j;
import l7.m;
import n6.a;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.platform.Platform;
import r4.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class HttpHeaders {
    private static final m QUOTED_STRING_DELIMITERS;
    private static final m TOKEN_DELIMITERS;

    static {
        m mVar = m.f12880d;
        QUOTED_STRING_DELIMITERS = c.e("\"\\");
        TOKEN_DELIMITERS = c.e("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        k.e(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String headerName) {
        k.e(headers, "<this>");
        k.e(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (headerName.equalsIgnoreCase(headers.name(i2))) {
                j jVar = new j();
                jVar.d0(headers.value(i2));
                try {
                    readChallengeHeader(jVar, arrayList);
                } catch (EOFException e) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        k.e(response, "<this>");
        if (k.a(response.request().method(), "HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && _UtilJvmKt.headersContentLength(response) == -1 && !"chunked".equalsIgnoreCase(Response.header$default(response, "Transfer-Encoding", null, 2, null))) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r3 = androidx.camera.core.processing.util.a.r(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r5 < 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r5 == 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        if (r5 == 1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
    
        r8 = com.ironsource.C2300e4.i.f8399b.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        if (r8 == 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
    
        if (r8 == 1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
    
        r4 = new java.lang.StringBuilder(com.ironsource.C2300e4.i.f8399b.length() * r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        if (1 > r5) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
    
        r4.append((java.lang.CharSequence) com.ironsource.C2300e4.i.f8399b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (r7 == r5) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:
    
        r4 = r4.toString();
        kotlin.jvm.internal.k.b(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        r4 = 0;
        r6 = com.ironsource.C2300e4.i.f8399b.charAt(0);
        r7 = new char[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        if (r4 >= r5) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
    
        r7[r4] = r6;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
    
        r4 = new java.lang.String(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
    
        r4 = com.ironsource.C2300e4.i.f8399b.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c1, code lost:
    
        throw new java.lang.IllegalArgumentException(("Count 'n' must be non-negative, but was " + r5 + '.').toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0115, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0115, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void readChallengeHeader(l7.j r9, java.util.List<okhttp3.Challenge> r10) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.readChallengeHeader(l7.j, java.util.List):void");
    }

    private static final String readQuotedString(j jVar) throws EOFException {
        if (jVar.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        j jVar2 = new j();
        while (true) {
            long jK = jVar.k(QUOTED_STRING_DELIMITERS);
            if (jK == -1) {
                return null;
            }
            if (jVar.i(jK) == 34) {
                jVar2.write(jVar, jK);
                jVar.readByte();
                return jVar2.r();
            }
            if (jVar.f12868b == jK + 1) {
                return null;
            }
            jVar2.write(jVar, jK);
            jVar.readByte();
            jVar2.write(jVar, 1L);
        }
    }

    private static final String readToken(j jVar) {
        long jK = jVar.k(TOKEN_DELIMITERS);
        if (jK == -1) {
            jK = jVar.f12868b;
        }
        if (jK != 0) {
            return jVar.q(jK, a.f13073a);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl url, Headers headers) {
        k.e(cookieJar, "<this>");
        k.e(url, "url");
        k.e(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.Companion.parseAll(url, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(url, all);
    }

    private static final boolean skipCommasAndWhitespace(j jVar) throws EOFException {
        boolean z2 = false;
        while (!jVar.M()) {
            byte bI = jVar.i(0L);
            if (bI != 44) {
                if (bI != 32 && bI != 9) {
                    break;
                }
                jVar.readByte();
            } else {
                jVar.readByte();
                z2 = true;
            }
        }
        return z2;
    }

    private static final boolean startsWith(j jVar, byte b8) {
        return !jVar.M() && jVar.i(0L) == b8;
    }
}
