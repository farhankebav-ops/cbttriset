package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.webkit.internal.b;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(28)
public final class AnimatedImageDecoder {
    private final ArrayPool arrayPool;
    private final List<ImageHeaderParser> imageHeaderParsers;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnimatedImageDrawableResource implements Resource<Drawable> {
        private static final int ESTIMATED_NUMBER_OF_FRAMES = 2;
        private final AnimatedImageDrawable imageDrawable;

        public AnimatedImageDrawableResource(AnimatedImageDrawable animatedImageDrawable) {
            this.imageDrawable = animatedImageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        public Class<Drawable> getResourceClass() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return Util.getBytesPerPixel(Bitmap.Config.ARGB_8888) * this.imageDrawable.getIntrinsicHeight() * this.imageDrawable.getIntrinsicWidth() * 2;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
            this.imageDrawable.stop();
            this.imageDrawable.clearAnimationCallbacks();
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        public Drawable get() {
            return this.imageDrawable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ByteBufferAnimatedImageDecoder implements ResourceDecoder<ByteBuffer, Drawable> {
        private final AnimatedImageDecoder delegate;

        public ByteBufferAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.delegate = animatedImageDecoder;
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public Resource<Drawable> decode(@NonNull ByteBuffer byteBuffer, int i2, int i8, @NonNull Options options) throws IOException {
            return this.delegate.decode(ImageDecoder.createSource(byteBuffer), i2, i8, options);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
            return this.delegate.handles(byteBuffer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class StreamAnimatedImageDecoder implements ResourceDecoder<InputStream, Drawable> {
        private final AnimatedImageDecoder delegate;

        public StreamAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.delegate = animatedImageDecoder;
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public Resource<Drawable> decode(@NonNull InputStream inputStream, int i2, int i8, @NonNull Options options) throws IOException {
            return this.delegate.decode(ImageDecoder.createSource(ByteBufferUtil.fromStream(inputStream)), i2, i8, options);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public boolean handles(@NonNull InputStream inputStream, @NonNull Options options) throws IOException {
            return this.delegate.handles(inputStream);
        }
    }

    private AnimatedImageDecoder(List<ImageHeaderParser> list, ArrayPool arrayPool) {
        this.imageHeaderParsers = list;
        this.arrayPool = arrayPool;
    }

    public static ResourceDecoder<ByteBuffer, Drawable> byteBufferDecoder(List<ImageHeaderParser> list, ArrayPool arrayPool) {
        return new ByteBufferAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool));
    }

    private boolean isHandled(ImageHeaderParser.ImageType imageType) {
        if (imageType != ImageHeaderParser.ImageType.ANIMATED_WEBP) {
            return Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        return true;
    }

    public static ResourceDecoder<InputStream, Drawable> streamDecoder(List<ImageHeaderParser> list, ArrayPool arrayPool) {
        return new StreamAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool));
    }

    public Resource<Drawable> decode(@NonNull ImageDecoder.Source source, int i2, int i8, @NonNull Options options) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new DefaultOnHeaderDecodedListener(i2, i8, options));
        if (b.x(drawableDecodeDrawable)) {
            return new AnimatedImageDrawableResource(b.g(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    public boolean handles(ByteBuffer byteBuffer) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, byteBuffer));
    }

    public boolean handles(InputStream inputStream) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, inputStream, this.arrayPool));
    }
}
