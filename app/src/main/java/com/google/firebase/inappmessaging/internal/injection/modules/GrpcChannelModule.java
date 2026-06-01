package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import e2.s;
import i4.e;
import i4.f;
import i4.j;
import i4.s0;
import i4.u0;
import java.util.List;
import java.util.logging.Logger;
import k4.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class GrpcChannelModule {
    @Provides
    public e providesGrpcChannel(String str) {
        u0 u0Var;
        Logger logger = u0.f11964c;
        synchronized (u0.class) {
            try {
                if (u0.f11965d == null) {
                    List<s0> listH = f.h(s0.class, u0.b(), s0.class.getClassLoader(), new j(7));
                    u0.f11965d = new u0();
                    for (s0 s0Var : listH) {
                        u0.f11964c.fine("Service loader found " + s0Var);
                        u0.f11965d.a(s0Var);
                    }
                    u0.f11965d.d();
                }
                u0Var = u0.f11965d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (u0Var.c() != null) {
            return new h(str).o();
        }
        throw new s("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact", 1);
    }

    @Provides
    public String providesServiceHost() {
        return "firebaseinappmessaging.googleapis.com";
    }
}
