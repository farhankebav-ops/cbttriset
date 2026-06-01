package okhttp3;

import com.ironsource.G5;
import e2.h;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.i;
import n6.j;
import n6.l;
import n6.m;
import n6.t;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final l TYPE_SUBTYPE = new l("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final l PARAMETER = new l(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m3536deprecated_get(String mediaType) {
            k.e(mediaType, "mediaType");
            return get(mediaType);
        }

        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m3537deprecated_parse(String mediaType) {
            k.e(mediaType, "mediaType");
            return parse(mediaType);
        }

        public final MediaType get(String str) {
            k.e(str, "<this>");
            h hVarA = MediaType.TYPE_SUBTYPE.a(0, str);
            if (hVarA == null) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.f('\"', "No subtype found for: \"", str));
            }
            if (((j) hVarA.f11233c) == null) {
                hVarA.f11233c = new j(hVarA);
            }
            j jVar = (j) hVarA.f11233c;
            k.b(jVar);
            String str2 = (String) jVar.get(1);
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            k.d(lowerCase, "toLowerCase(...)");
            if (((j) hVarA.f11233c) == null) {
                hVarA.f11233c = new j(hVarA);
            }
            j jVar2 = (j) hVarA.f11233c;
            k.b(jVar2);
            String lowerCase2 = ((String) jVar2.get(2)).toLowerCase(locale);
            k.d(lowerCase2, "toLowerCase(...)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher = (Matcher) hVarA.f11231a;
            int i2 = q.D0(matcher.start(), matcher.end()).f12710b;
            while (true) {
                int i8 = i2 + 1;
                if (i8 >= str.length()) {
                    return new MediaType(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
                }
                h hVarA2 = MediaType.PARAMETER.a(i8, str);
                if (hVarA2 == null) {
                    StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(i8);
                    k.d(strSubstring, "substring(...)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    throw new IllegalArgumentException(a1.a.e('\"', str, sb).toString());
                }
                Matcher matcher2 = (Matcher) hVarA2.f11231a;
                n6.k kVar = (n6.k) hVarA2.f11232b;
                i iVarA = kVar.a(1);
                String str3 = iVarA != null ? iVarA.f13099a : null;
                if (str3 == null) {
                    i2 = q.D0(matcher2.start(), matcher2.end()).f12710b;
                } else {
                    i iVarA2 = kVar.a(2);
                    String strSubstring2 = iVarA2 != null ? iVarA2.f13099a : null;
                    if (strSubstring2 == null) {
                        i iVarA3 = kVar.a(3);
                        k.b(iVarA3);
                        strSubstring2 = iVarA3.f13099a;
                    } else if (m.L0(strSubstring2, '\'') && m.t0(strSubstring2, '\'') && strSubstring2.length() > 2) {
                        strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                        k.d(strSubstring2, "substring(...)");
                    }
                    arrayList.add(str3);
                    arrayList.add(strSubstring2);
                    i2 = q.D0(matcher2.start(), matcher2.end()).f12710b;
                }
            }
        }

        public final MediaType parse(String str) {
            k.e(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    public MediaType(String mediaType, String type, String subtype, String[] parameterNamesAndValues) {
        k.e(mediaType, "mediaType");
        k.e(type, "type");
        k.e(subtype, "subtype");
        k.e(parameterNamesAndValues, "parameterNamesAndValues");
        this.mediaType = mediaType;
        this.type = type;
        this.subtype = subtype;
        this.parameterNamesAndValues = parameterNamesAndValues;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    /* JADX INFO: renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m3534deprecated_subtype() {
        return this.subtype;
    }

    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final String m3535deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && k.a(((MediaType) obj).mediaType, this.mediaType);
    }

    public final String getMediaType$okhttp() {
        return this.mediaType;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String name) {
        k.e(name, "name");
        int i2 = 0;
        int iA = z5.b.a(0, this.parameterNamesAndValues.length - 1, 2);
        if (iA < 0) {
            return null;
        }
        while (!t.g0(this.parameterNamesAndValues[i2], name)) {
            if (i2 == iA) {
                return null;
            }
            i2 += 2;
        }
        return this.parameterNamesAndValues[i2 + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }

    public final Charset charset(Charset charset) {
        String strParameter = parameter(G5.M);
        if (strParameter == null) {
            return charset;
        }
        try {
            return Charset.forName(strParameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
