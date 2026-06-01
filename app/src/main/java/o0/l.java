package o0;

import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f13148a = new l();

    @Override // com.google.firebase.encoders.config.Configurator
    public final void configure(EncoderConfig encoderConfig) {
        c cVar = c.f13115a;
        encoderConfig.registerEncoder(y.class, cVar);
        encoderConfig.registerEncoder(n.class, cVar);
        j jVar = j.f13138a;
        encoderConfig.registerEncoder(h0.class, jVar);
        encoderConfig.registerEncoder(v.class, jVar);
        d dVar = d.f13117a;
        encoderConfig.registerEncoder(a0.class, dVar);
        encoderConfig.registerEncoder(o.class, dVar);
        b bVar = b.f13107a;
        encoderConfig.registerEncoder(a.class, bVar);
        encoderConfig.registerEncoder(m.class, bVar);
        i iVar = i.f13130a;
        encoderConfig.registerEncoder(g0.class, iVar);
        encoderConfig.registerEncoder(u.class, iVar);
        e eVar = e.f13120a;
        encoderConfig.registerEncoder(c0.class, eVar);
        encoderConfig.registerEncoder(p.class, eVar);
        h hVar = h.f13128a;
        encoderConfig.registerEncoder(f0.class, hVar);
        encoderConfig.registerEncoder(s.class, hVar);
        g gVar = g.f13126a;
        encoderConfig.registerEncoder(e0.class, gVar);
        encoderConfig.registerEncoder(r.class, gVar);
        k kVar = k.f13145a;
        encoderConfig.registerEncoder(k0.class, kVar);
        encoderConfig.registerEncoder(x.class, kVar);
        f fVar = f.f13123a;
        encoderConfig.registerEncoder(d0.class, fVar);
        encoderConfig.registerEncoder(q.class, fVar);
    }
}
