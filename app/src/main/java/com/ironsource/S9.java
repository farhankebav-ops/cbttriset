package com.ironsource;

import com.bumptech.glide.load.Key;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class S9 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends GZIPOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7592a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OutputStream outputStream, int i2) throws IOException {
            super(outputStream);
            this.f7592a = i2;
            if (i2 < 0 || i2 > 9) {
                return;
            }
            ((GZIPOutputStream) this).def.setLevel(i2);
        }
    }

    public static byte[] a(String str, int i2) throws Exception {
        byte[] byteArray = new byte[0];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            a aVar = new a(byteArrayOutputStream, i2);
            aVar.write(str.getBytes());
            aVar.close();
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (OutOfMemoryError e) {
            C2531r4.d().a(e);
            String str2 = "Error while compressing:" + e.getMessage();
            IronLog.INTERNAL.error(str2);
            b(str2);
            return byteArray;
        }
    }

    private static void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, str);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        Mb.U().q().a(new C5(D5.TROUBLESHOOTING_FAILED_TO_GZIP, jSONObject));
    }

    public static byte[] a(String str) throws Exception {
        return a(str, -1);
    }

    public static String a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, Key.STRING_CHARSET_NAME));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    bufferedReader.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error("exception while decompressing " + e);
            return null;
        } catch (OutOfMemoryError e4) {
            C2531r4.d().a(e4);
            String str = "Error while decompressing:" + e4.getMessage();
            IronLog.INTERNAL.error(str);
            b(str);
            return null;
        }
    }
}
