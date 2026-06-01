package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.Q6;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10781a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f10783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10784d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f10785f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HttpURLConnection f10782b = null;
    private int g = -1;
    private byte[] h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10786i = 10000;
    private int j = 0;
    private int k = 2;
    private boolean l = true;
    private Runnable m = new a();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l0.this.c() || l0.this.j >= l0.this.k) {
                return;
            }
            l0.c(l0.this);
            q0.a(this);
        }
    }

    public l0(Context context) {
        this.f10783c = context;
    }

    public static /* synthetic */ int c(l0 l0Var) {
        int i2 = l0Var.j;
        l0Var.j = i2 + 1;
        return i2;
    }

    public abstract String a();

    public abstract void a(int i2, byte[] bArr);

    public static synchronized void a(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(f10781a)) {
            f10781a = str;
        }
    }

    private void b() {
        Object obj;
        if (this.f10782b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f10781a)) {
                jSONObject.put("ipv6", f10781a);
            }
            if (!TextUtils.isEmpty(com.pgl.ssdk.ces.b.f())) {
                jSONObject.put(Q6.U0, com.pgl.ssdk.ces.b.f());
            }
            jSONObject.put("region", m0.a());
            Pair<Integer, String> pairA = p0.a(jSONObject.toString());
            if (pairA == null || (obj = pairA.first) == null || pairA.second == null) {
                return;
            }
            this.f10782b.addRequestProperty("cypher", String.valueOf(obj));
            this.f10782b.addRequestProperty("transfer-param", (String) pairA.second);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b6 A[Catch: all -> 0x00ca, PHI: r0
  0x00b6: PHI (r0v14 java.io.InputStream) = (r0v13 java.io.InputStream), (r0v20 java.io.InputStream) binds: [B:30:0x00b3, B:27:0x00af] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #2 {all -> 0x00ca, blocks: (B:3:0x0004, B:5:0x0010, B:10:0x001f, B:12:0x0038, B:14:0x0040, B:15:0x0044, B:17:0x004d, B:19:0x0060, B:21:0x007d, B:23:0x0080, B:24:0x0096, B:33:0x00b9, B:32:0x00b6, B:18:0x0058), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c() {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.l0.c():boolean");
    }

    private void a(int i2) throws ProtocolException {
        this.f10782b.setRequestMethod(i2 != 1 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? "GET" : "TRACE" : "HEAD" : "DELETE" : "PUT" : "POST");
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr, 0, 1024);
            if (i2 > 0) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public void a(int i2, int i8, byte[] bArr) {
        b(i2, i8, bArr);
        q0.a(this.m);
    }

    private void b(int i2) {
        String str = i2 != 1 ? i2 != 2 ? "" : "application/octet-stream" : "application/json; charset=utf-8";
        if (!str.isEmpty()) {
            this.f10782b.addRequestProperty("Content-Type", str);
        }
        String strB = m0.b();
        if (strB != null) {
            this.f10782b.addRequestProperty("x-pangle-target-idc", strB);
        }
        b();
        try {
            String language = Locale.getDefault().getLanguage();
            if (language.equalsIgnoreCase("zh")) {
                this.f10782b.addRequestProperty("Accept-Language", Locale.getDefault().toString() + "," + language + ";q=0.9");
                return;
            }
            this.f10782b.addRequestProperty("Accept-Language", Locale.getDefault().toString() + "," + language + ";q=0.9,en-US;q=0.6,en;q=0.4");
        } catch (Throwable unused) {
        }
    }

    private void b(int i2, int i8, byte[] bArr) {
        this.f10784d = i2;
        this.e = i8;
        this.f10785f = bArr;
    }
}
