package com.apm.insight.k;

import com.apm.insight.CustomRequestHeader;
import com.apm.insight.MonitorCrash;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HttpURLConnection f4505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4507d;
    private f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private k f4508f;

    public i(String str, String str2, boolean z2) throws IOException {
        this.f4506c = str2;
        this.f4507d = z2;
        String str3 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f4504a = str3;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f4505b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.f4505b.setDoOutput(true);
        this.f4505b.setDoInput(true);
        this.f4505b.setRequestMethod("POST");
        CustomRequestHeader customRequestHeader = MonitorCrash.mCustomRequestHeader;
        if (customRequestHeader != null) {
            customRequestHeader.addRequestHeader(this.f4505b);
        }
        this.f4505b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str3);
        if (!z2) {
            this.e = new f(this.f4505b.getOutputStream());
        } else {
            this.f4505b.setRequestProperty("Content-Encoding", "gzip");
            this.f4508f = new k(this.f4505b.getOutputStream());
        }
    }

    public final void a(String str, String str2) {
        b(str, str2);
    }

    public final void b(String str, String str2) {
        StringBuilder sb = new StringBuilder("--");
        androidx.camera.core.processing.util.a.A(sb, this.f4504a, "\r\nContent-Disposition: form-data; name=\"", str, "\"\r\nContent-Type: text/plain; charset=");
        sb.append(this.f4506c);
        sb.append("\r\n\r\n");
        try {
            if (this.f4507d) {
                this.f4508f.write(sb.toString().getBytes());
            } else {
                this.e.write(sb.toString().getBytes());
            }
        } catch (IOException unused) {
        }
        byte[] bytes = str2.getBytes();
        try {
            if (this.f4507d) {
                this.f4508f.write(bytes);
                this.f4508f.write("\r\n".getBytes());
            } else {
                this.e.write(bytes);
                this.e.write("\r\n".getBytes());
            }
        } catch (IOException unused2) {
        }
    }

    public final void a(String str, File... fileArr) throws IOException {
        StringBuilder sb = new StringBuilder("--");
        androidx.camera.core.processing.util.a.A(sb, this.f4504a, "\r\nContent-Disposition: form-data; name=\"", str, "\"; filename=\"");
        sb.append(str);
        sb.append("\"\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.f4507d) {
            this.f4508f.write(sb.toString().getBytes());
        } else {
            this.e.write(sb.toString().getBytes());
        }
        if (this.f4507d) {
            com.apm.insight.l.f.a(this.f4508f, fileArr);
        } else {
            com.apm.insight.l.f.a(this.e, fileArr);
        }
        if (this.f4507d) {
            this.f4508f.write("\r\n".getBytes());
        } else {
            this.e.write("\r\n".getBytes());
            this.e.flush();
        }
    }

    public final void a(String str, File file, Map<String, String> map) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder("--");
        androidx.camera.core.processing.util.a.A(sb, this.f4504a, "\r\nContent-Disposition: form-data; name=\"", str, "\"; filename=\"");
        sb.append(name);
        sb.append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ");
            sb.append(entry.getKey());
            sb.append("=\"");
            sb.append(entry.getValue());
            sb.append("\"");
        }
        sb.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.f4507d) {
            this.f4508f.write(sb.toString().getBytes());
        } else {
            this.e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = fileInputStream.read(bArr);
            if (i2 == -1) {
                break;
            } else if (this.f4507d) {
                this.f4508f.write(bArr, 0, i2);
            } else {
                this.e.write(bArr, 0, i2);
            }
        }
        fileInputStream.close();
        if (this.f4507d) {
            this.f4508f.write("\r\n".getBytes());
        } else {
            this.e.write("\r\n".getBytes());
            this.e.flush();
        }
    }

    public final String a() throws IOException {
        ArrayList arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f4504a + "--\r\n").getBytes();
        if (this.f4507d) {
            this.f4508f.write(bytes);
            this.f4508f.b();
            this.f4508f.a();
        } else {
            this.e.write(bytes);
            this.e.flush();
            this.e.a();
        }
        int responseCode = this.f4505b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f4505b.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                arrayList.add(line);
            }
            bufferedReader.close();
            this.f4505b.disconnect();
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                sb.append((String) obj);
            }
            return sb.toString();
        }
        throw new IOException("Server returned non-OK status: ".concat(String.valueOf(responseCode)));
    }
}
