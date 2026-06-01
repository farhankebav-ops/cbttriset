package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.unity3d.services.core.device.MimeTypes;

/* JADX INFO: loaded from: classes6.dex */
final class a extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f17134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f17135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC0319a f17136c;

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.a$a, reason: collision with other inner class name */
    public interface InterfaceC0319a {
        void a(float f4);
    }

    public a(Handler handler, Context context, InterfaceC0319a interfaceC0319a) {
        super(handler);
        this.f17134a = -1.0f;
        this.f17135b = context.getApplicationContext();
        this.f17136c = interfaceC0319a;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        super.onChange(z2);
        float streamVolume = ((AudioManager) this.f17135b.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) != null ? 100.0f * (r4.getStreamVolume(3) / r4.getStreamMaxVolume(3)) : 100.0f;
        if (streamVolume != this.f17134a) {
            this.f17134a = streamVolume;
            sg.bigo.ads.common.t.a.a(0, 3, "AudioVolumeContentObserver", "Volume change, current value: " + streamVolume);
            InterfaceC0319a interfaceC0319a = this.f17136c;
            if (interfaceC0319a != null) {
                interfaceC0319a.a(this.f17134a);
            }
        }
    }
}
