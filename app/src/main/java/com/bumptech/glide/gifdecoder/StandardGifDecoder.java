package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;

    @ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";

    @ColorInt
    private int[] act;

    @NonNull
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;

    @Nullable
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;

    @ColorInt
    private int[] mainScratch;
    private GifHeaderParser parser;

    @ColorInt
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    @ColorInt
    private int averageColorsNear(int i2, int i8, int i9) {
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = i2; i15 < this.sampleSize + i2; i15++) {
            byte[] bArr = this.mainPixels;
            if (i15 >= bArr.length || i15 >= i8) {
                break;
            }
            int i16 = this.act[bArr[i15] & 255];
            if (i16 != 0) {
                i10 += (i16 >> 24) & 255;
                i11 += (i16 >> 16) & 255;
                i12 += (i16 >> 8) & 255;
                i13 += i16 & 255;
                i14++;
            }
        }
        int i17 = i2 + i9;
        for (int i18 = i17; i18 < this.sampleSize + i17; i18++) {
            byte[] bArr2 = this.mainPixels;
            if (i18 >= bArr2.length || i18 >= i8) {
                break;
            }
            int i19 = this.act[bArr2[i18] & 255];
            if (i19 != 0) {
                i10 += (i19 >> 24) & 255;
                i11 += (i19 >> 16) & 255;
                i12 += (i19 >> 8) & 255;
                i13 += i19 & 255;
                i14++;
            }
        }
        if (i14 == 0) {
            return 0;
        }
        return ((i10 / i14) << 24) | ((i11 / i14) << 16) | ((i12 / i14) << 8) | (i13 / i14);
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        int i2;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.mainScratch;
        int i11 = gifFrame.ih;
        int i12 = this.sampleSize;
        int i13 = i11 / i12;
        int i14 = gifFrame.iy / i12;
        int i15 = gifFrame.iw / i12;
        int i16 = gifFrame.ix / i12;
        boolean z2 = this.framePointer == 0;
        int i17 = this.downsampledWidth;
        int i18 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool = this.isFirstFrameTransparent;
        int i19 = 8;
        int i20 = 0;
        int i21 = 0;
        int i22 = 1;
        while (i21 < i13) {
            int[] iArr3 = iArr;
            if (gifFrame.interlace) {
                if (i20 >= i13) {
                    int i23 = i22 + 1;
                    i2 = i13;
                    if (i23 == 2) {
                        i22 = i23;
                        i20 = 4;
                    } else if (i23 == 3) {
                        i22 = i23;
                        i19 = 4;
                        i20 = 2;
                    } else if (i23 != 4) {
                        i22 = i23;
                    } else {
                        i22 = i23;
                        i20 = 1;
                        i19 = 2;
                    }
                } else {
                    i2 = i13;
                }
                i8 = i20 + i19;
            } else {
                i2 = i13;
                i8 = i20;
                i20 = i21;
            }
            int i24 = i20 + i14;
            boolean z7 = i12 == 1;
            if (i24 < i18) {
                int i25 = i24 * i17;
                int i26 = i25 + i16;
                int i27 = i26 + i15;
                int i28 = i25 + i17;
                if (i28 < i27) {
                    i27 = i28;
                }
                i9 = i8;
                int i29 = i21 * i12 * gifFrame.iw;
                if (z7) {
                    int i30 = i26;
                    while (i30 < i27) {
                        int i31 = i30;
                        int i32 = iArr2[bArr[i29] & 255];
                        if (i32 != 0) {
                            iArr3[i31] = i32;
                        } else if (z2 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i29 += i12;
                        i30 = i31 + 1;
                    }
                } else {
                    int i33 = ((i27 - i26) * i12) + i29;
                    i10 = i12;
                    int i34 = i26;
                    while (i34 < i27) {
                        int i35 = i27;
                        int iAverageColorsNear = averageColorsNear(i29, i33, gifFrame.iw);
                        if (iAverageColorsNear != 0) {
                            iArr3[i34] = iAverageColorsNear;
                        } else if (z2 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i29 += i10;
                        i34++;
                        i27 = i35;
                    }
                    i21++;
                    i12 = i10;
                    iArr = iArr3;
                    i13 = i2;
                    i20 = i9;
                }
            } else {
                i9 = i8;
            }
            i10 = i12;
            i21++;
            i12 = i10;
            iArr = iArr3;
            i13 = i2;
            i20 = i9;
        }
        if (this.isFirstFrameTransparent == null) {
            this.isFirstFrameTransparent = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i2 = gifFrame2.ih;
        int i8 = gifFrame2.iy;
        int i9 = gifFrame2.iw;
        int i10 = gifFrame2.ix;
        boolean z2 = this.framePointer == 0;
        int i11 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        int i12 = 0;
        byte b8 = -1;
        while (i12 < i2) {
            int i13 = (i12 + i8) * i11;
            int i14 = i13 + i10;
            int i15 = i14 + i9;
            int i16 = i13 + i11;
            if (i16 < i15) {
                i15 = i16;
            }
            int i17 = gifFrame2.iw * i12;
            int i18 = i14;
            while (i18 < i15) {
                byte b9 = bArr[i17];
                int[] iArr3 = iArr;
                int i19 = b9 & 255;
                if (i19 != b8) {
                    int i20 = iArr2[i19];
                    if (i20 != 0) {
                        iArr3[i18] = i20;
                    } else {
                        b8 = b9;
                    }
                }
                i17++;
                i18++;
                iArr = iArr3;
            }
            i12++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.isFirstFrameTransparent;
        this.isFirstFrameTransparent = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.isFirstFrameTransparent == null && z2 && b8 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15, types: [short] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i2;
        int i8;
        byte[] bArr;
        short s7;
        StandardGifDecoder standardGifDecoder = this;
        if (gifFrame != null) {
            standardGifDecoder.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = standardGifDecoder.header;
            i2 = gifHeader.width;
            i8 = gifHeader.height;
        } else {
            i2 = gifFrame.iw;
            i8 = gifFrame.ih;
        }
        int i9 = i2 * i8;
        byte[] bArr2 = standardGifDecoder.mainPixels;
        if (bArr2 == null || bArr2.length < i9) {
            standardGifDecoder.mainPixels = standardGifDecoder.bitmapProvider.obtainByteArray(i9);
        }
        byte[] bArr3 = standardGifDecoder.mainPixels;
        if (standardGifDecoder.prefix == null) {
            standardGifDecoder.prefix = new short[4096];
        }
        short[] sArr = standardGifDecoder.prefix;
        if (standardGifDecoder.suffix == null) {
            standardGifDecoder.suffix = new byte[4096];
        }
        byte[] bArr4 = standardGifDecoder.suffix;
        if (standardGifDecoder.pixelStack == null) {
            standardGifDecoder.pixelStack = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr5 = standardGifDecoder.pixelStack;
        int i10 = standardGifDecoder.readByte();
        int i11 = 1 << i10;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = i10 + 1;
        int i15 = (1 << i14) - 1;
        byte b8 = 0;
        for (int i16 = 0; i16 < i11; i16++) {
            sArr[i16] = 0;
            bArr4[i16] = (byte) i16;
        }
        byte[] bArr6 = standardGifDecoder.block;
        int i17 = i14;
        int i18 = i13;
        int i19 = i15;
        int i20 = 0;
        int block = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        while (true) {
            if (i20 >= i9) {
                break;
            }
            if (block == 0) {
                block = standardGifDecoder.readBlock();
                if (block <= 0) {
                    standardGifDecoder.status = 3;
                    break;
                }
                i21 = b8;
            }
            i23 += (bArr6[i21] & 255) << i22;
            i21++;
            block--;
            int i28 = i22 + 8;
            int i29 = i18;
            int i30 = i17;
            int i31 = i27;
            short[] sArr2 = sArr;
            int i32 = i25;
            while (true) {
                bArr = bArr4;
                if (i28 < i30) {
                    i18 = i29;
                    i25 = i32;
                    break;
                }
                int i33 = i23 & i19;
                i23 >>= i30;
                i28 -= i30;
                if (i33 == i11) {
                    i30 = i14;
                    i29 = i13;
                    i19 = i15;
                    bArr4 = bArr;
                    i31 = -1;
                } else {
                    if (i33 == i12) {
                        i25 = i32;
                        i18 = i29;
                        break;
                    }
                    byte[] bArr7 = bArr5;
                    if (i31 == -1) {
                        bArr3[i24] = bArr[i33];
                        i24++;
                        i20++;
                        i31 = i33;
                        i32 = i31;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                    } else {
                        if (i33 >= i29) {
                            bArr7[i26] = (byte) i32;
                            i26++;
                            s7 = i31;
                        } else {
                            s7 = i33;
                        }
                        while (s7 >= i11) {
                            bArr7[i26] = bArr[s7];
                            i26++;
                            s7 = sArr2[s7];
                        }
                        int i34 = bArr[s7] & 255;
                        byte b9 = (byte) i34;
                        bArr3[i24] = b9;
                        while (true) {
                            i24++;
                            i20++;
                            if (i26 <= 0) {
                                break;
                            }
                            i26--;
                            bArr3[i24] = bArr7[i26];
                        }
                        if (i29 < 4096) {
                            sArr2[i29] = (short) i31;
                            bArr[i29] = b9;
                            i29++;
                            if ((i29 & i19) == 0 && i29 < 4096) {
                                i30++;
                                i19 += i29;
                            }
                        }
                        i31 = i33;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                        i32 = i34;
                    }
                }
            }
            i22 = i28;
            sArr = sArr2;
            bArr4 = bArr;
            b8 = 0;
            i27 = i31;
            i17 = i30;
            standardGifDecoder = this;
        }
        Arrays.fill(bArr3, i24, i9, b8);
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Boolean bool = this.isFirstFrameTransparent;
        Bitmap bitmapObtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        bitmapObtain.setHasAlpha(true);
        return bitmapObtain;
    }

    private int readBlock() {
        int i2 = readByte();
        if (i2 <= 0) {
            return i2;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(i2, byteBuffer.remaining()));
        return i2;
    }

    private int readByte() {
        return this.rawData.get() & 255;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i2;
        int i8;
        Bitmap bitmap;
        int[] iArr = this.mainScratch;
        int i9 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                this.bitmapProvider.release(bitmap2);
            }
            this.previousImage = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i8 = gifFrame2.dispose) > 0) {
            if (i8 == 2) {
                if (!gifFrame.transparency) {
                    GifHeader gifHeader = this.header;
                    int i10 = gifHeader.bgColor;
                    if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                        i9 = i10;
                    }
                }
                int i11 = gifFrame2.ih;
                int i12 = this.sampleSize;
                int i13 = i11 / i12;
                int i14 = gifFrame2.iy / i12;
                int i15 = gifFrame2.iw / i12;
                int i16 = gifFrame2.ix / i12;
                int i17 = this.downsampledWidth;
                int i18 = (i14 * i17) + i16;
                int i19 = (i13 * i17) + i18;
                while (i18 < i19) {
                    int i20 = i18 + i15;
                    for (int i21 = i18; i21 < i20; i21++) {
                        iArr[i21] = i9;
                    }
                    i18 += this.downsampledWidth;
                }
            } else if (i8 == 3 && (bitmap = this.previousImage) != null) {
                int i22 = this.downsampledWidth;
                bitmap.getPixels(iArr, 0, i22, 0, 0, i22, this.downsampledHeight);
            }
        }
        decodeBitmapData(gifFrame);
        if (gifFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(gifFrame);
        } else {
            copyIntoScratchFast(gifFrame);
        }
        if (this.savePrevious && ((i2 = gifFrame.dispose) == 0 || i2 == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap3 = this.previousImage;
            int i23 = this.downsampledWidth;
            bitmap3.setPixels(iArr, 0, i23, 0, 0, i23, this.downsampledHeight);
        }
        Bitmap nextBitmap = getNextBitmap();
        int i24 = this.downsampledWidth;
        nextBitmap.setPixels(iArr, 0, i24, 0, 0, i24, this.downsampledHeight);
        return nextBitmap;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return (this.mainScratch.length * 4) + this.rawData.limit() + this.mainPixels.length;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int i2) {
        if (i2 < 0) {
            return -1;
        }
        GifHeader gifHeader = this.header;
        if (i2 < gifHeader.frameCount) {
            return gifHeader.frames.get(i2).delay;
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.header.height;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        int i2 = this.header.loopCount;
        if (i2 == -1) {
            return 1;
        }
        return i2;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        int i2;
        if (this.header.frameCount <= 0 || (i2 = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap getNextFrame() {
        try {
            if (this.header.frameCount <= 0 || this.framePointer < 0) {
                String str = TAG;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer);
                }
                this.status = 1;
            }
            int i2 = this.status;
            if (i2 != 1 && i2 != 2) {
                this.status = 0;
                if (this.block == null) {
                    this.block = this.bitmapProvider.obtainByteArray(255);
                }
                GifFrame gifFrame = this.header.frames.get(this.framePointer);
                int i8 = this.framePointer - 1;
                GifFrame gifFrame2 = i8 >= 0 ? this.header.frames.get(i8) : null;
                int[] iArr = gifFrame.lct;
                if (iArr == null) {
                    iArr = this.header.gct;
                }
                this.act = iArr;
                if (iArr == null) {
                    String str2 = TAG;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.framePointer);
                    }
                    this.status = 1;
                    return null;
                }
                if (gifFrame.transparency) {
                    System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                    int[] iArr2 = this.pct;
                    this.act = iArr2;
                    iArr2[gifFrame.transIndex] = 0;
                    if (gifFrame.dispose == 2 && this.framePointer == 0) {
                        this.isFirstFrameTransparent = Boolean.TRUE;
                    }
                }
                return setPixels(gifFrame, gifFrame2);
            }
            String str3 = TAG;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.status);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int i2 = this.header.loopCount;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i8 = inputStream.read(bArr, 0, 16384);
                    if (i8 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i8);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                Log.w(TAG, "Error closing stream", e4);
            }
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i2) {
        try {
            if (i2 > 0) {
                int iHighestOneBit = Integer.highestOneBit(i2);
                this.status = 0;
                this.header = gifHeader;
                this.framePointer = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.rawData = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                this.savePrevious = false;
                Iterator<GifFrame> it = gifHeader.frames.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                }
                this.sampleSize = iHighestOneBit;
                int i8 = gifHeader.width;
                this.downsampledWidth = i8 / iHighestOneBit;
                int i9 = gifHeader.height;
                this.downsampledHeight = i9 / iHighestOneBit;
                this.mainPixels = this.bitmapProvider.obtainByteArray(i8 * i9);
                this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        try {
            GifHeader header = getHeaderParser().setData(bArr).parseHeader();
            this.header = header;
            if (bArr != null) {
                setData(header, bArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.status;
    }
}
