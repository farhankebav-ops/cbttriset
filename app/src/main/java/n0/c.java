package n0;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import o0.l;
import q0.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f13050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f13051c;
    public final y0.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y0.a f13053f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataEncoder f13049a = new JsonDataEncoderBuilder().configureWith(l.f13148a).ignoreNullValues(true).build();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URL f13052d = b(a.f13041c);
    public final int g = 130000;

    public c(Context context, y0.a aVar, y0.a aVar2) {
        this.f13051c = context;
        this.f13050b = (ConnectivityManager) context.getSystemService("connectivity");
        this.e = aVar2;
        this.f13053f = aVar;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(a1.a.l("Invalid url: ", str), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p0.j a(p0.j r7) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.c.a(p0.j):p0.j");
    }
}
