package f2;

import androidx.webkit.ProxyConfig;
import com.ironsource.C2300e4;
import java.io.Serializable;
import java.net.ProtocolException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Serializable f11325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f11327d;

    public static g c(String str) throws ProtocolException {
        int i2;
        String strSubstring;
        boolean zStartsWith = str.startsWith("HTTP/1.");
        l4.l lVar = l4.l.HTTP_1_0;
        if (zStartsWith) {
            i2 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                lVar = l4.l.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i2 = 4;
        }
        int i8 = i2 + 3;
        if (str.length() < i8) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i9 = Integer.parseInt(str.substring(i2, i8));
            if (str.length() <= i8) {
                strSubstring = "";
            } else {
                if (str.charAt(i8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i2 + 4);
            }
            return new g(lVar, i9, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public p a() {
        f fVar = (f) this.f11327d;
        if (fVar != null) {
            throw fVar.a();
        }
        p pVarA = p.a(this.f11326c, (Object[]) this.f11325b, this);
        f fVar2 = (f) this.f11327d;
        if (fVar2 == null) {
            return pVarA;
        }
        throw fVar2.a();
    }

    public String b() {
        StringBuilder sb = new StringBuilder("$");
        int i2 = this.f11326c + 1;
        for (int i8 = 0; i8 < i2; i8++) {
            Object obj = ((Object[]) this.f11325b)[i8];
            if (obj instanceof d7.g) {
                d7.g gVar = (d7.g) obj;
                if (!kotlin.jvm.internal.k.a(gVar.getKind(), d7.m.f11202c)) {
                    int i9 = ((int[]) this.f11327d)[i8];
                    if (i9 >= 0) {
                        sb.append(".");
                        sb.append(gVar.e(i9));
                    }
                } else if (((int[]) this.f11327d)[i8] != -1) {
                    sb.append(C2300e4.i.f8403d);
                    sb.append(((int[]) this.f11327d)[i8]);
                    sb.append(C2300e4.i.e);
                }
            } else if (obj != h7.p.f11767a) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Serializable, java.lang.Object[]] */
    public void d(Object obj, Object obj2) {
        int i2 = (this.f11326c + 1) * 2;
        Object[] objArr = (Object[]) this.f11325b;
        if (i2 > objArr.length) {
            this.f11325b = Arrays.copyOf(objArr, b.d(objArr.length, i2));
        }
        a.a.n(obj, obj2);
        Object[] objArr2 = (Object[]) this.f11325b;
        int i8 = this.f11326c;
        int i9 = i8 * 2;
        objArr2[i9] = obj;
        objArr2[i9 + 1] = obj2;
        this.f11326c = i8 + 1;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Serializable, java.lang.Object[]] */
    public void e(Iterable iterable) {
        if (iterable instanceof Collection) {
            int size = (((Collection) iterable).size() + this.f11326c) * 2;
            Object[] objArr = (Object[]) this.f11325b;
            if (size > objArr.length) {
                this.f11325b = Arrays.copyOf(objArr, b.d(objArr.length, size));
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            d(entry.getKey(), entry.getValue());
        }
    }

    public String toString() {
        switch (this.f11324a) {
            case 1:
                return b();
            case 2:
                String str = (String) this.f11327d;
                StringBuilder sb = new StringBuilder();
                sb.append(((l4.l) this.f11325b) == l4.l.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
                sb.append(' ');
                sb.append(this.f11326c);
                if (str != null) {
                    sb.append(' ');
                    sb.append(str);
                }
                return sb.toString();
            case 3:
            default:
                return super.toString();
            case 4:
                StringBuilder sb2 = new StringBuilder();
                sb2.append((String) this.f11325b);
                sb2.append("://");
                int i2 = -1;
                if (((String) this.f11327d).indexOf(58) != -1) {
                    sb2.append('[');
                    sb2.append((String) this.f11327d);
                    sb2.append(']');
                } else {
                    sb2.append((String) this.f11327d);
                }
                int i8 = this.f11326c;
                if (i8 == -1) {
                    String str2 = (String) this.f11325b;
                    i8 = str2.equals(ProxyConfig.MATCH_HTTP) ? 80 : str2.equals("https") ? 443 : -1;
                }
                String str3 = (String) this.f11325b;
                if (str3.equals(ProxyConfig.MATCH_HTTP)) {
                    i2 = 80;
                } else if (str3.equals("https")) {
                    i2 = 443;
                }
                if (i8 != i2) {
                    sb2.append(':');
                    sb2.append(i8);
                }
                return sb2.toString();
        }
    }

    public g(l4.l lVar, int i2, String str) {
        this.f11324a = 2;
        this.f11325b = lVar;
        this.f11326c = i2;
        this.f11327d = str;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Serializable, java.lang.Object, java.lang.Object[]] */
    public g() {
        this.f11324a = 3;
        ?? r02 = new Object[5];
        this.f11325b = r02;
        this.f11327d = r02;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Serializable, java.lang.Object[]] */
    public g(int i2) {
        this.f11324a = 0;
        this.f11325b = new Object[i2 * 2];
        this.f11326c = 0;
    }
}
