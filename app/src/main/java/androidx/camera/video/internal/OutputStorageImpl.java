package androidx.camera.video.internal;

import android.net.Uri;
import androidx.camera.core.Logger;
import androidx.camera.video.FileDescriptorOutputOptions;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.OutputOptions;
import androidx.camera.video.internal.utils.StorageUtil;
import androidx.core.location.LocationRequestCompat;
import java.io.File;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class OutputStorageImpl implements OutputStorage {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "OutputStorageImpl";
    private final OutputOptions outputOptions;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public OutputStorageImpl(OutputOptions outputOptions) {
        k.e(outputOptions, "outputOptions");
        this.outputOptions = outputOptions;
    }

    @Override // androidx.camera.video.internal.OutputStorage
    public long getAvailableBytes() {
        try {
            OutputOptions outputOptions = this.outputOptions;
            if (outputOptions instanceof FileOutputOptions) {
                File parentFile = ((FileOutputOptions) outputOptions).getFile().getParentFile();
                k.b(parentFile);
                return StorageUtil.getAvailableBytes(parentFile);
            }
            if (outputOptions instanceof MediaStoreOutputOptions) {
                Uri collectionUri = ((MediaStoreOutputOptions) outputOptions).getCollectionUri();
                k.d(collectionUri, "getCollectionUri(...)");
                return StorageUtil.getAvailableBytesForMediaStoreUri(collectionUri);
            }
            if (outputOptions instanceof FileDescriptorOutputOptions) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
            throw new AssertionError("Unknown OutputOptions: " + this.outputOptions);
        } catch (RuntimeException e) {
            Logger.w(TAG, "Fail to access the available bytes.", e);
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
    }

    @Override // androidx.camera.video.internal.OutputStorage
    public OutputOptions getOutputOptions() {
        return this.outputOptions;
    }
}
