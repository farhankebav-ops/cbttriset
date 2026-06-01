package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamRelativeLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@InAppMessageScope
public class ModalBindingWrapper extends BindingWrapper {
    private ScrollView bodyScroll;
    private Button button;
    private View collapseImage;
    private ImageView imageView;
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private TextView messageBody;
    private TextView messageTitle;
    private ViewGroup modalContentRoot;
    private ModalMessage modalMessage;
    private FiamRelativeLayout modalRoot;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class ScrollViewAdjustableListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public ScrollViewAdjustableListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ModalBindingWrapper.this.imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ModalBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
        this.layoutListener = new ScrollViewAdjustableListener();
    }

    private void setButton(Map<Action, View.OnClickListener> map) {
        Action action = this.modalMessage.getAction();
        if (action == null || action.getButton() == null || TextUtils.isEmpty(action.getButton().getText().getText())) {
            this.button.setVisibility(8);
            return;
        }
        BindingWrapper.setupViewButtonFromModel(this.button, action.getButton());
        setButtonActionListener(this.button, map.get(this.modalMessage.getAction()));
        this.button.setVisibility(0);
    }

    private void setDismissListener(View.OnClickListener onClickListener) {
        this.collapseImage.setOnClickListener(onClickListener);
        this.modalRoot.setDismissListener(onClickListener);
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        this.imageView.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.imageView.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setMessage(ModalMessage modalMessage) {
        if (modalMessage.getImageData() == null || TextUtils.isEmpty(modalMessage.getImageData().getImageUrl())) {
            this.imageView.setVisibility(8);
        } else {
            this.imageView.setVisibility(0);
        }
        if (modalMessage.getTitle() != null) {
            if (TextUtils.isEmpty(modalMessage.getTitle().getText())) {
                this.messageTitle.setVisibility(8);
            } else {
                this.messageTitle.setVisibility(0);
                this.messageTitle.setText(modalMessage.getTitle().getText());
            }
            if (!TextUtils.isEmpty(modalMessage.getTitle().getHexColor())) {
                this.messageTitle.setTextColor(Color.parseColor(modalMessage.getTitle().getHexColor()));
            }
        }
        if (modalMessage.getBody() == null || TextUtils.isEmpty(modalMessage.getBody().getText())) {
            this.bodyScroll.setVisibility(8);
            this.messageBody.setVisibility(8);
        } else {
            this.bodyScroll.setVisibility(0);
            this.messageBody.setVisibility(0);
            this.messageBody.setTextColor(Color.parseColor(modalMessage.getBody().getHexColor()));
            this.messageBody.setText(modalMessage.getBody().getText());
        }
    }

    @NonNull
    public Button getActionButton() {
        return this.button;
    }

    @NonNull
    public View getCollapseButton() {
        return this.collapseImage;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public View getDialogView() {
        return this.modalContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ImageView getImageView() {
        return this.imageView;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ViewGroup getRootView() {
        return this.modalRoot;
    }

    @NonNull
    public View getScrollView() {
        return this.bodyScroll;
    }

    @NonNull
    public View getTitleView() {
        return this.messageTitle;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    @NonNull
    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener) {
        View viewInflate = this.inflater.inflate(R.layout.modal, (ViewGroup) null);
        this.bodyScroll = (ScrollView) viewInflate.findViewById(R.id.body_scroll);
        this.button = (Button) viewInflate.findViewById(R.id.button);
        this.collapseImage = viewInflate.findViewById(R.id.collapse_button);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.image_view);
        this.messageBody = (TextView) viewInflate.findViewById(R.id.message_body);
        this.messageTitle = (TextView) viewInflate.findViewById(R.id.message_title);
        this.modalRoot = (FiamRelativeLayout) viewInflate.findViewById(R.id.modal_root);
        this.modalContentRoot = (ViewGroup) viewInflate.findViewById(R.id.modal_content_root);
        if (this.message.getMessageType().equals(MessageType.MODAL)) {
            ModalMessage modalMessage = (ModalMessage) this.message;
            this.modalMessage = modalMessage;
            setMessage(modalMessage);
            setButton(map);
            setLayoutConfig(this.config);
            setDismissListener(onClickListener);
            setViewBgColorFromHex(this.modalContentRoot, this.modalMessage.getBackgroundHexColor());
        }
        return this.layoutListener;
    }

    @VisibleForTesting
    public void setLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.layoutListener = onGlobalLayoutListener;
    }
}
