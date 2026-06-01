package androidx.camera.video;

import androidx.camera.video.internal.OutputStorage;
import androidx.camera.video.internal.OutputStorageImpl;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.EncoderImpl;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements EncoderFactory, OutputStorage.Factory {
    @Override // androidx.camera.video.internal.OutputStorage.Factory
    public OutputStorage create(OutputOptions outputOptions) {
        return new OutputStorageImpl(outputOptions);
    }

    @Override // androidx.camera.video.internal.encoder.EncoderFactory
    public Encoder createEncoder(Executor executor, EncoderConfig encoderConfig, int i2) {
        return new EncoderImpl(executor, encoderConfig, i2);
    }
}
