package sg.bigo.ads.api;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.util.List;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public interface NativeAd extends Ad {

    public enum CreativeType {
        IMAGE,
        VIDEO,
        UNKNOWN
    }

    String getAdvertiser();

    String getCallToAction();

    CreativeType getCreativeType();

    String getDescription();

    float getMediaContentAspectRatio();

    c.d getPopPage();

    String getSponsored();

    String getTitle();

    @Nullable
    VideoController getVideoController();

    String getWarning();

    boolean hasIcon();

    void registerViewForInteraction(ViewGroup viewGroup, @Nullable MediaView mediaView, @Nullable ImageView imageView, @Nullable AdOptionsView adOptionsView, @Nullable List<View> list);

    void registerViewForInteraction(NativeAdView nativeAdView, @Nullable MediaView mediaView, @Nullable AdIconView adIconView, @Nullable AdOptionsView adOptionsView, @Nullable List<View> list);
}
