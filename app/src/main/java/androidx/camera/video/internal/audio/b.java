package androidx.camera.video.internal.audio;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements AudioStreamFactory {
    @Override // androidx.camera.video.internal.audio.AudioStreamFactory
    public final AudioStream create(AudioSettings audioSettings, Context context) {
        return new AudioStreamImpl(audioSettings, context);
    }
}
