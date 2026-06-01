package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.model.Button;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class Action {

    @Nullable
    private final String actionUrl;

    @Nullable
    private final Button button;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {

        @Nullable
        private String actionUrl;

        @Nullable
        private Button button;

        public Action build() {
            return new Action(this.actionUrl, this.button);
        }

        public Builder setActionUrl(@Nullable String str) {
            if (!TextUtils.isEmpty(str)) {
                this.actionUrl = str;
            }
            return this;
        }

        public Builder setButton(@Nullable Button button) {
            this.button = button;
            return this;
        }

        public Builder setButton(MessagesProto.Button button) {
            Button.Builder builder = new Button.Builder();
            builder.setButtonHexColor(button.getButtonHexColor());
            builder.setText(button.getText());
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        if (hashCode() != action.hashCode()) {
            return false;
        }
        String str = this.actionUrl;
        if ((str == null && action.actionUrl != null) || (str != null && !str.equals(action.actionUrl))) {
            return false;
        }
        Button button = this.button;
        return (button == null && action.button == null) || (button != null && button.equals(action.button));
    }

    @Nullable
    public String getActionUrl() {
        return this.actionUrl;
    }

    @Nullable
    public Button getButton() {
        return this.button;
    }

    public int hashCode() {
        String str = this.actionUrl;
        int iHashCode = str != null ? str.hashCode() : 0;
        Button button = this.button;
        return iHashCode + (button != null ? button.hashCode() : 0);
    }

    private Action(@Nullable String str, @Nullable Button button) {
        this.actionUrl = str;
        this.button = button;
    }
}
