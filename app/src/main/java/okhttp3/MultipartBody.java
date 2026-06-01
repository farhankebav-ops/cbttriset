package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.j;
import l7.m;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal._UtilJvmKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final m boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private final m boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder addFormDataPart(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            addPart(Part.Companion.createFormData(name, value));
            return this;
        }

        public final Builder addPart(RequestBody body) {
            k.e(body, "body");
            addPart(Part.Companion.create(body));
            return this;
        }

        public final MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.boundary, this.type, _UtilJvmKt.toImmutableList(this.parts));
        }

        public final Builder setType(MediaType type) {
            k.e(type, "type");
            if (k.a(type.type(), "multipart")) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        public Builder(String boundary) {
            k.e(boundary, "boundary");
            m mVar = m.f12880d;
            this.boundary = r4.c.e(boundary);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public final Builder addFormDataPart(String name, String str, RequestBody body) {
            k.e(name, "name");
            k.e(body, "body");
            addPart(Part.Companion.createFormData(name, str, body));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody body) {
            k.e(body, "body");
            addPart(Part.Companion.create(headers, body));
            return this;
        }

        public final Builder addPart(Part part) {
            k.e(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Builder(String str, int i2, f fVar) {
            if ((i2 & 1) != 0) {
                str = UUID.randomUUID().toString();
                k.d(str, "toString(...)");
            }
            this(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void appendQuotedString$okhttp(StringBuilder sb, String key) {
            k.e(sb, "<this>");
            k.e(key, "key");
            sb.append('\"');
            int length = key.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = key.charAt(i2);
                if (cCharAt == '\n') {
                    sb.append("%0A");
                } else if (cCharAt == '\r') {
                    sb.append("%0D");
                } else if (cCharAt != '\"') {
                    sb.append(cCharAt);
                } else {
                    sb.append("%22");
                }
            }
            sb.append('\"');
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Part {
        public static final Companion Companion = new Companion(null);
        private final RequestBody body;
        private final Headers headers;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final Part create(RequestBody body) {
                k.e(body, "body");
                return create(null, body);
            }

            public final Part createFormData(String name, String value) {
                k.e(name, "name");
                k.e(value, "value");
                return createFormData(name, null, RequestBody.Companion.create$default(RequestBody.Companion, value, (MediaType) null, 1, (Object) null));
            }

            private Companion() {
            }

            public final Part create(Headers headers, RequestBody body) {
                k.e(body, "body");
                f fVar = null;
                if ((headers != null ? headers.get("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((headers != null ? headers.get("Content-Length") : null) == null) {
                    return new Part(headers, body, fVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            public final Part createFormData(String name, String str, RequestBody body) {
                k.e(name, "name");
                k.e(body, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, name);
                if (str != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str);
                }
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb.toString()).build(), body);
            }
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, f fVar) {
            this(headers, requestBody);
        }

        public static final Part create(Headers headers, RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m3542deprecated_body() {
            return this.body;
        }

        /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m3543deprecated_headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get(ShareTarget.ENCODING_TYPE_MULTIPART);
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(m boundaryByteString, MediaType type, List<Part> parts) {
        k.e(boundaryByteString, "boundaryByteString");
        k.e(type, "type");
        k.e(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = MediaType.Companion.get(type + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(l7.k kVar, boolean z2) throws IOException {
        j jVar;
        if (z2) {
            kVar = new j();
            jVar = kVar;
        } else {
            jVar = 0;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Part part = this.parts.get(i2);
            Headers headers = part.headers();
            RequestBody requestBodyBody = part.body();
            k.b(kVar);
            kVar.write(DASHDASH);
            kVar.E(this.boundaryByteString);
            kVar.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    kVar.C(headers.name(i8)).write(COLONSPACE).C(headers.value(i8)).write(CRLF);
                }
            }
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                kVar.C("Content-Type: ").C(mediaTypeContentType.toString()).write(CRLF);
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength == -1 && z2) {
                k.b(jVar);
                jVar.a();
                return -1L;
            }
            byte[] bArr = CRLF;
            kVar.write(bArr);
            if (z2) {
                j += jContentLength;
            } else {
                requestBodyBody.writeTo(kVar);
            }
            kVar.write(bArr);
        }
        k.b(kVar);
        byte[] bArr2 = DASHDASH;
        kVar.write(bArr2);
        kVar.E(this.boundaryByteString);
        kVar.write(bArr2);
        kVar.write(CRLF);
        if (!z2) {
            return j;
        }
        k.b(jVar);
        long j3 = j + jVar.f12868b;
        jVar.a();
        return j3;
    }

    /* JADX INFO: renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m3538deprecated_boundary() {
        return boundary();
    }

    /* JADX INFO: renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m3539deprecated_parts() {
        return this.parts;
    }

    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m3540deprecated_size() {
        return size();
    }

    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m3541deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.t();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        List<Part> list = this.parts;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Part) it.next()).body().isOneShot()) {
                return true;
            }
        }
        return false;
    }

    public final Part part(int i2) {
        return this.parts.get(i2);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(l7.k sink) throws IOException {
        k.e(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
