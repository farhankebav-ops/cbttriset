package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.b8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2250b8<T> {
    T a(String str);

    void a(T t3);

    void a(String str, T t3);

    /* JADX INFO: renamed from: com.ironsource.b8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2250b8<ISDemandOnlyInterstitialListener> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private C2232a8 f8057a = new C2232a8();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, C2232a8> f8058b = new HashMap();

        @Override // com.ironsource.InterfaceC2250b8
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ISDemandOnlyInterstitialListener a(String instanceId) {
            kotlin.jvm.internal.k.e(instanceId, "instanceId");
            C2232a8 c2232a8 = this.f8058b.get(instanceId);
            return c2232a8 != null ? c2232a8 : this.f8057a;
        }

        @Override // com.ironsource.InterfaceC2250b8
        public void a(ISDemandOnlyInterstitialListener listener) {
            kotlin.jvm.internal.k.e(listener, "listener");
            this.f8057a.a(listener);
            Iterator<String> it = this.f8058b.keySet().iterator();
            while (it.hasNext()) {
                C2232a8 c2232a8 = this.f8058b.get(it.next());
                if (c2232a8 != null) {
                    c2232a8.a(listener);
                }
            }
        }

        @Override // com.ironsource.InterfaceC2250b8
        public void a(String instanceId, ISDemandOnlyInterstitialListener listener) {
            kotlin.jvm.internal.k.e(instanceId, "instanceId");
            kotlin.jvm.internal.k.e(listener, "listener");
            if (this.f8058b.containsKey(instanceId)) {
                C2232a8 c2232a8 = this.f8058b.get(instanceId);
                if (c2232a8 != null) {
                    c2232a8.a(listener);
                    return;
                }
                return;
            }
            this.f8058b.put(instanceId, new C2232a8(listener));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.b8$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2250b8<ISDemandOnlyRewardedVideoListener> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private C2286d8 f8059a = new C2286d8();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, C2286d8> f8060b = new HashMap();

        @Override // com.ironsource.InterfaceC2250b8
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ISDemandOnlyRewardedVideoListener a(String instanceId) {
            kotlin.jvm.internal.k.e(instanceId, "instanceId");
            C2286d8 c2286d8 = this.f8060b.get(instanceId);
            return c2286d8 != null ? c2286d8 : this.f8059a;
        }

        @Override // com.ironsource.InterfaceC2250b8
        public void a(ISDemandOnlyRewardedVideoListener listener) {
            kotlin.jvm.internal.k.e(listener, "listener");
            this.f8059a.a(listener);
            Iterator<String> it = this.f8060b.keySet().iterator();
            while (it.hasNext()) {
                C2286d8 c2286d8 = this.f8060b.get(it.next());
                if (c2286d8 != null) {
                    c2286d8.a(listener);
                }
            }
        }

        @Override // com.ironsource.InterfaceC2250b8
        public void a(String instanceId, ISDemandOnlyRewardedVideoListener listener) {
            kotlin.jvm.internal.k.e(instanceId, "instanceId");
            kotlin.jvm.internal.k.e(listener, "listener");
            if (this.f8060b.containsKey(instanceId)) {
                C2286d8 c2286d8 = this.f8060b.get(instanceId);
                if (c2286d8 != null) {
                    c2286d8.a(listener);
                    return;
                }
                return;
            }
            this.f8060b.put(instanceId, new C2286d8(listener));
        }
    }
}
