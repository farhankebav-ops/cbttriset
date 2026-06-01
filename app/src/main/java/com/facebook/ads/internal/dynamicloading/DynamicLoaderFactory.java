package com.facebook.ads.internal.dynamicloading;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import com.facebook.ads.internal.util.common.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@Nullsafe(Nullsafe.Mode.LOCAL)
public class DynamicLoaderFactory {
    private static final String AUDIENCE_NETWORK_CODE_PATH = "audience_network";
    public static final String AUDIENCE_NETWORK_DEX = "audience_network.dex";
    private static final String CODE_CACHE_DIR = "code_cache";
    static final String DEX_LOADING_ERROR_MESSAGE = "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.";
    private static final int DEX_LOAD_RETRY_COUNT = 3;
    private static final int DEX_LOAD_RETRY_DELAY_MS = 200;
    private static final String OPTIMIZED_DEX_PATH = "optimized";
    private static boolean sFallbackMode;
    private static final String DYNAMIC_LOADING_BUILD_TYPE = "releaseDL";
    public static final boolean LOAD_FROM_ASSETS = DYNAMIC_LOADING_BUILD_TYPE.equals(BuildConfig.BUILD_TYPE);
    private static final AtomicReference<DynamicLoader> sDynamicLoader = new AtomicReference<>();
    private static final AtomicBoolean sInitializing = new AtomicBoolean();
    private static boolean sUseLegacyClassLoader = true;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface RemoteClassLoaderFactory {
        @Nullable
        ClassLoader create(Context context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudienceNetworkAds.InitResult createErrorInitResult(final Throwable th) {
        return new AudienceNetworkAds.InitResult() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.3
            @Override // com.facebook.ads.AudienceNetworkAds.InitResult
            public String getMessage() {
                return DynamicLoaderFactory.createErrorMessage(th);
            }

            @Override // com.facebook.ads.AudienceNetworkAds.InitResult
            public boolean isSuccess() {
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String createErrorMessage(Throwable th) {
        return "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.\n" + stackTraceToString(th);
    }

    private static ClassLoader createInMemoryClassLoader(Context context) throws IOException {
        try {
            ClassLoader classLoaderCreate = ((RemoteClassLoaderFactory) context.getClassLoader().loadClass("com.facebook.ads.internal.dynamicloading.RemoteClassLoaderFactoryImpl").getDeclaredConstructor(null).newInstance(null)).create(context);
            if (classLoaderCreate != null) {
                return classLoaderCreate;
            }
        } catch (Exception unused) {
            FlashPreferences.getSharedPreferences(context).edit().clear().apply();
        }
        InputStream inputStreamOpen = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStreamOpen.read(bArr);
            if (i2 <= 0) {
                inputStreamOpen.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                a.s();
                return a.o(byteBufferWrap, DynamicLoaderFactory.class.getClassLoader());
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doCallInitialize(Context context, @Nullable DynamicLoader dynamicLoader, @Nullable final Throwable th, boolean z2, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable final AudienceNetworkAds.InitListener initListener) {
        if (th != null) {
            if (initListener != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.2
                    @Override // java.lang.Runnable
                    public void run() {
                        initListener.onInitialized(DynamicLoaderFactory.createErrorInitResult(th));
                    }
                }, 100L);
                return;
            } else {
                Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th);
                return;
            }
        }
        if (dynamicLoader != null) {
            if (z2) {
                dynamicLoader.createAudienceNetworkAdsApi().onContentProviderCreated(context);
            } else {
                dynamicLoader.createAudienceNetworkAdsApi().initialize(context, multithreadedBundleWrapper, initListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DynamicLoader doMakeLoader(Context context, boolean z2) throws Exception {
        AtomicReference<DynamicLoader> atomicReference = sDynamicLoader;
        DynamicLoader dynamicLoader = atomicReference.get();
        if (dynamicLoader == null) {
            if (LOAD_FROM_ASSETS) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                dynamicLoader = (DynamicLoader) makeAdsSdkClassLoader(context.getApplicationContext()).loadClass("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
                Log.d(AudienceNetworkAds.TAG, "SDK dex loading time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } else {
                dynamicLoader = (DynamicLoader) Class.forName("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
            }
            if (z2) {
                dynamicLoader.maybeInitInternally(context);
            }
            atomicReference.set(dynamicLoader);
        }
        return dynamicLoader;
    }

    @Nullable
    private static Context getApplicationContextViaReflection() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (Throwable th) {
            Log.e(AudienceNetworkAds.TAG, "Failed to fetch Context from  ActivityThread. Audience Network SDK won't work unless you call AudienceNetworkAds.buildInitSettings().withListener(InitListener).initialize().", th);
            return null;
        }
    }

    private static File getCacheCodeDirLegacy(Context context, File file) throws IOException {
        File file2 = new File(file, CODE_CACHE_DIR);
        try {
            mkdirChecked(file2);
            return file2;
        } catch (IOException unused) {
            File dir = context.getDir(CODE_CACHE_DIR, 0);
            mkdirChecked(dir);
            return dir;
        }
    }

    private static File getCodeCacheDir(Context context, File file) throws IOException {
        return context.getCodeCacheDir();
    }

    @Nullable
    public static DynamicLoader getDynamicLoader() {
        return sDynamicLoader.get();
    }

    private static File getSecondaryDir(File file) throws IOException {
        File file2 = new File(file, AUDIENCE_NETWORK_CODE_PATH);
        mkdirChecked(file2);
        return file2;
    }

    public static void initialize(final Context context, @Nullable final MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable final AudienceNetworkAds.InitListener initListener, final boolean z2) {
        if (z2 || !sInitializing.getAndSet(true)) {
            new Thread(new Runnable() { // from class: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    Throwable th;
                    DynamicLoader dynamicLoader;
                    int i2;
                    ANActivityLifecycleCallbacksListener.registerActivityCallbacks(context);
                    synchronized (DynamicLoaderFactory.class) {
                        DynamicLoader dynamicLoaderDoMakeLoader = null;
                        th = null;
                        int i8 = 0;
                        while (i8 < 3) {
                            try {
                                dynamicLoaderDoMakeLoader = DynamicLoaderFactory.doMakeLoader(context, false);
                                break;
                            } finally {
                                if (i8 == i2) {
                                    try {
                                    } catch (Throwable th2) {
                                    }
                                }
                            }
                        }
                        dynamicLoader = dynamicLoaderDoMakeLoader;
                    }
                    DynamicLoaderFactory.doCallInitialize(context, dynamicLoader, th, z2, multithreadedBundleWrapper, initListener);
                    DynamicLoaderFactory.sInitializing.set(false);
                }
            }).start();
        }
    }

    public static synchronized boolean isFallbackMode() {
        return sFallbackMode;
    }

    private static ClassLoader makeAdsSdkClassLoader(Context context) throws Exception {
        if (Build.VERSION.SDK_INT >= 30) {
            return createInMemoryClassLoader(context);
        }
        if (sUseLegacyClassLoader) {
            return makeLegacyAdsSdkClassLoader(context);
        }
        File secondaryDir = getSecondaryDir(getCodeCacheDir(context, new File(context.getApplicationInfo().dataDir)));
        StringBuilder sb = new StringBuilder();
        sb.append(secondaryDir.getPath());
        String strR = a1.a.r(sb, File.separator, AUDIENCE_NETWORK_DEX);
        InputStream inputStreamOpen = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        FileOutputStream fileOutputStream = new FileOutputStream(strR);
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStreamOpen.read(bArr);
            if (i2 <= 0) {
                inputStreamOpen.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(secondaryDir.getPath());
                File file = new File(a1.a.r(sb2, File.separator, OPTIMIZED_DEX_PATH));
                mkdirChecked(file);
                return new DexClassLoader(strR, file.getPath(), null, context.getClassLoader());
            }
            fileOutputStream.write(bArr, 0, i2);
        }
    }

    private static DexClassLoader makeLegacyAdsSdkClassLoader(Context context) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getPath());
        String strR = a1.a.r(sb, File.separator, AUDIENCE_NETWORK_DEX);
        InputStream inputStreamOpen = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        FileOutputStream fileOutputStream = new FileOutputStream(strR);
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStreamOpen.read(bArr);
            if (i2 <= 0) {
                inputStreamOpen.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                return new DexClassLoader(strR, context.getDir(OPTIMIZED_DEX_PATH, 0).getPath(), null, DynamicLoaderFactory.class.getClassLoader());
            }
            fileOutputStream.write(bArr, 0, i2);
        }
    }

    public static synchronized DynamicLoader makeLoader(Context context) {
        return makeLoader(context, true);
    }

    public static synchronized DynamicLoader makeLoaderUnsafe() {
        AtomicReference<DynamicLoader> atomicReference = sDynamicLoader;
        if (atomicReference.get() != null) {
            return atomicReference.get();
        }
        Context applicationContextViaReflection = getApplicationContextViaReflection();
        if (applicationContextViaReflection == null) {
            throw new RuntimeException("You must call AudienceNetworkAds.buildInitSettings(Context).initialize() before you can use Audience Network SDK.");
        }
        return makeLoader(applicationContextViaReflection, true);
    }

    private static void mkdirChecked(File file) throws IOException {
        String str;
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            str = "Failed to create dir " + file.getPath() + ". Parent file is null.";
        } else {
            str = "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite();
        }
        Log.e(AudienceNetworkAds.TAG, str);
        throw new IOException("Failed to create directory " + file.getPath() + ", detailed message: " + str);
    }

    public static synchronized void setFallbackMode(boolean z2) {
        try {
            if (z2) {
                sDynamicLoader.set(DynamicLoaderFallback.makeFallbackLoader());
                sFallbackMode = true;
            } else {
                sDynamicLoader.set(null);
                sFallbackMode = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void setUseLegacyClassLoader(boolean z2) {
        sUseLegacyClassLoader = z2;
    }

    private static String stackTraceToString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static synchronized DynamicLoader makeLoader(Context context, boolean z2) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        try {
        } catch (Throwable th) {
            Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th);
            DexLoadErrorReporter.reportDexLoadingIssue(context, createErrorMessage(th), 0.1d);
            DynamicLoader dynamicLoaderMakeFallbackLoader = DynamicLoaderFallback.makeFallbackLoader();
            sDynamicLoader.set(dynamicLoaderMakeFallbackLoader);
            sFallbackMode = true;
            return dynamicLoaderMakeFallbackLoader;
        }
        return doMakeLoader(context, z2);
    }
}
