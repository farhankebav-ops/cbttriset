package androidx.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import androidx.webkit.internal.AssetHelper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebViewAssetLoader {
    public static final String DEFAULT_DOMAIN = "appassets.androidplatform.net";
    private static final String TAG = "WebViewAssetLoader";
    private final List<PathMatcher> mMatchers;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private String mDomain = WebViewAssetLoader.DEFAULT_DOMAIN;

        @NonNull
        private final List<Pair<String, PathHandler>> mHandlerList = new ArrayList();
        private boolean mHttpAllowed;

        @NonNull
        public Builder addPathHandler(@NonNull String str, @NonNull PathHandler pathHandler) {
            this.mHandlerList.add(Pair.create(str, pathHandler));
            return this;
        }

        @NonNull
        public WebViewAssetLoader build() {
            ArrayList arrayList = new ArrayList();
            for (Pair<String, PathHandler> pair : this.mHandlerList) {
                arrayList.add(new PathMatcher(this.mDomain, pair.first, this.mHttpAllowed, pair.second));
            }
            return new WebViewAssetLoader(arrayList);
        }

        @NonNull
        public Builder setDomain(@NonNull String str) {
            this.mDomain = str;
            return this;
        }

        @NonNull
        public Builder setHttpAllowed(boolean z2) {
            this.mHttpAllowed = z2;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class InternalStoragePathHandler implements PathHandler {
        private static final String[] FORBIDDEN_DATA_DIRS = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};

        @NonNull
        private final File mDirectory;

        public InternalStoragePathHandler(@NonNull Context context, @NonNull File file) {
            try {
                this.mDirectory = new File(AssetHelper.getCanonicalDirPath(file));
                if (isAllowedInternalStorageDir(context)) {
                    return;
                }
                throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e);
            }
        }

        private boolean isAllowedInternalStorageDir(@NonNull Context context) throws IOException {
            String canonicalDirPath = AssetHelper.getCanonicalDirPath(this.mDirectory);
            String canonicalDirPath2 = AssetHelper.getCanonicalDirPath(context.getCacheDir());
            String canonicalDirPath3 = AssetHelper.getCanonicalDirPath(AssetHelper.getDataDir(context));
            if ((!canonicalDirPath.startsWith(canonicalDirPath2) && !canonicalDirPath.startsWith(canonicalDirPath3)) || canonicalDirPath.equals(canonicalDirPath2) || canonicalDirPath.equals(canonicalDirPath3)) {
                return false;
            }
            for (String str : FORBIDDEN_DATA_DIRS) {
                if (canonicalDirPath.startsWith(canonicalDirPath3 + str)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @NonNull
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            File canonicalFileIfChild;
            try {
                canonicalFileIfChild = AssetHelper.getCanonicalFileIfChild(this.mDirectory, str);
            } catch (IOException e) {
                Log.e(WebViewAssetLoader.TAG, "Error opening the requested path: " + str, e);
            }
            if (canonicalFileIfChild != null) {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), null, AssetHelper.openFile(canonicalFileIfChild));
            }
            Log.e(WebViewAssetLoader.TAG, String.format("The requested file: %s is outside the mounted directory: %s", str, this.mDirectory));
            return new WebResourceResponse(null, null, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface PathHandler {
        @Nullable
        @WorkerThread
        WebResourceResponse handle(@NonNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @VisibleForTesting
    public static class PathMatcher {
        static final String HTTPS_SCHEME = "https";
        static final String HTTP_SCHEME = "http";

        @NonNull
        final String mAuthority;

        @NonNull
        final PathHandler mHandler;
        final boolean mHttpEnabled;

        @NonNull
        final String mPath;

        public PathMatcher(@NonNull String str, @NonNull String str2, boolean z2, @NonNull PathHandler pathHandler) {
            if (str2.isEmpty() || str2.charAt(0) != '/') {
                throw new IllegalArgumentException("Path should start with a slash '/'.");
            }
            if (!str2.endsWith("/")) {
                throw new IllegalArgumentException("Path should end with a slash '/'");
            }
            this.mAuthority = str;
            this.mPath = str2;
            this.mHttpEnabled = z2;
            this.mHandler = pathHandler;
        }

        @NonNull
        @WorkerThread
        public String getSuffixPath(@NonNull String str) {
            return str.replaceFirst(this.mPath, "");
        }

        @Nullable
        @WorkerThread
        public PathHandler match(@NonNull Uri uri) {
            if (uri.getScheme().equals("http") && !this.mHttpEnabled) {
                return null;
            }
            if ((uri.getScheme().equals("http") || uri.getScheme().equals("https")) && uri.getAuthority().equals(this.mAuthority) && uri.getPath().startsWith(this.mPath)) {
                return this.mHandler;
            }
            return null;
        }
    }

    public WebViewAssetLoader(@NonNull List<PathMatcher> list) {
        this.mMatchers = list;
    }

    @Nullable
    @WorkerThread
    public WebResourceResponse shouldInterceptRequest(@NonNull Uri uri) {
        WebResourceResponse webResourceResponseHandle;
        for (PathMatcher pathMatcher : this.mMatchers) {
            PathHandler pathHandlerMatch = pathMatcher.match(uri);
            if (pathHandlerMatch != null && (webResourceResponseHandle = pathHandlerMatch.handle(pathMatcher.getSuffixPath(uri.getPath()))) != null) {
                return webResourceResponseHandle;
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AssetsPathHandler implements PathHandler {
        private final AssetHelper mAssetHelper;

        public AssetsPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @Nullable
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), null, this.mAssetHelper.openAsset(str));
            } catch (IOException e) {
                Log.e(WebViewAssetLoader.TAG, "Error opening asset path: " + str, e);
                return new WebResourceResponse(null, null, null);
            }
        }

        @VisibleForTesting
        public AssetsPathHandler(@NonNull AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ResourcesPathHandler implements PathHandler {
        private final AssetHelper mAssetHelper;

        public ResourcesPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @Nullable
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), null, this.mAssetHelper.openResource(str));
            } catch (Resources.NotFoundException e) {
                Log.e(WebViewAssetLoader.TAG, "Resource not found from the path: " + str, e);
                return new WebResourceResponse(null, null, null);
            } catch (IOException e4) {
                Log.e(WebViewAssetLoader.TAG, "Error opening resource from the path: " + str, e4);
                return new WebResourceResponse(null, null, null);
            }
        }

        @VisibleForTesting
        public ResourcesPathHandler(@NonNull AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }
}
