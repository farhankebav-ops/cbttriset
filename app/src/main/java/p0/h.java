package p0;

import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13279a = new h();

    @Override // com.google.firebase.encoders.config.Configurator
    public final void configure(EncoderConfig encoderConfig) {
        encoderConfig.registerEncoder(q.class, e.f13272a);
        encoderConfig.registerEncoder(s0.a.class, a.f13260a);
        encoderConfig.registerEncoder(s0.g.class, g.f13276a);
        encoderConfig.registerEncoder(s0.e.class, d.f13269a);
        encoderConfig.registerEncoder(s0.d.class, c.f13266a);
        encoderConfig.registerEncoder(s0.b.class, b.f13264a);
        encoderConfig.registerEncoder(s0.f.class, f.f13273a);
    }
}
