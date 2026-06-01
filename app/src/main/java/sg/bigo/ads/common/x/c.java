package sg.bigo.ads.common.x;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f16252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0304a f16253b = new C0304a();

        /* JADX INFO: renamed from: sg.bigo.ads.common.x.c$a$a, reason: collision with other inner class name */
        public static class C0304a {
            public static void a(@NonNull SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private a() {
        }

        public static a a() {
            if (f16252a == null) {
                f16252a = new a();
            }
            return f16252a;
        }
    }
}
