package okhttp3.internal.publicsuffix;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.g0;
import l7.o0;
import l7.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ResourcePublicSuffixList extends BasePublicSuffixList {
    public static final Companion Companion = new Companion(null);
    public static final g0 PUBLIC_SUFFIX_RESOURCE;
    private final t fileSystem;
    private final g0 path;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String str = g0.f12850b;
        PUBLIC_SUFFIX_RESOURCE = w1.f.d("okhttp3/internal/publicsuffix/PublicSuffixDatabase.list", false);
    }

    public ResourcePublicSuffixList() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final t getFileSystem() {
        return this.fileSystem;
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public o0 listSource() {
        return this.fileSystem.source(getPath());
    }

    public /* synthetic */ ResourcePublicSuffixList(g0 g0Var, t tVar, int i2, f fVar) {
        this((i2 & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : g0Var, (i2 & 2) != 0 ? t.RESOURCES : tVar);
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public g0 getPath() {
        return this.path;
    }

    public ResourcePublicSuffixList(g0 path, t fileSystem) {
        k.e(path, "path");
        k.e(fileSystem, "fileSystem");
        this.path = path;
        this.fileSystem = fileSystem;
    }
}
