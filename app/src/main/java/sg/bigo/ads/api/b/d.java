package sg.bigo.ads.api.b;

import androidx.annotation.NonNull;
import sg.bigo.ads.api.Ad;

/* JADX INFO: loaded from: classes6.dex */
public interface d<T extends Ad> {

    public interface a<T extends Ad> {
        void a(T t3);

        void a(T t3, int i2, int i8, String str);

        void a(T t3, boolean z2, int i2, int i8, String str, boolean z7);
    }

    void a(@NonNull a<T> aVar);
}
