package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private T data;
    private final Uri uri;
    protected final boolean useMediaStoreApisIfAvailable;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this(contentResolver, uri, false);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t3 = this.data;
        if (t3 != null) {
            try {
                close(t3);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void close(T t3) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T tLoadResource = loadResource(this.uri, this.contentResolver);
            this.data = tLoadResource;
            dataCallback.onDataReady(tLoadResource);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to open Uri", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    public abstract T loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public AssetFileDescriptor openAssetFileDescriptor(Uri uri) throws FileNotFoundException {
        return (this.useMediaStoreApisIfAvailable && MediaStoreUtil.isMediaStoreUri(uri) && MediaStoreUtil.isMediaStoreOpenFileApisAvailable()) ? MediaStoreUtil.openAssetFileDescriptor(uri, this.contentResolver) : this.contentResolver.openAssetFileDescriptor(uri, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
    }

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri, boolean z2) {
        this.contentResolver = contentResolver;
        this.uri = uri;
        this.useMediaStoreApisIfAvailable = z2;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }
}
