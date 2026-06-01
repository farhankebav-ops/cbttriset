package com.bytedance.sdk.component.Cc.tV.EO.MY;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static final ImageView.ScaleType IlO = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config MY = Bitmap.Config.ARGB_4444;
    private final int Bc;
    private int Cc;
    private final Bitmap.Config EO;
    private final ImageView.ScaleType lEW;
    private int tV;
    private final int vCE;
    private final int DmF = 1280;
    private final int NV = 83886080;

    public MY(int i2, int i8, ImageView.ScaleType scaleType, Bitmap.Config config, int i9, int i10) {
        this.EO = config;
        this.tV = i2;
        this.Cc = i8;
        this.lEW = scaleType;
        this.vCE = i9;
        this.Bc = i10;
        IlO(i2, i8);
    }

    private static int IlO(int i2, int i8, int i9, int i10) {
        if (i2 == 0 && i8 == 0) {
            return i9;
        }
        if (i2 == 0) {
            return (int) (((double) i9) * (((double) i8) / ((double) i10)));
        }
        if (i8 == 0) {
            return i2;
        }
        double d8 = ((double) i10) / ((double) i9);
        double d9 = i8;
        return ((double) i2) * d8 > d9 ? (int) (d9 / d8) : i2;
    }

    public static int IlO(int i2, int i8, int i9, int i10, int i11, int i12) {
        double dMin = Math.min(((double) i2) / ((double) i9), ((double) i8) / ((double) i10));
        if (i11 > 0 && i12 > 0) {
            dMin = Math.max(dMin, Math.min(((double) Math.max(i2, i8)) / ((double) Math.max(i11, i12)), ((double) Math.min(i2, i8)) / ((double) Math.min(i11, i12))));
        }
        return Integer.highestOneBit((int) dMin);
    }

    public Bitmap IlO(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.tV == 0 && this.Cc == 0) {
            options.inPreferredConfig = this.EO;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i8 = options.outHeight;
            int iIlO = IlO(this.tV, this.Cc, i2, i8);
            int iIlO2 = IlO(this.Cc, this.tV, i8, i2);
            options.inJustDecodeBounds = false;
            options.inSampleSize = IlO(i2, i8, iIlO, iIlO2, this.vCE, this.Bc);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iIlO || bitmapDecodeByteArray.getHeight() > iIlO2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iIlO, iIlO2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 83886080) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }

    private void IlO(int i2, int i8) {
        if (i2 > 1280 && i8 > 1280) {
            if (i2 > i8) {
                this.tV = 1280;
                this.Cc = (i8 * 1280) / i2;
                return;
            } else {
                this.tV = (i2 * 1280) / i8;
                this.Cc = 1280;
                return;
            }
        }
        if (i2 > 1280) {
            this.tV = 1280;
            this.Cc = (i8 * 1280) / i2;
        } else if (i8 > 1280) {
            this.tV = (i2 * 1280) / i8;
            this.Cc = 1280;
        }
    }
}
