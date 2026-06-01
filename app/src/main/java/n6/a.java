package n6;

import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f13073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f13074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f13075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f13076d;
    public static volatile Charset e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile Charset f13077f;

    static {
        Charset charsetForName = Charset.forName(Key.STRING_CHARSET_NAME);
        kotlin.jvm.internal.k.d(charsetForName, "forName(...)");
        f13073a = charsetForName;
        kotlin.jvm.internal.k.d(Charset.forName("UTF-16"), "forName(...)");
        Charset charsetForName2 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.k.d(charsetForName2, "forName(...)");
        f13074b = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.k.d(charsetForName3, "forName(...)");
        f13075c = charsetForName3;
        kotlin.jvm.internal.k.d(Charset.forName("US-ASCII"), "forName(...)");
        Charset charsetForName4 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.k.d(charsetForName4, "forName(...)");
        f13076d = charsetForName4;
    }
}
