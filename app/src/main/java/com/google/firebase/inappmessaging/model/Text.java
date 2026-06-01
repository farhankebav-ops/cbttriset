package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.MessagesProto;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class Text {

    @NonNull
    private final String hexColor;

    @Nullable
    private final String text;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {

        @Nullable
        private String hexColor;

        @Nullable
        private String text;

        public Text build() {
            if (TextUtils.isEmpty(this.hexColor)) {
                throw new IllegalArgumentException("Text model must have a color");
            }
            return new Text(this.text, this.hexColor);
        }

        public Builder setHexColor(@Nullable String str) {
            this.hexColor = str;
            return this;
        }

        public Builder setText(@Nullable String str) {
            this.text = str;
            return this;
        }

        public Builder setText(MessagesProto.Text text) {
            setText(text.getText());
            setHexColor(text.getHexColor());
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
        if (!(obj instanceof Text)) {
            return false;
        }
        Text text = (Text) obj;
        if (hashCode() != text.hashCode()) {
            return false;
        }
        String str = this.text;
        return (str != null || text.text == null) && (str == null || str.equals(text.text)) && this.hexColor.equals(text.hexColor);
    }

    @NonNull
    public String getHexColor() {
        return this.hexColor;
    }

    @Nullable
    public String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        if (str == null) {
            return this.hexColor.hashCode();
        }
        return this.hexColor.hashCode() + str.hashCode();
    }

    private Text(@Nullable String str, @NonNull String str2) {
        this.text = str;
        this.hexColor = str2;
    }
}
