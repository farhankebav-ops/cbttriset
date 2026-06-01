package m4;

import androidx.webkit.ProxyConfig;
import com.ironsource.C2270ca;
import com.ironsource.Ib;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import l7.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f12946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b[] f12947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f12948c;

    static {
        m mVar = m.f12880d;
        f12946a = r4.c.e(":");
        b bVar = new b(b.h, "");
        m mVar2 = b.e;
        b bVar2 = new b(mVar2, "GET");
        b bVar3 = new b(mVar2, "POST");
        m mVar3 = b.f12933f;
        b bVar4 = new b(mVar3, "/");
        b bVar5 = new b(mVar3, "/index.html");
        m mVar4 = b.g;
        b bVar6 = new b(mVar4, ProxyConfig.MATCH_HTTP);
        b bVar7 = new b(mVar4, "https");
        m mVar5 = b.f12932d;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, new b(mVar5, "200"), new b(mVar5, "204"), new b(mVar5, "206"), new b(mVar5, "304"), new b(mVar5, "400"), new b(mVar5, "404"), new b(mVar5, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b(C2270ca.m, ""), new b("allow", ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b("content-type", ""), new b("cookie", ""), new b("date", ""), new b("etag", ""), new b("expect", ""), new b("expires", ""), new b("from", ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b("location", ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b("referer", ""), new b("refresh", ""), new b("retry-after", ""), new b(Ib.f6986a, ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "")};
        f12947b = bVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i2 = 0; i2 < 61; i2++) {
            if (!linkedHashMap.containsKey(bVarArr[i2].f12934a)) {
                linkedHashMap.put(bVarArr[i2].f12934a, Integer.valueOf(i2));
            }
        }
        f12948c = Collections.unmodifiableMap(linkedHashMap);
    }

    public static void a(m mVar) throws IOException {
        int iD = mVar.d();
        for (int i2 = 0; i2 < iD; i2++) {
            byte bI = mVar.i(i2);
            if (bI >= 65 && bI <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(mVar.t()));
            }
        }
    }
}
