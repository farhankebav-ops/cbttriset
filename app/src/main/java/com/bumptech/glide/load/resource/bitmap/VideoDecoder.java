package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.c;
import androidx.camera.core.processing.util.a;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    public static final long DEFAULT_FRAME = -1;

    @VisibleForTesting
    static final int DEFAULT_FRAME_OPTION = 2;
    private static final String TAG = "VideoDecoder";
    private static final String WEBM_MIME_TYPE = "video/webm";
    private final BitmapPool bitmapPool;
    private final MediaMetadataRetrieverFactory factory;
    private final MediaInitializer<T> initializer;
    public static final Option<Long> TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.1
        private final ByteBuffer buffer = ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putLong(l.longValue()).array());
            }
        }
    });
    public static final Option<Integer> FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.2
        private final ByteBuffer buffer = ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putInt(num.intValue()).array());
            }
        }
    });
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    private static final List<String> PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(16)
    public static final class AssetFileDescriptorInitializer implements MediaInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeExtractor(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(23)
    public static final class ByteBufferInitializer implements MediaInitializer<ByteBuffer> {
        private MediaDataSource getMediaDataSource(final ByteBuffer byteBuffer) {
            return new MediaDataSource() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer.1
                @Override // android.media.MediaDataSource
                public long getSize() {
                    return byteBuffer.limit();
                }

                @Override // android.media.MediaDataSource
                public int readAt(long j, byte[] bArr, int i2, int i8) {
                    if (j >= byteBuffer.limit()) {
                        return -1;
                    }
                    byteBuffer.position((int) j);
                    int iMin = Math.min(i8, byteBuffer.remaining());
                    byteBuffer.get(bArr, i2, iMin);
                    return iMin;
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            };
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeExtractor(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
            mediaExtractor.setDataSource(getMediaDataSource(byteBuffer));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(getMediaDataSource(byteBuffer));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @VisibleForTesting
    public interface MediaInitializer<T> {
        @RequiresApi(16)
        void initializeExtractor(MediaExtractor mediaExtractor, T t3) throws IOException;

        void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, T t3);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @VisibleForTesting
    public static class MediaMetadataRetrieverFactory {
        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ParcelFileDescriptorInitializer implements MediaInitializer<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        @RequiresApi(16)
        public void initializeExtractor(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeRetriever(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        public VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public VideoDecoder(BitmapPool bitmapPool, MediaInitializer<T> mediaInitializer) {
        this(bitmapPool, mediaInitializer, DEFAULT_FACTORY);
    }

    @RequiresApi(16)
    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new AssetFileDescriptorInitializer());
    }

    @RequiresApi(api = 23)
    public static ResourceDecoder<ByteBuffer, Bitmap> byteBuffer(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ByteBufferInitializer());
    }

    private static Bitmap correctHdr180DegVideoFrameOrientation(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (isHdr180RotationFixRequired()) {
            try {
                if (isHDR(mediaMetadataRetriever)) {
                    if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) != 180) {
                        return bitmap;
                    }
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            } catch (NumberFormatException unused) {
                if (!Log.isLoggable(TAG, 3)) {
                    return bitmap;
                }
                Log.d(TAG, "Exception trying to extract HDR transfer function or rotation");
                return bitmap;
            }
        }
        return bitmap;
    }

    @Nullable
    private Bitmap decodeFrame(@NonNull T t3, MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i8, int i9, DownsampleStrategy downsampleStrategy) {
        if (isUnsupportedFormat(t3, mediaMetadataRetriever)) {
            throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
        }
        Bitmap bitmapDecodeScaledFrame = (Build.VERSION.SDK_INT < 27 || i8 == Integer.MIN_VALUE || i9 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.NONE) ? null : decodeScaledFrame(mediaMetadataRetriever, j, i2, i8, i9, downsampleStrategy);
        if (bitmapDecodeScaledFrame == null) {
            bitmapDecodeScaledFrame = decodeOriginalFrame(mediaMetadataRetriever, j, i2);
        }
        Bitmap bitmapCorrectHdr180DegVideoFrameOrientation = correctHdr180DegVideoFrameOrientation(mediaMetadataRetriever, bitmapDecodeScaledFrame);
        if (bitmapCorrectHdr180DegVideoFrameOrientation != null) {
            return bitmapCorrectHdr180DegVideoFrameOrientation;
        }
        throw new VideoDecoderException();
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j, i2);
    }

    @Nullable
    private static Bitmap decodeScaledFrame(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i8, int i9, DownsampleStrategy downsampleStrategy) {
        try {
            int i10 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i11 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i12 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i12 == 90 || i12 == 270) {
                i11 = i10;
                i10 = i11;
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(i10, i11, i8, i9);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i2, Math.round(i10 * scaleFactor), Math.round(scaleFactor * i11));
        } catch (Throwable th) {
            if (!Log.isLoggable(TAG, 3)) {
                return null;
            }
            Log.d(TAG, "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    @RequiresApi(30)
    private static boolean isHDR(MediaMetadataRetriever mediaMetadataRetriever) throws NumberFormatException {
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i2 = Integer.parseInt(strExtractMetadata);
        return (i2 == 7 || i2 == 6) && Integer.parseInt(strExtractMetadata2) == 6;
    }

    @VisibleForTesting
    public static boolean isHdr180RotationFixRequired() {
        if (Build.MODEL.startsWith("Pixel") && Build.VERSION.SDK_INT == 33) {
            return isTBuildRequiringRotationFix();
        }
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 30 && i2 < 33;
    }

    private static boolean isTBuildRequiringRotationFix() {
        Iterator<String> it = PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX.iterator();
        while (it.hasNext()) {
            if (Build.ID.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:23:0x0053, B:25:0x0059), top: B:40:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isUnsupportedFormat(@androidx.annotation.NonNull T r6, android.media.MediaMetadataRetriever r7) {
        /*
            r5 = this;
            java.lang.String r0 = "VideoDecoder"
            java.lang.String r1 = android.os.Build.DEVICE
            r2 = 0
            if (r1 == 0) goto L6d
            java.lang.String r3 = ".+_cheets|cheets_.+"
            boolean r1 = r1.matches(r3)
            if (r1 == 0) goto L6d
            r1 = 12
            r3 = 0
            java.lang.String r7 = r7.extractMetadata(r1)     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = "video/webm"
            boolean r7 = r1.equals(r7)     // Catch: java.lang.Throwable -> L51
            if (r7 != 0) goto L1f
            return r2
        L1f:
            android.media.MediaExtractor r7 = new android.media.MediaExtractor     // Catch: java.lang.Throwable -> L51
            r7.<init>()     // Catch: java.lang.Throwable -> L51
            com.bumptech.glide.load.resource.bitmap.VideoDecoder$MediaInitializer<T> r1 = r5.initializer     // Catch: java.lang.Throwable -> L4a
            r1.initializeExtractor(r7, r6)     // Catch: java.lang.Throwable -> L4a
            int r6 = r7.getTrackCount()     // Catch: java.lang.Throwable -> L4a
            r1 = r2
        L2e:
            if (r1 >= r6) goto L4d
            android.media.MediaFormat r3 = r7.getTrackFormat(r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "mime"
            java.lang.String r3 = r3.getString(r4)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "video/x-vnd.on2.vp8"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L47
            r7.release()
            r6 = 1
            return r6
        L47:
            int r1 = r1 + 1
            goto L2e
        L4a:
            r6 = move-exception
            r3 = r7
            goto L52
        L4d:
            r7.release()
            goto L66
        L51:
            r6 = move-exception
        L52:
            r7 = 3
            boolean r7 = android.util.Log.isLoggable(r0, r7)     // Catch: java.lang.Throwable -> L5f
            if (r7 == 0) goto L61
            java.lang.String r7 = "Exception trying to extract track info for a webm video on CrOS."
            android.util.Log.d(r0, r7, r6)     // Catch: java.lang.Throwable -> L5f
            goto L61
        L5f:
            r6 = move-exception
            goto L67
        L61:
            if (r3 == 0) goto L66
            r3.release()
        L66:
            return r2
        L67:
            if (r3 == 0) goto L6c
            r3.release()
        L6c:
            throw r6
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.isUnsupportedFormat(java.lang.Object, android.media.MediaMetadataRetriever):boolean");
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ParcelFileDescriptorInitializer());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull T t3, int i2, int i8, @NonNull Options options) throws Exception {
        long jLongValue = ((Long) options.get(TARGET_FRAME)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException(a.j("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", jLongValue));
        }
        Integer num = (Integer) options.get(FRAME_OPTION);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.DEFAULT;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever mediaMetadataRetrieverBuild = this.factory.build();
        try {
            this.initializer.initializeRetriever(mediaMetadataRetrieverBuild, t3);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Bitmap bitmapDecodeFrame = decodeFrame(t3, mediaMetadataRetrieverBuild, jLongValue, num.intValue(), i2, i8, downsampleStrategy2);
            if (Build.VERSION.SDK_INT < 29) {
                mediaMetadataRetrieverBuild.release();
            } else if (mediaMetadataRetrieverBuild instanceof AutoCloseable) {
                mediaMetadataRetrieverBuild.close();
            } else if (mediaMetadataRetrieverBuild instanceof ExecutorService) {
                c.v((ExecutorService) mediaMetadataRetrieverBuild);
            } else {
                if (mediaMetadataRetrieverBuild == 0) {
                    throw new IllegalArgumentException();
                }
                mediaMetadataRetrieverBuild.release();
            }
            return BitmapResource.obtain(bitmapDecodeFrame, this.bitmapPool);
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            if (Build.VERSION.SDK_INT < 29) {
                mediaMetadataRetrieverBuild.release();
                throw th3;
            }
            if (mediaMetadataRetrieverBuild instanceof AutoCloseable) {
                mediaMetadataRetrieverBuild.close();
                throw th3;
            }
            if (mediaMetadataRetrieverBuild instanceof ExecutorService) {
                c.v((ExecutorService) mediaMetadataRetrieverBuild);
                throw th3;
            }
            if (mediaMetadataRetrieverBuild == 0) {
                throw new IllegalArgumentException();
            }
            mediaMetadataRetrieverBuild.release();
            throw th3;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull T t3, @NonNull Options options) {
        return true;
    }

    @VisibleForTesting
    public VideoDecoder(BitmapPool bitmapPool, MediaInitializer<T> mediaInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.bitmapPool = bitmapPool;
        this.initializer = mediaInitializer;
        this.factory = mediaMetadataRetrieverFactory;
    }
}
