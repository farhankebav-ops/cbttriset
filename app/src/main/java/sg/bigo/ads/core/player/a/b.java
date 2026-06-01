package sg.bigo.ads.core.player.a;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sg.bigo.ads.common.m;

/* JADX INFO: loaded from: classes6.dex */
final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f17276d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern e = Pattern.compile("GET /(.*) HTTP");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17279c;

    private b(String str) {
        m.a(str);
        Matcher matcher = f17276d.matcher(str);
        long j = matcher.find() ? Long.parseLong(matcher.group(1)) : -1L;
        this.f17278b = Math.max(0L, j);
        this.f17279c = j >= 0;
        Matcher matcher2 = e.matcher(str);
        this.f17277a = matcher2.find() ? matcher2.group(1) : new String();
    }

    public static b a(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Key.STRING_CHARSET_NAME));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (TextUtils.isEmpty(line)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "ProxyCache", "GetRequest stringRequest=" + sb.toString());
                    return new b(sb.toString());
                }
                sb.append(line);
                sb.append('\n');
            }
        } catch (IOException e4) {
            sg.bigo.ads.common.t.a.a(0, "ProxyCache", "GetRequest#read, error message is : " + e4.toString());
            return null;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GetRequest{rangeOffset=");
        sb.append(this.f17278b);
        sb.append(", partial=");
        sb.append(this.f17279c);
        sb.append(", uri='");
        return a1.a.r(sb, this.f17277a, "'}");
    }
}
