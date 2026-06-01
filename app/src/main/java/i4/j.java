package i4;

import j4.b3;
import j4.s3;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements k, z0, l1, w0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f11874b = new j(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f11875c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11876a;

    public /* synthetic */ j(int i2) {
        this.f11876a = i2;
    }

    @Override // i4.k
    public OutputStream a(b3 b3Var) {
        switch (this.f11876a) {
            case 0:
                return b3Var;
            default:
                return new GZIPOutputStream(b3Var);
        }
    }

    @Override // i4.l1
    public boolean b(Object obj) {
        switch (this.f11876a) {
            case 6:
                ((p0) obj).getClass();
                break;
            case 7:
                ((s0) obj).getClass();
                break;
            default:
                ((g1) obj).getClass();
                break;
        }
        return true;
    }

    @Override // i4.w0
    public String c(Object obj) {
        return (String) obj;
    }

    @Override // i4.l1
    public int d(Object obj) {
        switch (this.f11876a) {
            case 6:
                ((p0) obj).getClass();
                break;
            case 7:
                ((k4.i) ((s0) obj)).getClass();
                try {
                    Class.forName("android.app.Application", false, k4.i.class.getClassLoader());
                }
                break;
            default:
                ((g1) obj).getClass();
                break;
        }
        return 5;
    }

    @Override // i4.k
    public InputStream e(s3 s3Var) {
        switch (this.f11876a) {
            case 0:
                return s3Var;
            default:
                return new GZIPInputStream(s3Var);
        }
    }

    @Override // i4.k
    public String getMessageEncoding() {
        switch (this.f11876a) {
            case 0:
                return "identity";
            default:
                return "gzip";
        }
    }

    @Override // i4.z0
    public Object o(byte[] bArr) {
        int i2;
        byte b8;
        switch (this.f11876a) {
            case 1:
                for (int i8 = 0; i8 < bArr.length; i8++) {
                    byte b9 = bArr[i8];
                    if (b9 < 32 || b9 >= 126 || (b9 == 37 && i8 + 2 < bArr.length)) {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
                        int i9 = 0;
                        while (i9 < bArr.length) {
                            if (bArr[i9] == 37 && i9 + 2 < bArr.length) {
                                try {
                                    byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i9 + 1, 2, e2.d.f11227a), 16));
                                    i9 += 3;
                                } catch (NumberFormatException unused) {
                                    byteBufferAllocate.put(bArr[i9]);
                                    i9++;
                                }
                            }
                            byteBufferAllocate.put(bArr[i9]);
                            i9++;
                        }
                        return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), e2.d.f11228b);
                    }
                }
                return new String(bArr, 0);
            default:
                char c7 = 0;
                if (bArr.length == 1 && bArr[0] == 48) {
                    return n1.e;
                }
                int length = bArr.length;
                if (length != 1) {
                    if (length == 2 && (b8 = bArr[0]) >= 48 && b8 <= 57) {
                        i2 = (b8 - 48) * 10;
                        c7 = 1;
                    }
                    return n1.g.h("Unknown code ".concat(new String(bArr, e2.d.f11227a)));
                }
                i2 = 0;
                byte b10 = bArr[c7];
                if (b10 >= 48 && b10 <= 57) {
                    int i10 = (b10 - 48) + i2;
                    List list = n1.f11913d;
                    if (i10 < list.size()) {
                        return (n1) list.get(i10);
                    }
                }
                return n1.g.h("Unknown code ".concat(new String(bArr, e2.d.f11227a)));
        }
    }

    public String toString() {
        switch (this.f11876a) {
            case 5:
                return "internal:health-check-consumer-listener";
            default:
                return super.toString();
        }
    }

    public j(SSLSession sSLSession) {
        this.f11876a = 4;
        sSLSession.getCipherSuite();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            Certificate certificate = localCertificates[0];
        }
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            if (peerCertificates != null) {
                Certificate certificate2 = peerCertificates[0];
            }
        } catch (SSLPeerUnverifiedException e) {
            b0.f11823d.log(Level.FINE, "Peer cert not available for peerHost=" + sSLSession.getPeerHost(), (Throwable) e);
        }
    }

    @Override // i4.z0
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public byte[] mo3445c(Object obj) {
        switch (this.f11876a) {
            case 1:
                byte[] bytes = ((String) obj).getBytes(e2.d.f11228b);
                int i2 = 0;
                while (i2 < bytes.length) {
                    byte b8 = bytes[i2];
                    if (b8 < 32 || b8 >= 126 || b8 == 37) {
                        byte[] bArr = new byte[((bytes.length - i2) * 3) + i2];
                        if (i2 != 0) {
                            System.arraycopy(bytes, 0, bArr, 0, i2);
                        }
                        int i8 = i2;
                        while (i2 < bytes.length) {
                            byte b9 = bytes[i2];
                            if (b9 < 32 || b9 >= 126 || b9 == 37) {
                                bArr[i8] = 37;
                                byte[] bArr2 = f11875c;
                                bArr[i8 + 1] = bArr2[(b9 >> 4) & 15];
                                bArr[i8 + 2] = bArr2[b9 & 15];
                                i8 += 3;
                            } else {
                                bArr[i8] = b9;
                                i8++;
                            }
                            i2++;
                        }
                        return Arrays.copyOf(bArr, i8);
                    }
                    i2++;
                }
                return bytes;
            default:
                return ((n1) obj).f11918a.f11910b;
        }
    }

    @Override // i4.w0
    public Object g(String str) {
        return str;
    }
}
