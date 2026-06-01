package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class FilterWord {
    private boolean EO;
    private String IlO;
    private String MY;
    private List<FilterWord> tV;

    public FilterWord(String str, String str2) {
        this.IlO = str;
        this.MY = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.tV == null) {
            this.tV = new ArrayList();
        }
        this.tV.add(filterWord);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FilterWord)) {
            return false;
        }
        FilterWord filterWord = (FilterWord) obj;
        return filterWord.getId().equals(getId()) && filterWord.getName().equals(getName());
    }

    public String getId() {
        return this.IlO;
    }

    public boolean getIsSelected() {
        return this.EO;
    }

    public String getName() {
        return this.MY;
    }

    public List<FilterWord> getOptions() {
        return this.tV;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.tV;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.IlO) || TextUtils.isEmpty(this.MY)) ? false : true;
    }

    public void setId(String str) {
        this.IlO = str;
    }

    public void setIsSelected(boolean z2) {
        this.EO = z2;
    }

    public void setName(String str) {
        this.MY = str;
    }

    public FilterWord() {
    }
}
