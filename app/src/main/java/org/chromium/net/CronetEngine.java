package org.chromium.net;

import android.content.Context;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CronetEngine {
    private static final String TAG = "CronetEngine";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        public static final int HTTP_CACHE_DISABLED = 0;
        public static final int HTTP_CACHE_DISK = 3;
        public static final int HTTP_CACHE_DISK_NO_HTTP = 2;
        public static final int HTTP_CACHE_IN_MEMORY = 1;
        protected final ICronetEngineBuilder mBuilderDelegate;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this(createBuilderDelegate(context));
        }

        @VisibleForTesting
        public static int compareVersions(String str, String str2) {
            if (str == null || str2 == null) {
                throw new IllegalArgumentException("The input values cannot be null");
            }
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            for (int i2 = 0; i2 < strArrSplit.length && i2 < strArrSplit2.length; i2++) {
                try {
                    int i8 = Integer.parseInt(strArrSplit[i2]);
                    int i9 = Integer.parseInt(strArrSplit2[i2]);
                    if (i8 != i9) {
                        return Integer.signum(i8 - i9);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Unable to convert version segments into integers: " + strArrSplit[i2] + " & " + strArrSplit2[i2], e);
                }
            }
            return Integer.signum(strArrSplit.length - strArrSplit2.length);
        }

        private static ICronetEngineBuilder createBuilderDelegate(Context context) {
            CronetProvider cronetProvider = getEnabledCronetProviders(context, new ArrayList(CronetProvider.getAllProviders(context))).get(0);
            if (Log.isLoggable(CronetEngine.TAG, 3)) {
                Log.d(CronetEngine.TAG, String.format("Using '%s' provider for creating CronetEngine.Builder.", cronetProvider));
            }
            return cronetProvider.createBuilder().mBuilderDelegate;
        }

        @VisibleForTesting
        public static List<CronetProvider> getEnabledCronetProviders(Context context, List<CronetProvider> list) {
            if (list.size() == 0) {
                throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
            }
            Iterator<CronetProvider> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().isEnabled()) {
                    it.remove();
                }
            }
            if (list.size() == 0) {
                throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
            }
            Collections.sort(list, new a());
            return list;
        }

        public Builder addPublicKeyPins(String str, Set<byte[]> set, boolean z2, Date date) {
            this.mBuilderDelegate.addPublicKeyPins(str, set, z2, date);
            return this;
        }

        public Builder addQuicHint(String str, int i2, int i8) {
            this.mBuilderDelegate.addQuicHint(str, i2, i8);
            return this;
        }

        public CronetEngine build() {
            return this.mBuilderDelegate.build();
        }

        public Builder enableBrotli(boolean z2) {
            this.mBuilderDelegate.enableBrotli(z2);
            return this;
        }

        public Builder enableHttp2(boolean z2) {
            this.mBuilderDelegate.enableHttp2(z2);
            return this;
        }

        public Builder enableHttpCache(int i2, long j) {
            this.mBuilderDelegate.enableHttpCache(i2, j);
            return this;
        }

        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z2) {
            this.mBuilderDelegate.enablePublicKeyPinningBypassForLocalTrustAnchors(z2);
            return this;
        }

        public Builder enableQuic(boolean z2) {
            this.mBuilderDelegate.enableQuic(z2);
            return this;
        }

        public String getDefaultUserAgent() {
            return this.mBuilderDelegate.getDefaultUserAgent();
        }

        public Builder setLibraryLoader(LibraryLoader libraryLoader) {
            this.mBuilderDelegate.setLibraryLoader(libraryLoader);
            return this;
        }

        public Builder setStoragePath(String str) {
            this.mBuilderDelegate.setStoragePath(str);
            return this;
        }

        public Builder setUserAgent(String str) {
            this.mBuilderDelegate.setUserAgent(str);
            return this;
        }

        public Builder(ICronetEngineBuilder iCronetEngineBuilder) {
            this.mBuilderDelegate = iCronetEngineBuilder;
        }

        @Deprecated
        public Builder enableSdch(boolean z2) {
            return this;
        }
    }

    public abstract URLStreamHandlerFactory createURLStreamHandlerFactory();

    public abstract byte[] getGlobalMetricsDeltas();

    public abstract String getVersionString();

    public abstract UrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor);

    public abstract URLConnection openConnection(URL url) throws IOException;

    public abstract void shutdown();

    public abstract void startNetLogToFile(String str, boolean z2);

    public abstract void stopNetLog();
}
