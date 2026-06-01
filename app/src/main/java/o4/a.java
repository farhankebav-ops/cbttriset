package o4;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import i4.i0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends InputStream implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageLite f13186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parser f13187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f13188c;

    public a(MessageLite messageLite, Parser parser) {
        this.f13186a = messageLite;
        this.f13187b = parser;
    }

    @Override // java.io.InputStream
    public final int available() {
        MessageLite messageLite = this.f13186a;
        if (messageLite != null) {
            return messageLite.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.f13188c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f13186a != null) {
            this.f13188c = new ByteArrayInputStream(this.f13186a.toByteArray());
            this.f13186a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f13188c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i8) throws IOException {
        MessageLite messageLite = this.f13186a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            if (serializedSize == 0) {
                this.f13186a = null;
                this.f13188c = null;
                return -1;
            }
            if (i8 >= serializedSize) {
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bArr, i2, serializedSize);
                this.f13186a.writeTo(codedOutputStreamNewInstance);
                codedOutputStreamNewInstance.flush();
                codedOutputStreamNewInstance.checkNoSpaceLeft();
                this.f13186a = null;
                this.f13188c = null;
                return serializedSize;
            }
            this.f13188c = new ByteArrayInputStream(this.f13186a.toByteArray());
            this.f13186a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f13188c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i2, i8);
        }
        return -1;
    }
}
