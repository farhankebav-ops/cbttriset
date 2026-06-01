package com.bytedance.adsdk.MY.tV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements tV {
    private final HttpURLConnection IlO;

    public IlO(HttpURLConnection httpURLConnection) {
        this.IlO = httpURLConnection;
    }

    @Override // com.bytedance.adsdk.MY.tV.tV
    public String EO() {
        return this.IlO.getContentType();
    }

    @Override // com.bytedance.adsdk.MY.tV.tV
    public boolean IlO() {
        try {
            return this.IlO.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.adsdk.MY.tV.tV
    public InputStream MY() throws IOException {
        return this.IlO.getInputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.IlO.disconnect();
    }

    @Override // com.bytedance.adsdk.MY.tV.tV
    public String tV() {
        try {
            if (IlO()) {
                return null;
            }
            return "Unable to fetch " + this.IlO.getURL() + ". Failed with " + this.IlO.getResponseCode() + "\n" + IlO(this.IlO);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private String IlO(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
