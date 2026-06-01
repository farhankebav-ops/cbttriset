package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.j;
import l7.l;
import l7.m;
import okhttp3.internal.Internal;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion;
    public static final ResponseBody EMPTY;
    private Reader reader;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final l source;

        public BomAwareReader(l source, Charset charset) {
            k.e(source, "source");
            k.e(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int i2, int i8) throws IOException {
            k.e(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.V(), _UtilJvmKt.readBomAsCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i2, i8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String str, MediaType mediaType) {
            k.e(str, "<this>");
            i iVarChooseCharset = Internal.chooseCharset(mediaType);
            Charset charset = (Charset) iVarChooseCharset.f13498a;
            MediaType mediaType2 = (MediaType) iVarChooseCharset.f13499b;
            j jVar = new j();
            k.e(charset, "charset");
            jVar.a0(str, 0, str.length(), charset);
            return create(jVar, mediaType2, jVar.f12868b);
        }

        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, m mVar, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(mVar, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, l lVar, MediaType mediaType, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            if ((i2 & 2) != 0) {
                j = -1;
            }
            return companion.create(lVar, mediaType, j);
        }

        public final ResponseBody create(byte[] bArr, MediaType mediaType) {
            k.e(bArr, "<this>");
            j jVar = new j();
            jVar.m3450write(bArr);
            return create(jVar, mediaType, bArr.length);
        }

        public final ResponseBody create(m mVar, MediaType mediaType) {
            k.e(mVar, "<this>");
            j jVar = new j();
            jVar.w(mVar);
            return create(jVar, mediaType, mVar.d());
        }

        public final ResponseBody create(final l lVar, final MediaType mediaType, final long j) {
            k.e(lVar, "<this>");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                public l source() {
                    return lVar;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, String content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, m content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, long j, l content) {
            k.e(content, "content");
            return create(content, mediaType, j);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        EMPTY = Companion.create$default(companion, m.f12880d, (MediaType) null, 1, (Object) null);
    }

    private final Charset charset() {
        return Internal.charsetOrUtf8(contentType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Throwable] */
    private final <T> T consumeSource(ResponseBody responseBody, e6.l lVar, e6.l lVar2) throws IOException {
        long jContentLength = responseBody.contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(androidx.camera.core.processing.util.a.j("Cannot buffer entire body for content length: ", jContentLength));
        }
        l lVarSource = responseBody.source();
        T t3 = null;
        try {
            Object objInvoke = lVar.invoke(lVarSource);
            if (lVarSource != null) {
                try {
                    lVarSource.close();
                } catch (Throwable 
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                    */
                /*
                    this = this;
                    long r0 = r6.contentLength()
                    r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
                    int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r2 > 0) goto L65
                    l7.l r6 = r6.source()
                    r2 = 0
                    java.lang.Object r7 = r7.invoke(r6)     // Catch: java.lang.Throwable -> L1f
                    if (r6 == 0) goto L1b
                    r6.close()     // Catch: java.lang.Throwable -> L1a
                    goto L1b
                L1a:
                    r2 = move-exception
                L1b:
                    r4 = r2
                    r2 = r7
                    r7 = r4
                    goto L2a
                L1f:
                    r7 = move-exception
                    if (r6 == 0) goto L2a
                    r6.close()     // Catch: java.lang.Throwable -> L26
                    goto L2a
                L26:
                    r6 = move-exception
                    a.a.h(r7, r6)
                L2a:
                    if (r7 != 0) goto L64
                    java.lang.Object r6 = r8.invoke(r2)
                    java.lang.Number r6 = (java.lang.Number) r6
                    int r6 = r6.intValue()
                    r7 = -1
                    int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r7 == 0) goto L63
                    long r7 = (long) r6
                    int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r7 != 0) goto L42
                    goto L63
                L42:
                    java.io.IOException r7 = new java.io.IOException
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder
                    java.lang.String r2 = "Content-Length ("
                    r8.<init>(r2)
                    r8.append(r0)
                    java.lang.String r0 = ") and stream length ("
                    r8.append(r0)
                    r8.append(r6)
                    java.lang.String r6 = ") disagree"
                    r8.append(r6)
                    java.lang.String r6 = r8.toString()
                    r7.<init>(r6)
                    throw r7
                L63:
                    return r2
                L64:
                    throw r7
                L65:
                    java.io.IOException r6 = new java.io.IOException
                    java.lang.String r7 = "Cannot buffer entire body for content length: "
                    java.lang.String r7 = androidx.camera.core.processing.util.a.j(r7, r0)
                    r6.<init>(r7)
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.ResponseBody.consumeSource(okhttp3.ResponseBody, e6.l, e6.l):java.lang.Object");
            }

            public static final ResponseBody create(String str, MediaType mediaType) {
                return Companion.create(str, mediaType);
            }

            public final InputStream byteStream() {
                return source().V();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v8 */
            public final m byteString() throws IOException {
                long jContentLength = contentLength();
                if (jContentLength > 2147483647L) {
                    throw new IOException(androidx.camera.core.processing.util.a.j("Cannot buffer entire body for content length: ", jContentLength));
                }
                l lVarSource = source();
                m th = null;
                try {
                    m mVarR = lVarSource.R();
                    try {
                        lVarSource.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    th = mVarR;
                } catch (Throwable th3) {
                    th = th3;
                    if (lVarSource != null) {
                        try {
                            lVarSource.close();
                        } catch (Throwable th4) {
                            a.a.h(th, th4);
                        }
                    }
                }
                if (th != 0) {
                    throw th;
                }
                int iD = th.d();
                if (jContentLength == -1 || jContentLength == iD) {
                    return th;
                }
                throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iD + ") disagree");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v8 */
            public final byte[] bytes() throws IOException {
                long jContentLength = contentLength();
                if (jContentLength > 2147483647L) {
                    throw new IOException(androidx.camera.core.processing.util.a.j("Cannot buffer entire body for content length: ", jContentLength));
                }
                l lVarSource = source();
                byte[] th = null;
                try {
                    byte[] bArrL = lVarSource.L();
                    try {
                        lVarSource.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    th = bArrL;
                } catch (Throwable th3) {
                    th = th3;
                    if (lVarSource != null) {
                        try {
                            lVarSource.close();
                        } catch (Throwable th4) {
                            a.a.h(th, th4);
                        }
                    }
                }
                if (th != 0) {
                    throw th;
                }
                int length = th.length;
                if (jContentLength == -1 || jContentLength == length) {
                    return th;
                }
                throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
            }

            public final Reader charStream() {
                Reader reader = this.reader;
                if (reader != null) {
                    return reader;
                }
                BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
                this.reader = bomAwareReader;
                return bomAwareReader;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                _UtilCommonKt.closeQuietly(source());
            }

            public abstract long contentLength();

            public abstract MediaType contentType();

            public abstract l source();

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r2v5 */
            public final String string() throws IOException {
                l lVarSource = source();
                String th = null;
                try {
                    String strP = lVarSource.P(_UtilJvmKt.readBomAsCharset(lVarSource, charset()));
                    try {
                        lVarSource.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    th = strP;
                } catch (Throwable th3) {
                    th = th3;
                    if (lVarSource != null) {
                        try {
                            lVarSource.close();
                        } catch (Throwable th4) {
                            a.a.h(th, th4);
                        }
                    }
                }
                if (th == 0) {
                    return th;
                }
                throw th;
            }

            public static final ResponseBody create(l lVar, MediaType mediaType, long j) {
                return Companion.create(lVar, mediaType, j);
            }

            public static final ResponseBody create(m mVar, MediaType mediaType) {
                return Companion.create(mVar, mediaType);
            }

            public static final ResponseBody create(MediaType mediaType, long j, l lVar) {
                return Companion.create(mediaType, j, lVar);
            }

            public static final ResponseBody create(MediaType mediaType, String str) {
                return Companion.create(mediaType, str);
            }

            public static final ResponseBody create(MediaType mediaType, m mVar) {
                return Companion.create(mediaType, mVar);
            }

            public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
                return Companion.create(mediaType, bArr);
            }

            public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
                return Companion.create(bArr, mediaType);
            }
        }
