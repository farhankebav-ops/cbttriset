package n0;

import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import p0.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f13042d;
    public static final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f13043f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13045b;

    static {
        String strM = a.a.M("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f13041c = strM;
        String strM2 = a.a.M("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String strM3 = a.a.M("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f13042d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new m0.c("proto"), new m0.c("json"))));
        e = new a(strM, null);
        f13043f = new a(strM2, strM3);
    }

    public a(String str, String str2) {
        this.f13044a = str;
        this.f13045b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName(Key.STRING_CHARSET_NAME));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }
}
