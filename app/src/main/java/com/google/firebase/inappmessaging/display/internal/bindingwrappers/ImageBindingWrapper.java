package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@InAppMessageScope
public class ImageBindingWrapper extends BindingWrapper {
    private Button collapseButton;
    private ViewGroup imageContentRoot;
    private FiamFrameLayout imageRoot;
    private ImageView imageView;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    @NonNull
    public View getCollapseButton() {
        return this.collapseButton;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public View getDialogView() {
        return this.imageContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ImageView getImageView() {
        return this.imageView;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ViewGroup getRootView() {
        return this.imageRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @Nullable
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View viewInflate = this.inflater.inflate(R.layout.image, (ViewGroup) null);
        this.imageRoot = (FiamFrameLayout) viewInflate.findViewById(R.id.image_root);
        this.imageContentRoot = (ViewGroup) viewInflate.findViewById(R.id.image_content_root);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.image_view);
        this.collapseButton = (Button) viewInflate.findViewById(R.id.collapse_button);
        this.imageView.setMaxHeight(this.config.getMaxImageHeight());
        this.imageView.setMaxWidth(this.config.getMaxImageWidth());
        if (this.message.getMessageType().equals(MessageType.IMAGE_ONLY)) {
            ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) this.message;
            this.imageView.setVisibility((imageOnlyMessage.getImageData() == null || TextUtils.isEmpty(imageOnlyMessage.getImageData().getImageUrl())) ? 8 : 0);
            this.imageView.setOnClickListener(map.get(imageOnlyMessage.getAction()));
        }
        this.imageRoot.setDismissListener(onClickListener);
        this.collapseButton.setOnClickListener(onClickListener);
        return null;
    }
}
