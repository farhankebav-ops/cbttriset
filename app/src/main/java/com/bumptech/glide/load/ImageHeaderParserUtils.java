package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ImageHeaderParserUtils {
    private static final int MARK_READ_LIMIT = 5242880;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface JpegMpfReader {
        boolean getHasJpegMpfAndRewind(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OrientationReader {
        int getOrientationAndRewind(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface TypeReader {
        ImageHeaderParser.ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private ImageHeaderParserUtils() {
    }

    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @Nullable final ByteBuffer byteBuffer, @NonNull final ArrayPool arrayPool) throws IOException {
        if (byteBuffer == null) {
            return -1;
        }
        return getOrientationInternal(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.4
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientationAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getOrientation(byteBuffer, arrayPool);
                } finally {
                    ByteBufferUtil.rewind(byteBuffer);
                }
            }
        });
    }

    private static int getOrientationInternal(@NonNull List<ImageHeaderParser> list, OrientationReader orientationReader) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int orientationAndRewind = orientationReader.getOrientationAndRewind(list.get(i2));
            if (orientationAndRewind != -1) {
                return orientationAndRewind;
            }
        }
        return -1;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable final InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getTypeInternal(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.1
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getType(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    @NonNull
    private static ImageHeaderParser.ImageType getTypeInternal(@NonNull List<ImageHeaderParser> list, TypeReader typeReader) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType typeAndRewind = typeReader.getTypeAndRewind(list.get(i2));
            if (typeAndRewind != ImageHeaderParser.ImageType.UNKNOWN) {
                return typeAndRewind;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static boolean hasJpegMpf(@NonNull List<ImageHeaderParser> list, @Nullable final ByteBuffer byteBuffer, @NonNull final ArrayPool arrayPool) throws IOException {
        if (byteBuffer == null) {
            return false;
        }
        return hasJpegMpfInternal(list, new JpegMpfReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.7
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.JpegMpfReader
            public boolean getHasJpegMpfAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.hasJpegMpf(byteBuffer, arrayPool);
                } finally {
                    ByteBufferUtil.rewind(byteBuffer);
                }
            }
        });
    }

    private static boolean hasJpegMpfInternal(@NonNull List<ImageHeaderParser> list, JpegMpfReader jpegMpfReader) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (jpegMpfReader.getHasJpegMpfAndRewind(list.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @Nullable final InputStream inputStream, @NonNull final ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getOrientationInternal(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.5
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientationAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getOrientation(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static boolean hasJpegMpf(@NonNull List<ImageHeaderParser> list, @Nullable final InputStream inputStream, @NonNull final ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return false;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return hasJpegMpfInternal(list, new JpegMpfReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.8
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.JpegMpfReader
            public boolean getHasJpegMpfAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.hasJpegMpf(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    @RequiresApi(21)
    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @NonNull final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull final ArrayPool arrayPool) throws IOException {
        return getOrientationInternal(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.6
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientationAndRewind(ImageHeaderParser imageHeaderParser) throws Throwable {
                RecyclableBufferedInputStream recyclableBufferedInputStream;
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
                try {
                    recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), arrayPool);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream, arrayPool);
                    recyclableBufferedInputStream.release();
                    parcelFileDescriptorRewinder.rewindAndGet();
                    return orientation;
                } catch (Throwable th2) {
                    th = th2;
                    recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                    if (recyclableBufferedInputStream2 != null) {
                        recyclableBufferedInputStream2.release();
                    }
                    parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            }
        });
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable final ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return getTypeInternal(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.2
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getType(byteBuffer);
                } finally {
                    ByteBufferUtil.rewind(byteBuffer);
                }
            }
        });
    }

    @RequiresApi(21)
    public static boolean hasJpegMpf(@NonNull List<ImageHeaderParser> list, @NonNull final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull final ArrayPool arrayPool) throws IOException {
        return hasJpegMpfInternal(list, new JpegMpfReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.9
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.JpegMpfReader
            public boolean getHasJpegMpfAndRewind(ImageHeaderParser imageHeaderParser) throws Throwable {
                RecyclableBufferedInputStream recyclableBufferedInputStream;
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
                try {
                    recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), arrayPool);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    boolean zHasJpegMpf = imageHeaderParser.hasJpegMpf(recyclableBufferedInputStream, arrayPool);
                    recyclableBufferedInputStream.release();
                    parcelFileDescriptorRewinder.rewindAndGet();
                    return zHasJpegMpf;
                } catch (Throwable th2) {
                    th = th2;
                    recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                    if (recyclableBufferedInputStream2 != null) {
                        recyclableBufferedInputStream2.release();
                    }
                    parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            }
        });
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @NonNull final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull final ArrayPool arrayPool) throws IOException {
        return getTypeInternal(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.3
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getTypeAndRewind(ImageHeaderParser imageHeaderParser) throws Throwable {
                RecyclableBufferedInputStream recyclableBufferedInputStream;
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
                try {
                    recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), arrayPool);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream);
                    recyclableBufferedInputStream.release();
                    parcelFileDescriptorRewinder.rewindAndGet();
                    return type;
                } catch (Throwable th2) {
                    th = th2;
                    recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                    if (recyclableBufferedInputStream2 != null) {
                        recyclableBufferedInputStream2.release();
                    }
                    parcelFileDescriptorRewinder.rewindAndGet();
                    throw th;
                }
            }
        });
    }
}
