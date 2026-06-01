package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcdp extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzcdn {
    private static final float[] zza = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzcdo zzb;
    private final float[] zzc;
    private final float[] zzd;
    private final float[] zze;
    private final float[] zzf;
    private final float[] zzg;
    private final float[] zzh;
    private final float[] zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt;
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzcdp(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = zza;
        int length = fArr.length;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzt = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.zzc = new float[9];
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzf = new float[9];
        this.zzg = new float[9];
        this.zzh = new float[9];
        this.zzi = new float[9];
        this.zzj = Float.NaN;
        zzcdo zzcdoVar = new zzcdo(context);
        this.zzb = zzcdoVar;
        zzcdoVar.zzc(this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            StringBuilder sb = new StringBuilder(str.length() + 10 + String.valueOf(iGlGetError).length());
            sb.append(str);
            sb.append(": glError ");
            sb.append(iGlGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    private static final void zzi(float[] fArr, float[] fArr2, float[] fArr3) {
        float f4 = fArr2[0] * fArr3[0];
        float f8 = fArr2[1];
        float f9 = fArr3[3];
        float f10 = fArr2[2];
        float f11 = fArr3[6];
        fArr[0] = f4 + (f8 * f9) + (f10 * f11);
        float f12 = fArr2[0];
        float f13 = fArr3[1] * f12;
        float f14 = fArr3[4];
        float f15 = fArr3[7];
        fArr[1] = f13 + (f8 * f14) + (f10 * f15);
        float f16 = f12 * fArr3[2];
        float f17 = fArr2[1];
        float f18 = fArr3[5];
        float f19 = fArr3[8];
        fArr[2] = f16 + (f17 * f18) + (f10 * f19);
        float f20 = fArr2[3];
        float f21 = fArr3[0];
        float f22 = fArr2[4];
        float f23 = fArr2[5];
        fArr[3] = (f20 * f21) + (f9 * f22) + (f23 * f11);
        float f24 = fArr2[3];
        float f25 = fArr3[1];
        fArr[4] = (f24 * f25) + (f22 * f14) + (f23 * f15);
        float f26 = fArr3[2];
        fArr[5] = (f24 * f26) + (fArr2[4] * f18) + (f23 * f19);
        float f27 = fArr2[6] * f21;
        float f28 = fArr2[7];
        float f29 = fArr3[3] * f28;
        float f30 = fArr2[8];
        fArr[6] = f27 + f29 + (f11 * f30);
        float f31 = fArr2[6];
        float f32 = f15 * f30;
        fArr[7] = f32 + (f28 * fArr3[4]) + (f25 * f31);
        fArr[8] = (f31 * f26) + (fArr2[7] * fArr3[5]) + (f30 * f19);
    }

    private static final void zzj(float[] fArr, float f4) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d8 = f4;
        fArr[4] = (float) Math.cos(d8);
        fArr[5] = (float) (-Math.sin(d8));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d8);
        fArr[8] = (float) Math.cos(d8);
    }

    private static final void zzk(float[] fArr, float f4) {
        double d8 = f4;
        fArr[0] = (float) Math.cos(d8);
        fArr[1] = (float) (-Math.sin(d8));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d8);
        fArr[4] = (float) Math.cos(d8);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static final int zzl(int i2, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i2);
        zzh("createShader");
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            zzh("shaderSource");
            GLES20.glCompileShader(iGlCreateShader);
            zzh("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            zzh("getShaderiv");
            if (iArr[0] == 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 26);
                sb.append("Could not compile shader ");
                sb.append(i2);
                sb.append(":");
                Log.e("SphericalVideoRenderer", sb.toString());
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(iGlCreateShader));
                GLES20.glDeleteShader(iGlCreateShader);
                zzh("deleteShader");
                return 0;
            }
        }
        return iGlCreateShader;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzs++;
        Object obj = this.zzv;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 944
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdp.run():void");
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zza() {
        Object obj = this.zzv;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public final void zzb(SurfaceTexture surfaceTexture, int i2, int i8) {
        this.zzn = i2;
        this.zzm = i8;
        this.zzp = surfaceTexture;
    }

    public final void zzc(int i2, int i8) {
        Object obj = this.zzv;
        synchronized (obj) {
            this.zzn = i2;
            this.zzm = i8;
            this.zzA = true;
            obj.notifyAll();
        }
    }

    public final void zzd() {
        Object obj = this.zzv;
        synchronized (obj) {
            this.zzB = true;
            this.zzp = null;
            obj.notifyAll();
        }
    }

    @Nullable
    public final SurfaceTexture zze() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
        } catch (InterruptedException unused) {
        }
        return this.zzo;
    }

    public final void zzf(float f4, float f8) {
        int i2 = this.zzn;
        int i8 = this.zzm;
        if (i2 <= i8) {
            i2 = i8;
        }
        float f9 = i2;
        this.zzk -= (f4 * 1.7453293f) / f9;
        float f10 = this.zzl - ((f8 * 1.7453293f) / f9);
        this.zzl = f10;
        if (f10 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f10 = -1.5707964f;
        }
        if (f10 > 1.5707964f) {
            this.zzl = 1.5707964f;
        }
    }

    @VisibleForTesting
    public final boolean zzg() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzz;
        boolean zEglDestroyContext = false;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            zEglDestroyContext = this.zzw.eglDestroySurface(this.zzx, this.zzz) | this.zzw.eglMakeCurrent(this.zzx, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.zzz = null;
        }
        EGLContext eGLContext = this.zzy;
        if (eGLContext != null) {
            zEglDestroyContext |= this.zzw.eglDestroyContext(this.zzx, eGLContext);
            this.zzy = null;
        }
        EGLDisplay eGLDisplay = this.zzx;
        if (eGLDisplay == null) {
            return zEglDestroyContext;
        }
        boolean zEglTerminate = this.zzw.eglTerminate(eGLDisplay) | zEglDestroyContext;
        this.zzx = null;
        return zEglTerminate;
    }
}
