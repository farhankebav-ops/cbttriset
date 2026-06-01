package okhttp3.internal.publicsuffix;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.b;
import l7.o0;
import okhttp3.internal.platform.PlatformRegistry;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class AssetPublicSuffixList extends BasePublicSuffixList {
    public static final Companion Companion = new Companion(null);
    private static final String PUBLIC_SUFFIX_RESOURCE = "PublicSuffixDatabase.list";
    private final String path;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String getPUBLIC_SUFFIX_RESOURCE() {
            return AssetPublicSuffixList.PUBLIC_SUFFIX_RESOURCE;
        }

        private Companion() {
        }
    }

    public AssetPublicSuffixList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public o0 listSource() throws IOException {
        AssetManager assets;
        Context applicationContext = PlatformRegistry.INSTANCE.getApplicationContext();
        if (applicationContext == null || (assets = applicationContext.getAssets()) == null) {
            throw new IOException("Platform applicationContext not initialized");
        }
        InputStream inputStreamOpen = assets.open(getPath());
        k.d(inputStreamOpen, "open(...)");
        return b.j(inputStreamOpen);
    }

    public /* synthetic */ AssetPublicSuffixList(String str, int i2, f fVar) {
        this((i2 & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : str);
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public String getPath() {
        return this.path;
    }

    public AssetPublicSuffixList(String path) {
        k.e(path, "path");
        this.path = path;
    }
}
