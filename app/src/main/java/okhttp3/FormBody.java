package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.j;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.url._UrlKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FormBody extends RequestBody {
    private final List<String> encodedNames;
    private final List<String> encodedValues;
    public static final Companion Companion = new Companion(null);
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get(ShareTarget.ENCODING_TYPE_URL_ENCODED);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder add(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            this.names.add(_UrlKt.canonicalizeWithCharset$default(name, 0, 0, _UrlKt.FORM_ENCODE_SET, false, false, false, false, this.charset, 91, null));
            this.values.add(_UrlKt.canonicalizeWithCharset$default(value, 0, 0, _UrlKt.FORM_ENCODE_SET, false, false, false, false, this.charset, 91, null));
            return this;
        }

        public final Builder addEncoded(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            this.names.add(_UrlKt.canonicalizeWithCharset$default(name, 0, 0, _UrlKt.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(_UrlKt.canonicalizeWithCharset$default(value, 0, 0, _UrlKt.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : charset);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public FormBody(List<String> encodedNames, List<String> encodedValues) {
        k.e(encodedNames, "encodedNames");
        k.e(encodedValues, "encodedValues");
        this.encodedNames = _UtilJvmKt.toImmutableList(encodedNames);
        this.encodedValues = _UtilJvmKt.toImmutableList(encodedValues);
    }

    private final long writeOrCountBytes(l7.k kVar, boolean z2) throws EOFException {
        j buffer;
        if (z2) {
            buffer = new j();
        } else {
            k.b(kVar);
            buffer = kVar.getBuffer();
        }
        int size = this.encodedNames.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                buffer.x(38);
            }
            buffer.d0(this.encodedNames.get(i2));
            buffer.x(61);
            buffer.d0(this.encodedValues.get(i2));
        }
        if (!z2) {
            return 0L;
        }
        long j = buffer.f12868b;
        buffer.a();
        return j;
    }

    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m3500deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int i2) {
        return this.encodedNames.get(i2);
    }

    public final String encodedValue(int i2) {
        return this.encodedValues.get(i2);
    }

    public final String name(int i2) {
        return _UrlKt.percentDecode$default(encodedName(i2), 0, 0, true, 3, null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int i2) {
        return _UrlKt.percentDecode$default(encodedValue(i2), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(l7.k sink) throws IOException {
        k.e(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
