package com.onesignal.core.internal.config;

import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.common.modeling.SingletonModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import e6.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ConfigModelStore extends SingletonModelStore<ConfigModel> {

    /* JADX INFO: renamed from: com.onesignal.core.internal.config.ConfigModelStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements a {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // e6.a
        public final ConfigModel invoke() {
            return new ConfigModel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigModelStore(IPreferencesService prefs) {
        super(new SimpleModelStore(AnonymousClass1.INSTANCE, "config", prefs));
        k.e(prefs, "prefs");
    }
}
