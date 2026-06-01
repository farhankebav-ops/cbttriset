package sg.bigo.ads.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface AdLoader<T> {

    public interface Builder<T extends Ad, S extends Builder, U extends AdLoader> {
        @NonNull
        U build();

        @NonNull
        S withAdLoadListener(@Nullable AdLoadListener<T> adLoadListener);

        @NonNull
        S withExt(String str);
    }
}
