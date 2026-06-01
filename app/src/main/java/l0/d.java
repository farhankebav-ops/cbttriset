package l0;

import android.content.res.AssetFileDescriptor;
import android.graphics.Matrix;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.util.Log;
import android.util.Size;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.o;
import com.cbt.exam.browser.R;
import com.cbt.exam.browser.activity.ActivityScanner;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements ImageAnalysis.Analyzer, OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f12733a;

    public /* synthetic */ d(e eVar) {
        this.f12733a = eVar;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(ImageProxy imageProxy) {
        BarcodeScanning.getClient().process(InputImage.fromMediaImage(imageProxy.getImage(), imageProxy.getImageInfo().getRotationDegrees())).addOnSuccessListener(new d(this.f12733a)).addOnCompleteListener(new j7.a(imageProxy, 1));
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public /* synthetic */ Size getDefaultTargetResolution() {
        return o.a(this);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public /* synthetic */ int getTargetCoordinateSystem() {
        return o.b(this);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        List list = (List) obj;
        e eVar = this.f12733a;
        if (eVar.g) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String rawValue = ((Barcode) it.next()).getRawValue();
            if (rawValue != null) {
                eVar.g = true;
                androidx.camera.core.impl.b bVar = eVar.h;
                if (bVar != null) {
                    ActivityScanner activityScanner = (ActivityScanner) bVar.f3611b;
                    int i2 = ActivityScanner.f5118d;
                    activityScanner.runOnUiThread(new a3.c(17, activityScanner, rawValue));
                }
                c cVar = eVar.f12739i;
                if (cVar != null) {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
                    mediaPlayer.setOnCompletionListener(new a());
                    mediaPlayer.setOnErrorListener(new b());
                    try {
                        AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = cVar.f12732a.getResources().openRawResourceFd(R.raw.beep);
                        try {
                            mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                            assetFileDescriptorOpenRawResourceFd.close();
                            mediaPlayer.setVolume(0.1f, 0.1f);
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                            return;
                        } catch (Throwable th) {
                            assetFileDescriptorOpenRawResourceFd.close();
                            throw th;
                        }
                    } catch (IOException e) {
                        Log.w("c", e);
                        mediaPlayer.reset();
                        mediaPlayer.release();
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public /* synthetic */ void updateTransform(Matrix matrix) {
        o.c(this, matrix);
    }
}
