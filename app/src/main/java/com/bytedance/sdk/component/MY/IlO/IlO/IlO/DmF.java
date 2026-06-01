package com.bytedance.sdk.component.MY.IlO.IlO.IlO;

import com.bytedance.sdk.component.MY.IlO.ea;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends ea {
    HttpURLConnection IlO;
    InputStream MY;

    public DmF(HttpURLConnection httpURLConnection) throws IOException {
        this.IlO = httpURLConnection;
        this.MY = new Bc(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.MY.IlO.ea
    public com.bytedance.sdk.component.MY.IlO.DmF Cc() {
        if (this.IlO.getContentType() != null) {
            return com.bytedance.sdk.component.MY.IlO.DmF.IlO(this.IlO.getContentType());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.ea
    public InputStream EO() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.ea
    public long IlO() {
        try {
            return this.IlO.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.MY.IlO.ea
    public String MY() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.MY));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
                stringBuffer.append(line + "\n");
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.MY.IlO.ea, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.MY.close();
            this.IlO.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.MY.IlO.ea
    public byte[] tV() {
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i2 = this.MY.read(bArr);
                if (i2 == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public DmF(HttpURLConnection httpURLConnection, InputStream inputStream) {
        this.IlO = httpURLConnection;
        this.MY = new Bc(inputStream, httpURLConnection);
    }
}
