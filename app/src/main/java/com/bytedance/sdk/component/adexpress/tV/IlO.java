package com.bytedance.sdk.component.adexpress.tV;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.HardwareRenderer;
import android.graphics.Paint;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.internal.ads.p0;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static Bitmap IlO(Context context, Bitmap bitmap, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
            return com.bytedance.sdk.component.adexpress.tV.tV() == 0 ? MY(context, bitmapCreateScaledBitmap, i2) : com.bytedance.sdk.component.adexpress.tV.tV() == 1 ? IlO(bitmapCreateScaledBitmap, i2) : MY(bitmapCreateScaledBitmap, i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.renderscript.BaseObj, android.renderscript.ScriptIntrinsicBlur] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.renderscript.Allocation] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.renderscript.Allocation] */
    public static Bitmap MY(Context context, Bitmap bitmap, int i2) {
        RenderScript renderScriptCreate;
        Allocation allocationCreateFromBitmap;
        ?? Create;
        ?? CreateFromBitmap;
        com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO;
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
            renderScriptCreate = RenderScript.create(context);
            if (renderScriptCreate == null) {
                try {
                    com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO2 = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
                    if (EO2 == null || !EO2.cl() || renderScriptCreate == null) {
                        return null;
                    }
                    RenderScript.releaseAllContexts();
                    return null;
                } catch (Throwable th) {
                    th.getMessage();
                    return null;
                }
            }
            try {
                Create = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                try {
                    allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
                    try {
                        CreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                    } catch (Throwable th2) {
                        th = th2;
                        CreateFromBitmap = 0;
                    }
                    try {
                        Create.setRadius(i2);
                        Create.setInput(allocationCreateFromBitmap);
                        Create.forEach(CreateFromBitmap);
                        CreateFromBitmap.copyTo(bitmapCreateBitmap);
                        try {
                            com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO3 = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
                            if (EO3 != null && EO3.cl()) {
                                RenderScript.releaseAllContexts();
                                if (allocationCreateFromBitmap != null) {
                                    allocationCreateFromBitmap.destroy();
                                }
                                CreateFromBitmap.destroy();
                                Create.destroy();
                            }
                        } catch (Throwable th3) {
                            th3.getMessage();
                        }
                        return bitmapCreateBitmap;
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            th.getMessage();
                            try {
                                EO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
                                return EO == null ? null : null;
                            } catch (Throwable th5) {
                                th5.getMessage();
                                return null;
                            }
                        } catch (Throwable th6) {
                            try {
                                com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO4 = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
                                if (EO4 != null && EO4.cl()) {
                                    if (renderScriptCreate != null) {
                                        RenderScript.releaseAllContexts();
                                    }
                                    if (allocationCreateFromBitmap != null) {
                                        allocationCreateFromBitmap.destroy();
                                    }
                                    if (CreateFromBitmap != 0) {
                                        CreateFromBitmap.destroy();
                                    }
                                    if (Create != 0) {
                                        Create.destroy();
                                    }
                                }
                            } catch (Throwable th7) {
                                th7.getMessage();
                            }
                            throw th6;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    allocationCreateFromBitmap = null;
                    CreateFromBitmap = 0;
                }
            } catch (Throwable th9) {
                th = th9;
                allocationCreateFromBitmap = null;
                Create = allocationCreateFromBitmap;
                CreateFromBitmap = Create;
                th.getMessage();
                EO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
                if (EO == null && EO.cl()) {
                    if (renderScriptCreate != null) {
                        RenderScript.releaseAllContexts();
                    }
                    if (allocationCreateFromBitmap != null) {
                        allocationCreateFromBitmap.destroy();
                    }
                    if (CreateFromBitmap != 0) {
                        CreateFromBitmap.destroy();
                    }
                    if (Create == 0) {
                        return null;
                    }
                    Create.destroy();
                    return null;
                }
            }
        } catch (Throwable th10) {
            th = th10;
            renderScriptCreate = null;
            allocationCreateFromBitmap = null;
        }
    }

    public static Bitmap IlO(Bitmap bitmap, int i2) {
        int i8;
        int i9;
        int i10 = i2;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i11 = width * height;
            int[] iArr = new int[i11];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int[] iArr2 = iArr;
            int i12 = width - 1;
            int i13 = height - 1;
            int i14 = i10 + i10;
            int i15 = i14 + 1;
            char c7 = 2;
            int i16 = (i14 + 2) >> 1;
            int i17 = i16 * i16;
            int[] iArr3 = new int[Math.max(width, height)];
            int i18 = i17 * 256;
            int[] iArr4 = new int[i18];
            int[] iArr5 = new int[i11];
            int[] iArr6 = new int[i11];
            int[] iArr7 = new int[i11];
            int i19 = 0;
            for (int i20 = 0; i20 < i18; i20++) {
                iArr4[i20] = i20 / i17;
            }
            int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i15, 3);
            int i21 = i10 + 1;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i22 < height) {
                char c8 = c7;
                int i25 = -i10;
                int i26 = i19;
                int i27 = i26;
                int i28 = i27;
                int i29 = i28;
                int i30 = i29;
                int i31 = i30;
                int i32 = i31;
                int i33 = i32;
                int i34 = i33;
                while (i25 <= i10) {
                    int[] iArr9 = iArr2;
                    int[][] iArr10 = iArr8;
                    int i35 = iArr9[i23 + Math.min(i12, Math.max(i25, i19))];
                    int[] iArr11 = iArr10[i25 + i10];
                    iArr11[0] = (i35 & 16711680) >> 16;
                    iArr11[1] = (i35 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr11[c8] = i35 & 255;
                    int iAbs = i21 - Math.abs(i25);
                    int i36 = iArr11[0];
                    i26 = (i36 * iAbs) + i26;
                    int i37 = iArr11[1];
                    i27 = (i37 * iAbs) + i27;
                    int i38 = iArr11[c8];
                    i28 = (iAbs * i38) + i28;
                    if (i25 <= 0) {
                        i30 += i36;
                        i32 += i37;
                        i34 += i38;
                    } else {
                        i29 += i36;
                        i31 += i37;
                        i33 += i38;
                    }
                    i25++;
                    iArr2 = iArr9;
                    iArr8 = iArr10;
                    i19 = 0;
                }
                int[] iArr12 = iArr2;
                int[][] iArr13 = iArr8;
                int i39 = i10;
                int i40 = 0;
                while (i40 < width) {
                    iArr5[i23] = iArr4[i26];
                    iArr6[i23] = iArr4[i27];
                    iArr7[i23] = iArr4[i28];
                    int[] iArr14 = iArr13[((i39 - i10) + i15) % i15];
                    int i41 = i26 - i30;
                    int i42 = i27 - i32;
                    int i43 = i28 - i34;
                    int i44 = i30 - iArr14[0];
                    int i45 = i32 - iArr14[1];
                    int i46 = i34 - iArr14[c8];
                    if (i22 == 0) {
                        i9 = i40;
                        iArr3[i9] = Math.min(i40 + i10 + 1, i12);
                    } else {
                        i9 = i40;
                    }
                    int i47 = iArr12[i24 + iArr3[i9]];
                    int i48 = (i47 & 16711680) >> 16;
                    iArr14[0] = i48;
                    int i49 = (i47 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr14[1] = i49;
                    int i50 = i47 & 255;
                    iArr14[c8] = i50;
                    int i51 = i29 + i48;
                    int i52 = i31 + i49;
                    int i53 = i33 + i50;
                    i39 = (i39 + 1) % i15;
                    int[] iArr15 = iArr13[i39 % i15];
                    i26 = i41 + i51;
                    i27 = i42 + i52;
                    i28 = i43 + i53;
                    int i54 = iArr15[0];
                    i29 = i51 - i54;
                    int i55 = iArr15[1];
                    i31 = i52 - i55;
                    int i56 = iArr15[c8];
                    i33 = i53 - i56;
                    i30 = i44 + i54;
                    i32 = i45 + i55;
                    i34 = i46 + i56;
                    i23++;
                    i40 = i9 + 1;
                }
                i24 += width;
                i22++;
                c7 = c8;
                iArr2 = iArr12;
                iArr8 = iArr13;
                i19 = 0;
            }
            int[] iArr16 = iArr2;
            int[][] iArr17 = iArr8;
            char c9 = c7;
            int i57 = 0;
            while (i57 < width) {
                int i58 = -i10;
                int i59 = i58 * width;
                int i60 = 0;
                int i61 = 0;
                int i62 = 0;
                int i63 = 0;
                int i64 = 0;
                int i65 = 0;
                int i66 = 0;
                int i67 = 0;
                int i68 = 0;
                while (i58 <= i10) {
                    int[] iArr18 = iArr17[i58 + i10];
                    int iMax = Math.max(0, i59) + i57;
                    int iAbs2 = i21 - Math.abs(i58);
                    int i69 = iArr5[iMax];
                    i60 = (i69 * iAbs2) + i60;
                    i61 = (iArr6[iMax] * iAbs2) + i61;
                    i62 = (iArr7[iMax] * iAbs2) + i62;
                    iArr18[0] = i69;
                    int i70 = iArr6[iMax];
                    iArr18[1] = i70;
                    int i71 = iArr7[iMax];
                    iArr18[c9] = i71;
                    if (i58 <= 0) {
                        i64 += i69;
                        i66 += i70;
                        i68 += i71;
                    } else {
                        i63 += i69;
                        i65 += i70;
                        i67 += i71;
                    }
                    if (i58 < i13) {
                        i59 += width;
                    }
                    i58++;
                    i10 = i2;
                }
                int i72 = i2;
                int i73 = i57;
                int i74 = 0;
                while (i74 < height) {
                    iArr16[i73] = (iArr16[i73] & ViewCompat.MEASURED_STATE_MASK) | (iArr4[i60] << 16) | (iArr4[i61] << 8) | iArr4[i62];
                    int[] iArr19 = iArr17[((i72 - i2) + i15) % i15];
                    int i75 = i60 - i64;
                    int i76 = i61 - i66;
                    int i77 = i62 - i68;
                    int i78 = i64 - iArr19[0];
                    int i79 = i66 - iArr19[1];
                    int i80 = i68 - iArr19[c9];
                    if (i57 == 0) {
                        i8 = i74;
                        iArr3[i8] = Math.min(i8 + i21, i13) * width;
                    } else {
                        i8 = i74;
                    }
                    int i81 = iArr3[i8] + i57;
                    int i82 = iArr5[i81];
                    iArr19[0] = i82;
                    int i83 = iArr6[i81];
                    iArr19[1] = i83;
                    int i84 = iArr7[i81];
                    iArr19[c9] = i84;
                    int i85 = i63 + i82;
                    int i86 = i65 + i83;
                    int i87 = i67 + i84;
                    i60 = i75 + i85;
                    i61 = i76 + i86;
                    i62 = i77 + i87;
                    i72 = (i72 + 1) % i15;
                    int[] iArr20 = iArr17[i72];
                    int i88 = iArr20[0];
                    i63 = i85 - i88;
                    int i89 = iArr20[1];
                    i65 = i86 - i89;
                    int i90 = iArr20[c9];
                    i67 = i87 - i90;
                    i64 = i78 + i88;
                    i66 = i79 + i89;
                    i68 = i80 + i90;
                    i73 += width;
                    i74 = i8 + 1;
                }
                i57++;
                i10 = i2;
            }
            bitmap.setPixels(iArr16, 0, width, 0, 0, width, height);
            return bitmap;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static Bitmap MY(Bitmap bitmap, int i2) {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                ImageReader imageReaderNewInstance = ImageReader.newInstance(bitmap.getWidth(), bitmap.getHeight(), 1, 1, 768L);
                p0.l();
                RenderNode renderNodeG = p0.g();
                p0.y();
                HardwareRenderer hardwareRendererE = p0.e();
                hardwareRendererE.setSurface(imageReaderNewInstance.getSurface());
                hardwareRendererE.setContentRoot(renderNodeG);
                renderNodeG.setPosition(0, 0, imageReaderNewInstance.getWidth(), imageReaderNewInstance.getHeight());
                float f4 = i2;
                Shader.TileMode tileMode = Shader.TileMode.MIRROR;
                renderNodeG.setRenderEffect(RenderEffect.createBlurEffect(f4, f4, Shader.TileMode.MIRROR));
                renderNodeG.beginRecording().drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                renderNodeG.endRecording();
                hardwareRendererE.createRenderRequest().setWaitForPresent(true).syncAndDraw();
                Image imageAcquireNextImage = imageReaderNewInstance.acquireNextImage();
                HardwareBuffer hardwareBuffer = imageAcquireNextImage.getHardwareBuffer();
                Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, null);
                hardwareBuffer.close();
                imageAcquireNextImage.close();
                imageReaderNewInstance.close();
                renderNodeG.discardDisplayList();
                hardwareRendererE.destroy();
                return bitmapWrapHardwareBuffer;
            }
            return IlO(bitmap, i2);
        } catch (Throwable th) {
            th.getMessage();
            return IlO(bitmap, i2);
        }
    }
}
