package okhttp3;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.e;
import l7.g0;
import l7.m;
import l7.o0;
import l7.r0;
import l7.t;
import okhttp3.internal.Internal;
import okhttp3.internal._UtilCommonKt;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class RequestBody {
    public static final Companion Companion;
    public static final RequestBody EMPTY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] content) {
            k.e(content, "content");
            return create$default(this, mediaType, content, 0, 0, 12, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, m mVar, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(mVar, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] content, int i2) {
            k.e(content, "content");
            return create$default(this, mediaType, content, i2, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, FileDescriptor fileDescriptor, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(fileDescriptor, mediaType);
        }

        public final RequestBody create(byte[] bArr) {
            k.e(bArr, "<this>");
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i2, int i8, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                mediaType = null;
            }
            if ((i9 & 2) != 0) {
                i2 = 0;
            }
            if ((i9 & 4) != 0) {
                i8 = bArr.length;
            }
            return companion.create(bArr, mediaType, i2, i8);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            k.e(bArr, "<this>");
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i2) {
            k.e(bArr, "<this>");
            return create$default(this, bArr, mediaType, i2, 0, 4, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public final RequestBody create(String str, MediaType mediaType) {
            k.e(str, "<this>");
            i iVarChooseCharset = Internal.chooseCharset(mediaType);
            Charset charset = (Charset) iVarChooseCharset.f13498a;
            MediaType mediaType2 = (MediaType) iVarChooseCharset.f13499b;
            byte[] bytes = str.getBytes(charset);
            k.d(bytes, "getBytes(...)");
            return create(bytes, mediaType2, 0, bytes.length);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, g0 g0Var, t tVar, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                mediaType = null;
            }
            return companion.create(g0Var, tVar, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i2, int i8, int i9, Object obj) {
            if ((i9 & 4) != 0) {
                i2 = 0;
            }
            if ((i9 & 8) != 0) {
                i8 = bArr.length;
            }
            return companion.create(mediaType, bArr, i2, i8);
        }

        public final RequestBody create(final m mVar, final MediaType mediaType) {
            k.e(mVar, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return mVar.d();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(l7.k sink) {
                    k.e(sink, "sink");
                    sink.E(mVar);
                }
            };
        }

        public final RequestBody create(final FileDescriptor fileDescriptor, final MediaType mediaType) {
            k.e(fileDescriptor, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public boolean isOneShot() {
                    return true;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(l7.k sink) throws IOException {
                    k.e(sink, "sink");
                    FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
                    try {
                        sink.getBuffer().H(l7.b.j(fileInputStream));
                        fileInputStream.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(final byte[] bArr, final MediaType mediaType, final int i2, final int i8) {
            k.e(bArr, "<this>");
            _UtilCommonKt.checkOffsetAndCount(bArr.length, i2, i8);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$3
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i8;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(l7.k sink) {
                    k.e(sink, "sink");
                    sink.write(bArr, i2, i8);
                }
            };
        }

        public final RequestBody create(final File file, final MediaType mediaType) {
            k.e(file, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(l7.k sink) throws IOException {
                    k.e(sink, "sink");
                    File file2 = file;
                    k.e(file2, "<this>");
                    e eVar = new e(new FileInputStream(file2), r0.NONE);
                    try {
                        sink.H(eVar);
                        eVar.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(final g0 g0Var, final t fileSystem, final MediaType mediaType) {
            k.e(g0Var, "<this>");
            k.e(fileSystem, "fileSystem");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    Long l = fileSystem.metadata(g0Var).f12901d;
                    if (l != null) {
                        return l.longValue();
                    }
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(l7.k sink) throws IOException {
                    k.e(sink, "sink");
                    o0 o0VarSource = fileSystem.source(g0Var);
                    try {
                        sink.H(o0VarSource);
                        o0VarSource.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(MediaType mediaType, String content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final RequestBody create(MediaType mediaType, m content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] content, int i2, int i8) {
            k.e(content, "content");
            return create(content, mediaType, i2, i8);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            k.e(file, "file");
            return create(file, mediaType);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        EMPTY = Companion.create$default(companion, m.f12880d, (MediaType) null, 1, (Object) null);
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(l7.k kVar) throws IOException;

    public static final RequestBody create(FileDescriptor fileDescriptor, MediaType mediaType) {
        return Companion.create(fileDescriptor, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(m mVar, MediaType mediaType) {
        return Companion.create(mVar, mediaType);
    }

    public static final RequestBody create(g0 g0Var, t tVar, MediaType mediaType) {
        return Companion.create(g0Var, tVar, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, m mVar) {
        return Companion.create(mediaType, mVar);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i2) {
        return Companion.create(mediaType, bArr, i2);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i2, int i8) {
        return Companion.create(mediaType, bArr, i2, i8);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create(bArr);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i2) {
        return Companion.create(bArr, mediaType, i2);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i2, int i8) {
        return Companion.create(bArr, mediaType, i2, i8);
    }
}
