package com.bytedance.adsdk.ugeno.Cc;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
interface IlO {
    int IlO(int i2, int i8, int i9);

    int IlO(View view);

    int IlO(View view, int i2, int i8);

    View IlO(int i2);

    void IlO(View view, int i2, int i8, EO eo);

    void IlO(EO eo);

    boolean IlO();

    int MY(int i2, int i8, int i9);

    View MY(int i2);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<EO> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    void setFlexLines(List<EO> list);
}
